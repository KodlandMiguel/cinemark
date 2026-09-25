create database cinemark_in4bm;

use cinemark_in4bm;

create table Usuarios (

	id_usuario int auto_increment primary key,
    email varchar(60) unique not null,
	nickname varchar(30) unique,
    contrasena varchar(120)

);

create table Peliculas (

	id_pelicula int auto_increment primary key,
	nombre_pelicula varchar(30),
    duracion double

);

create table Funciones (

	id_funcion int auto_increment primary key,
	id_pelicula int,
    fecha date,
    hora double,
    foreign key (id_pelicula) references Peliculas(id_pelicula)

);

create table Salas (

	id_sala int primary key not null,
    id_pelicula int,
    id_usuario int,
    foreign key (id_pelicula) references Peliculas(id_pelicula),
	foreign key (id_usuario) references Usuarios(id_usuario)

);

INSERT INTO Peliculas (nombre_pelicula, duracion) VALUES
('El Padrino', 2.55),
('Titanic', 3.14),
('Avatar', 2.42),
('Gladiador', 2.35),
('Interestelar', 2.49),
('Pulp Fiction', 1.54),
('El Rey León', 1.28),
('Jurassic Park', 2.07),
('Forrest Gump', 2.22),
('Star Wars', 2.01),
('Terminator 2', 2.17),
('Volver al Futuro', 1.56),
('El Señor de los Anillos', 3.21),
('Matrix', 2.16),
('Toy Story', 1.21),
('Buscando a Nemo', 1.40),
('Up', 1.36),
('Wall-E', 1.38),
('Coco', 1.45),
('Frozen', 1.42),
('Avengers', 2.23),
('Batman', 2.06),
('Joker', 2.02),
('Parasitos', 2.12),
('1917', 1.59),
('Duna', 2.35),
('Top Gun', 2.10),
('Barbie', 1.54),
('Oppenheimer', 3.00),
('Spider-Man', 2.20),
('Logan', 2.17),
('Deadpool', 1.48),
('La La Land', 2.08),
('Whiplash', 1.46),
('Alien', 1.57),
('Depredador', 1.47),
('Rocky', 1.59),
('Rambo', 1.33),
('Duro de Matar', 2.12),
('Braveheart', 2.58),
('Wonka', 1.56),
('Aquaman', 2.23),
('The Batman', 2.56),
('The Flash', 2.24),
('Blue Beetle', 2.07),
('Elemental', 1.41),
('Wish', 1.32),
('Kung Fu Panda 4', 1.34),
('Dune Parte 2', 2.46),
('Godzilla x Kong', 1.55),
('Civil War', 1.52),
('Bad Boys 4', 2.08),
('Intensa-Mente 2', 1.36),
('Mi Villano Favorito 4', 1.34),
('Deadpool y Wolverine', 2.08),
('Alien Romulus', 1.59),
('Beetlejuice 2', 1.47),
('Guasón 2', 2.18),
('Moana 2', 1.48),
('Mufasa', 1.46),
('Sonic 3', 2.02),
('Nosferatu', 2.11),
('El Padrino II', 3.22),
('The Truman Show', 1.43),
('El Club de la Pelea', 2.19),
('Seven', 2.07),
('El Silencio', 1.58),
('Memento', 1.53),
('The Prestige', 2.10),
('Shutter Island', 2.18),
('Origen', 2.28),
('Tenet', 2.30),
('La Llegada', 1.56),
('Blade Runner 2049', 2.44),
('Mad Max Furia', 2.00),
('Her', 2.06),
('Ex Machina', 1.48),
('Sicario', 2.01),
('Prisoners', 2.33),
('Zodiac', 2.37),
('The Departed', 2.31),
('Goodfellas', 2.26),
('Casino', 2.58),
('Scarface', 2.50),
('Heat', 2.50),
('Ciudad de Dios', 2.10),
('Secreto de sus Ojos', 2.09),
('Relatos Salvajes', 2.02),
('Nueve Reinas', 1.54),
('El Clan', 1.48),
('Argentina 1985', 2.20),
('Esperando la Carroza', 1.27),
('Gladiator II', 2.28),
('Sonido de Libertad', 2.11),
('Krakens y Sirenas', 1.31),
('Gran Turismo', 2.14),
('The Creator', 2.13),
('Napoleón', 2.38),
('The Marvels', 1.45),
('Resistencia', 2.13);

INSERT INTO Funciones (id_pelicula, fecha, hora) VALUES
(1, '2026-06-01', 18.30), -- El Padrino
(2, '2026-06-01', 21.00), -- Titanic
(3, '2026-06-02', 15.30), -- Avatar
(4, '2026-06-02', 19.00), -- Gladiador
(5, '2026-06-03', 20.15), -- Interestelar
(6, '2026-06-03', 22.30), -- Pulp Fiction
(7, '2026-06-04', 14.00), -- El Rey León
(8, '2026-06-04', 17.45), -- Jurassic Park
(9, '2026-06-05', 18.00), -- Forrest Gump
(10, '2026-06-05', 21.30), -- Star Wars
(11, '2026-06-06', 19.15), -- Terminator 2
(12, '2026-06-06', 16.00), -- Volver al Futuro
(13, '2026-06-07', 17.00), -- El Señor de los Anillos
(14, '2026-06-07', 20.00), -- Matrix
(15, '2026-06-08', 14.30), -- Toy Story
(16, '2026-06-08', 16.30), -- Buscando a Nemo
(17, '2026-06-09', 15.00), -- Up
(18, '2026-06-09', 17.15), -- Wall-E
(19, '2026-06-10', 16.45), -- Coco
(20, '2026-06-10', 18.30), -- Frozen
(21, '2026-06-11', 20.00), -- Avengers
(22, '2026-06-11', 22.15), -- Batman
(23, '2026-06-12', 19.30), -- Joker
(24, '2026-06-12', 21.45), -- Parasitos
(25, '2026-06-13', 18.00), -- 1917
(26, '2026-06-13', 20.30), -- Duna
(27, '2026-06-14', 17.30), -- Top Gun
(28, '2026-06-14', 20.00), -- Barbie
(29, '2026-06-15', 19.00), -- Oppenheimer
(30, '2026-06-15', 21.30), -- Spider-Man
(31, '2026-06-16', 18.15), -- Logan
(32, '2026-06-16', 20.45), -- Deadpool
(33, '2026-06-17', 17.00), -- La La Land
(34, '2026-06-17', 19.30), -- Whiplash
(35, '2026-06-18', 21.00), -- Alien
(36, '2026-06-18', 23.00), -- Depredador
(37, '2026-06-19', 16.00), -- Rocky
(38, '2026-06-19', 18.30), -- Rambo
(39, '2026-06-20', 20.15), -- Duro de Matar
(40, '2026-06-20', 22.45), -- Braveheart
(41, '2026-06-21', 15.30), -- Wonka
(42, '2026-06-21', 18.00), -- Aquaman
(43, '2026-06-22', 20.30), -- The Batman
(44, '2026-06-22', 22.45), -- The Flash
(45, '2026-06-23', 16.15), -- Blue Beetle
(46, '2026-06-23', 18.45), -- Elemental
(47, '2026-06-24', 15.00), -- Wish
(48, '2026-06-24', 17.30), -- Kung Fu Panda 4
(49, '2026-06-25', 19.00), -- Dune Parte 2
(50, '2026-06-25', 21.30), -- Godzilla x Kong
(51, '2026-06-26', 17.15), -- Civil War
(52, '2026-06-26', 19.45), -- Bad Boys 4
(53, '2026-06-27', 16.00), -- Intensa-Mente 2
(54, '2026-06-27', 18.15), -- Mi Villano Favorito 4
(55, '2026-06-28', 20.00), -- Deadpool y Wolverine
(56, '2026-06-28', 22.15), -- Alien Romulus
(57, '2026-06-29', 17.45), -- Beetlejuice 2
(58, '2026-06-29', 20.15), -- Guasón 2
(59, '2026-06-30', 15.30), -- Moana 2
(60, '2026-06-30', 17.45), -- Mufasa
(61, '2026-07-01', 19.15), -- Sonic 3
(62, '2026-07-01', 21.30), -- Nosferatu
(63, '2026-07-02', 18.00), -- El Padrino II
(64, '2026-07-02', 20.30), -- The Truman Show
(65, '2026-07-03', 16.30), -- El Club de la Pelea
(66, '2026-07-03', 19.00), -- Seven
(67, '2026-07-04', 15.00), -- El Silencio
(68, '2026-07-04', 17.15), -- Memento
(69, '2026-07-05', 18.30), -- The Prestige
(70, '2026-07-05', 21.00), -- Shutter Island
(71, '2026-07-06', 19.45), -- Origen
(72, '2026-07-06', 22.15), -- Tenet
(73, '2026-07-07', 17.00), -- La Llegada
(74, '2026-07-07', 19.45), -- Blade Runner 2049
(75, '2026-07-08', 20.30), -- Mad Max Furia
(76, '2026-07-08', 22.45), -- Her
(77, '2026-07-09', 16.00), -- Ex Machina
(78, '2026-07-09', 18.30), -- Sicario
(79, '2026-07-10', 19.15), -- Prisoners
(80, '2026-07-10', 21.45), -- Zodiac
(81, '2026-07-11', 18.00), -- The Departed
(82, '2026-07-11', 20.45), -- Goodfellas
(83, '2026-07-12', 17.30), -- Casino
(84, '2026-07-12', 20.30), -- Scarface
(85, '2026-07-13', 19.00), -- Heat
(86, '2026-07-13', 21.30), -- Ciudad de Dios
(87, '2026-07-14', 16.30), -- Secreto de sus Ojos
(88, '2026-07-14', 18.45), -- Relatos Salvajes
(89, '2026-07-15', 20.00), -- Nueve Reinas
(90, '2026-07-15', 22.30), -- El Clan
(91, '2026-07-16', 15.00), -- Argentina 1985
(92, '2026-07-16', 17.15), -- Esperando la Carroza
(93, '2026-07-17', 18.30), -- Gladiator II
(94, '2026-07-17', 21.00), -- Sonido de Libertad
(95, '2026-07-18', 16.45), -- Krakens y Sirenas
(96, '2026-07-18', 19.00), -- Gran Turismo
(97, '2026-07-19', 17.15), -- The Creator
(98, '2026-07-19', 19.30), -- Napoleón
(99, '2026-07-20', 18.00), -- The Marvels
(100, '2026-07-20', 20.45);