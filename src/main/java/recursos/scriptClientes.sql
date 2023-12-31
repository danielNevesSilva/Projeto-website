CREATE TABLE cliente (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          cpf VARCHAR(14) NOT NULL,
                          gender VARCHAR(60) NOT NULL,
                          birthdate date,
                          password VARCHAR(255) NOT NULL
);

CREATE TABLE ENDERECOENTREGA (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CEP VARCHAR(10) NOT NULL,
    RUA VARCHAR(255) NOT NULL,
    NUMERO VARCHAR(255) NOT NULL,
    BAIRRO VARCHAR(255) NOT NULL,
    CIDADE VARCHAR(255) NOT NULL,
    UF VARCHAR(255) NOT NULL,
    LOGRADOURO VARCHAR(255) NOT NULL,
    CLIENTE_ID INT ,
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID)
);

