# language: pt

@cart @regressive
Funcionalidade: Gerenciar fluxo de carrinhos

  Cenário: Requisição com sucesso
    Quando realizo uma busca por todos os carrinhos
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter uma lista de carrinhos
    E o tempo da resposta deve ser menor que 2000 milissegundos

  Cenário: Buscar carrinho existente
    Quando realizo uma busca por um carrinho específico com id 1
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do carrinho

  @Bug
  Cenário: Buscar carrinho inexistente
    Quando realizo uma busca por um carrinho específico com id 9999
    Então o status da resposta deve ser 404

  Cenário: Criar carrinho com dados válidos
    Quando realizo o cadastro de um novo carrinho com dados completos e válidos
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do novo carrinho

  @Bug
  Cenário: Criar carrinho com dados incompletos
    Quando realizo o cadastro de um novo carrinho com campos obrigatórios ausentes
    Então o status da resposta deve ser 400

  Cenário: Atualizar carrinho com dados válidos
    Quando realizo a atualização de um carrinho existente com dados válidos
    Então o status da resposta deve ser 200
    E os dados do carrinho devem ser atualizados corretamente

  Cenário: Deletar carrinho existente
    Quando realizo a exclusão de um carrinho existente com id 1
    Então o status da resposta deve ser 200

  @Bug
  Cenário: Deletar carrinho inexistente
    Quando realizo a exclusão de um carrinho inexistente com id 9999
    Então o status da resposta deve ser 400