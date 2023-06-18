-- Tabela 'agendamento'
CREATE TABLE agendamento (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  paciente_id BIGINT,
  medico_id BIGINT,
  motivo_id BIGINT,
  datahora DATETIME NOT NULL,
  sintomas VARCHAR(255) NOT NULL,
  status VARCHAR(20) NOT NULL,
  tipo_consulta VARCHAR(20) NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (medico_id) REFERENCES medico(id),
  FOREIGN KEY (motivo_id) REFERENCES motivo(id)
);