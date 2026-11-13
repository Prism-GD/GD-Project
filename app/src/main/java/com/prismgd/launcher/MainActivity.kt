package com.prismgd.launcher

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import java.io.File

class MainActivity : Activity() {
    private lateinit var root: LinearLayout
    private lateinit var status: TextView
    private lateinit var modList: LinearLayout

    private val openMod = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) importMod(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildScreen()
        refreshMods()
    }

    private fun buildScreen() {
        val page = ScrollView(this)
        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 48, 28, 32)
            setBackgroundColor(0xFF111018.toInt())
        }

        root.addView(label("PRISMA", 30f, true))
        root.addView(label("LAUNCHER  •  GEODE EDITION", 12f, true, 0xFFB7A6FF.toInt()))
        root.addView(label("Um espaço para organizar seus mods de Geometry Dash.", 15f))

        status = label(
            "Loader nativo Geode: ainda não integrado. Os arquivos abaixo ficam apenas na biblioteca local.",
            13f, false, 0xFFFFD18A.toInt()
        )
        root.addView(status)
        root.addView(actionButton("ABRIR GEOMETRY DASH") { launchGame() })
        root.addView(actionButton("IMPORTAR ARQUIVO .GEODE") { openMod.launch(arrayOf("*/*")) })
        root.addView(label("SUA BIBLIOTECA", 18f, true))
        modList = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        root.addView(modList)
        root.addView(label(
            "Alvo de desenvolvimento: Geometry Dash 2.2091 / Geode 6.0.0-alpha.1. " +
                "A alpha é experimental. Importar um pacote aqui não o instala nem o carrega no jogo.",
            12f, false, 0xFFAAA6B8.toInt()
        ))

        page.addView(root)
        setContentView(page)
    }

    private fun label(value: String, size: Float, bold: Boolean = false, color: Int = 0xFFFFFFFF.toInt()) =
        TextView(this).apply {
            text = value
            textSize = size
            setTextColor(color)
            if (bold) setTypeface(typeface, Typeface.BOLD)
            setPadding(0, 10, 0, 10)
        }

    private fun actionButton(value: String, action: () -> Unit) = Button(this).apply {
        text = value
        isAllCaps = false
        setOnClickListener { action() }
    }

    private fun launchGame() {
        val intent = packageManager.getLaunchIntentForPackage("com.robtopx.geometryjump")
        if (intent == null) {
            Toast.makeText(this, "Geometry Dash não encontrado. Instale o jogo completo primeiro.", Toast.LENGTH_LONG).show()
        } else {
            startActivity(intent)
        }
    }

    private fun importMod(uri: Uri) {
        try {
            val name = queryDisplayName(uri) ?: ("mod-" + System.currentTimeMillis() + ".geode")
            if (!name.endsWith(".geode", ignoreCase = true)) {
                Toast.makeText(this, "Escolha um arquivo com extensão .geode", Toast.LENGTH_LONG).show()
                return
            }
            val destination = File(modsDirectory(), name)
            contentResolver.openInputStream(uri)?.use { input ->
                destination.outputStream().use { output -> input.copyTo(output) }
            } ?: throw IllegalStateException("Não foi possível ler o arquivo selecionado.")
            status.text = "Arquivo importado para a biblioteca local. Ainda não foi instalado no Geode."
            Toast.makeText(this, "Importado: " + name, Toast.LENGTH_SHORT).show()
            refreshMods()
        } catch (error: Exception) {
            Toast.makeText(this, "Falha ao importar: " + error.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun queryDisplayName(uri: Uri): String? {
        contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            val column = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
            if (cursor.moveToFirst() && column >= 0) return cursor.getString(column)
        }
        return null
    }

    private fun modsDirectory() = File(filesDir, "mods").apply { mkdirs() }

    private fun refreshMods() {
        if (!::modList.isInitialized) return
        modList.removeAllViews()
        val mods = modsDirectory().listFiles()
            ?.filter { it.isFile && it.extension.equals("geode", ignoreCase = true) }
            ?.sortedBy { it.name.lowercase() }
            .orEmpty()
        if (mods.isEmpty()) {
            modList.addView(label("Nenhum pacote importado ainda.", 13f, false, 0xFFAAA6B8.toInt()))
            return
        }
        mods.forEach { file ->
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(0, 4, 0, 4)
            }
            val name = TextView(this).apply {
                text = file.name
                textSize = 13f
                setTextColor(0xFFFFFFFF.toInt())
                maxLines = 2
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }
            val remove = Button(this).apply {
                text = "Remover"
                isAllCaps = false
                setOnClickListener {
                    if (file.delete()) {
                        Toast.makeText(this@MainActivity, "Pacote removido da biblioteca.", Toast.LENGTH_SHORT).show()
                        refreshMods()
                    } else {
                        Toast.makeText(this@MainActivity, "Não foi possível remover o pacote.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            row.addView(name)
            row.addView(remove)
            modList.addView(row)
        }
    }
}
