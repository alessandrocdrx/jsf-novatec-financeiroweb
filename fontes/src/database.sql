create database financeiro;
use financeiro;
show databases;

CREATE TABLE usuario (
    codigo int(11) NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    login varchar(15) NOT NULL,
    email varchar(100) NOT NULL,
    senha varchar(10) NOT NULL,
    nascimento date NOT NULL,
    celular varchar(25),
    idioma varchar(5) NOT NULL,
    ativo tinyint(1) NOT NULL,
    PRIMARY KEY (codigo),
    UNIQUE KEY login (login)
);
