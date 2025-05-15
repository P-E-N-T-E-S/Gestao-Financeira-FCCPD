-- Script de povoamento de dados para as tabelas usuarios, categoria, transferencia e metas

USE gerencia;  -- ajuste para o nome do seu banco

-- Populando usuarios
INSERT INTO usuario (username, senha) VALUES
    ('alice', 'senhaAlice123'),
    ('bob',   'senhaBob456'),
    ('carol', 'senhaCarol789'),
    ('davi',  'senhaDavi321'),
    ('eve',   'senhaEve654');

-- Populando categorias
INSERT INTO categoria (titulo, descricao) VALUES
    ('Alimentação', 'Despesas com restaurantes, supermercados e lanches'),
    ('Transporte', 'Gastos com ônibus, táxi, combustível e manutenção de veículo'),
    ('Saúde',       'Consultas médicas, remédios e exames'),
    ('Lazer',       'Cinema, viagens, shows e hobbies'),
    ('Salário',     'Recebimento de salário ou remunerações');

-- Populando transferencias
INSERT INTO transferencia (valor, data, descricao, usuario_id, recebimento, categoria_id) VALUES
    ( 150.00, '2025-04-02', 'Compra no supermercado',      1, 0, 1),
    (  50.00, '2025-04-03', 'Uber para o trabalho',         2, 0, 2),
    (1200.00, '2025-04-05', 'Recebimento de salário',       3, 1, 5),
    (  75.50, '2025-04-07', 'Consulta odontológica',        4, 0, 3),
    (  40.00, '2025-04-08', 'Cinema com amigos',            5, 0, 4),
    ( 200.00, '2025-04-10', 'Freelance de design gráfico',  1, 1, NULL),  -- sem categoria
    (  15.00, '2025-04-11', 'Almoço no trabalho',           2, 0, 1),
    ( 500.00, '2025-04-12', 'Bônus trimestral',            3, 1, NULL),
    (  30.00, '2025-04-13', 'Revisão de carro',             4, 0, 2),
    (  60.00, '2025-04-14', 'Pequenos remédios',            5, 0, 3);

INSERT INTO meta (titulo, descricao, valor, usuario_id) VALUES
    ('Poupança Viagem',       'Guardar para viagem de férias',      3000.00, 1),
    ('Fundo Emergência',       'Reserva para imprevistos',           5000.00, 2),
    ('Comprar Notebook',       'Meta para trocar de computador',     2500.00, 3),
    ('Curso Programação',      'Investir em cursos de especialização',1500.00, 4),
    ('Reforma da Casa',        'Planejamento de pequenas reformas',   8000.00, 5);

-- Commit final
COMMIT;
