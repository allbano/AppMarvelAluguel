ALTER TABLE public.usuarios 
DROP COLUMN aluguelhq_data_devolucao;
ALTER TABLE public.aluguelhq
ADD COLUMN aluguelhq_data_devolucao date;