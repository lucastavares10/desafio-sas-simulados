CREATE TABLE simulado_prova (
	id serial PRIMARY KEY,
	simulado_id BIGINT NOT NULL,
	prova_id BIGINT NOT NULL,
	FOREIGN KEY (simulado_id) REFERENCES simulado(id),
	FOREIGN KEY (prova_id) REFERENCES prova(id)
);

INSERT INTO simulado_prova (simulado_id, prova_id) VALUES ('1', '1');
INSERT INTO simulado_prova (simulado_id, prova_id) VALUES ('1', '2');
INSERT INTO simulado_prova (simulado_id, prova_id) VALUES ('2', '1');
INSERT INTO simulado_prova (simulado_id, prova_id) VALUES ('3', '2');