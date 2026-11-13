# Arquitetura inicial

- **Prisma Launcher:** interface, biblioteca de mods, preferências e inicialização.
- **Geometry Dash:** aplicativo separado, instalado pelo usuário.
- **Geode:** loader nativo que carrega mods dentro do processo do jogo.

O Prisma não executa arquivos .geode por conta própria. A tela atual apenas importa pacotes para armazenamento privado. A integração futura deve encaminhá-los ao diretório/gerenciador reconhecido pelo Geode, respeitando as restrições do Android.

Módulos futuros: integração Geode/NDK/CMake; detecção de versão e ABI; instalação/atualização segura de mods; logs e diagnóstico.
