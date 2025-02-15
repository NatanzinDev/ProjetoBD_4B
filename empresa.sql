create database empresa;

create table funcionario(
	id_funcionario int auto_increment primary key not null,
    nome text,
    salario double,
    cargo varchar(30),
    telefone varchar(20)
);

select * from funcionario;