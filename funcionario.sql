 CREATE TABLE marlene_joias.funcionario (id serial, nome varchar, CONSTRAINT funcionario_pkey PRIMARY KEY (id));
 ALTER TABLE marlene_joias.compras ADD COLUMN funcionario_id int;
 ALTER TABLE marlene_joias.compras ADD CONSTRAINT compras_funcionario_fkey FOREIGN KEY (funcionario_id) REFERENCES marlene_joias.funcionario (id);