CREATE TABLE cliente (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          cpf VARCHAR(14) NOT NULL,
                          gender VARCHAR(60) NOT NULL,
                          password VARCHAR(255) NOT NULL
);
