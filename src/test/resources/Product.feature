# language: pt

@product @regressive
Funcionalidade: Gerenciar fluxo de produtos

  Cenário: Consultar todos os produtos com sucesso
    Quando realizo uma busca por todos os produtos
    Então o status da resposta deve ser 200
    E a resposta deve conter uma lista de produtos
    E o tempo da resposta deve ser menor que 2000 milissegundos

  Cenário: Buscar usuário existente
    Quando realizo uma busca por um produto específico com id 3
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do produto

  @Bug
  Cenário: Consultar produto com ID inexistente
    Quando realizo uma busca por um produto específico com id 999
    Então o status da resposta deve ser 404

  Cenário: Criar produto com dados válidos
    Quando realizo o cadastro de um novo produto com dados completos e válidos
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do novo produto

  @Bug
  Cenário: Criar produto com dados incompletos
    Quando realizo o cadastro de um novo produto com campos obrigatórios ausentes
    Então o status da resposta deve ser 400

  Cenário: Atualizar produto com dados válidos
    Quando realizo a atualização de um produto existente com dados válidos
    Então o status da resposta deve ser 200
    E os dados do produto devem ser atualizados corretamente

  Cenário: Deletar produto existente
    Quando realizo a exclusão de um produto existente com id 3
    Então o status da resposta deve ser 200

  @Bug
  Cenário: Deletar produto inexistente
    Quando realizo a exclusão de um produto inexistente com id 999
    Então o status da resposta deve ser 400