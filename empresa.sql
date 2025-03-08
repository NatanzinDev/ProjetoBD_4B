create database empresa;

create table funcionario(
	id_funcionario int auto_increment primary key not null,
    nome text,
    salario double,
    cargo varchar(30),
    telefone varchar(20)
    id_setor int, 
    FOREIGN KEY (id_setor) REFERENCES setor(id_setor)
);

CREATE TABLE supervisor(
id_supervisor INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
email TEXT NOT NULL,
senha TEXT NOT NULL,
nome TEXT NOT NULL
);

create table setor(
	id_setor INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome varchar(100),
	lugar varchar(100)
);

select * from funcionario;