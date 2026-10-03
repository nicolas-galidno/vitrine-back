-- =======================================================================================================
-- CÓDIGO COMPLETO ANTES DAS ATUALIZAÇOES FINAIS (NÃO EXECUTAR ESSE CÓDIGO EXECUTE OS SEPARADOS NA ORDEM)
-- =======================================================================================================

USE master;
GO

-- =========================================
-- APAGAR O BANCO SE JÁ EXISTIR
-- =========================================

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'vitrine_db')
BEGIN
    DROP DATABASE vitrine_db;
END
GO


-- =========================================
-- CRIAR O BANCO
-- =========================================

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

INSERT INTO Estado (nome, sigla)
VALUES
('Acre', 'AC'),
('Alagoas', 'AL'),
('Amapá', 'AP'),
('Amazonas', 'AM'),
('Bahia', 'BA'),
('Ceará', 'CE'),
('Distrito Federal', 'DF'),
('Espírito Santo', 'ES'),
('Goiás', 'GO'),
('Maranhão', 'MA'),
('Mato Grosso', 'MT'),
('Mato Grosso do Sul', 'MS'),
('Minas Gerais', 'MG'),
('Pará', 'PA'),
('Paraíba', 'PB'),
('Paraná', 'PR'),
('Pernambuco', 'PE'),
('Piauí', 'PI'),
('Rio de Janeiro', 'RJ'),
('Rio Grande do Norte', 'RN'),
('Rio Grande do Sul', 'RS'),
('Rondônia', 'RO'),
('Roraima', 'RR'),
('Santa Catarina', 'SC'),
('São Paulo', 'SP'),
('Sergipe', 'SE'),
('Tocantins', 'TO');
GO

USE vitrine_db;
GO

INSERT INTO Cidade (nome, estado_sigla)
VALUES

-- ACRE
('Rio Branco', 'AC'),
('Cruzeiro do Sul', 'AC'),
('Sena Madureira', 'AC'),

-- ALAGOAS
('Maceió', 'AL'),
('Arapiraca', 'AL'),
('Rio Largo', 'AL'),

-- AMAPÁ
('Macapá', 'AP'),
('Santana', 'AP'),
('Laranjal do Jari', 'AP'),

-- AMAZONAS
('Manaus', 'AM'),
('Parintins', 'AM'),
('Itacoatiara', 'AM'),

-- BAHIA
('Salvador', 'BA'),
('Feira de Santana', 'BA'),
('Vitória da Conquista', 'BA'),
('Camaçari', 'BA'),
('Juazeiro', 'BA'),
('Ilhéus', 'BA'),
('Itabuna', 'BA'),
('Porto Seguro', 'BA'),

-- CEARÁ
('Fortaleza', 'CE'),
('Caucaia', 'CE'),
('Juazeiro do Norte', 'CE'),
('Sobral', 'CE'),
('Maracanaú', 'CE'),
('Crato', 'CE'),

-- DISTRITO FEDERAL
('Brasília', 'DF'),

-- ESPÍRITO SANTO
('Vitória', 'ES'),
('Vila Velha', 'ES'),
('Serra', 'ES'),
('Cariacica', 'ES'),
('Linhares', 'ES'),
('Colatina', 'ES'),

-- GOIÁS
('Goiânia', 'GO'),
('Aparecida de Goiânia', 'GO'),
('Anápolis', 'GO'),
('Rio Verde', 'GO'),
('Luziânia', 'GO'),
('Catalão', 'GO'),

-- MARANHÃO
('São Luís', 'MA'),
('Imperatriz', 'MA'),
('São José de Ribamar', 'MA'),
('Timon', 'MA'),
('Caxias', 'MA'),

-- MATO GROSSO
('Cuiabá', 'MT'),
('Várzea Grande', 'MT'),
('Rondonópolis', 'MT'),
('Sinop', 'MT'),
('Sorriso', 'MT'),

-- MATO GROSSO DO SUL
('Campo Grande', 'MS'),
('Dourados', 'MS'),
('Três Lagoas', 'MS'),
('Corumbá', 'MS'),
('Ponta Porã', 'MS'),

-- MINAS GERAIS
('Belo Horizonte', 'MG'),
('Uberlândia', 'MG'),
('Contagem', 'MG'),
('Juiz de Fora', 'MG'),
('Betim', 'MG'),
('Montes Claros', 'MG'),
('Uberaba', 'MG'),
('Governador Valadares', 'MG'),
('Ouro Preto', 'MG'),

-- PARÁ
('Belém', 'PA'),
('Ananindeua', 'PA'),
('Santarém', 'PA'),
('Marabá', 'PA'),
('Parauapebas', 'PA'),
('Castanhal', 'PA'),

-- PARAÍBA
('João Pessoa', 'PB'),
('Campina Grande', 'PB'),
('Santa Rita', 'PB'),
('Patos', 'PB'),
('Bayeux', 'PB'),

-- PARANÁ
('Curitiba', 'PR'),
('Londrina', 'PR'),
('Maringá', 'PR'),
('Ponta Grossa', 'PR'),
('Cascavel', 'PR'),
('São José dos Pinhais', 'PR'),
('Foz do Iguaçu', 'PR'),
('Guarapuava', 'PR'),

-- PERNAMBUCO
('Recife', 'PE'),
('Jaboatão dos Guararapes', 'PE'),
('Olinda', 'PE'),
('Caruaru', 'PE'),
('Petrolina', 'PE'),
('Paulista', 'PE'),
('Cabo de Santo Agostinho', 'PE'),

-- PIAUÍ
('Teresina', 'PI'),
('Parnaíba', 'PI'),
('Picos', 'PI'),
('Floriano', 'PI'),

-- RIO DE JANEIRO
('Rio de Janeiro', 'RJ'),
('Niterói', 'RJ'),
('São Gonçalo', 'RJ'),
('Duque de Caxias', 'RJ'),
('Nova Iguaçu', 'RJ'),
('Petrópolis', 'RJ'),
('Volta Redonda', 'RJ'),
('Campos dos Goytacazes', 'RJ'),
('Cabo Frio', 'RJ'),
('Angra dos Reis', 'RJ'),
('Búzios', 'RJ'),

-- RIO GRANDE DO NORTE
('Natal', 'RN'),
('Mossoró', 'RN'),
('Parnamirim', 'RN'),
('São Gonçalo do Amarante', 'RN'),
('Caicó', 'RN'),

-- RIO GRANDE DO SUL
('Porto Alegre', 'RS'),
('Caxias do Sul', 'RS'),
('Canoas', 'RS'),
('Pelotas', 'RS'),
('Santa Maria', 'RS'),
('Gravataí', 'RS'),
('Novo Hamburgo', 'RS'),
('São Leopoldo', 'RS'),
('Gramado', 'RS'),
('Canela', 'RS'),

-- RONDÔNIA
('Porto Velho', 'RO'),
('Ji-Paraná', 'RO'),
('Ariquemes', 'RO'),
('Vilhena', 'RO'),

-- RORAIMA
('Boa Vista', 'RR'),
('Rorainópolis', 'RR'),
('Caracaraí', 'RR'),

-- SANTA CATARINA
('Florianópolis', 'SC'),
('Joinville', 'SC'),
('Blumenau', 'SC'),
('São José', 'SC'),
('Itajaí', 'SC'),
('Chapecó', 'SC'),
('Criciúma', 'SC'),
('Balneário Camboriú', 'SC'),
('Lages', 'SC'),

-- SÃO PAULO
('São Paulo', 'SP'),
('Guarulhos', 'SP'),
('Campinas', 'SP'),
('São Bernardo do Campo', 'SP'),
('Santo André', 'SP'),
('São José dos Campos', 'SP'),
('Osasco', 'SP'),
('Ribeirão Preto', 'SP'),
('Sorocaba', 'SP'),
('Mauá', 'SP'),
('São José do Rio Preto', 'SP'),
('Mogi das Cruzes', 'SP'),
('Santos', 'SP'),
('Carapicuíba', 'SP'),
('Bauru', 'SP'),
('Piracicaba', 'SP'),
('Jundiaí', 'SP'),
('Franca', 'SP'),
('Barueri', 'SP'),
('Taubaté', 'SP'),
('Itu', 'SP'),
('Guarujá', 'SP'),
('Praia Grande', 'SP'),

-- SERGIPE
('Aracaju', 'SE'),
('Nossa Senhora do Socorro', 'SE'),
('Lagarto', 'SE'),
('Itabaiana', 'SE'),

-- TOCANTINS
('Palmas', 'TO'),
('Araguaína', 'TO'),
('Gurupi', 'TO'),
('Porto Nacional', 'TO');

GO

USE vitrine_db;
GO

INSERT INTO Categoria (nome, cod_status)
VALUES
('Alimentação', 1),
('Restaurante', 1),
('Lanchonete', 1),
('Padaria', 1),
('Mercado', 1),
('Moda e Vestuário', 1),
('Beleza e Estética', 1),
('Saúde', 1),
('Educação', 1),
('Tecnologia', 1),
('Informática', 1),
('Construção', 1),
('Imobiliária', 1),
('Automóveis', 1),
('Oficina Mecânica', 1),
('Transporte', 1),
('Turismo e Viagens', 1),
('Hotelaria', 1),
('Academia e Esportes', 1),
('Pet Shop', 1),
('Veterinária', 1),
('Serviços Domésticos', 1),
('Contabilidade', 1),
('Advocacia', 1),
('Marketing e Publicidade', 1),
('Fotografia', 1),
('Eventos', 1),
('Entretenimento', 1),
('Comércio', 1),
('Indústria', 1),
('Agricultura', 1),
('Consultoria', 1),
('Serviços Gerais', 1);
GO

-- =========================================
-- CONSULTAR TODAS AS TABELAS
-- =========================================

SELECT * FROM Categoria;
SELECT * FROM Empresas;
SELECT * FROM Usuario;
SELECT * FROM Telefone;
SELECT * FROM Usuario_Telefone;
SELECT * FROM Empresa_Telefone;
SELECT * FROM Estado;
SELECT * FROM Cidade;
GO

DROP TABLE Cidade;





