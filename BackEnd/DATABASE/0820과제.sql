/* 초기 제공 코드
CREATE TABLE customers (
  customer_id SERIAL PRIMARY KEY,
  name        VARCHAR(50) NOT NULL,
  email       VARCHAR(100) UNIQUE NOT NULL,
  city        VARCHAR(50),
  joined_at   DATE NOT NULL
);

CREATE TABLE products (
  product_id  SERIAL PRIMARY KEY,
  name        VARCHAR(50) NOT NULL,
  category    VARCHAR(50) NOT NULL,
  price       NUMERIC(10,2) NOT NULL CHECK (price >= 0)
);

CREATE TABLE orders (
  order_id    SERIAL PRIMARY KEY,
  customer_id INT NOT NULL REFERENCES customers(customer_id),
  ordered_at  TIMESTAMP NOT NULL,
  status      VARCHAR(20) NOT NULL CHECK (status IN ('PAID','CANCELLED','SHIPPED'))
);

CREATE TABLE order_items (
  order_item_id SERIAL PRIMARY KEY,
  order_id   INT NOT NULL REFERENCES orders(order_id) ON DELETE CASCADE,
  product_id INT NOT NULL REFERENCES products(product_id),
  qty        INT NOT NULL CHECK (qty > 0),
  unit_price NUMERIC(10,2) NOT NULL CHECK (unit_price >= 0)
);

-- 샘플 데이터
INSERT INTO customers (name,email,city,joined_at) VALUES
('Kim','kim@example.com','Seoul','2025-07-01'),
('Lee','lee@example.com','Busan','2025-07-10'),
('Park','park@example.com','Seoul','2025-08-01'),
('Choi','choi@example.com','Incheon','2025-08-05');

INSERT INTO products (name,category,price) VALUES
('Keyboard','Electronics', 45000),
('Mouse','Electronics', 25000),
('Monitor 27"','Electronics', 290000),
('Mug','Lifestyle', 9000),
('Notebook','Stationery', 3000),
('Pen','Stationery', 1000);

INSERT INTO orders (customer_id, ordered_at, status) VALUES
(1,'2025-08-10 10:00','PAID'),
(1,'2025-08-11 09:30','CANCELLED'),
(2,'2025-08-12 14:00','SHIPPED'),
(3,'2025-08-12 18:20','PAID');

INSERT INTO order_items (order_id, product_id, qty, unit_price) VALUES
(1, 1, 1, 45000),    -- Keyboard
(1, 2, 2, 24000),    -- Mouse (할인 가정)
(1, 4, 1, 9000),     -- Mug
(2, 3, 1, 290000),   -- Monitor (주문 취소건)
(3, 2, 1, 25000),    -- Mouse
(3, 6, 5, 1000),     -- Pen
(4, 1, 1, 45000),    -- Keyboard
(4, 5, 3, 2800);     -- Notebook (할인 가정)
*/

-- 1) SELECT / WHERE / ORDER BY / LIMIT
-- customers에서 이메일이 @example.com으로 끝나는 고객의 name, email을 이름 오른차순으로 조회하세요.
SELECT name, email FROM customers WHERE email like "%@example.com" ORDER BY name ASC; 

-- products에서 category가 Electronics 또는 Lifestyle인 상품을 이름 내림차순으로 조회하세요.
SELECT * FROM products WHERE category = "Electronics" OR category = "Lifestyle" ORDER BY name DESC;

-- products에서 가장 비싼 상품 3개의 name, price를 조회하세요.
SELECT name, price FROM products ORDER BY price DESC LIMIT 3;

-- customers 에서 city가 NULL이 아닌 고객의 도시 목록(중복 제거)를 조회하세요.
SELECT DISTINCT(CITY) FROM customers WHERE CITY IS NOT NULL;


-- 2) 집계 / GROUP BY / HAVING
-- orders에서 상태별 주문 수(status, cnt)를 조회하세요.
SELECT status, COUNT(*) AS cnt FROM orders GROUP BY status;

-- order_items에서 주문별 라인수(한 주문에 들어있는 항목 수)를 조회하세요.
SELECT order_id, COUNT(product_id) AS total_product_line FROM order_items GROUP BY order_id;

-- order_items에서 주문별 총수량(sum(qty))이 5 이상인 주문만 조회하세요.
SELECT order_id FROM order_items GROUP BY order_id HAVING SUM(qty) >= 5;

-- products에서 카테고리별 평균 가격을 반올림하여 조회하세요
SELECT category, ROUND(AVG(price), 2) AS AVG_price FROM products GROUP BY category;

-- 3) DML (INSERT / UPDATE / DELETE)
-- products에 새 상품을 추가하세요.
INSERT INTO test.products VALUES(NULL,'Apple','fruit',5000); -- 0이나 NULL을 넣어도 AUTO_INCREMENT로 숫자는 자동으로 들어감
INSERT INTO test.products (name, category, price) VALUES ('Orange','fruit',8000);

-- customers에서 Busan 거주 고객의 city를 Busan_si로 수정하세요.
UPDATE customers SET city = "Busan_si" WHERE city="Busan";

-- orders 에서 1년 이전의 CANCELLED 주문을 삭제하세요..
-- 기준 1) 현재 년도가 아닌 모든 데이터 삭제
DELETE FROM orders WHERE status='CANCELLED' AND YEAR(ordered_at) <> YEAR(NOW());
-- 기준 2) 1년 이상 지난 모든 데이터 삭제
DELETE FROM orders WHERE status='CANCELLED' AND  DATEDIFF(NOW(), ordered_at) >= 365;
DELETE FROM orders WHERE status='CANCELLED' AND  TIMESTAMPDIFF(DAY, ordered_at, NOW()) >= 365;
DELETE FROM orders WHERE status='CANCELLED' AND  ordered_at NOT BETWEEN DATE_SUB(NOW(), INTERVAL 1 YEAR) AND NOW();
-- 기준 3) 작년의 모든 데이터 삭제
DELETE FROM orders WHERE status='CANCELLED' AND  YEAR(ordered_at) = (YEAR(NOW())-1);

-- order_items에서 qty=0인 행 들을 삭제하세요.
DELETE FROM order_items WHERE qty=0;


-- 4) 계산식 / 표현식 / CASE
-- products에서 price에 10% 할인한 할인가(sale_price)를 함께 조회하세요.
SELECT *, ROUND((price*0.9), 2) AS sale_price FROM products;

-- orders에서 상태를 한글로 치환(PAID-결제완료, SHIPPED-배송중, CANCELLED-취소) 하여 조회하세요.
SELECT order_id, customer_id, ordered_at,
	CASE status
		WHEN "PAID" THEN '결제완료'
        WHEN "SHIPPED" THEN '배송중'
        ELSE '취소' 
	END AS KOR_status FROM orders;

-- order_itmes에서 qty * unit_price 를 line_amount로 계산하여 조회하세요.
SELECT order_item_id, order_id, product_id, qty*unit_price AS line_amount FROM order_items;