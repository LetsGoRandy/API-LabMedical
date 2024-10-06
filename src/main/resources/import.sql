INSERT INTO usuarios(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, crm, especializacao_clinica, senha) VALUES ('Gabriel Otávio Mendes','masculino','21/02/1991', '689.865.430-60', '28.485.990-4', 1, '(11) 99473-3354', 'gabriel_mendes@itatiaia.net', 'Brasileiro', '25897/SC', 2, '8fwMNeN8EG');
INSERT INTO usuarios(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, crm, especializacao_clinica, senha) VALUES ('Bento Francisco Castro', 'masculino', '17/05/1987', '091.411.553-78', '13.193.729-7', 0, '(67) 98995-3226', 'bento_francisco_castro@somma.net.br', 'Brasileiro', '55452/PR', 0, 'Q5y44E5BuP');
INSERT INTO usuarios(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, crm, especializacao_clinica, senha) VALUES ('Sophie Nicole Nair Barros', 'feminino', '13/07/1986', '905.238.777-06', '47.474.011-0', 2, '(51) 98701-5677', 'sophie.nicole.barros@gtx.ag', 'Argentina', '2479/RS', 3, 'LlaLuTJAuN');
INSERT INTO usuarios(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, crm, especializacao_clinica, senha) VALUES ('Bianca Mariana Silveira', 'feminino', '14/07/1970', '760.995.292-33', '43.399.164-1', 4, '(63) 99646-2619', 'bianca-silveira70@predilectasorocaba.com.br', 'Brasileira', '4615/TO', 7, '9GInwEJYWO');

INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88036-800', 'Florianópolis', 'SC', 'Rua Santos Saraiva', 987, 'Apartamento 202', 'Estreito', 'Próximo ao Supermercado Angeloni');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88130-001', 'Palhoça', 'SC', 'Avenida Aniceto Zacchi', 1250, NULL, 'Pagani', 'Em frente ao Shopping ViaCatarina');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88040-100', 'Florianópolis', 'SC', 'Rua Lauro Linhares', 456, 'Bloco B', 'Trindade', 'Próximo à UFSC');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88095-200', 'São José', 'SC', 'Rua Domingos André Zanini', 789, 'Casa 1', 'Barreiros', NULL);
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88058-500', 'Florianópolis', 'SC', 'Servidão Maria Cecília de Oliveira', 112, NULL, 'Ingleses', 'Perto da praia dos Ingleses');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88101-970', 'São José', 'SC', 'Rua Adhemar da Silva', 555, 'Cobertura', 'Kobrasol', 'Próximo ao MundoCar Mais Shopping');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88132-110', 'Palhoça', 'SC', 'Rua João José Martins', 210, 'Sala 302', 'Centro', NULL);
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88066-490', 'Florianópolis', 'SC', 'Rodovia Baldicero Filomeno', 3500, 'Casa', 'Ribeirão da Ilha', 'Perto do restaurante Ostradamus');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88113-250', 'São José', 'SC', 'Rua Heriberto Hulse', 35, 'Sobrado', 'Forquilhinhas', 'Ao lado da Igreja Matriz');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88137-060', 'Palhoça', 'SC', 'Rua Maria Regina de Oliveira', 77, NULL, 'Ponte do Imaruim', NULL);
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88020-400', 'Florianópolis', 'SC', 'Rua Bocaiúva', 1200, 'Cobertura', 'Centro', 'Ao lado do Shopping Beiramar');
INSERT INTO enderecos(cep, cidade, estado, logradouro, numero, complemento, bairro, ponto_referencia) VALUES ('88054-600', 'Florianópolis', 'SC', 'Rua das Gaivotas', 489, NULL, 'Ingleses', 'Próximo ao Hotel Praiatur');

INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Samuel Julio Ferreira', 'masculino', '1998-08-23', '509.699.949-15', '38.567.534-3', 1, '(48) 99808-5600', 'samueljulioferreira@mx.labinal.com', 'Brasileiro', '(48) 3902-6601', 'dipirona', 'nenhum', 'unimed', '93044457405', '2025-12-30', 1);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Mariana Souza Lima', 'feminino', '1985-05-12', '378.525.378-22', '40.987.533-2', 0, '(21) 98722-3354', 'marianaslima@exemplo.com', 'Brasileira', '(21) 91234-1122', 'glúten', 'dieta restrita', 'amil', '75220030003', '2024-10-15', 2);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Carlos Alberto Silva', 'masculino', '1990-02-14', '789.324.911-10', '12.345.678-9', 3, '(11) 90002-5678', 'carlossilva90@dominio.com', 'Brasileiro', '(11) 90001-3456', 'nenhuma', 'pressão alta', 'bradesco saúde', '8904560032', '2026-05-20', 3);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Juliana Pereira Costa', 'feminino', '1978-11-02', '234.567.890-12', '98.765.432-1', 4, '(31) 99876-4321', 'juliana.costa@exemplo.com', 'Brasileira', '(31) 91234-5678', 'aspirina', 'evitar estresse', 'unimed', '75920394058', '2027-07-10', 4);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('João Carlos Andrade', 'masculino', '1982-03-22', '123.456.789-01', '22.334.567-8', 0, '(47) 99999-1234', 'joao.andrade@exemplo.com', 'Brasileiro', '(47) 92034-1123', 'amendoim', 'controle rigoroso', 'sulamerica', '1234567890', '2025-06-30', 5);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Ana Clara Mendes', 'feminino', '1995-10-08', '654.321.987-56', '11.223.344-9', 1, '(41) 98888-5566', 'anamendes95@dominio.com', 'Brasileira', '(41) 91223-4567', 'lactose', 'dieta especial', 'bradesco saúde', '0987654321', '2025-09-15', 6);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Pedro Henrique Oliveira', 'masculino', '2000-12-18', '789.123.456-99', '33.445.556-0', 0, '(27) 97777-8888', 'pedrohenrique@exemplo.com', 'Brasileiro', '(27) 92022-3344', 'nenhuma', 'nenhum', 'amil', '3344556677', '2026-03-20', 7);
INSERT INTO pacientes(nome_completo, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade, contato_emergencia, alergias, cuidados_especificos, convenio, numero_convenio, validade_convenio, endereco_id) VALUES ('Fernanda Aparecida Gomes', 'feminino', '1973-07-30', '345.678.912-34', '44.556.667-7', 3, '(19) 96543-2109', 'fernanda.gomes@exemplo.com', 'Brasileira', '(19) 95432-1098', 'paracetamol', 'evitar esforços físicos', 'unimed', '4455667788', '2028-11-05', 8);

INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-01-15 08:30:00', 'Paracetamol', 'Tomar em caso de dor ou febre',0 , 10, 2, 1, 1);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-02-10 09:00:00', 'Ibuprofeno', 'Uso para dor muscular', 1, 14, 0, 2, 2);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-03-05 14:00:00', 'Amoxicilina', 'Antibiótico para infecção', 2, 20, 1, 3, 3);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-04-22 07:45:00', 'Omeprazol', 'Tomar em jejum', 3, 14, 3, 4, 4);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-05-10 18:30:00', 'Loratadina', 'Uso em caso de alergia', 4, 5, 4, 1, 5);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-06-15 11:00:00', 'Metformina', 'Controle de glicose', 0, 60, 5, 2, 6);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-07-20 12:30:00', 'Losartana', 'Controle de pressão arterial', 1, 30, 6, 3, 7);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-08-18 16:00:00', 'Simvastatina', 'Controle de colesterol', 2, 30, 7, 4, 8);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-09-25 08:00:00', 'Cetirizina', 'Para alergias sazonais', 3, 7, 1, 1, 1);
INSERT INTO medicamentos(moment, nome_medicamento, observacoes, posologia, quantidade, tipo_medicamento, medico_id, paciente_id) VALUES ('2024-10-02 19:15:00', 'Azitromicina', 'Antibiótico para infecção respiratória', 4, 3, 2, 2, 2);