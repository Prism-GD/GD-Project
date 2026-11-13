# GD-Project

Série de projetos com ferramentas para Termux/F-Droid, mods Geode e o Prisma Launcher.

## Prisma Launcher

Aplicativo Android em desenvolvimento para organizar e iniciar o Geometry Dash, com integração planejada ao Geode.

A estrutura Android inicial está na pasta `app/`. Consulte:
- [Arquitetura](docs/ARCHITECTURE.md)
- [Integração Geode](docs/GEODE_INTEGRATION.md)
- [Build](docs/BUILD.md)

**Estado:** protótipo inicial. A tela abre o Geometry Dash instalado e importa arquivos `.geode` para a área privada do Prisma. A integração nativa do Geode ainda não foi portada; portanto, a importação não ativa mods dentro do jogo.

O build de CI gera um APK de debug quando passa. Isso não significa que a integração Geode esteja pronta.

Não distribuímos arquivos proprietários do Geometry Dash.
