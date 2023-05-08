-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2023 a las 16:48:10
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
-- Base de datos: `bar_cafeteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `descuento` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `descuento`) VALUES
(4, 5),
(5, 8),
(8, 0);

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
(1, 'interior', 2),
(2, 'interior', 4),
(3, 'interior', 6),
(4, 'interior', 8),
(5, 'interior', 10),
(6, 'exterior', 2),
(7, 'exterior', 4),
(8, 'exterior', 6),
(9, 'exterior', 8),
(10, 'exterior', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas_pedidos`
--

CREATE TABLE `mesas_pedidos` (
  `idMesaPedido` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `numMesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesas_pedidos`
--

INSERT INTO `mesas_pedidos` (`idMesaPedido`, `idPedido`, `numMesa`) VALUES
(1, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL,
  `idTrabajador` int(11) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `estadoPedido` varchar(20) NOT NULL DEFAULT 'En preparación',
  `fechaHoraPedido` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idPedido`, `idTrabajador`, `idCliente`, `estadoPedido`, `fechaHoraPedido`) VALUES
(1, 3, 4, 'En preparación', '2023-05-06 18:20:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(50) NOT NULL,
  `precioProducto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombreProducto`, `precioProducto`) VALUES
(2, 'Ensalada rural', 5),
(3, 'Revuelto de setas con gambas', 5),
(4, 'Espaguetis boloñesa', 5),
(5, 'Pimientos rellenos de bacalao', 8),
(6, 'Canelones', 8),
(7, 'Sepia a la plancha', 10),
(8, 'Croquetas de jamón', 10),
(9, 'Solomillos de pollo', 10),
(10, 'Calamares a la romana', 15),
(11, 'Gambon a la plancha', 15),
(12, 'Pastel de manzana', 5),
(13, 'Tarta de queso', 5),
(14, 'Tiramisú', 5),
(15, 'Créme brulée', 8),
(16, 'Tocino de cielo', 8);

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
(1, 1, 6, 2),
(2, 1, 14, 1),
(3, 1, 12, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `idReserva` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `numMesa` int(11) NOT NULL,
  `fechaHoraReserva` timestamp NOT NULL DEFAULT current_timestamp(),
  `estadoReserva` varchar(50) NOT NULL DEFAULT 'Confirmada'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `idTrabajador` int(11) NOT NULL,
  `salario` float NOT NULL DEFAULT 500.5,
  `NIF` varchar(9) NOT NULL DEFAULT '00000000X',
  `categoria` varchar(20) DEFAULT 'Camarero'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`idTrabajador`, `salario`, `NIF`, `categoria`) VALUES
(3, 1000, '78963254P', 'Administrador'),
(6, 500.5, '78563210M', 'Camarero'),
(7, 500.5, '02365474S', 'Camarero');

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
  `email` varchar(100) DEFAULT NULL,
  `tipoUsuario` varchar(20) DEFAULT 'cliente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `usuario`, `password`, `nombre`, `apellidos`, `telefono`, `email`, `tipoUsuario`) VALUES
(3, 'admin', '9jq3P9HuHIZhWYdRQPNt', 'Administrador', 'Bar Cafeteria', '789456123', 'administrador1@gmail.com', 'trabajador'),
(4, 'jogonlop', '50z6WU/EkGPTeuC/noC6', 'Josu', 'González López', '036985410', 'gonzalezlopezjosu@gmail.com', 'cliente'),
(5, 'EPC', '50z6WU/EkGPTeuC/noC6', 'Esmeralda', 'Parra Cano', '548632012', 'alalaepc@gmail.com', 'cliente'),
(6, 'afc123', 'uKCthaAZf0o2Zzm7k3CO', 'Alberto', 'Fernandez García', '125478951', 'afc123@gmail.com', 'trabajador'),
(7, 'apm123', '4DYSAjJdgWVe/J89QzR6', 'Andrea', 'Pérez Martínez', '478521368', 'apm123@gmail.com', 'trabajador'),
(8, 'mrh3', '/ZaZ9bW2q/c8MNXLCGH ', 'Martina', 'Rodríguez Hernádez', '145896254', 'mrh3@gmail.com', 'cliente');

--
-- Disparadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `insertarClienteOTrabajador` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
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
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`numMesa`);

--
-- Indices de la tabla `mesas_pedidos`
--
ALTER TABLE `mesas_pedidos`
  ADD PRIMARY KEY (`idMesaPedido`),
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `numMesa` (`numMesa`);

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
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `numMesa` (`numMesa`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD KEY `idTrabajador` (`idTrabajador`);

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
  MODIFY `numMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `mesas_pedidos`
--
ALTER TABLE `mesas_pedidos`
  MODIFY `idMesaPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  MODIFY `idPP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `mesas_pedidos`
--
ALTER TABLE `mesas_pedidos`
  ADD CONSTRAINT `mesas_pedidos_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`),
  ADD CONSTRAINT `mesas_pedidos_ibfk_2` FOREIGN KEY (`numMesa`) REFERENCES `mesas` (`numMesa`);

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
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`numMesa`) REFERENCES `mesas` (`numMesa`);

--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD CONSTRAINT `trabajadores_ibfk_1` FOREIGN KEY (`idTrabajador`) REFERENCES `usuarios` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
