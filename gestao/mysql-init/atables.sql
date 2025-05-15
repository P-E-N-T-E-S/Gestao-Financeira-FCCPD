Create database if not exists gerencia;

GRANT ALL PRIVILEGES ON gerencia.* TO 'user'@'%';
FLUSH PRIVILEGES;


USE gerencia;

CREATE TABLE IF NOT EXISTS usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS categoria (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50),
    descricao TEXT
);

CREATE TABLE IF NOT EXISTS transferencia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL(10, 2) NOT NULL,
    data DATE NOT NULL,
    descricao TEXT,
    usuario_id INT NOT NULL,
    recebimento BIT,
    categoria_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE IF NOT EXISTS meta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50),
    descricao TEXT,
    valor DECIMAL(10, 2),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);