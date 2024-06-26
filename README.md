## DS151 - Disciplina de Aplicativos Móveis 
### Projeto Avaliativo Marvel App

#### Trabalho da Disciplina de Aplicativos Móveis do Curso Técnologo em Análise e Desenvolvimento de Sistemas (TADS - UFPR)

#### Equipe do Trabalho:
* Albano Roberto Drescher von Maywitz
* André Alex Jankoski
* João Vitor Araújo dos Santos
* Matheus Henrique Miranda

### Instruções para executar o projeto:

1. Instalar o JDK 17 ou superior.
2. Instalar o Spring Boot 3.3.0 ou superior.
3. Instalar o Maven 3.9.8 ou superior.
4. No seu celular, baixar o aplicativo Expo.

#### Abra um terminal no Linux e execute:
```bash
git clone https://github.com/allbano/AppMarvelAluguel.git
```
#### Primeiro deve-se executar o backend (SpringBoot/JPA/PostgreSQL)
##### Altere para o diretório do backend:
```bash
cd AppMarvelAluguel/marvel-app-apring
```
##### Digite o comando de build&run:
```bash
mvn clean package spring-boot:run
```
###### O terminal vai ficar em execução! Abra uma nova aba no terminal.

#### Segundo deve-se executar o frontend (React-Native/expo)
##### Navegue até a pasta onde clonou o projeto e digite:
```bash
cd marvel-app-ui
```
##### Agora digite o comando para realizar o download das dependências do nodejs:
```bash
npm install
```
##### Agora digite o comando para iniciar o frontend:
```bash
npx expo start
```

##### Com o aplicativo baixado, leia o QR code que aparece na tela. Caso não tiver algum problema com a leitura, pode-se executar pela url, que encontra-se na linha:
```bash
› Metro waiting on {Digitar a partir daqui:} exp://[IP DA SUA REDE]
```

#### PS: As credenciais usadas no banco de dados PostgreSQL ficam no application.yml
#### Ela não está presente neste repositório e devem ser solicitadas para a equipe.

### Segue um application.yml de exemplo:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://[IP OU URL PARA O BANCO]:[PORTA UTILIZADA]/[NOME DO BANCO]
    username: [USUÁRIO]
    password: [SENHA]
```
##### _O arquivo application.yml deve ficar na pasta raiz do bakend:_ __marvel-app-spring__
