USE master;
GO

-- ==============
-- CRIAR O BANCO
-- ==============

CREATE DATABASE vitrine_db;
GO

USE vitrine_db;
GO




CREATE TABLE Categoria (
    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);
GO




CREATE TABLE Estado (
    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sigla CHAR(2) NOT NULL UNIQUE
);
GO




CREATE TABLE Cidade (
    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    estado_sigla CHAR(2) NOT NULL,

    CONSTRAINT fk_cidade_estado
        FOREIGN KEY (estado_sigla)
        REFERENCES Estado(sigla)
);
GO




CREATE TABLE Empresas (
    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    email VARCHAR(45) NOT NULL,
    senha VARCHAR(255) NOT NULL,

    categoria_id BIGINT NULL,
    cidade_id BIGINT NULL,

    descricao VARCHAR(300),
    logradouro VARCHAR(50) NULL,
    cod_status BIT NOT NULL,

    CONSTRAINT fk_empresa_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES Categoria(id),

    CONSTRAINT fk_empresa_cidade
        FOREIGN KEY (cidade_id)
        REFERENCES Cidade(id)
);
GO




CREATE TABLE Usuario (
    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cod_status BIT NOT NULL,
    ddd VARCHAR(2) NOT NULL,
    numero VARCHAR(9) NOT NULL
    
);
GO




CREATE TABLE Empresa_telefone(
    id BIGINT NOT NULL IDENTITY (1,1) PRIMARY KEY,
    ddd VARCHAR(2) NOT NULL,
    numero VARCHAR(9) NOT NULL,
    empresa_id BIGINT NOT NULL,

    CONSTRAINT FK_empresa_telefone
        FOREIGN KEY (empresa_id)
        REFERENCES empresas(id),
);
GO


CREATE TABLE Produto (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    empresa_id BIGINT NOT NULL,
    nome VARCHAR(45) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(255) NULL

        CONSTRAINT FK_produto_empresa
        FOREIGN KEY(empresa_id)
        REFERENCES empresas(id),
    
);
GO

CREATE TABLE Servico(
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    empresa_id BIGINT NOT NULL,
    nome VARCHAR(45) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(255) NULL

    CONSTRAINT FK_servico_empresa
        FOREIGN KEY(empresa_id)
        REFERENCES empresas(id),
);
GO


