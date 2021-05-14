<h1 align="center"> Anúncios Online </h1>

## Projeto
Projeto desenvolvido para o gerenciamento de anúncios online. Imprime a contagem de visualizações, compartilhamentos e cliques do anúncio em redes sociais, oferecendo o rastreio dos resultados da campanha.

## Tecnologias
Ferramentas utilizadas no projeto:
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [H2 Databse](https://www.h2database.com/html/main.html)
- [MockMvc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html)
- [Swagger](https://swagger.io/)

## Funcionalidades
- Cria um anúncio a partir da inserção dos dados: 
   - Nome do anúncio
   - Cliente
   - Data de início do anúncio
   - Data de término do anúncio
   - Valor investido por dia
   
- Lista todos os dados inseridos.

- Imprime relatório através dos filtros: Cliente e intervalo de tempo. </br>
O relatório mostrará: 
  - Valor total investido
  - Quantidade de visualizações
  - Quantidade de cliques
  - Quantidade de compartilhamentos

## Como executar
Para executar o projeto:
1. Compilar o projeto em uma IDE de sua preferência. </br>
Após a compilação terá acesso a documentação através do Swagger UI e ao H2 Database. <br />
2. Para acessar a documentação, basta utilizar a rota http://localhost:8080/swagger-ui/index.html <br />
3. Para acessar o banco de dados, basta utilizar a rota (não é necessário inserir a senha) http://localhost:8080/h2/
