## Descrição do Projeto

<p>
  Projeto com objetivo de testar meus conhecimentos aprimorando meus códigos em um sistema de cadastro de Paciente 
</p>

## Conteúdo

<p>
  <a href="#requirements">Pré-requisitos  |</a>
  <a href="#runningApp">Rodando o Aplicação frontend  |</a>
  <a href="#runningBack">Rodando o Aplicação backend  |</a>
  <a href="#technology">Tecnologias  |</a>
  <a href="#author">Autor  |</a>
</p>


### Pré-requisitos

.[Nodejs]
.[Docker]

 ### Configurando Docker

 # Certifique-se que o Docker esteja instalado

  # No linux, usei este comando para criar o container com a imagem do MySQL
  $ docker run --name mysql-teste-gt-clinica -e MYSQL_ROOT_PASSWORD=docker -e MYSQL_DATABASE=mydbgt -d -p 3306:3306 mysql:latest

<section id='runningApp'>

  ### Rodando o Aplicação frontend

    # Clone este repositório
    $ git clone https://github.com/denion465/teste-pratico-gt

    # Acesse a pasta do projeto frontend
    $ cd teste-pratico-gt/frontend   

    # Instale as dependências
    $ npm i ou $ yarn

    # A applicação inciará na porta:3000 - acesse <http://localhost:3000>

  # IMPORTANTE - WEBPACK CAUSANDO UM ERRO 
  # Caso aconteça esse erro ou similar:

  ./node_modules/@react-leaflet/core/esm/path.js 10:41
    Module parse failed: Unexpected token (10:41)
    File was processed with these loaders:

  ./node_modules/react-scripts/node_modules/babel-loader/lib/index.js
  You may need an additional loader to handle the result of these loaders.
  | useEffect(function updatePathOptions() {
  | if (props.pathOptions !== optionsRef.current) {
    const options = props.pathOptions ?? {};
  | element.instance.setStyle(options);
  | optionsRef.current = options;

  # Por favor entre na pasta frontend/node_modules/webpack e exclua a pasta node_modules que vai estar dentro da pasta do webpack.
  # Não entendi muito esse erro, por enquanto foi está solução que encontrei.

  # Após isso reinicie a aplicação novamente
 
</section>

<section id='runningBack'>

  ### Rodando o Aplicação backend
      # Acesse a pasta do projeto backend
      $ cd teste-pratico-gt/backend  

      # Inicie a aplicação com $ ./mvnw spring-boot:run

      # A applicação inciará na porta:8080

</section>

<section id='technology'>

### 🛠 Tecnologias
  * .[NodeJs]
  * .[React]
  * .[Docker]
  * .[SpringBoot]
  * .[MySql]

  ### 📘 Libs
  # 💻 Frontend
  * Material-ui
  * unform
  * unform-material-ui
  * Axios
  * leaflet
  * polished
  * react-leaflet
  * styled-components
  * typescript

  # 💽 Backend
  * Spring Boot data Jpa
  * Spring Boot data Starter Web
  * MySQL connector java
  * Lombok
  * Spring Boot Maven plugin
  
</section>


<section id='#author'>

  ## Author
    * Daniel Vidal
    * GitHub: https://github.com/denion465

  </section>







