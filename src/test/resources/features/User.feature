# language: pt

@user @regressive
Funcionalidade: Gerenciar fluxo de usuários

  Cenário: Requisição com sucesso
    Quando realizo uma busca por todos os usuários
    Entao o status da resposta deve ser 200
    E o corpo da resposta deve conter uma lista de usuários
    E o tempo da resposta deve ser menor que 2000 milissegundos

  Cenário: Buscar usuário existente
    Quando realizo uma busca por um usuário específico com id 1
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do usuário

  @Bug
  Cenário: Buscar usuário inexistente
    Quando realizo uma busca por um usuário específico com id 9999
    Então o status da resposta deve ser 404

  Cenário: Criar usuário com dados válidos
    Quando realizo o cadastro de um novo usuário com dados completos e válidos
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do novo usuário

  @Bug
  Cenário: Criar usuário com dados incompletos
    Quando realizo o cadastro de um novo usuário com campos obrigatórios ausentes
    Então o status da resposta deve ser 400

  @Bug
  Cenário: Criar usuário com tipos de dados inválidos
    Quando realizo o cadastro de um novo usuário com tipos de dados inválidos
    Então o status da resposta deve ser 400

  Cenário: Atualizar usuário com dados válidos
    Quando realizo a atualização de um usuário existente com dados válidos
    Então o status da resposta deve ser 200
    E os dados do usuário devem ser atualizados corretamente

  Cenário: Deletar usuário existente
    Quando realizo a exclusão de um usuário existente com id 1
    Então o status da resposta deve ser 200

  @Bug
  Cenário: Deletar usuário inexistente
    Quando realizo a exclusão de um usuário inexistente com id 9999
    Então o status da resposta deve ser 400