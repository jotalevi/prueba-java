DROP DATABASE libreria;
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

INSERT INTO VENTA (folio, dia, mes, anio, total)
VALUES
    (1, 1, 1, 1, 0),
    (879, 13, 6, 2023, 63),
    (542, 5, 9, 2023, 82),
    (356, 22, 3, 2023, 25),
    (981, 8, 11, 2023, 90),
    (204, 18, 7, 2023, 44),
    (673, 3, 2, 2023, 38),
    (419, 24, 4, 2023, 32),
    (758, 10, 10, 2023, 30),
    (125, 7, 8, 2023, 30),
    (890, 20, 5, 2023, 63);

INSERT INTO PAGO (monto, numero, codigo, isTarjeta, venta)
VALUES
    (63, 32789014, "", 0, 879),
    (82, 0, "2F8A7E5D", 1, 542),
    (25, 89456723, "", 0, 356),
    (90, 12345678, "", 0, 981),
    (44, 0, "B6C4D9A2", 1, 204),
    (38, 74538901, "", 0, 673),
    (32, 98123456, "", 0, 419),
    (30, 0, "1E3F6A8B", 1, 758),
    (30, 56789012, "", 0, 125),
    (63, 43210987, "", 0, 890);

INSERT INTO LIBRO (codigo, descripcion, paginas, cantidad, precio, autorOTema, isNovela, venta)
VALUES
    ('L001', 'The Art of Programming', 500, 100, ROUND(RAND() * (25000 - 8000) + 8000), 'Donald Knuth', 0, 1),
    ('L002', 'Data Science Basics', 350, 75, ROUND(RAND() * (25000 - 8000) + 8000), 'John Smith', 0, 1),
    ('L003', 'History of Ancient Rome', 400, 90, ROUND(RAND() * (25000 - 8000) + 8000), 'Mary Johnson', 0, 1),
    ('L004', 'Introduction to AI', 450, 80, ROUND(RAND() * (25000 - 8000) + 8000), 'Alan Turing', 0, 1),
    ('L005', 'Cooking with Spices', 200, 120, ROUND(RAND() * (25000 - 8000) + 8000), 'Chef Gordon', 0, 1),
    ('L006', 'The Mystery of the Lost City', 300, 60, ROUND(RAND() * (25000 - 8000) + 8000), 'Jane Doe', 0, 1),
    ('L007', 'Artificial Neural Networks', 320, 70, ROUND(RAND() * (25000 - 8000) + 8000), 'Ada Lovelace', 0, 1),
    ('L008', 'World War II Chronicles', 600, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Winston Churchill', 0, 1),
    ('L009', 'Python Programming Guide', 250, 85, ROUND(RAND() * (25000 - 8000) + 8000), 'Guido van Rossum', 0, 1),
    ('L010', 'Healthy Living Habits', 180, 130, ROUND(RAND() * (25000 - 8000) + 8000), 'Dr. Wellness', 0, 1),
    ('L011', 'The Great Gatsby', 220, 95, ROUND(RAND() * (25000 - 8000) + 8000), 'F. Scott Fitzgerald', 1, 1),
    ('L012', 'Space Exploration: A Journey Beyond', 480, 105, ROUND(RAND() * (25000 - 8000) + 8000), 'Neil Armstrong', 0, 1),
    ('L013', 'The Science of Climate Change', 360, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Climate Scientist', 0, 1),
    ('L014', 'Art of the Renaissance', 240, 75, ROUND(RAND() * (25000 - 8000) + 8000), 'Leonardo da Vinci', 0, 1),
    ('L015', 'Modern Jazz Techniques', 180, 120, ROUND(RAND() * (25000 - 8000) + 8000), 'Miles Davis', 0, 1),
    ('L016', 'The Catcher in the Rye', 200, 85, ROUND(RAND() * (25000 - 8000) + 8000), 'J.D. Salinger', 1, 1),
    ('L017', 'Chemistry for Beginners', 280, 95, ROUND(RAND() * (25000 - 8000) + 8000), 'Marie Curie', 0, 1),
    ('L018', 'Financial Planning Handbook', 320, 100, ROUND(RAND() * (25000 - 8000) + 8000), 'Financial Expert', 0, 1),
    ('L019', 'The Hobbit', 300, 80, ROUND(RAND() * (25000 - 8000) + 8000), 'J.R.R. Tolkien', 1, 1),
    ('L020', 'The Physics of Quantum Mechanics', 400, 90, ROUND(RAND() * (25000 - 8000) + 8000), 'Richard Feynman', 0, 1),
    ('L021', 'Creative Writing Techniques', 220, 70, ROUND(RAND() * (25000 - 8000) + 8000), 'Stephen King', 0, 1),
    ('L022', 'The Joy of Painting', 180, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Bob Ross', 0, 1),
    ('L023', 'The Odyssey', 260, 75, ROUND(RAND() * (25000 - 8000) + 8000), 'Homer', 1, 1),
    ('L024', 'Web Development Basics', 280, 95, ROUND(RAND() * (25000 - 8000) + 8000), 'Web Developer', 0, 1),
    ('L025', 'Exploring the Amazon Rainforest', 350, 120, ROUND(RAND() * (25000 - 8000) + 8000), 'Explorer Jane', 0, 1),
    ('L026', 'The Alchemist', 240, 85, ROUND(RAND() * (25000 - 8000) + 8000), 'Paulo Coelho', 1, 1),
    ('L027', 'Understanding Black Holes', 420, 100, ROUND(RAND() * (25000 - 8000) + 8000), 'Astrophysicist', 0, 1),
    ('L028', 'Effective Time Management', 200, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Time Management Expert', 0, 1),
    ('L029', 'To Kill a Mockingbird', 280, 90, ROUND(RAND() * (25000 - 8000) + 8000), 'Harper Lee', 1, 1),
    ('L030', 'Economics for Everyone', 320, 80, ROUND(RAND() * (25000 - 8000) + 8000), 'Economist', 0, 1),
    ('L031', 'Artificial Intelligence Ethics', 260, 75, ROUND(RAND() * (25000 - 8000) + 8000), 'AI Ethicist', 0, 1),
    ('L032', 'Yoga and Meditation Guide', 180, 120, ROUND(RAND() * (25000 - 8000) + 8000), 'Yoga Instructor', 0, 1),
    ('L033', 'Crime and Punishment', 300, 95, ROUND(RAND() * (25000 - 8000) + 8000), 'Fyodor Dostoevsky', 1, 1),
    ('L034', 'Geology and Earth Sciences', 380, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Geologist', 0, 1),
    ('L035', 'The Shining', 240, 85, ROUND(RAND() * (25000 - 8000) + 8000), 'Stephen King', 1, 1),
    ('L036', 'Introduction to Machine Learning', 400, 100, ROUND(RAND() * (25000 - 8000) + 8000), 'ML Expert', 0, 1),
    ('L037', 'Nutrition and Health', 220, 120, ROUND(RAND() * (25000 - 8000) + 8000), 'Health Expert', 0, 1),
    ('L038', 'Brave New World', 260, 95, ROUND(RAND() * (25000 - 8000) + 8000), 'Aldous Huxley', 0, 1),
    ('L039', 'Environmental Sustainability', 340, 90, ROUND(RAND() * (25000 - 8000) + 8000), 'Environmental Scientist', 0, 1),
    ('L040', 'The Hitchhikers Guide to the Galaxy', 280, 80, ROUND(RAND() * (25000 - 8000) + 8000), 'Douglas Adams', 1, 1),
    ('L041', 'Introduction to Robotics', 320, 75, ROUND(RAND() * (25000 - 8000) + 8000), 'Robotics Engineer', 0, 1),
    ('L042', 'Healthy Cooking Recipes', 200, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Nutritionist', 0, 1),
    ('L043', 'The Lord of the Rings', 500, 95, ROUND(RAND() * (25000 - 8000) + 8000), 'J.R.R. Tolkien', 1, 1),
    ('L044', 'History of Ancient Egypt', 360, 100, ROUND(RAND() * (25000 - 8000) + 8000), 'Egyptologist', 0, 1),
    ('L045', 'The Martian', 300, 85, ROUND(RAND() * (25000 - 8000) + 8000), 'Andy Weir', 1, 1),
    ('L046', 'Introduction to Astrophysics', 420, 110, ROUND(RAND() * (25000 - 8000) + 8000), 'Astrophysicist', 0, 1),
    ('L047', 'Effective Communication Skills', 240, 120, ROUND(RAND() * (25000 - 8000) + 8000), 'Communication Expert', 0, 1),
    ('L048', 'Pride and Prejudice', 220, 90, ROUND(RAND() * (25000 - 8000) + 8000), 'Jane Austen', 1, 1),
    ('L049', 'The Solar System', 300, 100, ROUND(RAND() * (25000 - 8000) + 8000), 'Astronomer', 0, 1),
    ('L050', 'Art and Creativity', 180, 80, ROUND(RAND() * (25000 - 8000) + 8000), 'Creative Artist', 0, 1);


