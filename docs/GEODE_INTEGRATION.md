# Integração Geode — plano técnico e estado real

## Estado desta branch

O loader Geode **ainda não está incorporado** nesta branch. O aplicativo atual é apenas uma casca Android: abre o Geometry Dash instalado e importa arquivos `.geode` para o armazenamento privado do Prisma. Isso não instala, injeta nem carrega mods no processo do jogo.

## Upstream oficial

O projeto oficial para Android é https://github.com/geode-sdk/android-launcher. Ele não é apenas uma biblioteca: contém a Activity que prepara/inicia o jogo, código JNI/C++ de patching, integração com diretórios, recursos, logs e atualização. A integração correta exige portar/adaptar esses componentes, não apenas adicionar uma dependência Maven.

O framework/loader fica em https://github.com/geode-sdk/geode.

## Versão

A intenção original do projeto é Geode 6.0.0. Antes de fixar uma release, validar no upstream se a versão é estável ou pré-lançamento e se existe binário Android compatível com a versão exata do Geometry Dash. Não substituir silenciosamente a versão desejada por outra. A build atual do launcher oficial consultada usa Geode 5.11.2 como versão de download — isso não prova compatibilidade com Geode 6.

## Trabalho necessário para carregar mods de verdade

1. Portar o fluxo de instalação/lançamento Android do upstream, preservando avisos/licença BSL-1.0.
2. Integrar JNI/C++ e o patcher nativo do launcher oficial via CMake/NDK.
3. Resolver o acesso ao diretório de dados do jogo segundo a versão do Android e o mecanismo suportado pelo launcher.
4. Instalar/atualizar o loader e seus recursos, verificando hashes dos downloads.
5. Fazer o Prisma administrar os pacotes .geode usando a API/diretório reconhecido pelo loader, em vez de guardá-los numa pasta privada isolada.
6. Validar versão do Geometry Dash, versão do Geode e ABI do aparelho.
7. Testar em aparelho físico: primeiro boot, inicialização sem mods, instalação de um mod compatível, reinício, atualização e remoção.

## Limites e segurança

- Não empacotar nem redistribuir APK ou assets proprietários do Geometry Dash.
- Não baixar binários não verificados nem carregar mods de origem desconhecida automaticamente.
- Não declarar compatibilidade com Android/ABI sem teste real.
- O APK de debug, quando a CI passar, ainda não será prova de que o loader nativo funciona.
