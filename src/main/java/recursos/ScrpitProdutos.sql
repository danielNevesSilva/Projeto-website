CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    amount INT NOT NULL,
    description TEXT,
    status VARCHAR(20) DEFAULT 'Ativo',
    avaliacao DECIMAL(2, 1),
    data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    main_image_path VARCHAR(255),
    image_paths TEXT
);

CREATE TABLE imagens_produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    image_default VARCHAR(3),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);
