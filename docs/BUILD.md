# Build

O build integrado usa o código oficial fixado em `third_party/geode-android`.

Requisitos do workflow:
- JDK 17
- Gradle 9.4.1
- Android SDK Platform 37
- Android NDK 30.0.16248370
- CMake 3.21.0

O GitHub Actions:
1. inicializa o submódulo oficial;
2. fixa Geode `6.0.0-alpha.1`;
3. aplica o identificador e nome Prisma;
4. compila a variante Google Play, que inclui os binários e recursos do loader;
5. verifica se o APK contém `libgeode.so` e `liblauncherfix.so` para ARM64 e ARMv7.

O artefato de CI é apenas para validação técnica. Não é uma declaração de compatibilidade com GD 2.2091. A entrega depende de teste em aparelho físico, incluindo menu Geode e carregamento de mod. O antigo módulo `app/` é o protótipo legado, não o build integrado.

Acompanhe o workflow em [GitHub Actions](https://github.com/Prism-GD/GD-Project/actions).
