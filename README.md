<h1 align="center">
  Desafio SAS - Gerenciador de Simulados
  <br>
</h1>

<!-- <h4 align="center"></h4> -->

<p align="center">
    <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v11-orange.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v2.5.6-brightgreen.svg" />
    </a>
    <a alt="Flyway">
        <img src="https://img.shields.io/badge/Flyway-v8.0.4-brown.svg">
    </a>
    <a alt="Swagger-UI">
        <img src="https://img.shields.io/badge/SwaggerUI-v2.9.2-green.svg">
    </a>    
</p>

## Índice ##
1. [Descrição do desafio](#Descrição-desafio)
2. [Tecnologias](#Tecnologias)
3. [Diagramas UML](#Diagramas-UML)
4. [Esquema Banco de Dados](#Esquema-Banco-de-Dados)
5. [Requisitos](#Requisitos)
6. [Instruções de uso](#Instruções-de-uso)
7. [Documentação REST](#Documentação-REST)


## Descrição do desafio ##

* [https://github.com/felipeas314/backend-teste-sas](https://github.com/felipeas314/backend-teste-sas)


## Tecnologias ##
Following libraries were used during the development of this starter kit :

- **Maven** - Software de gerenciamento de projetos
- **Spring Boot** - Framework de aplicações Java
- **PostgreSQL** - Banco de dados SQL
- **Flyway** - Framework de migrations 
- **Docker** - Framework de conteinerização
- **Swagger** - Documentação de API


### Diagrama de Caso de Uso ###

<img src="./docs/images/DesafioCasoDeUso.drawio.png" alt="caso_de_uso"></a>

### Diagrama de Classes ###

<img src="./docs/images/DesafioClasse.drawio.png" alt="classes"></a>


## Esquema Banco de Dados ##

<img src="./docs/images/DesafioEntidadeRelacionamento.drawio.png" alt="db_esquema"></a>

  

## Instruções de uso ##

**1. Clonar repositório**

**2. Criar banco de dados PostgreSQL**
```bash
CREATE DATABASE desafiosas;
```

**3. Configurar username e password do postgres no properties**

+ Caminho: `src/main/resources/application.properties`

**4. Build e start usando maven**

```bash
./mvnw clean && ./mvnw package
java -jar target/desafio-0.0.1-SNAPSHOT.jar
```

Aplicação estará disponível em <http://localhost:8080>.

## Documentação REST ##

Os recursos REST da api estão documentados com Swagger, disponíveis uma vez que o projeto esteja rodando: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

<img src="./docs/images/swagger-ui.png" alt="swagger-ui"></a>
  

## Contribuidores ##
[Lucas Tavares](https://www.linkedin.com/in/lucas-tavares-a25323116/)
