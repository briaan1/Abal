CREATE DATABASE abal;
USE abal;

INSERT INTO categoria (nombre, descripcion)
VALUES ("pizza", "Todo tipo de pizzas"),
	   ("bebida", "Todo tipo de bebidas"),
       ("combo", "Combos de pizzas");

INSERT INTO producto (nombre, descripcion, imagen, precio, categoria_id)
VALUES  ("Faina", "Harina de garbanzos y aceite de oliva", "pizza_faina.jpg", 500.00, 1),
		("Papa Pizza", "Papas fritas y mozzarella", "pizza_papas.jpg", 650.00, 1),
		("Pizza Boom", "Huevo frito, salchicha y mozzarella", "pizza_huevo.jpeg", 700.00, 1),
		("Pizza Clasica", "Doble mozzarella y oregano a eleccion", "pizza_muzarela.jpg", 600.00, 1),
        ("Pizza Fugazzeta", "Cebolla blanca y mozzarella", "pizza_fugazeta.jpg", 600.00, 1),
		("Pizza JyM", "Jamon, morron y mozzarella", "pizza_jamon.jpg", 650.00, 1),
        ("Pizza Napolitana", "Tomate, albahaca y mozzarella", "pizza_napolitana.jpg", 600.00, 1),
        ("Pizza Peperoni", "Peperoni y mozzarella", "pizza_peperoni.jpg", 700.00, 1),
		("Pizza Popeye", "Espinaca, salsa blanca y mozzarella", "pizza_espinaca.jpg", 600.00, 1),
		("Pizza Vegana", "Queso vegano, champiÃ±ones y rucula", "pizza_vegana.jpg", 650.00, 1),
        ("Pizza Vegetariana", "Morron verde, cebolla morada, aceitunas negras y mozzarella", "pizza_vegetariana.jpg", 600.00, 1);

INSERT INTO producto (nombre, descripcion, imagen, precio, categoria_id)
VALUES  ("Coca Cola 500ml", "Bebida gasificada sabor Cola", "bebida_coca.jpg", 150.00, 2),
        ("Fanta 500ml", "Bebida gasificada sabor naranja", "bebida_naranja.jpg", 150.00, 2),
		("Glaciar 500ml", "Agua mineral bajo sodio", "bebida_agua.jpg", 150.00, 2),
		("Levite 500ml", "Bebida sin gas sabor a eleccion", "bebida_jugo.jpg", 150.00, 2),
        ("Sprite 500ml", "Bebida gasificada sabor lima limon", "bebida_lima.jpg", 150.00, 2),
		("Villavicencio 500ml", "Agua mineral con gas", "bebida_gas.jpg", 150.00, 2),
		("Combo 1", "Pizza Peperoni y especial con anana", "combo_uno.jpg", 1500.00, 3),
		("Combo 2", "Pizza Napolitana y especial con atun", "combo_dos.jpg", 1350.00, 3),
		("Combo 3", "Pizza Vegana y especial con tomate y peperoni", "combo_tres.jpg", 1250.00, 3);
        
INSERT INTO usuario (activo, email, nombre, password, rol, apellido, codPostal, domicilio, localidad, imagen )
VALUES (true, 'user@mail.com','Abal', '123456', 'usuario', 'Labarden', 1754, 'Arieta 2133', 'San Justo', "persona1.jpg");

INSERT INTO login (usuario_id)
VALUES (1);

INSERT INTO comentario(comentario, usuario_id,imagen, nombreUsuario)
VALUES ('Las mejores pizzas de la zona. Muy recomendadas.' ,1,"persona1.jpg", 'Juan Acosta'),
		('¡Excelente calidad!. Los recomiendo.' ,1,"persona2.jpg", 'Abal Labarden'),
		('Riquisimas :)' ,1,"persona3.png", 'Laura Perez');
