
CREATE DATABASE IF NOT EXISTS db_turnos2;
use db_turnos2;
CREATE TABLE persona (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    contrasena  VARCHAR(50) NOT NULL
);

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
  
    FOREIGN KEY (id) REFERENCES persona(id)
);

CREATE TABLE especialidad (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);
CREATE TABLE profesional (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_persona INT NOT NULL,
    id_especialidad INT NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id),
    FOREIGN KEY (id_especialidad) REFERENCES especialidad(id)
);
CREATE TABLE servicio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    id_especialidad INT NOT NULL,
    duracion VARCHAR (20) NOT NULL, 
    FOREIGN KEY (id_especialidad) REFERENCES especialidad(id)
);

CREATE TABLE contacto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_persona INT NOT NULL,
    email VARCHAR(50) NOT NULL, 
    telefono VARCHAR(255) NOT NULL,
	movil VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id)
);

CREATE TABLE turno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_profesional INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_profesional) REFERENCES profesional(id),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id)
);

CREATE TABLE disponibilidad (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    disponibilidad BOOLEAN DEFAULT TRUE,
	id_profesional INT NOT NULL,
	FOREIGN KEY (id_profesional) REFERENCES profesional(id)
);