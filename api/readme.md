# 🐾 ChicoHub API – Gestão Inteligente para Petshops

Esta API REST é o coração do ecossistema **ChicoHub**, desenvolvida para oferecer uma solução robusta de gerenciamento para petshops. O projeto evoluiu de um gerenciamento local para uma arquitetura moderna baseada em **Containers** e **Segurança Federada**.

## 🚀 Diferenciais Técnicos

* **Segurança com OAuth2 e Google:** Implementação de autenticação social que protege os dados dos pets, garantindo que cada dono acesse apenas suas próprias informações.
* **Infraestrutura como Código (IaC):** Projeto totalmente dockerizado, permitindo o deploy e execução idêntica em qualquer ambiente via Docker Compose.
* **Isolamento de Dados (Privacy by Design):** Uso do e-mail de autenticação para filtrar registros no banco de dados, garantindo privacidade total entre os usuários.
* **Integração com BrasilAPI:** Cadastro de lojas automatizado através da busca de CNPJ, reduzindo erros de digitação e tempo de setup.
* **Arquitetura Relacional Complexa:** Vínculos em cadeia (Loja -> Cliente -> Pet -> Serviço) garantindo rastreabilidade total.

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **Segurança:** Spring Security & OAuth2 (Google Login)
* **DevOps:** Docker & Docker Compose
* **ORM:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL
* **Testes:** Postman

## 🏗️ Estrutura do Projeto

O projeto segue o padrão de camadas para separação de responsabilidades:
* **`controller`**: Endpoints REST protegidos e gerenciamento de requisições.
* **`domain`**: Entidades de negócio e mapeamento JPA complexo.
* **`repository`**: Queries customizadas com filtros de isolamento por proprietário.
* **`config`**: Configurações de segurança e infraestrutura (CORS, OAuth2, Docker).

## 📈 Jornada de Desenvolvimento (Sprints)

### Sprint 1 a 5: Base e Regras de Negócio
* Configuração do ecossistema de Lojas, Clientes, Pets e Serviços.
* Integração com BrasilAPI e persistência em banco de dados relacional.

### Sprint 6: Segurança e Identidade
* Implementação do Spring Security e integração com Google OAuth2.
* Criação do endpoint `/meus-pets` com filtro automático por `donoEmail`.

### Sprint 7: Infraestrutura e DevOps
* Criação de **Dockerfile** otimizado para a aplicação Java.
* Orquestração com **Docker Compose** para gestão automatizada de containers e variáveis de ambiente.



## 🚥 Como Executar (Via Docker)

Este é o modo recomendado para garantir que a aplicação rode com todas as dependências configuradas.

1. **Clone o repositório.**
2. **Configure suas credenciais do Google** no terminal do Linux:
   ```bash
   export GOOGLE_CLIENT_ID=seu_id
   export GOOGLE_CLIENT_SECRET=sua_chave


##Compile o projeto:

./mvnw clean package -DskipTests

##Suba o container:

docker compose up -d

##Acesse no navegador: http://localhost:8080/api/pets/meus-pets

