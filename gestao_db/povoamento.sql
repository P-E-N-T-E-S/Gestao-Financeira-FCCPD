INSERT INTO usuarios (username, senha)
VALUES
    ('joao_alves', 'senha123'),
    ('maria_souza', 'senha456');

INSERT INTO entradas (valor, data, descricao, usuario_id)
VALUES
    (2500.00, '2025-04-01', 'Salário Abril', 1),
    (300.00, '2025-04-10', 'Venda de item usado', 1),
    (4000.00, '2025-04-01', 'Salário Abril', 2);

INSERT INTO saidas (valor, data, descricao, usuario_id)
VALUES
    (200.00, '2025-04-05', 'Supermercado', 1),
    (120.00, '2025-04-07', 'Uber', 1),
    (800.00, '2025-04-03', 'Aluguel', 2),
    (250.00, '2025-04-10', 'Farmácia', 2);
