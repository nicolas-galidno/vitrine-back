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
    nome VARCHAR(45) NOT NULL,
    cod_status BIT NOT NULL
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
    cod_status BIT NOT NULL
);
GO




CREATE TABLE Telefone (
    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    numero VARCHAR(11) NOT NULL,
    ddd VARCHAR(3) NULL,
    cod_status BIT NOT NULL
);
GO




CREATE TABLE Usuario_Telefone (
    usuario_id BIGINT NOT NULL,
    telefone_id BIGINT NOT NULL,

    PRIMARY KEY (usuario_id, telefone_id),

    CONSTRAINT fk_usuario_telefone_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES Usuario(id),

    CONSTRAINT fk_usuario_telefone_telefone
        FOREIGN KEY (telefone_id)
        REFERENCES Telefone(id)
);
GO



CREATE TABLE Empresa_Telefone (
    empresa_id BIGINT NOT NULL,
    telefone_id BIGINT NOT NULL,

    PRIMARY KEY (empresa_id, telefone_id),

    CONSTRAINT fk_empresa_telefone_empresa
        FOREIGN KEY (empresa_id)
        REFERENCES Empresas(id),

    CONSTRAINT fk_empresa_telefone_telefone
        FOREIGN KEY (telefone_id)
        REFERENCES Telefone(id)
);
GO