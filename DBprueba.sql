SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `actividades` (
  `id` int(11) NOT NULL,
  `titulo` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL,
  `hora_inicio` datetime NOT NULL,
  `hora_final` datetime NOT NULL,
  `estado` enum('Hecho','Por Hacer','','') COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Por Hacer',
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `actividades` (`id`, `titulo`, `descripcion`, `hora_inicio`, `hora_final`, `estado`, `id_usuario`) VALUES
(3, 'sdasdas', 'dsadasdasdas', '2020-12-16 15:39:26', '2020-12-25 15:39:26', 'Por Hacer', 1),
(56, 'Terminar la prueba', 'Terminar la prueba de programación de angular con springboot', '2020-12-01 13:38:00', '2020-12-01 11:41:00', 'Por Hacer', 1),
(58, 'Entregar la prueba', 'Entregar la prueba de programación de angular con springboot', '2020-12-12 11:40:00', '2020-12-10 11:40:00', 'Por Hacer', 2),
(61, '22323', 'Terminar la pru23223232', '2020-12-18 13:39:00', '2020-12-18 13:41:00', 'Por Hacer', 2),
(62, 'Terminar la pruebaweweqwe', 'asdasdasdsda', '2020-12-04 18:40:00', '2020-12-23 13:44:00', 'Por Hacer', 1),
(63, 'Terminar la pruebaweweqwe', 'asdasdasdsda', '2020-12-04 18:40:00', '2020-12-23 13:44:00', 'Por Hacer', 1);

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(65);

CREATE TABLE `tipo_documento` (
  `id` int(11) NOT NULL,
  `tipo_documento` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `tipo_documento` (`id`, `tipo_documento`) VALUES
(1, 'Cedula de ciudadanía '),
(4, 'Cedula extranjera '),
(2, 'Pasaporte'),
(3, 'Tarjeta de identidad');

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `n_documento` varchar(33) COLLATE utf8_spanish2_ci NOT NULL,
  `primer_nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `segundo_nombre` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `primer_apellido` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `segundo_apellido` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `tipo_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `usuarios` (`id`, `n_documento`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `edad`, `tipo_documento`) VALUES
(1, '101010', 'Fausto', NULL, 'Fiorentino', NULL, 30, 1),
(2, '12121212', 'Ricardinho', NULL, 'Pelé', 'Rafardinho', 24, 1),
(3, '5353535', 'El Chamo', NULL, 'Gonzalez', NULL, 32, 4);

ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbuai2xdlw8up6ej2a1opvq60o` (`id_usuario`);

ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6mar96yv8281yooclfurf9rm5` (`tipo_documento`);

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_TipoDocumento` (`tipo_documento`);

ALTER TABLE `actividades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

ALTER TABLE `tipo_documento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `actividades`
  ADD CONSTRAINT `FKbuai2xdlw8up6ej2a1opvq60o` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

ALTER TABLE `usuarios`
  ADD CONSTRAINT `FKfqxatq70rbej6n6gvhtgqjr7h` FOREIGN KEY (`id`) REFERENCES `tipo_documento` (`id`),
  ADD CONSTRAINT `fk_TipoDocumento` FOREIGN KEY (`tipo_documento`) REFERENCES `tipo_documento` (`id`);
COMMIT;
