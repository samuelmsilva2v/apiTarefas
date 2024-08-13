CREATE DATABASE bd_apitarefas;

USE bd_apitarefas;

CREATE TABLE categoria(
	id			INTEGER			AUTO_INCREMENT,
	nome			VARCHAR(50)		NOT NULL,
	PRIMARY KEY(id));
	
CREATE TABLE tarefa(
	id			INTEGER			AUTO_INCREMENT,
	nome			VARCHAR(100)	NOT NULL,
	data			DATE			NOT NULL,
	descricao		VARCHAR(250)	NOT NULL,
	categoria_id	INTEGER			NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(categoria_id) REFERENCES categoria(id)
);

DESC categoria;
DESC tarefa;