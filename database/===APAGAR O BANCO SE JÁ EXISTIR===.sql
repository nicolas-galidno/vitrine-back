USE master;
GO

-- =========================================
-- APAGAR O BANCO SE JÁ EXISTIR
-- =========================================

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'vitrine_db')
BEGIN
    ALTER DATABASE vitrine_db
    SET SINGLE_USER
    WITH ROLLBACK IMMEDIATE;

    DROP DATABASE vitrine_db;
END
GO