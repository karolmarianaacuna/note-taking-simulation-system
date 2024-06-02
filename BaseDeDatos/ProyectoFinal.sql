CREATE DATABASE proyectoFinal
use proyectoFinal;

CREATE TABLE Personas(

    id_Persona int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(299),
    apellido VARCHAR(299),
    genero VARCHAR(299),
    email VARCHAR(299)
    

);

CREATE TABLE NotasPersonales(

    id_NotasPersonal int PRIMARY KEY AUTO_INCREMENT,
    Titulo1_Nota VARCHAR(299),
    fecha_Creacion date,
    descripcion VARCHAR(299),
    tipo_EMOCION VARCHAR(299)
    

);
CREATE TABLE NotasAcademicas(

    id_NotasAcademicas int PRIMARY KEY AUTO_INCREMENT,
    Titulo1_Nota VARCHAR(299),
    fecha_Creacion date,
    descripcion VARCHAR(299),
    Objetivos_Academicos VARCHAR(299)
    

);
CREATE TABLE NotasFinanzas(

    id_NotasFinanzas int PRIMARY KEY AUTO_INCREMENT,
    Titulo1_Nota VARCHAR(299),
    fecha_Creacion date,
    descripcion VARCHAR(299),
    medioPago VARCHAR(299)
    
    

);

CREATE TABLE NotasSalud(

    id_NotasSalud int PRIMARY KEY AUTO_INCREMENT,
    Titulo1_Nota VARCHAR(299),
    fecha_Creacion date,
    descripcion VARCHAR(299),
    SignosVitales VARCHAR(299)
    

);
CREATE TABLE Notasvarios(

    id_Notasvarios int PRIMARY KEY AUTO_INCREMENT,
    Titulo1_Nota VARCHAR(299),
    fecha_Creacion date,
    descripcion VARCHAR(299),
    Recordatorios VARCHAR(299)
    

);
CREATE TABLE NotasTrabajo(

    id_NotasTrabajo int PRIMARY KEY AUTO_INCREMENT,
    Titulo1_Nota VARCHAR(299),
    fecha_Creacion date,
    descripcion VARCHAR(299),
    Prioridad VARCHAR(299),
    Recordatorios VARCHAR(299)
    

);
CREATE TABLE Notas (
    id_NotasTrabajo INT,
    id_Notasvarios INT,
    id_NotasSalud INT,
    id_NotasFinanzas INT,
    id_NotasAcademicas INT,
    id_NotasPersonal INT,
    id_Persona INT,
    FOREIGN KEY (id_NotasTrabajo) REFERENCES NotasTrabajo(id_NotasTrabajo),
    FOREIGN KEY (id_Notasvarios) REFERENCES Notasvarios(id_Notasvarios),
    FOREIGN KEY (id_NotasSalud) REFERENCES NotasSalud(id_NotasSalud),
    FOREIGN KEY (id_NotasFinanzas) REFERENCES NotasFinanzas(id_NotasFinanzas),
    FOREIGN KEY (id_NotasAcademicas) REFERENCES NotasAcademicas(id_NotasAcademicas),
    FOREIGN KEY (id_NotasPersonal) REFERENCES NotasPersonales(id_NotasPersonal),
    FOREIGN KEY (id_Persona) REFERENCES Personas(id_Persona)
);


