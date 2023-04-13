-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-03-2023 a las 11:40:56
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `descuento` float DEFAULT 0.1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `descuento`) VALUES
(2, 5),
(3, 0.5),
(6, 0),
(12, 0.7),
(101, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

CREATE TABLE `mesas` (
  `numMesa` int(11) NOT NULL,
  `localizacion` varchar(8) NOT NULL,
  `PAX` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesas`
--

INSERT INTO `mesas` (`numMesa`, `localizacion`, `PAX`) VALUES
(1, 'interior', 6),
(2, 'interior', 6),
(3, 'interior', 5),
(4, 'interior', 20),
(5, 'interior', 8),
(6, 'exterior', 10),
(7, 'exterior', 16),
(8, 'interior', 6),
(9, 'interior', 15),
(10, 'exterior', 15),
(11, 'exterior', 15),
(12, 'exterior', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL,
  `idTrabajador` int(11) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `fechaHoraPedido` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idPedido`, `idTrabajador`, `idCliente`, `estado`, `fechaHoraPedido`) VALUES
(1, 5, 2, 'En preparacion', '2023-03-08 16:41:35'),
(2, 1, 2, 'En preparacion', '2023-03-25 09:00:00'),
(5, 1, 2, 'En preparacion', '2023-01-10 12:00:00'),
(6, 1, 3, 'En preparacion', '2023-03-17 16:41:00'),
(7, 1, 3, 'Listo', '2023-03-08 16:41:35'),
(8, 5, 3, 'En preparacion', '2023-03-08 16:41:35'),
(9, 5, 3, 'En preparacion', '2023-01-08 01:30:00'),
(13, 5, 12, 'En preparacion', '2024-02-23 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(20) NOT NULL,
  `precioProducto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombreProducto`, `precioProducto`) VALUES
(1, 'Menu Infantil', 13.5),
(2, 'Entrantes', 25.64),
(3, 'Sopa de marisco', 13.5),
(4, 'Ensalada de gulas', 13.7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_pedidos`
--

CREATE TABLE `productos_pedidos` (
  `idPP` int(11) NOT NULL,
  `idPedido` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `cantidadProducto` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos_pedidos`
--

INSERT INTO `productos_pedidos` (`idPP`, `idPedido`, `idProducto`, `cantidadProducto`) VALUES
(1, 5, 3, 2),
(2, 6, 2, 2),
(3, 1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `idReserva` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `numMesa` int(11) NOT NULL,
  `fechaHoraReserva` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`idReserva`, `idCliente`, `numMesa`, `fechaHoraReserva`) VALUES
(1, 3, 1, '2023-03-08 15:30:00'),
(2, 12, 1, '2023-04-14 11:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `idTrabajador` int(11) NOT NULL,
  `salario` float NOT NULL DEFAULT 300.58,
  `NIF` varchar(9) DEFAULT NULL,
  `categoria` varchar(20) DEFAULT 'Camarero'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`idTrabajador`, `salario`, `NIF`, `categoria`) VALUES
(1, 200, '25986325L', 'Administrador'),
(5, 1080.56, '25748512K', 'Camarero'),
(11, 300.55, '25784132L', 'Cocinero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `tipoUsuario` varchar(20) DEFAULT 'cliente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `usuario`, `password`, `nombre`, `apellidos`, `telefono`, `tipoUsuario`) VALUES
(1, 'admin', 'admin', 'Administrador', '', '965841223', 'trabajador'),
(2, 'love64', '123456', 'Amor', 'Fernandez Garcia', '652000111', 'cliente'),
(3, 'josu12', '14022003', 'Josu', 'Gonzalez Lopez', '651584102', 'cliente'),
(5, 'ruli58', '1234', 'Roberto', 'Lituania Marruecos', '412586985', 'trabajador'),
(6, 'jUjunctr', '04122018', 'Julieta', 'Aguilar López', '258693147', 'cliente'),
(11, 'cocinero1', 'cocinero1', 'Cocinero', '', '145278963', 'trabajador'),
(12, 'leo34', '123456789', 'Leo', 'Hola Prueba', '158963258', 'cliente'),
(101, 'hoad', '1245', 'Hola', 'Adios', '874152698', 'cliente');

--
-- Disparadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `insertarCliente` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
    IF new.tipoUsuario LIKE 'cliente' THEN
    	INSERT INTO clientes VALUES (new.idUsuario,0.0);
    ELSEIF NEW.tipoUsuario LIKE 'trabajador' THEN  
    	INSERT INTO trabajadores(idTrabajador) VALUES (new.idUsuario);
    END IF;    
END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`numMesa`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idTrabajador` (`idTrabajador`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD PRIMARY KEY (`idPP`),
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `numMesa` (`numMesa`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`idTrabajador`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `mesas`
--
ALTER TABLE `mesas`
  MODIFY `numMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  MODIFY `idPP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajadores` (`idTrabajador`),
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`);

--
-- Filtros para la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD CONSTRAINT `productos_pedidos_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`),
  ADD CONSTRAINT `productos_pedidos_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`numMesa`) REFERENCES `mesas` (`numMesa`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`);

--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD CONSTRAINT `trabajadores_ibfk_1` FOREIGN KEY (`idTrabajador`) REFERENCES `usuarios` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
