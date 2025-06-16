CREATE DATABASE IF NOT EXISTS db_turnos_recuperacion;
use db_turnos_recuperacion;


CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);
-- Tabla CoNTACT
CREATE TABLE contact (
    id INT PRIMARY KEY,
    work_email VARCHAR(100),
    personal_email VARCHAR(100),
    phone VARCHAR(20),
    mobile VARCHAR(20),
    FOREIGN KEY (id) REFERENCES user(id)
);

-- Tabla de subclase: CLIENT
CREATE TABLE client (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    last_name VARCHAR(100),
    dni VARCHAR(20),
    FOREIGN KEY (id) REFERENCES user(id)
);

-- Tabla de subclase: PROFESSIONAL
CREATE TABLE professional (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    last_name VARCHAR(100),
    cuil VARCHAR(20),
    FOREIGN KEY (id) REFERENCES user(id)
);

-- Tabla CATEGORY
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Tabla SPECIALTY
CREATE TABLE specialty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Tabla SERVICE
CREATE TABLE service (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    duration VARCHAR(20),
    specialty_id INT,
    FOREIGN KEY (specialty_id) REFERENCES specialty(id)
);

-- Tabla PROFESSIONAL_SPECIALTY
CREATE TABLE professional_specialty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50),
    professional_id INT,
    specialty_id INT,
    FOREIGN KEY (professional_id) REFERENCES professional(id),
    FOREIGN KEY (specialty_id) REFERENCES specialty(id)
);

-- Tabla PROFESSIONAL_SERVICE
CREATE TABLE professional_service (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(10,2),
    init_work_hour TIME,
    end_work_hour TIME,
    work_days VARCHAR(100),
    professional_id INT,
    service_id INT,
    FOREIGN KEY (professional_id) REFERENCES professional(id),
    FOREIGN KEY (service_id) REFERENCES service(id)
);

-- Tabla APPOINTMENT
CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    time TIME,
    is_blocked BOOLEAN,
    location VARCHAR(255),
    report TEXT,
    client_id INT,
    professional_service_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (professional_service_id) REFERENCES professional_service(id)
);