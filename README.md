# BillToPay REST API

## Descrição

Este projeto é uma API RESTful desenvolvida com Spring Boot que realiza operações de CRUD (Create, Read, Update, Delete) em contas a pagar. A aplicação está configurada para ser executada em um ambiente Docker utilizando Docker Compose.

## Funcionalidades

- Criar uma nova conta a pagar
- Buscar contas a pagar
- Atualizar uma conta a pagar
- Deletar uma conta a pagar

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Bean Validation
- H2 Database (para desenvolvimento)
- PostgreSQL (para produção)
- Docker
- Docker Compose

## Pré-requisitos

- Docker instalado
- Docker Compose instalado
- JDK 17 instalado

## Configuração do Ambiente de Desenvolvimento

- Abrir a pasta src/main/resources/docker/postgres e rodar os comandos:

```bash
docker build -t my-postgres .
docker run -d -p 5432:5432 --name my-postgres-container my-postgres

### Clonar o Repositório

```bash
git clone https://github.com/douglasvboas/CRUD-API-REST-CONTAS-A-PAGAR.git