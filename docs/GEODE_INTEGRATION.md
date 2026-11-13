# Integração Geode — plano técnico e estado real

## Estado desta branch

O loader Geode **ainda não está incorporado** nesta branch. O aplicativo atual é uma casca Android que abre o Geometry Dash instalado e importa arquivos `.geode` para o armazenamento privado do Prisma. Isso não instala, injeta nem carrega mods no processo do jogo.

## Upstream oficial e bloqueio de compatibilidade

- Launcher Android: https://github.com/geode-sdk/android-launcher
- Loader/SDK: https://github.com/geode-sdk/geode
- Release alvo: https://github.com/geode-sdk/geode/releases/tag/v6.0.0-alpha.1

O Geode v6.0.0-alpha.1 anuncia suporte a Geometry Dash 2.209x e inclui pacotes Android 32-bit e 64-bit. É uma alpha para desenvolvedores, não uma versão estável.

O launcher Android oficial tem release 1.9.0. As notas dessa release dizem explicitamente: **"This update is not Geode for 2.209!"**. Portanto, não é correto combinar o APK 1.9.0 com o jogo 2.2091 e declarar que o Geode 6 está funcionando. O upstream Android Launcher também contém JNI/C++, patcher, gerenciamento de diretórios, instalação/atualização de loader e fluxo de inicialização; não é uma dependência Maven simples.

## Alvo de desenvolvimento

- Dispositivo: Samsung Galaxy A04s
- ABI principal pretendida: `arm64-v8a`
- Geometry Dash pretendido: 2.2091 / 2.209x
- Geode pretendido: 6.0.0-alpha.1

Esses são alvos de desenvolvimento, não uma declaração de compatibilidade testada.

## Trabalho necessário para carregar mods de verdade

1. Fixar e auditar os commits exatos do loader v6 e do Android launcher.
2. Portar/adaptar o fluxo Android de instalação e lançamento do upstream, preservando avisos e licença BSL-1.0.
3. Integrar JNI/C++ e o patcher nativo via CMake/NDK para a ABI escolhida.
4. Implementar a instalação/atualização dos binários Android 64-bit da release Geode 6, com validação de hashes e tratamento de falhas.
5. Resolver o acesso aos dados do jogo respeitando as restrições de armazenamento da versão Android.
6. Fazer o Prisma administrar os pacotes .geode no diretório/API reconhecido pelo loader, em vez de mantê-los numa pasta privada isolada.
7. Testar em aparelho físico: primeiro boot, inicialização sem mods, instalação de mod compatível, reinício, atualização, safe mode e remoção.
8. Só então publicar APK como compatível com Geometry Dash 2.2091 e Geode 6.

## Critérios para considerar pronto

- O APK instala no Galaxy A04s.
- O jogo original instalado continua sendo usado; não redistribuímos Geometry Dash.
- O Prisma consegue preparar e iniciar o jogo pelo loader Geode.
- O menu Geode aparece dentro do jogo.
- Um mod Android/arm64 compatível é instalado, carregado e removido com sucesso.
- Safe mode permite iniciar o jogo sem mods.
- CI verde não substitui o teste no aparelho físico.

## Limites e segurança

- Não empacotar nem redistribuir APK ou assets proprietários do Geometry Dash.
- Não baixar binários não verificados nem carregar mods desconhecidos automaticamente.
- Não declarar compatibilidade com Android/ABI sem teste real.
- O APK de debug da casca atual não é um launcher Geode funcional.


## Auditoria do código upstream (13/11/2026)

Foi inspecionada a árvore atual de `geode-sdk/android-launcher`, não apenas a release binária:

- O projeto upstream é um aplicativo Android completo: Activity própria para executar o Geometry Dash, classes de diretório/instalação, JNI e patcher C++.
- O arquivo upstream `app/build.gradle.kts` atualmente fixa `currentGeodeVersion = "5.11.2"`; portanto, apontar apenas para a branch principal também **não** entrega automaticamente Geode 6.0.0-alpha.1.
- O launcher upstream faz download e validação de metadados/hash dos binários Geode e extrai recursos do loader durante o build.
- O patcher nativo atua no processo do jogo (incluindo hooks ELF/relocações); não pode ser substituído por uma chamada Android que apenas abre o pacote do Geometry Dash.
- A release 1.9.0 publicada em 19/10/2026 declara nas próprias notas que não é Geode para 2.209, apesar de corrigir alguns crashes dessa versão.

Fontes primárias:
- https://github.com/geode-sdk/android-launcher
- https://github.com/geode-sdk/android-launcher/blob/main/app/build.gradle.kts
- https://github.com/geode-sdk/android-launcher/blob/main/app/src/main/cpp/patcher.cpp
- https://github.com/geode-sdk/android-launcher/releases/tag/1.9.0
- https://github.com/geode-sdk/geode/releases/tag/v6.0.0-alpha.1

## Fonte upstream incorporada ao repositório (13/11/2026)

O código-fonte oficial do Geode Android Launcher foi adicionado como submódulo Git em `third_party/geode-android`, fixado no commit upstream `9e136f728d35bdd60b8e66f382e0d1e405376854`. O workflow do GitHub Actions agora inicializa submódulos recursivamente. A licença e o histórico permanecem no repositório upstream.

Isso incorpora o código-fonte do motor oficial ao projeto, mas **não significa que o Prisma já o execute**: a aplicação atual ainda não foi substituída/adaptada para usar as Activities, o JNI, o patcher C++ e o processo de instalação desse subprojeto. O build atual do Prisma ainda compila a casca original. Além disso, o submódulo upstream fixa Geode 5.11.2 no Gradle, então o alvo 6.0.0-alpha.1 ainda exige adaptação e validação de download/recursos.

## Decisão de implementação

A integração deve ser feita como port/adaptação do launcher Android upstream para a identidade e interface Prisma, mantendo o motor de inicialização, as classes de acesso ao jogo, o patcher/JNI, o empacotamento de recursos e os avisos/licenças. O Geode deve ser fixado explicitamente na versão alpha solicitada e os binários devem ser validados por hash.

Não tratar o launcher upstream como biblioteca, não copiar apenas `Geode.*.so` para o APK e não mover arquivos `.geode` para uma pasta privada arbitrária: nenhuma dessas ações, isoladamente, carrega mods no processo do jogo.

**Estado atual:** o código-fonte upstream está incorporado como submódulo fixado, mas o port de runtime ainda não está concluído. A integração funcional exige ligar o módulo Android upstream ao aplicativo Prisma, adaptar o carregamento para Geode 6.0.0-alpha.1 e validar o patcher no Geometry Dash 2.2091 em aparelho físico. Nenhum APK deve ser tratado como entrega até esses passos terminarem.
