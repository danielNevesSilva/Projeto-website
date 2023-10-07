CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          cpf VARCHAR(14) NOT NULL,
                          rua VARCHAR(255) NOT NULL,
                          numero VARCHAR(10) NOT NULL,
                          bairro VARCHAR(255) NOT NULL,
                          senha VARCHAR(255) NOT NULL
);
