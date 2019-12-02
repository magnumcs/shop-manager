# Shop Manager

## Descrição

Projeto de um sistema sistema para gerenciamento, coleta e manipulação de eventos realizados por
usuários em estabelecimentos pelas cidades.

## Tecnololigas utilizadas

- No back-end foi utilizado spring-boot v2.2 com java 8;
- Para persistência dos dados em memória o banco de dados não relacional MongoDB;
- Para publicação e integração dos ambientes foi utilizado o docker para cada serviço e o docker-compose
para orquestração de todo o ecossistema.
- Foi utilizado Spring Cloud, com Eureka, Zuul e Feign para integração entre serviços, 
balanceamento de carga e gateway.

## Instruções de uso

Para executar o projeto é necessário seguir os requisitos:

- Sistema operacional Linux
- Docker instalado;
- Docker-compose instalado.
- Git

Clonar o projeto localmente e rodar o sequinte comando:

### `sh start.sh`

Após todos os procedimentos serem executados com sucesso, acessar as seguintes urls:

### `http://0.0.0.0:8080/api/event-register/timeline`
### `http://0.0.0.0:8080/api/event-register/events/collect`
### `http://0.0.0.0:8080/api/event-register/events/autocomplete/{input}`
