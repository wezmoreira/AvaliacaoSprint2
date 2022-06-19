create database avaliacao;

use avaliacao;

create table Produto(
Id int not null,
Nome varchar(100) not null,
Descricao varchar(200) not null,
Quantidade int not null,
Preco double not null,
CONSTRAINT PK_ProdutoID PRIMARY KEY CLUSTERED (Id));



create table Filmes(
Id int auto_increment,
Nome varchar(100) not null,
Descricao varchar(200) not null,
Ano date not null,
CONSTRAINT PK_FilmesID PRIMARY KEY CLUSTERED (Id));

insert into Filmes (Nome, Descricao, Ano) values(
'O senhor dos anéis: A sociedade do Anél', 'Os hobbits se unem a gandalf para salvar o mundo', '2001-01-01'),
('O Senhor dos Anéis: As Duas Torres', 'Gandalf morre e as coisas começam a dar errado', '2002-12-27'),
('O Senhor dos Anéis: O Retorno do Rei', 'Rohan atende o pedido de Gondor e ali se cria a maior cena de todos os tempos', '2003-12-25'),
('Matrix', 'Um filme revolucionario', '1999-04-21'),
('A volta daqueles que não foram', 'Eles foram ou não', '2010-10-15'),
('American Pie: 1', 'Primeiro filme da franquia', '2005-07-28'),
('American Pie: 2', 'Segundo filme da franquia', '2006-03-15'),
('American Pie: 3', 'Terceiro filme da franquia', '2007-08-23'),
('American Pie: 4', 'Quarto filme da franquia', '2008-01-22'),
('American Pie: 5', 'Quinto filme da franquia', '2009-04-18'),
('O Hobbit: Uma jornada inesperada', 'Primeiro filme da triologia', '2010-05-13'),
('O Hobbit: A desolação de Smaug', 'Segundo filme da triologia', '2010-05-13'),
('O Hobbit: A batalha dos 5 exércitos', 'Terceiro filme da triologia', '2010-05-13'),
('Resident Evil: 1', 'O primeiro filme dessa franquia', '2012-06-22'),
('Resident Evil: 2', 'O Segundo filme dessa franquia', '2013-07-28'),
('Resident Evil: 3', 'O Terceiro filme dessa franquia', '2014-03-12'),
('Resident Evil: 4', 'O Quarto filme dessa franquia', '2015-05-23'),
('Resident Evil: 5', 'O Quinto filme dessa franquia', '2016-02-11'),
('Os vingadores: Era de Ultron', 'Segundo filme dos vingadores', '2013-05-07'),
('Os vingadores: Guerra infinita', 'Terceiro filme dos vingadores', '2018-05-07');
