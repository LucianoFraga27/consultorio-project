-- Dados de teste

-- Deletando todos os dados das tabelas.
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM Agendamento;
DELETE FROM Paciente;
DELETE FROM Medico;
DELETE FROM Motivo;
DELETE FROM chegada;
DELETE FROM endereco;
DELETE FROM ficha_atendimento;
DELETE FROM telefone;
SET FOREIGN_KEY_CHECKS = 1;

-- Mudando o auto incremento para 1, para retornar ao 
ALTER TABLE Agendamento auto_increment=1;
ALTER TABLE Paciente auto_increment=1;
ALTER TABLE Medico auto_increment=1;
ALTER TABLE Motivo auto_increment=1;
ALTER TABLE chegada auto_increment=1;
ALTER TABLE endereco auto_increment=1;
ALTER TABLE ficha_atendimento auto_increment=1;
ALTER TABLE telefone auto_increment=1;


-- Inserts para tabela 'paciente'
INSERT INTO paciente (nome, email, CPF, nascimento, plano_saude) VALUES ('Maria Silva', 'maria@example.com', '93670347097', '1990-05-15', 'Unimed');
INSERT INTO paciente (nome, email, CPF, nascimento, plano_saude) VALUES ('João Santos', 'joao@example.com', '02657974031', '1985-09-20', 'Amil');
INSERT INTO paciente (nome, email, CPF, nascimento, plano_saude) VALUES ('Ana Rodrigues', 'ana@example.com', '66329334080', '1992-11-30', 'Bradesco');

-- Inserts para tabela 'endereco'
INSERT INTO endereco (paciente_id, cep, logradouro, bairro, cidade, complemento, principal) VALUES (1, '12345678', 'Rua das Flores', 'Centro', 'São Paulo', 'Apartamento 101', 'S');
INSERT INTO endereco (paciente_id, cep, logradouro, bairro, cidade, complemento, principal) VALUES (2, '54321876', 'Avenida das Palmeiras', 'Jardins', 'Rio de Janeiro', NULL, 'S');
INSERT INTO endereco (paciente_id, cep, logradouro, bairro, cidade, complemento, principal) VALUES (3, '98765432', 'Rua das Acácias', 'Centro', 'Porto Alegre', 'Casa 20', 'N');

-- Inserts para tabela 'telefone'
INSERT INTO telefone (paciente_id, ddd, numero, principal) VALUES (1, '11', '999998888', 'S');
INSERT INTO telefone (paciente_id, ddd, numero, principal) VALUES (2, '21', '777776666', 'S');
INSERT INTO telefone (paciente_id, ddd, numero, principal) VALUES (3, '51', '555554444', 'S');

-- Inserts para tabela 'motivo'
INSERT INTO motivo (titulo, descricao) VALUES ('Consulta agendada', 'Consulta agendada previamente');
INSERT INTO motivo (titulo, descricao) VALUES ('Consulta de emergência', 'Situação de emergência médica');
INSERT INTO motivo (titulo, descricao) VALUES ('Exame de Rotina', 'Realização de exames de rotina');
INSERT INTO motivo (titulo, descricao) VALUES ('Acompanhamento de Tratamento', 'Consulta para acompanhar tratamento');

-- Inserts para tabela 'chegada'
INSERT INTO chegada (motivo_id) VALUES (1);
INSERT INTO chegada (motivo_id) VALUES (2);
INSERT INTO chegada (motivo_id) VALUES (1);

-- Inserts para tabela 'medico'
INSERT INTO medico (nome, CRM) VALUES ('Dr. Carlos', '12345');
INSERT INTO medico (nome, CRM) VALUES ('Dra. Ana', '54321');

-- Inserts para tabela 'agendamento'
INSERT INTO agendamento (paciente_id, medico_id, motivo_id, datahora, sintomas, status, tipo_consulta) VALUES (1, 1, 1, '2023-06-18 10:00:00', 'Febre alta', 'AGENDADO', 'CONSULTA');
INSERT INTO agendamento (paciente_id, medico_id, motivo_id, datahora, sintomas, status, tipo_consulta) VALUES (2, 2, 2, '2023-06-19 14:30:00', 'Dor de cabeça intensa', 'AGENDADO', 'CONSULTA');
INSERT INTO agendamento (paciente_id, medico_id, motivo_id, datahora, sintomas, status, tipo_consulta) VALUES (3, 1, 1, '2023-06-20 09:00:00', 'Dor de garganta', 'AGENDADO', 'CONSULTA');

-- Inserts para tabela 'ficha_atendimento'
INSERT INTO ficha_atendimento (agendamento_id, diagnostico, observacao, receita, retorno) VALUES (1, 'Gripe', 'Recomendar repouso', 'Paracetamol', '2023-06-25 10:00:00');
INSERT INTO ficha_atendimento (agendamento_id, diagnostico, observacao, receita, retorno) VALUES (2, 'Enxaqueca', 'Prescrever analgésico', 'Dipirona', '2023-06-27 14:30:00');
INSERT INTO ficha_atendimento (agendamento_id, diagnostico, observacao, receita, retorno) VALUES (3, 'Amigdalite', 'Indicar antibiótico', 'Amoxicilina', '2023-06-30 09:00:00');

