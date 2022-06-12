CREATE DATABASE abal;
USE abal;

INSERT INTO categoria (nombre, descripcion)
VALUES ("pizza", "Pizza de espinaca con salsa blanca"),
		("pizza", "Pizza con cebolla"),
        ("pizza", "Pizza con jamon y morron");

INSERT INTO producto (nombre, descripcion, imagen, precio, categoria_id)
VALUES ("Pizza", "La mejor pizza de ", "pizza_espinaca.jpg", 500.0, 1),
		("Pizza", "La mejor pizza de ", "pizza_fugazeta.jpg", 500.0, 2),
        ("Pizza", "La mejor pizza de ", "pizza_jamon.jpg", 500.0, 3);


-- select * from producto;