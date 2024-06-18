CREATE TABLE usuarios (
	user_id serial PRIMARY KEY,
	user_nome varchar(150) NOT NULL,
	user_email varchar(150) NOT NULL,
	user_senha varchar(256) NOT NULL,
	user_telefone varchar(11) NOT NULL,
	user_foto varchar(255)
);