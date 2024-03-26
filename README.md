<a name="readme-top"></a>

# Introdução

O Produto Service é um sistema de gestão de itens que oferece aos usuários a capacidade de controle de cadastro e manipulação de itens, bem como seus preços.


## Sumário
* [Instruções](#instruções)
* [Funcionalidades de Produto Service](#funcionalidades-de-produto-service)
* [Tecnologias](#-tecnologias)
* [Ilustração do MS Produto Service](#-ilustração-do-ms-produto-service)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok, Validation e MySql, portanto é necessário adicionar os plugins na IDE
- Antes de iniciar a instância dos Microserviços, é necessário garantir que os seguintes serviços estejam operacionais para garantir a operação adequada:</br>

	* **Service Discovery** - Inicie o Service Discovery. Execute e verifique se pelo menos uma instância do Service Discovery está operacional.</br></br>
	
	* **API Gateway** - Inicie o API Gateway. Verifique se pelo menos uma instância do API Gateway está em execução.

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
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFETUlOIiwidXNlcklkIjo0fQ.TpdJ2zQludisCSS8ujlNwn6Y_uaE5OZF-lfcHJMm0is' \
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
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFETUlOIiwidXNlcklkIjo0fQ.TpdJ2zQludisCSS8ujlNwn6Y_uaE5OZF-lfcHJMm0is' \
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

## 📍️ Tecnologias

- A API foi construída em Java 18 utilizando Spring Framework 3.2.2
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MySql

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

## 📍️ Ilustração do MS Produto Service

![produto-service.png](document%2Fproduto-service.png)

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>