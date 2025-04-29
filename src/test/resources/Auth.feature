# language: pt

@auth @regressive
Funcionalidade: Gerenciar fluxo de autenticação

  Cenário: Login com credenciais válidas
    Dado que tenho um usuário válido
    Quando executo a requisição para realizar autenticação
    Então o status da resposta deve ser 200
    E a resposta deve conter um token de autenticação válido
    E o tempo da resposta deve ser menor que 2000 milissegundos

  Cenário: Login com senha incorreta
    Dado que tenho um usuário válido
    Quando executo a requisição para realizar autenticação com password incorreto
    Então o status da resposta deve ser 401

  Cenário: Login com usuário inexistente
    Quando executo a requisição para realizar autenticação com um usuário não registrado
    Então o status da resposta deve ser 401

  Cenário: Login com campos obrigatórios ausentes
    Quando executo a requisição para realizar autenticação sem informar o campo username
    Então o status da resposta deve ser 400