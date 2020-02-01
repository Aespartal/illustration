-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-02-2020 a las 19:48:55
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
-- Estructura de tabla para la tabla `achievement`
--

CREATE TABLE `achievement` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album`
--

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `title` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `date` date NOT NULL,
  `is_private` tinyint(1) NOT NULL,
  `user_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` int(45) NOT NULL,
  `description` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
  `user_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  `body` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `date` date DEFAULT NULL,
  `is_reported` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `follower`
--

CREATE TABLE `follower` (
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `is_acepted` tinyint(4) DEFAULT NULL
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
  `date` date DEFAULT NULL,
  `tags` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `is_private` tinyint(1) DEFAULT NULL,
  `is_reported` tinyint(1) DEFAULT NULL,
  `album_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_has_achievement`
--

CREATE TABLE `user_has_achievement` (
  `user_id` int(11) NOT NULL,
  `achiev_id` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_Id` (`user_Id`);

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`user_id`,`image_id`),
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
  ADD KEY `category_id` (`category_id`),
  ADD KEY `album_id` (`album_id`);

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
-- Indices de la tabla `user_has_achievement`
--
ALTER TABLE `user_has_achievement`
  ADD PRIMARY KEY (`user_id`,`achiev_id`),
  ADD KEY `achiev_id` (`achiev_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `album`
--
ALTER TABLE `album`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

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
  ADD CONSTRAINT `image_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `image_ibfk_2` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`);

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
  ADD CONSTRAINT `fk_Usuario_Role1` FOREIGN KEY (`Role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `user_has_achievement`
--
ALTER TABLE `user_has_achievement`
  ADD CONSTRAINT `achiev_id` FOREIGN KEY (`achiev_id`) REFERENCES `achievement` (`id`),
  ADD CONSTRAINT `user_has_achiev1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
