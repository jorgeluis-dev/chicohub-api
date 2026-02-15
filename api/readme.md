# 🐾 ChicoHub API – Gestão Inteligente para Petshops

Esta API REST é o coração do ecossistema **ChicoHub**, desenvolvida para oferecer uma solução robusta de gerenciamento para petshops. O foco principal é a escalabilidade, integridade de dados e a separação lógica de unidades de negócio (Multi-tenant inicial).

## 🚀 Diferenciais Técnicos

* **Integração com BrasilAPI:** Cadastro de lojas automatizado através da busca de CNPJ, reduzindo erros de digitação e tempo de setup.
* **Arquitetura Relacional Complexa:** Implementação de vínculos em cadeia (Loja -> Cliente -> Pet -> Serviço) garantindo rastreabilidade total.
* **Persistência em Produção:** Banco de dados MySQL configurado em ambiente remoto (Hostinger), simulando um cenário real de mercado.
* **Tipagem Profissional:** Uso de `BigDecimal` para precisão financeira e `LocalDate` para controle cronológico rigoroso.

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **ORM:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL
* **Produtividade:** Lombok e Spring Boot DevTools
* **Testes:** Postman

## 🏗️ Estrutura do Projeto

O projeto segue o padrão de camadas para separação de responsabilidades:
* **`controller`**: Gerencia os endpoints e as requisições HTTP.
* **`domain`**: Contém as entidades de negócio e mapeamento JPA.
* **`repository`**: Interfaces de comunicação com o banco de dados.
* **`dto`**: Objetos para integração com serviços externos.

## 📈 Jornada de Desenvolvimento (Sprints)

### Sprint 1 & 2: Infraestrutura e Lojas
* Configuração do ambiente e banco de dados MySQL.
* Desenvolvimento do `LojaController` com integração à BrasilAPI para endereçamento automático.

### Sprint 3 & 4: Clientes e Pets
* Mapeamento da entidade `Pet` e `Cliente` com relacionamentos `@ManyToOne`.
* Implementação de filtros para que cada loja gerencie apenas seus próprios dados (Isolamento de Unidade).

### Sprint 5: Ciclo de Atendimentos
* Criação da entidade `Servico` para registro de banhos, tosas e outros procedimentos.
* Endpoint para histórico completo de vida do pet dentro do sistema.

## 🚥 Como Executar

1. Clone o repositório.
2. Certifique-se de ter o Java 17 instalado.
3. Configure as credenciais do banco no `application.properties`.
4. Execute via Maven: `./mvnw spring-boot:run`.

---



---