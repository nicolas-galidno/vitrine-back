USE vitrine_db;
GO

-- =========================================
-- INSERIR TODOS MUNICIPIOS DO BRASIL
-- =========================================


IF OBJECT_ID('tempdb..#Municipios') IS NOT NULL
    DROP TABLE #Municipios;
GO

CREATE TABLE #Municipios (
    estado_id INT NOT NULL,
    municipio_id INT NOT NULL,
    nome NVARCHAR(100) NOT NULL
);
GO

--Tem que ligar o SQLCMD MOD 

!! powershell -NoProfile -ExecutionPolicy Bypass -Command "New-Item -ItemType Directory -Force -Path 'C:\Temp' | Out-Null; Invoke-WebRequest -UseBasicParsing -Uri 'https://raw.githubusercontent.com/maiconschmitz/estados-municipios-ibge/main/municipios.csv' -OutFile 'C:\Temp\municipios.csv'"

BULK INSERT #Municipios
FROM 'C:\Temp\municipios.csv'
WITH (
    FORMAT = 'CSV',
    FIRSTROW = 2,
    FIELDQUOTE = '"',
    FIELDTERMINATOR = ',',
    ROWTERMINATOR = '0x0a',
    CODEPAGE = '65001'
);
GO

INSERT INTO Cidade (nome, estado_sigla)
SELECT
    nome,
    CASE estado_id
        WHEN 11 THEN 'RO'
        WHEN 12 THEN 'AC'
        WHEN 13 THEN 'AM'
        WHEN 14 THEN 'RR'
        WHEN 15 THEN 'PA'
        WHEN 16 THEN 'AP'
        WHEN 17 THEN 'TO'
        WHEN 21 THEN 'MA'
        WHEN 22 THEN 'PI'
        WHEN 23 THEN 'CE'
        WHEN 24 THEN 'RN'
        WHEN 25 THEN 'PB'
        WHEN 26 THEN 'PE'
        WHEN 27 THEN 'AL'
        WHEN 28 THEN 'SE'
        WHEN 29 THEN 'BA'
        WHEN 31 THEN 'MG'
        WHEN 32 THEN 'ES'
        WHEN 33 THEN 'RJ'
        WHEN 35 THEN 'SP'
        WHEN 41 THEN 'PR'
        WHEN 42 THEN 'SC'
        WHEN 43 THEN 'RS'
        WHEN 50 THEN 'MS'
        WHEN 51 THEN 'MT'
        WHEN 52 THEN 'GO'
        WHEN 53 THEN 'DF'
    END
FROM #Municipios
WHERE NOT EXISTS (
    SELECT 1
    FROM Cidade c
    WHERE c.nome = #Municipios.nome
      AND c.estado_sigla = CASE #Municipios.estado_id
        WHEN 11 THEN 'RO'
        WHEN 12 THEN 'AC'
        WHEN 13 THEN 'AM'
        WHEN 14 THEN 'RR'
        WHEN 15 THEN 'PA'
        WHEN 16 THEN 'AP'
        WHEN 17 THEN 'TO'
        WHEN 21 THEN 'MA'
        WHEN 22 THEN 'PI'
        WHEN 23 THEN 'CE'
        WHEN 24 THEN 'RN'
        WHEN 25 THEN 'PB'
        WHEN 26 THEN 'PE'
        WHEN 27 THEN 'AL'
        WHEN 28 THEN 'SE'
        WHEN 29 THEN 'BA'
        WHEN 31 THEN 'MG'
        WHEN 32 THEN 'ES'
        WHEN 33 THEN 'RJ'
        WHEN 35 THEN 'SP'
        WHEN 41 THEN 'PR'
        WHEN 42 THEN 'SC'
        WHEN 43 THEN 'RS'
        WHEN 50 THEN 'MS'
        WHEN 51 THEN 'MT'
        WHEN 52 THEN 'GO'
        WHEN 53 THEN 'DF'
      END
);
GO

SELECT COUNT(*) AS total_municipios
FROM Cidade;
GO

SELECT
    c.id,
    c.nome AS cidade,
    c.estado_sigla
FROM Cidade c
ORDER BY c.estado_sigla, c.nome;
GO
