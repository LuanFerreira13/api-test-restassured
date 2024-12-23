# Testes Automatizado de API com Rest Assured

Este projeto demonstra como automatizar testes de APIs REST utilizando a biblioteca Rest Assured em Java com o gerenciamento de dependências feito através do Gradle.

## Descrição

O objetivo deste projeto é fornecer exemplos práticos de como configurar e executar testes automatizados em APIs REST, validando respostas, status codes e outros aspectos das requisições HTTP.

## Pré-requisitos

- **Java JDK 8 ou superior**
- **Gradle** (versão 6 ou superior)
- **IDE de sua preferência** (Eclipse, IntelliJ, etc.)

## Configuração do Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://gitlab.com/LuanFerreira13/api-test-restassured.git
   cd api-test-restassured
   ```

2. **Abra o projeto em sua IDE ou editor de texto compatível com Gradle.**

3. **Verifique o arquivo `build.gradle` para garantir que as dependências do Rest Assured estejam configuradas:**

   ```gradle
   plugins {
       id 'java'
   }

   repositories {
       mavenCentral()
   }

   dependencies {
       testImplementation 'io.rest-assured:rest-assured:5.5.0'
       testImplementation 'org.junit.jupiter:junit-jupiter:5.9.3'
   }

   test {
       useJUnitPlatform()
   }
   ```

## Estrutura do Projeto

- **`src/test/java`**: Contém os testes automatizados utilizando o Rest Assured.

## Executando os Testes

1. **Configure variáveis de ambiente ou arquivos de configuração, se necessário.**

2. **Execute os testes utilizando o Gradle:**

   ```bash
   ./gradlew test
   ```

   Os relatórios de teste serão gerados na pasta `build/reports/tests/test`.

## Recursos Adicionais

- [Documentação Oficial do Rest Assured](https://rest-assured.io/)
- [Documentação do Gradle](https://docs.gradle.org/)

## Autor

**Luan Ferreira**  
Projeto criado para demonstrar o uso do Rest Assured com Gradle em um ambiente de teste automatizado para APIs REST.

---
