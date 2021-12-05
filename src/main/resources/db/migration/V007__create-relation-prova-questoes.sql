CREATE TABLE prova_questoes (
	id serial PRIMARY KEY,
	prova_id BIGINT NOT NULL,
	questao_id BIGINT NOT NULL,
	FOREIGN KEY (prova_id) REFERENCES prova(id),
	FOREIGN KEY (questao_id) REFERENCES questao(id)
);

INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '1');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '2');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '3');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '4');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '5');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '6');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '7');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '8');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '9');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('1', '10');

INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '1');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '12');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '13');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '14');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '15');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '16');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '17');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '18');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '19');
INSERT INTO prova_questoes (prova_id, questao_id) VALUES ('2', '20');