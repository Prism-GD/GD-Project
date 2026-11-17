# Blocos BR 100 — Sketchware Pro

Pacote com 100 blocos personalizados em português, separados em 10 categorias (10 blocos por categoria).

## Conteúdo
- categorias/: JSONs individuais, um por categoria.
- BlocosBR100.json: arquivo único com os 100 blocos (gerado pelo script).
- CATALOGO.md: lista dos blocos e seus tipos.
- manifest.json: resumo técnico do pacote.

## Importar no Sketchware Pro
1. Abra o menu de três pontos.
2. Entre em Ferramentas do desenvolvedor → Gerenciador de blocos.
3. Crie uma paleta para a categoria desejada e abra-a.
4. Abra o menu da paleta → Importar bloco.
5. Escolha o JSON da pasta categorias/ e selecione os blocos.

Para reunir tudo em uma paleta, importe BlocosBR100.json em vez dos arquivos individuais.

## Conexões de dados
- s: saída de texto.
- d: saída numérica.
- b: saída booleana (verdadeiro/falso).
- espaço: comando sem retorno.

Exemplo: Obter modelo do dispositivo (s) pode alimentar uma entrada de texto de Definir texto do TextView.

## Observações
O formato segue os campos do JSON de referência enviado: name, palette, spec, typeName, type, code e color. O pacote foi validado estruturalmente (JSON, nomes únicos, tipos e placeholders), mas não foi compilado dentro do Sketchware Pro. Compatibilidade de APIs pode variar entre versões e forks.

Os blocos de Interface que pedem um ID usam o nome do componente do layout, digitado manualmente. Os blocos de Arquivos trabalham no armazenamento privado do app. O bloco de vibração requer android.permission.VIBRATE no manifesto. Evite o bloco Pausar execução na thread principal, pois ele pode congelar a interface.

A paleta/ID 138 foi preservada do JSON de referência; importe dentro da paleta de destino pelo Gerenciador de blocos.
