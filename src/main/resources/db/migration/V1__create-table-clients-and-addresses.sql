-- Tabela de endereços
CREATE TABLE addresses (
    id SERIAL PRIMARY KEY,
    cep CHAR(8) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    number VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserindo dados na tabela addresses
INSERT INTO addresses (cep, street, neighborhood, city, state, number)
VALUES
('01001000', 'Praça da Sé', 'Sé', 'São Paulo', 'SP', '100'),
('20040002', 'Rua da Alfândega', 'Centro', 'Rio de Janeiro', 'RJ', '200'),
('30120002', 'Rua da Bahia', 'Centro', 'Belo Horizonte', 'MG', '300'),
('40020000', 'Rua Chile', 'Centro', 'Salvador', 'BA', '400'),
('60010010', 'Avenida Beira Mar', 'Meireles', 'Fortaleza', 'CE', '500'),
('70040001', 'Esplanada dos Ministérios', 'Zona Cívico-Administrativa', 'Brasília', 'DF', '600'),
('80020030', 'Rua XV de Novembro', 'Centro', 'Curitiba', 'PR', '700'),
('90010020', 'Rua dos Andradas', 'Centro Histórico', 'Porto Alegre', 'RS', '800'),
('60020350', 'Rua São Paulo', 'Centro', 'Manaus', 'AM', '900'),
('59010020', 'Avenida Salgado Filho', 'Lagoa Nova', 'Natal', 'RN', '1000');

-- Tabela de clientes
CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    cpf CHAR(11) NOT NULL,
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES addresses(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserindo dados na tabela clients
INSERT INTO clients (first_name, last_name, email, date_of_birth, cpf, address_id)
VALUES
('Ana', 'Silva', 'ana.silva@example.com', '1984-05-20', '12345678901', 1),
('Carlos', 'Oliveira', 'carlos.oliveira@example.com', '1990-11-12', '23456789012', 2),
('Mariana', 'Santos', 'mariana.santos@example.com', '2002-01-30', '34567890123', 3),
('Paulo', 'Costa', 'paulo.costa@example.com', '1988-04-15', '45678901234', 4),
('Fernanda', 'Pereira', 'fernanda.pereira@example.com', '1995-07-22', '56789012345', 5),
('Ricardo', 'Lima', 'ricardo.lima@example.com', '1986-09-10', '67890123456', 6),
('Juliana', 'Gomes', 'juliana.gomes@example.com', '1998-12-05', '78901234567', 7),
('Mateus', 'Almeida', 'mateus.almeida@example.com', '2000-02-28', '89012345678', 8),
('Aline', 'Martins', 'aline.martins@example.com', '1992-03-18', '90123456789', 9),
('Thiago', 'Rocha', 'thiago.rocha@example.com', '1985-06-25', '01234567890', 10);
