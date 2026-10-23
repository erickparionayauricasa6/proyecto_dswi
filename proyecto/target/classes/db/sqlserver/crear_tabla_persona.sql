IF OBJECT_ID(N'dbo.persona', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.persona (
        id INT IDENTITY(1,1) NOT NULL,
        nombres NVARCHAR(100) NOT NULL,
        apellidos NVARCHAR(100) NOT NULL,
        correo NVARCHAR(150) NOT NULL,
        fecha_nacimiento DATE NOT NULL,
        CONSTRAINT pk_persona PRIMARY KEY (id),
        CONSTRAINT uq_persona_correo UNIQUE (correo)
    );
END;
