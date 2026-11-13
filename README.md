# GD-Project

Série de projetos com ferramentas para Termux/F-Droid, mods Geode e o Prisma Launcher.

## Prisma Launcher

Launcher Android baseado no código-fonte oficial do [Geode Android Launcher](https://github.com/geode-sdk/android-launcher), com adaptação de identidade e build para o Prisma.

O código oficial fica fixado em `third_party/geode-android` como submódulo Git. O workflow aplica Geode `6.0.0-alpha.1`, identidade de pacote `com.prismgd.launcher` e nome `Prisma Launcher`, e compila o motor Android com JNI/patcher C++ e payloads nativos do Geode.

- [Arquitetura](docs/ARCHITECTURE.md)
- [Integração Geode](docs/GEODE_INTEGRATION.md)
- [Build](docs/BUILD.md)

**Estado:** integração do código upstream e adaptação de build em andamento. O APK só será considerado pronto após CI verificar a presença das bibliotecas nativas e testes reais no Geometry Dash 2.2091 confirmarem menu Geode e carregamento de um mod. O app antigo em `app/` é apenas o protótipo inicial e não é o artefato de integração.

Não distribuímos o APK nem assets proprietários do Geometry Dash.
