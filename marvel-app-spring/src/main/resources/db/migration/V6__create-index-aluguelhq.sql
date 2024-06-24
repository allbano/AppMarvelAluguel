-- Índice na chave estrangeira id_user em user_hq para melhorar consultas
CREATE INDEX idx_aluguelhq_usuario_id ON aluguelhq(aluguelhq_usuario_id);

-- Índice na chave estrangeira id_hq em user_hq para melhorar consultas
CREATE INDEX idx_aluguelhq_marvelhq_id ON aluguelhq(aluguelhq_marvelhq_id);