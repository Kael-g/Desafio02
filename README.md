# Sistema Registro de Vendas
Sistema responsável pelos registros de vendas de uma organização. O usuário pode visualizazr clientes cadastrados, vendedores cadastrados e vendas registradas, pode pesquisar o histórico de completo de um cliente através de seu CPF, o histórico de vendas completo de um vendedor através de seu e-mail, cadastrar novos clientes, novos vendedores e novas vendas.
## > Menu Inicial
Possui as seguintes opções:
1. Ver registros
2. Fazer novo cadastro
3. Sair
### > > Ver registros
Possui as seguintes opções:
1. Listar todos os vendedores
2. Listar todos os clientes
3. Listar todas as vendas
4. Histórico de vendas de um vendedor
5. Histórico de compras de um cliente
6. Voltar
#### > > > Listar todos os vendedores
Exibe uma lista de todos os vendedores cadastrados, com seu nome, e-mail e CPF
#### > > > Listar todos os clientes
Exibe uma lista de todos os clientes cadastrados, com seu nome, e-mail e CPF
#### > > > Listar todas as vendas
Exibe uma lista de todas as vendas cadastradas, com nome do vendedor responsável, cliente, valor da venda e data de registro
#### > > > Histórico de vendas de um vendedor
Solicita que o usuário digite o e-mail do vendedor para exibir todas as suas vendas
  - Verifica se o texto digitado é um formato de e-mail válido, se não for, exibe mensagem de "E-mail inválido"
  - Se for um e-mail válido, verifica se há vendedor registrado com o e-mail, se não houver, exibe a mensagem "Vendedor não encontrado"
  - Se houver vendedor cadastrado com o e-mail informado, exibe todas as suas vendas
#### > > > Histórico de compras de um cliente
Solicita que o usuário digite o CPF do cliente para exibir todas as suas compras
  - Verifica se o texto digitado é um formato de CPF válido, se não for, exibe mensagem de "CPF inválido"
  - Se for um CPF válido, verifica se há cliente registrado com o CPF, se não houver, exibe a mensagem "Cliente não encontrado"
  - Se houver cliente cadastrado com o CPF informado, exibe todas as suas compras
#### > > > Voltar
Exibe o menu inicial
### > > Fazer novo cadastro
Possui as seguintes opções:
1. Cadastrar novo cliente
2. Cadastrar novo vendedor
3. Cadastrar nova venda
4. Voltar
#### > > > Cadastrar novo cliente
Solicita que o usuário digite o nome, e-mail e cpf do cliente a ser cadastrado
  - Verifica se o nome possui conteúdo (não é String vazia)
  - Verifica se o texto digitado para cpf é um formato de CPF válido e se não existe cliente castrado com o CPF informado
  - Verifica se o texto digitado para e-mail é um formato de e-mail válido e se não existe cliente cadastrado com o e-mail informado
  - Se passar por todas as validações com sucesso, cadastra o cliente
#### > > > Cadastrar novo vendedor
Solicita que o usuário digite o nome, e-mail e cpf do vendedor a ser cadastrado
  - Verifica se o nome possui conteúdo (não é String vazia)
  - Verifica se o texto digitado para cpf é um formato de CPF válido e se não existe vendedor castrado com o CPF informado
  - Verifica se o texto digitado para e-mail é um formato de e-mail válido e se não existe vendedor cadastrado com o e-mail informado
  - Se passar por todas as validações com sucesso, cadastra o vendedor
#### > > > Cadastrar nova venda
Solicita que o usuário digite CPF do vendedor responsável pela venda, CPF do cliente e valor da venda
  - Verifica se os textos digitados para CPFs são formatos válidos de CPF e se correspondem a um vendedor e cliente cadastrados
  - Verifica se o valor digitado possui formato válido para valor
  - Se passar por todas as validações com sucesso, cadastra a venda. A data de registro da venda é a data atual
#### > > > Voltar
Exibe menu inicial
### > > Sair
Finaliza o programa

### * Opções inválidas
Caso o usuário digite uma opção inválida em qualquer um dos menus, exibe a mensagem "Opção inválida" e retorna ao menu inicial

# Possíveis melhorias
- Formatar o CPF no momento de exibir lista de vendedores e clientes cadastrados para o formato 000.000.000-00. Atualmente exibe apenas números
- Validar informações de entrada nos cadastros de cliente, vendedor e venda conforme vão sendo inseridas. Atualmente recebe todas as informações e só então faz as validações
- Permitir que o usuário modifique e exclua vendedores, clientes e vendas cadastrados
- Confirmar informações inseridas ao cadastrar vendedor, cliente ou venda, e permitir que o usuário modifique alguma informação errada
- Melhorar a forma de selecionar o vendedor e cliente no momento de cadastrar nova venda. Atualmente só é possível selecionar digitando o CPF, e a lista não é exibida nesse momento
- Informar que não há clientes, vendedores ou vendas cadastradas no momento de listar todos, fazer pesquisas ou cadastrar venda, caso não haja cadastro das categorias solicitadas ou necessárias
