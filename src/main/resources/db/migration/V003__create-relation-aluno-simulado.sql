CREATE TABLE aluno_simulado (
	id serial PRIMARY KEY,
	aluno_id BIGINT NOT NULL,
	simulado_id BIGINT NOT NULL,
	status VARCHAR(20) NOT NULL,
	FOREIGN KEY (aluno_id) REFERENCES aluno(id),
	FOREIGN KEY (simulado_id) REFERENCES simulado(id)
);


INSERT INTO aluno_simulado (aluno_id, simulado_id, status) VALUES ('1', '1', 'EM_ANDAMENTO');
INSERT INTO aluno_simulado (aluno_id, simulado_id, status) VALUES ('1', '2', 'EM_ANDAMENTO');
INSERT INTO aluno_simulado (aluno_id, simulado_id, status) VALUES ('2', '3', 'CONCLUIDO');
INSERT INTO aluno_simulado (aluno_id, simulado_id, status) VALUES ('2', '1', 'CONCLUIDO');
INSERT INTO aluno_simulado (aluno_id, simulado_id, status) VALUES ('3', '2', 'ELIMINADO');
INSERT INTO aluno_simulado (aluno_id, simulado_id, status) VALUES ('3', '3', 'ELIMINADO');