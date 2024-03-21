<a name="readme-top"></a>

# Introdução

O Produto Service é um sistema de gestão de itens que oferece aos usuários a capacidade de controle de cadastro e manipulação de itens, bem como seus preços.


## Sumário
* [Instruções](#instruções)
* [Funcionalidades de Produto Service](#funcionalidades-de-produto-service)
* [Tecnologias](#-tecnologias)
* [Desafios](#-desafios)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok, Validation e MySql, portanto é necessário adicionar os plugins na IDE
- Antes de iniciar a instância do microserviço Produto-Service, é necessário garantir que os seguintes serviços estejam operacionais:
	* Service Discovery  &  API Gateway

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

### Funcionalidades de Produto Service

>[ Base URL: http://localhost:porta ] 

`Substitua <porta> pela porta atribuída dinamicamente pelo ambiente.`


### ``POST``  
`*Para criar produto`

```
	/produtos
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:42019/produtos' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Mouse",
    "descricao": "HyperX",
    "preco": 150.00
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

201 - _Created_
`- Será retornado o id do produto criado.`

```
1
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter produto pelo id`

```
	/produtos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:42019/produtos/1'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o produto`

```
{
    "id": 1,
    "nome": "Mouse",
    "descricao": "HyperX",
    "preco": 150.0,
    "status": "ATIVO",
    "dataCriacao": "2024-03-21T20:15:33.816997"
}
```

404 - _Not Found_

```
{
    "code": "tc.produtoNaoEncontrado",
    "message": "Produto não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter todos os produtos cadastrados`

```
	/produtos
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:42019/produtos'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado todos os produtos ativos`

```
[
    {
        "id": 1,
        "nome": "Mouse",
        "descricao": "HyperX",
        "preco": 150.0,
        "status": "ATIVO",
        "dataCriacao": "2024-03-21T20:15:33.816997"
    },
    {
        "id": 2,
        "nome": "Teclado",
        "descricao": "HyperX",
        "preco": 500.0,
        "status": "ATIVO",
        "dataCriacao": "2024-03-21T20:23:35.090652"
    }
]
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de um produto`

```
	/produtos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:42019/produtos/1' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Mouse Alterado",
    "descricao": "HyperX Alerado",
    "preco": 200.00
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_
`- O produto foi alterado com sucesso`

404 - _Not Found_

```
{
    "code": "tc.produtoNaoEncontrado",
    "message": "Produto não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``
`*Para inativar o produto`

```
	/produtos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:42019/produtos/2'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_
`- O produto foi inativado com sucesso`
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="tecnologias"></a>
## 📍️ Tecnologias

- A API foi construída em Java 17 utilizando Spring Framework 3.2.2
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MySql

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="desafios"></a>
## 📍️ Desafios

A arquitetura do Spring Cloud como um todo, alinhado com o uso de Microserviços, nos obrigou a utilizar diversos patterns para que no mundo cloud tudo se conecta-se corretamente e claro, juntamente com as boas práticas, funcionassem perfeitamente como o esperado.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>