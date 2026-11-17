import json
import zipfile
from pathlib import Path

root = Path(__file__).resolve().parent
repo = root.parent
labels = [
    "Sistema e dispositivo", "Interface", "Texto", "Matemática", "Data e hora",
    "Arquivos", "Internet", "Segurança", "Aplicativos", "Avançado"
]
files = sorted((root / "categorias").glob("*.json"))
blocks = []
catalog = ["# Catálogo — Blocos BR 100", "", "100 blocos · 10 categorias · 10 blocos por categoria", ""]
for label, path in zip(labels, files):
    group = json.loads(path.read_text(encoding="utf-8"))
    if len(group) != 10:
        raise SystemExit(f"{path.name}: esperado 10 blocos, encontrado {len(group)}")
    blocks.extend(group)
    catalog += [f"## {label}", ""]
    for block in group:
        kind = {"s": "texto", "d": "número", "b": "booleano", " ": "comando"}[block["type"]]
        catalog.append(f"- **{block['name']}** — {block['spec']} ({kind})")
    catalog.append("")
names = [block["name"] for block in blocks]
if len(blocks) != 100 or len(set(names)) != 100:
    raise SystemExit(f"Validação falhou: {len(blocks)} blocos, {len(set(names))} nomes únicos")
(root / "BlocosBR100.json").write_text(json.dumps(blocks, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
(root / "CATALOGO.md").write_text("\n".join(catalog), encoding="utf-8")
zip_path = repo / "BlocosBR100.zip"
with zipfile.ZipFile(zip_path, "w", zipfile.ZIP_DEFLATED) as archive:
    for path in sorted(root.rglob("*")):
        if path.is_file() and path.name != "build_package.py":
            archive.write(path, path.relative_to(repo))
print(f"Pacote criado: {zip_path} ({len(blocks)} blocos)")
