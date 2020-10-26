# Projeto stoom-street
Microservice Register Street 

* Banco de Dados MySql
* Spring Boot 
* Swagger Documentação da API 


# Devera ser criado para execução do projeto a tabela street 
  script :stoom-street/src/main/resources/scripts/create_table_street.sql
  
# Apos criação deverá ser configurado no application.properties

    - Spring DATASOURCE (URI do Banco , usuario e senha para autenticação)
        spring.datasource.url=jdbc:mysql://localhost:3306/Register?allowPublicKeyRetrieval=true&useSSL=false
        spring.datasource.username=reinaldo
        spring.datasource.password=R31n@1d0

    - Dialeto SQL melhorar o SQL gerado pelo Hibernate (Dialeto do Banco que sera usado)
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

    - CONTEXTO E RECURSOS(Chave de Acesso a API do Google e API)
        uri.acess.geolocalizacao=https://maps.googleapis.com/maps/api/geocode/json
        uri.acess.key=AIzaSyDTK0igIQTCi5EYKL9tzOIJ9N6FUASGZos
        
# Para mas facil entendimento foi criado um grupo no Postman chamado de Stoom (Onde encontran-se montados todas as API's CRUD de endereço )
   - Cadastro de Endereco
   - Alteração de Endereco por codigo
   - Busca de Endereco por codigo
   - Exluir endereco por codigo
   - Consulta de geolocalização
path : stoom-street/src/main/resources/scripts/Stoom.postman_collection.json


   
