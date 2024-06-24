ALTER TABLE public.usuarios ADD COLUMN active boolean NOT NULL;
UPDATE usuarios SET active = true;