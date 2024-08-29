INSERT INTO tb_pizza(name, description, price, vegetarian, vegan, available) VALUES ("Peperoni", "Description Peperoni", 23.0, false, false, true);
INSERT INTO tb_pizza(name, description, price, vegetarian, vegan, available) VALUES ("Mexican", "Description Mexican", 30.0, false, false, true);
INSERT INTO tb_pizza(name, description, price, vegetarian, vegan, available) VALUES ("Vegetarian cheese", "Description Vegetarian Cheese", 15.0, true, false, true);
INSERT INTO tb_pizza(name, description, price, vegetarian, vegan, available) VALUES ("Vegan Margherita", "Description Vegan Margherita", 12.0, false, true, true);
INSERT INTO tb_pizza(name, description, price, vegetarian, vegan, available) VALUES ("Onion", "Description Onion", 5.0, false, false, false);
INSERT INTO tb_pizza(name, description, price, vegetarian, vegan, available) VALUES ("Mushroom", "Description Mushroom", 10.0, false, false, true);


INSERT INTO tb_customer(name, address, email, phone_number) VALUES ("Leo Messi", "Miami", "messi@gmail.com", "67567576567");
INSERT INTO tb_customer(name, address, email, phone_number) VALUES ("CR7", "Arabia", "cr7@gmail.com", "67567576567");
INSERT INTO tb_customer(name, address, email, phone_number) VALUES ("Neymar JR", "Arabia", "ney@gmail.com", "67567576567");
INSERT INTO tb_customer(name, address, email, phone_number) VALUES ("Kiliam Mbappe", "Madrid", "mbappe@gmail.com", "67567576567");
INSERT INTO tb_customer(name, address, email, phone_number) VALUES ("Lamin", "Yamal", "lamin@gmail.com", "67567576567");

INSERT INTO tb_order(total, method, additional_notes, id_customer) VALUES (33.0, "D", "I need fast the pizza", 1);
INSERT INTO tb_order(total, method, additional_notes, id_customer) VALUES (30.0, "H", "I need fast the pizza", 2);
INSERT INTO tb_order(total, method, additional_notes, id_customer) VALUES (15.0, "D", "I need fast the pizza", 3);
INSERT INTO tb_order(total, method, additional_notes, id_customer) VALUES (12, "D", "I need fast the pizza", 4);
INSERT INTO tb_order(total, method, additional_notes, id_customer) VALUES (5.0, "H", "I need fast the pizza", 5);

INSERT INTO tb_order_item(id_order, id_pizza, quantity, price) VALUES (1, 1, 1, 23.0);
INSERT INTO tb_order_item(id_order, id_pizza, quantity, price) VALUES (2, 2, 1, 30.0);
INSERT INTO tb_order_item(id_order, id_pizza, quantity, price) VALUES (3, 3, 1, 15.0);
INSERT INTO tb_order_item(id_order, id_pizza, quantity, price) VALUES (4, 4, 1, 12.0);
INSERT INTO tb_order_item(id_order, id_pizza, quantity, price) VALUES (5, 5, 1, 5.0);
INSERT INTO tb_order_item(id_order, id_pizza, quantity, price) VALUES (1, 6, 1, 10.0);

INSERT INTO users(username, password, email, locked, disabled) VALUES ("admin", "$2y$10$O7MUR/YifUPEy/zTW5h3s.bqQtqIPbA2WsbledIMGEAiQ.iLf5WQ2", "admin@gmail.com", false, false);
INSERT INTO users(username, password, email, locked, disabled) VALUES ("customer", "$2y$10$DmX2Jtf3Z4aXhvTwHpWqxeKTxa3LvJxrrRObqu4XD6dfc8sN38rvK", "customer@gmail.com", false, false);
INSERT INTO users(username, password, email, locked, disabled) VALUES ("ElPrimerChef", "$2y$10$4xtfgBs872kX7JUL7VCJ1e2YnMbhRx7u3Q9pNYBUY7QECygxDinXq", "chef@gmail.com", false, false);
INSERT INTO users(username, password, email, locked, disabled) VALUES ("cliente", "$2y$10$nKa55nGEMu7yb4sNClK9BOtMBjcgcMSjIjZ3/1oXum6ntZdn8om/m", "cliente@gmail.com", false, false);
INSERT INTO users(username, password, email, locked, disabled) VALUES ("messi", "$2y$10$o9aRGWM1VizFTaC.Az304uD5LNDZEu1Q9FkpSPW1vDWAT8VaFFM26", "messi@gmail.com", false, false);

INSERT INTO user_role(rol_name, user_id) VALUES ("ADMIN", 1);
INSERT INTO user_role(rol_name, user_id) VALUES ("CUSTOMER", 2);
INSERT INTO user_role(rol_name, user_id) VALUES ("CHEF", 3);
INSERT INTO user_role(rol_name, user_id) VALUES ("CUSTOMER", 4);
INSERT INTO user_role(rol_name, user_id) VALUES ("ADMIN", 5);