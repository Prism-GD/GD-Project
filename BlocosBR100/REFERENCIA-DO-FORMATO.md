# Referência do formato

O JSON de More Blocks fornecido como referência contém uma lista de objetos com os campos name, palette, spec, typeName, type, code e color. Esses campos foram preservados.

A documentação pública do Sketchware Pro descreve os tipos s (String), b (Boolean) e d (Number), entre outros. O pacote usa esses três tipos de saída e o tipo regular (um espaço) para comandos.

Os marcadores %s, %d e %b representam entradas tipadas; %1$s, %2$s etc. no código apontam para essas entradas em ordem. O sufixo .inputOnly indica um campo digitado manualmente, usado aqui para IDs de Views.

Validação automatizada: JSON válido, 100 nomes únicos, tipos reconhecidos e placeholders conferidos. Isso não substitui importar e compilar os blocos dentro da versão instalada do Sketchware Pro.
