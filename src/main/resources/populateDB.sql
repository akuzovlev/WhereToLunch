DELETE FROM users;
DELETE FROM dishes;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO dishes (description, price, restaurantName) VALUES
  ('Fresh melon fruit salad', 2.30, 'Cafe Pushkin'),
  ('Zucchini light soup', 5.14, 'Cafe Pushkin'),
  ('Asparagus frittata', 7.14, 'Cafe Pushkin'),
  ('Baked apple', 1.04, 'Cafe Pushkin'),
  ('Green tea', 0.60, 'Cafe Pushkin'),

  ('salad', 1.30, 'Varenichnaya No 1'),
  ('soup', 2.14, 'Varenichnaya No 1'),
  ('frittata', 3.14, 'Varenichnaya No 1'),
  ('ice-cream', 2.04, 'Varenichnaya No 1'),
  ('tea', 1.60, 'Varenichnaya No 1'),

  ('Fish soup', 2.14, 'Odessa-Mama'),
  ('Meatballs with baked potato', 3.14, 'Odessa-Mama'),
  ('Kompot', 1.60, 'Odessa-Mama');