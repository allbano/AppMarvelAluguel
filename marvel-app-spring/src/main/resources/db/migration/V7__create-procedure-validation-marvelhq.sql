-- Procedimento armazenado para inserir uma nova HQ garantindo unicidade
CREATE OR REPLACE PROCEDURE inserir_hq(
    p_hq_id integer,
    p_hq_titulo varchar,
    p_hq_imagem varchar
)
LANGUAGE plpgsql
AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM marvelhq WHERE hq_id = p_hq_id) THEN
        INSERT INTO marvelhq (hq_id, hq_titulo, hq_imagem)
        VALUES (p_hq_id, p_hq_titulo, p_hq_imagem);
    ELSE
        RAISE NOTICE 'HQ with ID % already exists', p_hq_id;
    END IF;
END;
$$;