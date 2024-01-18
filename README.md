# API de Gestão de Pedidos

Este projeto implementa uma API de gerenciamento de pedidos desenvolvida com Spring Boot. Ela permite aos clientes criar, buscar e gerenciar pedidos. Esta API é capaz de lidar com pedidos em formato JSON e XML, e implementa regras de negócio específicas, como descontos baseados na quantidade e validação de números de controle de pedidos.

## Funcionalidades

- **Criação de Pedidos**: Permite aos clientes criar pedidos com detalhes como nome do produto, valor e quantidade.
- **Busca de Pedidos**: Os usuários podem buscar pedidos por número de controle, data de cadastro ou listar todos os pedidos.
- **Validação de Pedidos**: Validações incluem a unicidade do número de controle e a aplicação de descontos com base na quantidade de produtos.
- **Testes Unitários**: Cobertura de testes unitários para garantir a confiabilidade e a robustez da aplicação.

## Tecnologias Utilizadas

- Spring Boot
- Java 17
- JPA / Hibernate
- MySQL
- Maven
- JUnit e Mockito para testes

## Configuração e Instalação

### Pré-requisitos

- Java JDK 17
- Maven
- MySQL

### Instalação e Execução

```bash
git clone https://github.com/Leuciobatista/infuse
cd infuse
mvn clean install
java -jar target/infuse.jar
```
### Configuração do Banco de Dados
Crie um banco de dados no MySQL usando o Script no repositório antes de iniciar a aplicação.
Configure o arquivo application.properties com as credenciais do seu banco de dados.

## Endpoints

### Criar Pedidos:

URL: /pedidos

Método: POST

Body: Lista de pedidos (JSON ou XML)
### Buscar Pedidos por Número de Controle:

URL: /pedidos/buscarPorNumeroControle

Método: GET

Parâmetros: numeroControle

### Buscar Pedidos por Data de Cadastro:

URL: /pedidos/buscarPorDataCadastro

Método: GET

Parâmetros: dataCadastro

### Listar Todos os Pedidos:

URL: /pedidos/todos

Método: GET

### Autor
Lêucio Batista

### Agradecimentos 
Agradeço todos da INFUSE TECNOLOGIA pela oportunidade de participar do processo seletivo.

## Considerações sobre o Projeto

Este projeto foi desenvolvido com foco na funcionalidade básica e na demonstração das capacidades do Spring Boot para gerenciamento de pedidos. Embora tenha sido alcançado um bom nível de funcionalidade e testes, existem várias áreas que podem ser aprimoradas em iterações futuras.

### Melhorias Potenciais

1. **Autenticação e Autorização**: Implementar um sistema de autenticação e autorização, como OAuth2 ou JWT, para melhorar a segurança da API.

2. **Documentação da API**: Utilizar ferramentas como Swagger ou OpenAPI para gerar documentação interativa da API, facilitando o uso por terceiros.

3. **Dockerização**: Containerizar a aplicação usando Docker para simplificar o processo de implantação e garantir a consistência do ambiente em diferentes plataformas.

4. **CI/CD**: Configurar pipelines de integração contínua e entrega contínua para automatizar testes e implantação.

5. **Logs e Monitoramento**: Integrar uma solução de monitoramento e logging, como ELK Stack ou Prometheus com Grafana, para melhor observabilidade.

6. **Testes de Carga e Performance**: Realizar testes de carga e performance para garantir que a aplicação possa lidar com um número elevado de requisições simultâneas.

7. **Internacionalização (i18n)**: Adicionar suporte para internacionalização, permitindo que a API atenda a usuários em diferentes idiomas.

8. **Melhorias na Interface de Usuário**: Se houver uma interface de usuário (front-end), considerar aprimoramentos na usabilidade e no design.

9. **Expansão das Funcionalidades**: Adicionar novas funcionalidades, como gestão de clientes, integração com sistemas de estoque, entre outras.

### Conclusão

O projeto atingiu seus objetivos iniciais, estabelecendo uma base sólida para a gestão de pedidos. As melhorias listadas são recomendadas para tornar o sistema mais robusto, seguro e fácil de usar.
