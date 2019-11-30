# Central de Erros - SQUAD 2

### Visão Geral

Este é um projeto final do programa Aceleradev - Java promovido pela [Codenation](https://www.codenation.dev/). Este projeto é basicamente uma API Rest desenvolvida com Spring-Boot onde foram implementados os seguintes requisitos:

* Criação de endpoints para serem utilizados pelo frontend da aplicação;
* Criação de endpoints que serão utilizados para armazenamento dos erros em um banco de dados relacional;
* Permissão de acesso aos endpoints apenas com tokens de autenticação válidos.

### Detalhes da implementação
Neste projeto, as principais tecnologias utilizadas foram:
* Spring-Boot: para implementação do padrão MVC;
* H2: como banco de dados relacional;
* Auth0: como sistema de gerenciamento de usuarios e autenticação;
* Swagger: para criação da documentação do backend da API;
* Maven: para gerenciamento do ciclo de build da aplicação.

### Instalação
Com o terminal na pasta raiz do projeto digite:
```
mvn clean install 
```
em seguida:
```
cd target
java -jar [nome do arquivo].jar
```
### Documentação da API

Após a instalação, a documentação da API pode ser acessada em: https://localhost:8080/swagger-ui.html

### [FRONT-END](https://github.com/codenation-dev/squad-2-ad-java-softplan-1-front) application
