# ATIVIDADE 2 REST - Gianluca Notari Magnabosco da Silva

* Existe um arquivo chamado `import.sql` que contém três registros de Pessoas que são adicionados ao Banco de Dados assim que a aplicação é iniciada!

* O servidor está rodando na porta 8081

* Todos os dados da pessoa são obrigatórios e devem ser inseridos em inserções e atualizações

* Neste respositório temos o modelo Pessoa que pode ser acessado via chamadas à API Rest, as requisições podem ser feitas nas seguintes rotas:

<br/>

## Método GET para http://localhost:8081/pessoa/all
* Retorna uma lista com todas as pessoas cadastradas no sistema;

<br/>

## Método GET para http://localhost:8081/pessoa/{id}
* Retorna os dados da pessoa com o id informado;
* Exemplo: http://localhost:8081/pessoa/1

<br/>

## Método POST para http://localhost:8081/pessoa/add
* Insere uma pessoa no sistema;
* O corpo da mensagem (RequestBody) deve conter os dados da pessoa a ser inserida;
* Exemplo: 

```json
{
    "nome": "Fulano de Tal",
    "cpf": "12332112312",
    "rg": "5035939",
    "dataNasc": "2000-06-14",
    "estadoCivil": "SOLTEIRO",
    "telefone": "+5547999050594",
    "email": "fulano@teste.com"
}
```

* Note que o estadoCivil deve ser ou SOLTEIRO ou CASADO ou VIUVO ou SEPARADO ou DIVORCIADO, caso contrário dará erro

<br/>


## Método PUT para http://localhost:8081/pessoa/{id}
* Atualiza os dados da pessoa com o id informado;
* Exemplo: PUT http://localhost:8081/pessoa/1
* O corpo da mensagem (RequestBody) deve conter os dados da pessoa a ser atualizada;
* Exemplo: 

```json
{
    "nome": "Fulano de Tal",
    "cpf": "12332112312",
    "rg": "5035939",
    "dataNasc": "2000-06-14",
    "estadoCivil": "CASADO",
    "telefone": "+5547999050594",
    "email": "fulano@teste.com"
}
```

* Note que o estadoCivil deve ser ou SOLTEIRO ou CASADO ou VIUVO ou SEPARADO ou DIVORCIADO, caso contrário dará erro

<br/>

## Método DELETE para http://localhost:8081/pessoa/{id}
* Remove a pessoa com o id informado do sistema;
* Exemplo: DELETE http://localhost:8081/pessoa/1


<br/>
<br/>
<br/>

# Para executar as requisições, recomenda-se o uso do POSTMAN

* Após baixar o Postman, crie uma nova requisição HTTP e insira a URL e o Método HTTP que você deseja acessar.
* Lembre-se que o servidor estará rodando na URL http://localhost:8081
* Então, para realizar as requisições insira a URL acima, acessando o recurso /pessoa (http://localhost:8081/pessoa)
* Defina o método desejado, se necessário especifique o RequestBody ou a PathVariable (/pessoa/{id}) - onde {id} é a PathVariable