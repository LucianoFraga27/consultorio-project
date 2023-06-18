-- Tabela 'paciente'
CREATE TABLE paciente (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  CPF VARCHAR(11) NOT NULL,
  nascimento DATE NOT NULL,
  plano_saude VARCHAR(255)
);

-- Tabela 'endereco'
CREATE TABLE endereco (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  paciente_id BIGINT,
  cep VARCHAR(10) NOT NULL,
  logradouro VARCHAR(255) NOT NULL,
  bairro VARCHAR(255) NOT NULL,
  cidade VARCHAR(255) NOT NULL,
  complemento VARCHAR(255),
  principal ENUM('S', 'N'),
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

-- Tabela 'telefone'
CREATE TABLE telefone (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  paciente_id BIGINT,
  ddd VARCHAR(2) NOT NULL,
  numero VARCHAR(9) NOT NULL,
  principal ENUM('S', 'N'),
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);