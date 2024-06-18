CREATE TABLE user_hq (
	id_user integer,
	id_hq integer,
	CONSTRAINT fk_usuario_marvelhq FOREIGN KEY(id_user) REFERENCES usuarios(user_id),
	CONSTRAINT fk_marvelhq_usuario FOREIGN KEY(id_hq) REFERENCES marvelhq(hq_id)
);