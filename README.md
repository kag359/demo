# demo

A base de dados Mysql  contem 6 campos (id,nome,capital,regiao,subRegiao,area)
Para o primeiro desafio para criar um novo Pais apartir da API com todas as propriedades foi feito o uso do Postman

POST localhost:8080/api/paises
Com o recurso a JSON para a insercao dos dados
{
   "nome" : "",
   "capital" : "",
   "regiao" : "",
   "subRegiao" : "",
   "area" : ""
}

Os campos estao validados para TEXT e NOT NULL e o id gerado automaticamente.

2. Para fazer a listagem de todos os paises anteriormente criados

GET localhost:8080/api/paises

3. Para Actualizar os dados de um pais 
 A pesquisa do Pais e feita pelo nome.
 PUT localhost:8080/api/paises/nomeDoPais
Inserindo os novos dados em Json nos devidos campos
{
   "nome" : "",
   "capital" : "",
   "regiao" : "",
   "subRegiao" : "",
   "area" : ""
}

4. Eliminar um Pais
A eliminacao do Pais e feita atraves do id(findById) disponibilizado pelo JpaRepository

DELETE PUT localhost:8080/api/paises/IdDoPais

5. Ordenar
E possivel ordenar a lista dos paises atraves da propriedade nome em ordem Alfabetica

GET localhost:8080/api/paises/ordenar
