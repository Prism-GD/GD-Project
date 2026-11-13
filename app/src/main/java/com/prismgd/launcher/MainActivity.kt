package com.prismgd.launcher

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import java.io.File

class MainActivity : Activity() {
 private lateinit var status: TextView
 private val pickMod = 41

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  val root = LinearLayout(this).apply {
   orientation = LinearLayout.VERTICAL
   setPadding(32, 64, 32, 32)
   setBackgroundColor(0xFF111018.toInt())
  }
  fun text(value: String, size: Float) = TextView(this).apply {
   this.text = value
   textSize = size
   setTextColor(0xFFFFFFFF.toInt())
   setPadding(0, 12, 0, 12)
  }
  root.addView(text("PRISMA LAUNCHER", 26f))
  root.addView(text("Seu espaço para Geometry Dash + Geode", 15f))
  status = text("Geode: integração nativa em desenvolvimento", 14f)
  root.addView(status)
  root.addView(Button(this).apply {
   this.text = "Abrir Geometry Dash"
   setOnClickListener { launchGame() }
  })
  root.addView(Button(this).apply {
   this.text = "Importar mod .geode"
   setOnClickListener {
    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
     type = "*/*"
     addCategory(Intent.CATEGORY_OPENABLE)
    }
    startActivityForResult(intent, pickMod)
   }
  })
  root.addView(text("Importar guarda o pacote no Prisma; ainda não instala/carrega o mod no jogo.", 12f))
  setContentView(root)
 }

 private fun launchGame() {
  val intent = packageManager.getLaunchIntentForPackage("com.robtopx.geometryjump")
  if (intent == null) Toast.makeText(this, "Geometry Dash não encontrado. Instale o jogo primeiro.", Toast.LENGTH_LONG).show()
  else startActivity(intent)
 }

 @Deprecated("Use Activity Result API in a future UI refactor")
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
  super.onActivityResult(requestCode, resultCode, data)
  if (requestCode == pickMod && resultCode == RESULT_OK) {
   data?.data?.let { uri -> if (copyMod(uri)) status.text = "Pacote importado para a biblioteca local do Prisma." }
  }
 }

 private fun copyMod(uri: Uri): Boolean = try {
  val dir = File(filesDir, "mods").apply { mkdirs() }
  val name = contentResolver.query(uri, null, null, null, null)?.use { cursor ->
   val index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
   if (cursor.moveToFirst() && index >= 0) cursor.getString(index) else null
  } ?: ("imported-" + System.currentTimeMillis() + ".geode")
  if (!name.endsWith(".geode", ignoreCase = true)) {
   Toast.makeText(this, "Selecione um arquivo .geode", Toast.LENGTH_SHORT).show()
   return false
  }
  contentResolver.openInputStream(uri)?.use { input ->
   File(dir, name).outputStream().use { output -> input.copyTo(output) }
  } ?: return false
  Toast.makeText(this, "Mod importado: " + name, Toast.LENGTH_LONG).show()
  true
 } catch (error: Exception) {
  Toast.makeText(this, "Falha ao importar: " + error.message, Toast.LENGTH_LONG).show()
  false
 }
}
