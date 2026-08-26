# Adopet Console

Aplicação Java de linha de comando para integração com a API do Adopet, permitindo cadastrar abrigos, listar abrigos, listar pets de um abrigo e importar pets via CSV.

## Tecnologias

- Java 17
- Maven
- Java HTTP Client (`java.net.http`)
- Gson e Jackson (serialização/desserialização JSON)
- JUnit e Mockito (testes)

## Funcionalidades

- **Listar abrigos cadastrados**
- **Cadastrar novo abrigo**
- **Listar pets de um abrigo**
- **Importar pets para um abrigo a partir de arquivo CSV**

## Pré-requisitos

- Java 17 configurado no ambiente
- Maven instalado e disponível no PATH

## Como executar

1. Inicie a API local (fornecida no projeto):
   ```bash
   java -jar api.jar
   ```
2. Execute a aplicação `AdopetConsoleApplication` pela sua IDE.

> A aplicação cliente consome os endpoints em `http://localhost:8080`.

## Execução de testes

```bash
mvn test
```

## Formato esperado do CSV de pets

Cada linha deve conter:

`tipo,nome,raca,idade,cor,peso`

Exemplo:

`cachorro,Rex,Poodle,5,Marrom,10.5`

## Estrutura principal do projeto

- `src/main/java/br/com/alura/AdopetConsoleApplication.java`: menu principal
- `src/main/java/br/com/alura/*Command.java`: comandos acionados no menu
- `src/main/java/br/com/alura/service`: regras de negócio e chamadas HTTP
- `src/main/java/br/com/alura/client`: configuração das requisições HTTP
- `src/main/java/br/com/alura/domain`: entidades de domínio (`Abrigo`, `Pet`)
- `src/test/java/br/com/service`: testes de serviço