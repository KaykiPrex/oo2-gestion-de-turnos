CREATE DATABASE IF NOT EXISTS db_turnos;
USE db_turnos;

CREATE TABLE persona (
    id_persona INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    contrasena  VARCHAR(50) NOT NULL,
    dni INT NOT NULL
);

CREATE TABLE cliente (
    id_persona INT PRIMARY KEY,
    nro_cliente INT NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

CREATE TABLE especialidad (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE profesional (
    id_persona INT PRIMARY KEY,
    id_especialidad INT NOT NULL,
    nro_matricula INT NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona),
    FOREIGN KEY (id_especialidad) REFERENCES especialidad(id)
);

CREATE TABLE servicio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    duracion VARCHAR (20) NOT NULL
);

CREATE TABLE contacto (
    id_persona INT PRIMARY KEY,
    email VARCHAR(50) NOT NULL, 
    telefono VARCHAR(255) NOT NULL,
    movil VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

CREATE TABLE turno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_profesional INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_persona),
    FOREIGN KEY (id_profesional) REFERENCES profesional(id_persona),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id)
);

CREATE TABLE disponibilidad (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    disponibilidad BOOLEAN DEFAULT TRUE,
    id_profesional INT NOT NULL,
    FOREIGN KEY (id_profesional) REFERENCES profesional(id_persona)
);