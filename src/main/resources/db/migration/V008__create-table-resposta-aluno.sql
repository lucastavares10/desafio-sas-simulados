CREATE TABLE resposta_aluno (
	id serial PRIMARY KEY,
	resposta VARCHAR(10) NOT NULL,
	aluno_id BIGINT NOT NULL,
	simulado_id BIGINT NOT NULL,
	prova_id BIGINT NOT NULL,
	questao_id BIGINT NOT NULL,
	FOREIGN KEY (aluno_id) REFERENCES aluno(id),
	FOREIGN KEY (simulado_id) REFERENCES simulado(id),
	FOREIGN KEY (prova_id) REFERENCES prova(id),
	FOREIGN KEY (questao_id) REFERENCES questao(id)
);

INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('B', '1', '1', '1', '1');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('E', '1', '1', '1', '2');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('C', '1', '1', '1', '3');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('D', '1', '1', '1', '4');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('C', '1', '1', '1', '5');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('C', '1', '1', '1', '6');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('C', '1', '1', '1', '7');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('E', '1', '1', '1', '8');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('A', '1', '1', '1', '9');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('B', '1', '1', '1', '10');

INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('B', '1', '1', '2', '11');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('C', '1', '1', '2', '12');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('D', '1', '1', '2', '13');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('E', '1', '1', '2', '14');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('E', '1', '1', '2', '15');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('C', '1', '1', '2', '16');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('A', '1', '1', '2', '17');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('A', '1', '1', '2', '18');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('B', '1', '1', '2', '19');
INSERT INTO resposta_aluno (resposta, aluno_id, simulado_id, prova_id, questao_id) VALUES ('B', '1', '1', '2', '20');









