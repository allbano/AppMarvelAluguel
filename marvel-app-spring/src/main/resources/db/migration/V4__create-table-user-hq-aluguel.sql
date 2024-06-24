CREATE TABLE aluguelhq (
	aluguelhq_id serial PRIMARY KEY,
	aluguelhq_usuario_id integer,
	aluguelhq_marvelhq_id integer,
	CONSTRAINT fk_usuario_marvelhq FOREIGN KEY(aluguelhq_usuario_id) REFERENCES usuarios(user_id),
	CONSTRAINT fk_marvelhq_usuario FOREIGN KEY(aluguelhq_marvelhq_id) REFERENCES marvelhq(hq_id)
);