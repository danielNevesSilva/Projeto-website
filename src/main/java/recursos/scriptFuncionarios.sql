CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    funcao VARCHAR(20) NOT NULL,
    Status VARCHAR(20) DEFAULT 'Ativo'
);