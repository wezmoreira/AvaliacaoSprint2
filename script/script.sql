create database avaliacao;

use avaliacao;

create table Produto(
Id int not null,
Nome varchar(100) not null,
Descricao varchar(200) not null,
Quantidade int not null,
Preco double not null,
CONSTRAINT PK_ProdutoID PRIMARY KEY CLUSTERED (Id));

select * from Produto;
