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

-- Insertar especialidades
INSERT INTO especialidad (nombre) VALUES
('Dermatología'),
('Cardiología'),
('Odontología'),
('Pediatría'),
('Neurología'),
('Traumatología');

-- Insertar personas (profesionales y clientes)
INSERT INTO persona (nombre, contrasena, dni) VALUES
('Dr. Juan Pérez', 'pass123', 12345678),      -- id_persona=1 (profesional)
('Dra. María López', 'pass234', 23456789),    -- id_persona=2 (profesional)
('Dr. Pablo García', 'pass345', 34567890),    -- id_persona=3 (profesional)
('Ana Torres', 'cliente1', 45678901),         -- id_persona=4 (cliente)
('Carlos Díaz', 'cliente2', 56789012),        -- id_persona=5 (cliente)
('Lucía Fernández', 'cliente3', 67890123);    -- id_persona=6 (cliente)

-- Insertar profesionales
INSERT INTO profesional (id_persona, id_especialidad, nro_matricula) VALUES
(1, 1, 1001), -- Dermatóloga
(2, 2, 2002), -- Cardióloga
(3, 3, 3003); -- Odontólogo

-- Insertar clientes
INSERT INTO cliente (id_persona, nro_cliente) VALUES
(4, 4001),
(5, 5002),
(6, 6003);

-- Insertar contactos (algunos sí, otros no)
INSERT INTO contacto (id_persona, email, telefono, movil) VALUES
(1, 'juan.perez@clinic.com', '01112345678', '1156781234'),
(4, 'ana.torres@email.com', '01123456789', '1167892345'),
(5, 'carlos.diaz@email.com', '01134567890', '1178903456');
-- Nota: No se insertan contactos para Dra. María López, Dr. Pablo García ni Lucía Fernández

-- Insertar servicios
INSERT INTO servicio (nombre, descripcion, precio, duracion) VALUES
('Consulta Dermatológica', 'Consulta especializada en enfermedades de la piel', 3000.00, '30m'),
('Consulta Cardiológica', 'Consulta y control de salud cardiovascular', 3500.00, '40m'),
('Consulta Odontológica', 'Consulta general y chequeo dental', 2500.00, '30m'),
('Electrocardiograma', 'Estudio del ritmo cardíaco', 2000.00, '20m'),
('Limpieza Dental', 'Limpieza profesional de dientes', 1500.00, '45m'),
('Control Infantil', 'Control de salud pediátrico', 3200.00, '35m');

-- Insertar disponibilidades para los profesionales
INSERT INTO disponibilidad (fecha, hora, disponibilidad, id_profesional) VALUE
('2025-07-01', '08:00:00', TRUE, 1),
('2025-07-01', '09:00:00', TRUE, 1),
('2025-07-01', '10:00:00', TRUE, 1),
('2025-07-02', '11:00:00', TRUE, 1),
('2025-07-03', '09:00:00', TRUE, 1),
('2025-07-01', '12:00:00', TRUE, 2),
('2025-07-02', '09:00:00', TRUE, 2),
('2025-07-02', '10:00:00', TRUE, 2),
('2025-07-02', '11:00:00', TRUE, 2),
('2025-07-03', '09:00:00', TRUE, 2),
('2025-07-01', '15:00:00', TRUE, 3),
('2025-07-02', '10:00:00', TRUE, 3),
('2025-07-03', '11:00:00', TRUE, 3);
('2025-07-03', '13:00:00', TRUE, 3),
('2025-07-03', '14:00:00', TRUE, 3),

-- Insertar turnos (citas/reservas)
INSERT INTO turno (id_cliente, id_profesional, id_servicio, fecha_hora) VALUES
(4, 1, 1, '2025-07-01 09:00:00'), -- Ana Torres con Juan Pérez (Dermatología)
(5, 2, 2, '2025-07-02 09:00:00'), -- Carlos Díaz con María López (Cardiología)
(6, 3, 3, '2025-07-03 13:00:00'), -- Lucía Fernández con Pablo García (Odontología)
(4, 3, 5, '2025-07-03 14:00:00'), -- Ana Torres con Pablo García (Limpieza Dental)
(5, 1, 1, '2025-07-01 10:00:00'), -- Carlos Díaz con Juan Pérez (Dermatología)
(6, 2, 4, '2025-07-02 11:00:00'); -- Lucía Fernández con María López (Electrocardiograma)

-- Actualizar disponibilidades utilizadas por los turnos para ponerlas en FALSE
UPDATE disponibilidad SET disponibilidad = FALSE
WHERE (fecha = '2025-07-01' AND hora = '09:00:00' AND id_profesional = 1)
   OR (fecha = '2025-07-01' AND hora = '10:00:00' AND id_profesional = 1)
   OR (fecha = '2025-07-02' AND hora = '09:00:00' AND id_profesional = 2)
   OR (fecha = '2025-07-02' AND hora = '11:00:00' AND id_profesional = 2)
   OR (fecha = '2025-07-03' AND hora = '13:00:00' AND id_profesional = 3)
   OR (fecha = '2025-07-03' AND hora = '14:00:00' AND id_profesional = 3);