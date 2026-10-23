CREATE TABLE IF NOT EXISTS persona (
    id INT NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    CONSTRAINT pk_persona PRIMARY KEY (id),
    CONSTRAINT uq_persona_correo UNIQUE (correo)
);
