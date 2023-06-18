-- Tabela 'chegada'
CREATE TABLE chegada (
  senha BIGINT AUTO_INCREMENT PRIMARY KEY,
  motivo_id BIGINT,
  FOREIGN KEY (motivo_id) REFERENCES motivo(id)
);