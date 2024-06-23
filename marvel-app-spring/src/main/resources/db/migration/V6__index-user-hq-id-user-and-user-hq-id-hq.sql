-- Índice na chave estrangeira id_user em user_hq para melhorar consultas
CREATE INDEX idx_user_hq_id_user ON user_hq(id_user);
-- Índice na chave estrangeira id_hq em user_hq para melhorar consultas
CREATE INDEX idx_user_hq_id_hq ON user_hq(id_hq);