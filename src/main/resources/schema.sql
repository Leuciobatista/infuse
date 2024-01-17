TABLE pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_controle VARCHAR(255) UNIQUE,
    data_cadastro DATE,
    nome VARCHAR(255),
    valor DECIMAL(10, 2),
    quantidade INT,
    codigo_cliente BIGINT,
    valor_total DECIMAL(10, 2)
);