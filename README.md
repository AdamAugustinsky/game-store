# Game-Store project

Este projeto foi feito utilizando Quarkus, devido à sua grande velocidade e baixo uso de memoria, saiba mais em https://quarkus.io/

## Como Executar a API

Antes de executar a API, utilize o comando abaixo para criar o banco de dados postgres usando o docker
```sh
  docker-compose up -d
```

Para executar os testes da APi, utilize o comando
```sh
  ./mvnw clean test
```

Para executar a API em modo de desenvolvimento, utilize o comando
```sh
  ./mvnw quarkus:dev
```

Para realizar o build da API, utilize o comando
```sh
  ./mvnw clean package
```
Após a execução, o arquivo .jar ficará disponível em /target/quarkus-app/quarkus-run.jar

Saiba mais em https://quarkus.io/guides/maven-tooling

## Documentação

Para uma fácil interação com a API é possivel ir em http://localhost:8080/q/swagger-ui

Ou utilizar o arquivo yaml com a documentação openapi gerada automaticamente em http://localhost:8080/q/openapi

---

Já existem 2 carrinhos de teste com produtos(ids: 1,2)

Para começar a interagir com a API, crie um Carrinho utilizando a rota

### POST /carts

Request body
```json
{
}
```

Response body
```json
{
  "id": 3,
  "products": []
}
```

---

Adicione um produto ao carrinho

### PUT /carts/products/{cartId} <-- id do carrinho criado anteriormente

Request body
```json
{
  "image": "teste",
  "name": "teste",
  "price": 149.99,
  "score": 10
}
```

Response body
```json
{
  "id": 3,
  "products": [
    {
      "id": 12,
      "image": "teste",
      "name": "teste",
      "price": 149.99,
      "score": 10
    }
  ]
}
```

---

Visualize o carrinho por completo

### GET /carts/products/{cartId} <-- id do carrinho criado anteriormente

Response body
```json
{
  "id": 3,
  "products": [
    {
      "id": 12,
      "image": "teste",
      "name": "teste",
      "price": 149.99,
      "score": 10
    }
  ]
}
```

---

Para organizar a visualização do carrinho em ordem alfabética, popularidade ou preço, utilize os query params na rota

### GET /carts/products/{cartId}/?alphabetical_order=true&price_order=false&score_order=false

Response body
```json
{
  "id": 3,
  "products": [
    {
      "id": 12,
      "image": "teste",
      "name": "teste",
      "price": 149.99,
      "score": 10
    }
  ]
}
```

---

Faça o checkout do carrinho

### GET /carts/{cartId}/checkout <-- id do carrinho criado anteriormente

Response body
```json
{
  "shipping_price": 20,
  "subtotal": 149.99,
  "total": 169.99
}
```

---

Remova um produto indesejado do carrinho

### DELETE /carts/products/{cartId}/{productId} <-- id do produto que deseja remover

Response body
```json
{
  "id": 3,
  "products": [
  ]
}
```
