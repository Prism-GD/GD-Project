# Catálogo — Blocos BR 100

100 blocos · 10 categorias · 10 blocos por categoria

## Sistema e dispositivo

- **br100_modelo_dispositivo** — Obter modelo do dispositivo (texto)
- **br100_fabricante** — Obter fabricante (texto)
- **br100_marca** — Obter marca do dispositivo (texto)
- **br100_dispositivo** — Obter nome interno do dispositivo (texto)
- **br100_produto** — Obter nome do produto (texto)
- **br100_versao_android** — Obter versão do Android (texto)
- **br100_sdk_android** — Obter nível da API Android (número)
- **br100_id_build** — Obter identificador da compilação (texto)
- **br100_idioma** — Obter idioma do dispositivo (texto)
- **br100_pais** — Obter país/região do dispositivo (texto)

## Interface

- **br100_textview_texto** — Definir texto do TextView %s.inputOnly para %s (comando)
- **br100_textview_cor** — Definir cor do texto %s.inputOnly para %d (comando)
- **br100_view_visibilidade** — Definir visibilidade da View %s.inputOnly para %d (comando)
- **br100_view_habilitada** — Definir View %s.inputOnly habilitada? %b (comando)
- **br100_view_alpha** — Definir transparência da View %s.inputOnly para %d (comando)
- **br100_view_foco** — Solicitar foco para View %s.inputOnly (comando)
- **br100_view_descricao** — Definir descrição da View %s.inputOnly para %s (comando)
- **br100_view_cor_fundo** — Definir cor de fundo da View %s.inputOnly para %d (comando)
- **br100_textview_tamanho** — Definir tamanho do texto %s.inputOnly para %d sp (comando)
- **br100_toast** — Mostrar aviso %s (comando)

## Texto

- **br100_texto_juntar** — Juntar textos %s e %s (texto)
- **br100_texto_maiusculas** — Converter %s para MAIÚSCULAS (texto)
- **br100_texto_minusculas** — Converter %s para minúsculas (texto)
- **br100_texto_trim** — Remover espaços das pontas de %s (texto)
- **br100_texto_tamanho** — Obter quantidade de caracteres de %s (número)
- **br100_texto_contem** — O texto %s contém %s? (booleano)
- **br100_texto_substituir** — Em %s substituir %s por %s (texto)
- **br100_texto_comeca** — O texto %s começa com %s? (booleano)
- **br100_texto_termina** — O texto %s termina com %s? (booleano)
- **br100_texto_vazio** — O texto %s está vazio? (booleano)

## Matemática

- **br100_num_somar** — Somar %d + %d (número)
- **br100_num_subtrair** — Subtrair %d - %d (número)
- **br100_num_multiplicar** — Multiplicar %d × %d (número)
- **br100_num_dividir** — Dividir %d ÷ %d (número)
- **br100_num_resto** — Obter resto de %d ÷ %d (número)
- **br100_num_absoluto** — Obter valor absoluto de %d (número)
- **br100_num_arredondar** — Arredondar %d (número)
- **br100_num_maximo** — Maior entre %d e %d (número)
- **br100_num_minimo** — Menor entre %d e %d (número)
- **br100_num_par** — O número %d é par? (booleano)

## Data e hora

- **br100_data_timestamp** — Obter timestamp atual em milissegundos (número)
- **br100_data_ano** — Obter ano atual (número)
- **br100_data_mes** — Obter mês atual (1 a 12) (número)
- **br100_data_dia** — Obter dia do mês atual (número)
- **br100_data_hora** — Obter hora atual (0 a 23) (número)
- **br100_data_minuto** — Obter minuto atual (número)
- **br100_data_segundo** — Obter segundo atual (número)
- **br100_data_formatada** — Obter data/hora no formato %s (texto)
- **br100_data_dia_semana** — Obter dia da semana (1=domingo) (número)
- **br100_data_bissexto** — O ano %d é bissexto? (booleano)

## Arquivos

- **br100_arquivo_escrever** — Salvar no arquivo %s o texto %s (comando)
- **br100_arquivo_existe** — O arquivo %s existe? (booleano)
- **br100_arquivo_apagar** — Apagar o arquivo %s (comando)
- **br100_arquivo_tamanho** — Obter tamanho do arquivo %s em bytes (número)
- **br100_arquivo_criar_pasta** — Criar pasta interna %s (comando)
- **br100_arquivo_pasta_existe** — A pasta interna %s existe? (booleano)
- **br100_arquivo_listar_qtd** — Contar arquivos na pasta interna %s (número)
- **br100_arquivo_renomear** — Renomear arquivo %s para %s (comando)
- **br100_arquivo_limpar_cache** — Limpar arquivos do cache do aplicativo (comando)
- **br100_arquivo_caminho** — Obter caminho da pasta privada do aplicativo (texto)

## Internet

- **br100_url_codificar** — Codificar texto para URL %s (texto)
- **br100_url_decodificar** — Decodificar texto de URL %s (texto)
- **br100_url_valida** — O endereço %s parece ser uma URL válida? (booleano)
- **br100_url_host** — Obter domínio da URL %s (texto)
- **br100_url_protocolo** — Obter protocolo da URL %s (texto)
- **br100_url_porta** — Obter porta da URL %s (número)
- **br100_url_caminho** — Obter caminho da URL %s (texto)
- **br100_url_abrir** — Abrir endereço %s no navegador (comando)
- **br100_url_compartilhar** — Compartilhar endereço %s (comando)
- **br100_url_contem_https** — O endereço %s usa HTTPS? (booleano)

## Segurança

- **br100_seg_base64_codificar** — Codificar em Base64 o texto %s (texto)
- **br100_seg_base64_decodificar** — Decodificar Base64 %s (texto)
- **br100_seg_uuid** — Gerar identificador UUID (texto)
- **br100_seg_aleatorio** — Gerar número aleatório entre %d e %d (número)
- **br100_seg_senha_tamanho** — A senha %s tem pelo menos %d caracteres? (booleano)
- **br100_seg_email** — O texto %s tem formato básico de e-mail? (booleano)
- **br100_seg_numerico** — O texto %s contém somente números? (booleano)
- **br100_seg_hash_java** — Obter hashCode Java do texto %s (número)
- **br100_seg_limpar_html** — Remover tags HTML simples de %s (texto)
- **br100_seg_comparar** — Comparar textos %s e %s (iguais?) (booleano)

## Aplicativos

- **br100_app_compartilhar_texto** — Compartilhar texto %s (comando)
- **br100_app_ligar** — Abrir discador com número %s (comando)
- **br100_app_email** — Abrir aplicativo de e-mail para %s com assunto %s (comando)
- **br100_app_copiar** — Copiar para área de transferência o texto %s (comando)
- **br100_app_abrir_config** — Abrir configurações do Android (comando)
- **br100_app_info** — Abrir informações deste aplicativo (comando)
- **br100_app_pacote** — Obter nome do pacote do aplicativo (texto)
- **br100_app_abrir_pacote** — Tentar abrir aplicativo com pacote %s (comando)
- **br100_app_toast_longo** — Mostrar aviso longo %s (comando)
- **br100_app_vibrar** — Vibrar por %s milissegundos (comando)

## Avançado

- **br100_adv_log** — Registrar no Logcat a mensagem %s (comando)
- **br100_adv_log_erro** — Registrar erro no Logcat %s (comando)
- **br100_adv_memoria_livre** — Obter memória livre da JVM em bytes (número)
- **br100_adv_memoria_total** — Obter memória total da JVM em bytes (número)
- **br100_adv_memoria_max** — Obter memória máxima da JVM em bytes (número)
- **br100_adv_thread** — Obter nome da thread atual (texto)
- **br100_adv_thread_id** — Obter ID da thread atual (número)
- **br100_adv_timestamp_ns** — Obter tempo monotônico em nanossegundos (número)
- **br100_adv_gc** — Solicitar coleta de lixo da memória (comando)
- **br100_adv_pausar** — Pausar execução por %s milissegundos (comando)
