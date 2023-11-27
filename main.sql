CREATE DATABASE libreria;
USE libreria;

CREATE TABLE VENTA (
    folio INT PRIMARY KEY,
    dia INT NOT NULL,
    mes INT NOT NULL,
    anio INT NOT NULL,
    total INT NOT NULL
);

CREATE TABLE LIBRO (
    codigo VARCHAR(128) PRIMARY KEY,
    descripcion TEXT NOT NULL,
    paginas INT NOT NULL,
    cantidad INT NOT NULL,
    precio INT NOT NULL,
    autorOTema TEXT NOT NULL,
    isNovela INT NOT NULL,
    venta INT,
    FOREIGN KEY (venta) REFERENCES VENTA(folio)
);

CREATE TABLE PAGO (
    monto INT NOT NULL,
    numero INT NOT NULL,
    codigo TEXT NOT NULL,
    isTarjeta INT NOT NULL,
    venta INT,
    FOREIGN KEY (venta) REFERENCES VENTA(folio)
);


INSERT INTO VENTA (folio, dia, mes, anio, total) VALUES (1, 27, 06, 2022, 15000);
INSERT INTO VENTA (folio, dia, mes, anio, total) VALUES (2, 23, 06, 2023, 15000);
INSERT INTO VENTA (folio, dia, mes, anio, total) VALUES (3, 23, 06, 2023, 18000);
INSERT INTO VENTA (folio, dia, mes, anio, total) VALUES (4, 23, 06, 2023, 21000);
INSERT INTO VENTA (folio, dia, mes, anio, total) VALUES (5, 26, 06, 2023, 15000);

INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("01", "un libro fome", 152, 3, 5000, 'software', 0, 1);
INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("02", "otro libro fome", 392, 2, 5000, 'software', 0, 2);
INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("03", "html para hueones", 392, 1, 5000, 'software', 0, 2);
INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("04", "Novela muy Fomr", 152, 1, 18000, 'Maria Piñera', 1, 3);
INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("05", "Novela Rara", 152, 1, 21000, 'Augusto pinoshit', 1, 4);
INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("06", "ñelasdka", 152, 1, 7500, 'autor uno', 0, 5);
INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta) VALUES ("07", "xn3p9xa", 321, 1, 7500, 'autor dos', 0, 5);

INSERT INTO PAGO (monto, numero, codigo, isTarjeta, venta) VALUES (15000, 0013984, "", 0, 1);
INSERT INTO PAGO (monto, numero, codigo, isTarjeta, venta) VALUES (15000, 8410343, "", 0, 2);
INSERT INTO PAGO (monto, numero, codigo, isTarjeta, venta) VALUES (18000, 0, "98W4HFOHSOH4", 1, 3);
INSERT INTO PAGO (monto, numero, codigo, isTarjeta, venta) VALUES (21000, 2391238, "", 0, 4);
INSERT INTO PAGO (monto, numero, codigo, isTarjeta, venta) VALUES (15000, 0, "8FHPJ4PFI4PI", 0, 5;
