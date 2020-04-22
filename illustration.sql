-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2020 a las 16:53:51
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `illustration`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `description`) VALUES
(1, 'Animación'),
(2, 'Cómics'),
(3, 'Literatura'),
(4, 'Videojuegos'),
(5, 'Otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `body` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `Date` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comments`
--

INSERT INTO `comments` (`id`, `body`, `Date`, `user_id`, `image_id`) VALUES
(1, 'Vendo opel corsa', '2020-04-16 17:03:35', 8, 3),
(2, '¿Es foto o dibujo?', '2020-04-16 17:03:35', 3, 4),
(3, 'Increible!!', '2020-04-16 17:03:35', 9, 4),
(4, 'M encanta tu dibujo y está página en general', '2020-04-16 17:03:35', 2, 1),
(5, 'Mis dieses', '2020-04-16 17:03:35', 10, 9),
(6, 'Podrías dibujarme a mi???', '2020-04-16 17:03:36', 7, 5),
(7, 'Sigue así!!', '2020-04-16 17:03:36', 10, 7),
(8, 'Yo dibujo mejor', '2020-04-16 17:03:36', 7, 2),
(9, 'Increible!!', '2020-04-16 17:03:36', 7, 2),
(10, 'Un fenomeno', '2020-04-16 17:03:36', 2, 10),
(11, 'Me gusta mucho, sigue asi', '2020-04-16 17:35:54', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `follower`
--

CREATE TABLE `follower` (
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `title` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `tags` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `is_private` tinyint(1) DEFAULT NULL,
  `is_reported` tinyint(1) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `image`
--

INSERT INTO `image` (`id`, `image`, `title`, `description`, `date`, `tags`, `is_private`, `is_reported`, `category_id`, `user_id`) VALUES
(1, 'FINISH_mini_delgada_417936.jpg', 'Tomb raider', 'Empecé a hacer retratos en mi tiempo libre ', '2020-04-16 16:57:08', 'saladitos,acuarela', 0, 0, 5, 10),
(2, 'girl1_419811.jpg', 'Lost', 'Hola de nuevo practicando....\nComo estamos en febrero,  quise dibujar a esta chica... Nada más romántico', '2020-04-16 16:57:09', 'foto', 0, 0, 3, 8),
(3, 'pt2020_01_02_21_22_27_mh1577996576440_417180.jpg', 'Dibujo sin mirar', 'Dibujo acuarela sobre papel fabriano 22,9 cm X 30,5 cm', '2020-04-16 16:57:14', 'foto', 0, 0, 2, 6),
(4, 'PAG_31_COL_418634.jpg', 'Titanic', 'esto lo pinte hace mucho , pero quedo mal ...asi que le volvi a dar una pasada ..y bueno ..eso .\n\nasi que aqui lo comparto .\n\nsaludos a todos !', '2020-04-16 16:57:15', 'dibujo,3d,animacion', 0, 0, 1, 9),
(5, 'llllllll_419226.jpg', 'Dibujo sin mirar', 'Empecé a hacer retratos en mi tiempo libre ', '2020-04-16 16:57:15', 'juego', 0, 0, 5, 6),
(6, 'FINISH_mini_delgada_417936.jpg', 'La soledad', 'Primer Dibujo del año, Jill  del Resident Evil 3, espero que les guste, ah si, disculpen la tardanza, prometo que no volverá a pasar', '2020-04-16 16:57:15', 'saladitos,acuarela', 0, 0, 5, 8),
(7, 'JillSD_418077.jpg', 'Vinilo', 'Primer Dibujo del año, Jill  del Resident Evil 3, espero que les guste, ah si, disculpen la tardanza, prometo que no volverá a pasar', '2020-04-16 16:57:16', 'a mano,pintura', 0, 0, 2, 2),
(8, 'IlustracionDigital023_1__417268.jpg', 'Los caracoles', 'Empecé a hacer retratos en mi tiempo libre ', '2020-04-16 16:57:16', 'ciudad,personaje,cielo', 0, 0, 4, 8),
(9, '2A580BB7_5EEE_49D9_8D0B_4BD31C3B63CC_418225.jpeg', 'Lola', 'Hola de nuevo practicando....\nComo estamos en febrero,  quise dibujar a esta chica... Nada más romántico', '2020-04-16 16:57:16', 'juego', 0, 0, 2, 7),
(10, '20200114_418128.gif', 'Bostezo', 'esto lo pinte hace mucho , pero quedo mal ...asi que le volvi a dar una pasada ..y bueno ..eso .\n\nasi que aqui lo comparto .\n\nsaludos a todos !', '2020-04-16 16:57:16', 'dibujo,3d,animacion', 0, 0, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `like_image`
--

CREATE TABLE `like_image` (
  `user_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `message`
--

CREATE TABLE `message` (
  `to_id` int(11) NOT NULL,
  `from_id` int(11) NOT NULL,
  `body` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `description` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `description`) VALUES
(1, 'Administrador'),
(2, 'Artista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `surname1` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `surname2` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `username` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `is_private` tinyint(4) DEFAULT NULL,
  `description` varchar(240) COLLATE utf8_spanish_ci DEFAULT NULL,
  `date_register` date DEFAULT NULL,
  `img_profile` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `img_cover` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  `is_validate` tinyint(4) DEFAULT NULL,
  `is_banned` tinyint(4) DEFAULT NULL,
  `is_reported` tinyint(4) DEFAULT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `surname1`, `surname2`, `username`, `password`, `email`, `is_private`, `description`, `date_register`, `img_profile`, `img_cover`, `token`, `level`, `exp`, `is_validate`, `is_banned`, `is_reported`, `role_id`) VALUES
(1, 'Admin', NULL, NULL, 'Admin', '12345', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
(2, 'Alex', 'de la', 'Llobarro', 'alex25', '12345', 'dodell9675@illustration.com', 0, 'Todos tenemos un artista interior. ', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'at386dl33oj6oc2r8m82v31', NULL, NULL, 1, 0, 0, 2),
(3, 'Jaumet', 'de la', 'Cebes', 'jadece3365', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'jadece3365@illustration.com', 0, 'Vivimos es una sociedad.', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'qd530kb92pv7nn8k0v38t76', NULL, NULL, 1, 0, 0, 2),
(4, 'Jaumet', 'de la', 'Cargols', 'jadeca3074', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'jadeca3074@illustration.com', 0, 'Todos tenemos un artista interior. ', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'lw775kb05lr6mk2i7k71k79', NULL, NULL, 1, 0, 0, 2),
(5, 'Pepet', 'de Can', 'Llobarro', 'pedell4052', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'pedell4052@illustration.com', 0, 'Solo programo alarmas. ', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'ha884to69od2zx6i8l69a64', NULL, NULL, 1, 0, 0, 2),
(6, 'Pompeu', 'de la', 'Metge', 'podeme8636', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'podeme8636@illustration.com', 0, 'Abre tu mente y descubriras lo que disfruta la gente de la vida.', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'lv997uz87om8jw7f1g99q30', NULL, NULL, 1, 0, 0, 2),
(7, 'Pepet', 'de la', 'Metge', 'pedeme3076', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'pedeme3076@illustration.com', 0, ' ', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'ji360yz24zd5sd3u4u88w67', NULL, NULL, 1, 0, 0, 2),
(8, 'Miqueleta', 'de Cal', 'Palla', 'midepa9689', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'midepa9689@illustration.com', 0, ' ', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'mb939ez12uw4br8g2x99b86', NULL, NULL, 1, 0, 0, 2),
(9, 'Bernat', 'Pacoco', 'Trencapins', 'bepatr3953', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'bepatr3953@illustration.com', 0, 'Abre tu mente y descubriras lo que disfruta la gente de la vida.', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'ir066jw14df0vf9c8a81z08', NULL, NULL, 1, 0, 0, 2),
(10, 'Cirili', 'de les', 'Freda', 'cidefr2092', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'cidefr2092@illustration.com', 0, 'Abre tu mente y descubriras lo que disfruta la gente de la vida.', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'lg504lv99gl2nx2i9t96f79', NULL, NULL, 1, 0, 0, 2),
(11, 'Paco', 'Pacoco', 'Pacoco', 'papapa7943', '498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF', 'papapa7943@illustration.com', 0, 'Programo en vanila jaja salu2. ', '2020-04-16', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png', 'https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg', 'ja673jc08in6zl0c1s10s88', NULL, NULL, 1, 0, 0, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`) USING BTREE,
  ADD KEY `image_id` (`image_id`);

--
-- Indices de la tabla `follower`
--
ALTER TABLE `follower`
  ADD PRIMARY KEY (`user_id`,`friend_id`),
  ADD KEY `fk_Usuario_has_Usuario1` (`friend_id`);

--
-- Indices de la tabla `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `image_ibfk_1` (`category_id`),
  ADD KEY `image_user` (`user_id`);

--
-- Indices de la tabla `like_image`
--
ALTER TABLE `like_image`
  ADD PRIMARY KEY (`user_id`,`image_id`),
  ADD KEY `image_id` (`image_id`);

--
-- Indices de la tabla `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`to_id`,`from_id`),
  ADD KEY `fk_Usuario_has_Usuario3` (`from_id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Usuario_Role1` (`role_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `follower`
--
ALTER TABLE `follower`
  ADD CONSTRAINT `fk_Usuario_has_Usuario` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_has_Usuario1` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `image_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `image_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `like_image`
--
ALTER TABLE `like_image`
  ADD CONSTRAINT `like_image_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `like_image_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `fk_Usuario_has_Usuario2` FOREIGN KEY (`to_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_has_Usuario3` FOREIGN KEY (`from_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_Usuario_Role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
