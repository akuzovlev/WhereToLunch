DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password,admin) VALUES
  ('User', 'user@yandex.ru', 'password',FALSE ),
  ('Admin', 'admin@gmail.com', 'admin',TRUE );

INSERT INTO restaurants (name) VALUES
  ('Cafe Pushkin'),
  ('Varenichnaya No 1'),
  ('Odessa-Mama');


INSERT INTO dishes (description, price, restaurant_id) VALUES
  ('Fresh melon fruit salad', 230, 1002),
  ('Zucchini light soup', 514, 1002),
  ('Asparagus frittata', 714, 1002),
  ('Baked apple', 104, 1002),
  ('Green tea', 060, 1002),

  ('salad', 130, 1003),
  ('soup', 214, 1003),
  ('frittata', 314, 1003),
  ('ice-cream', 204, 1003),
  ('tea', 160, 1003),

  ('Fish soup', 214, 1004),
  ('Meatballs with baked potato', 314, 1004),
  ('Kompot', 160, 1004);