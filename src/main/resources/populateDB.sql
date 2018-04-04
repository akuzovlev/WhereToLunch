DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO restaurants (name) VALUES
  ('Cafe Pushkin'),
  ('Varenichnaya No 1'),
  ('Odessa-Mama');


INSERT INTO dishes (description, price, restaurant_id) VALUES
  ('Fresh melon fruit salad', 2.30, 1002),
  ('Zucchini light soup', 5.14, 1002),
  ('Asparagus frittata', 7.14, 1002),
  ('Baked apple', 1.04, 1002),
  ('Green tea', 0.60, 1002),

  ('salad', 1.30, 1003),
  ('soup', 2.14, 1003),
  ('frittata', 3.14, 1003),
  ('ice-cream', 2.04, 1003),
  ('tea', 1.60, 1003),

  ('Fish soup', 2.14, 1004),
  ('Meatballs with baked potato', 3.14, 1004),
  ('Kompot', 1.60, 1004);