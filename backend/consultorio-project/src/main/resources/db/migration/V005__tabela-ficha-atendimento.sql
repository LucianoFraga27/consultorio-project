-- Tabela 'ficha_atendimento'
CREATE TABLE ficha_atendimento (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  agendamento_id BIGINT,
  diagnostico VARCHAR(255) NOT NULL,
  observacao VARCHAR(255),
  receita VARCHAR(255),
  retorno DATETIME,
  FOREIGN KEY (agendamento_id) REFERENCES agendamento(id)
);