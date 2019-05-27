# INFOS

Login

## Banco de dados
* MySql

## Tabelas criadas
* Info
* Login

## Conexão com o banco de dados
mysql -h database-1.cxgjvlf5pkak.us-east-2.rds.amazonaws.com -P 3306 -u admin -p
password: password (a senha é essa mesmo)

## Scripts para inserir nas tabelas

* insert into info (id, name, address, telephone) values (1, "Rodrigo", "End. Teste", "22223333");
* insert into login (user, password, id) values ("user", "password", 1);

Exemplo para rodar local
http://localhost:5000/login?user=user&pass=password

## Solução proposta
Para melhorar o fluxo de requisições, usei um recurso so Spring chamado @Async, que trata cada requisição em uma thread diferente.
