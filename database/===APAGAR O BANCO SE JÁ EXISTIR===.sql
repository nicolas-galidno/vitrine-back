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