-- 1) JOIN (기본/활용)
-- 주문-고객 매핑 : 주문 번호, 고객 이름, 주문 시각을 조회하세요. (orders ↔ customers JOIN)
SELECT order_id, name, ordered_at
FROM orders o JOIN customers c ON o.customer_id = c.customer_id;

-- 주문별 총액 : 주문별로 총 주문금액(qty*unit_price 합계)을 구하세요. (orders ↔ order_items)
SELECT o.order_id, SUM(qty*unit_price) AS 'total_order_price' 
FROM orders o JOIN order_items i ON o.order_id = i.order_id
GROUP BY order_id;

-- 고객별 실매출 : CANCELLED 제외 기준, 고객별 총 매출을 구하고 매출 내림차순 정렬하세요. (orders ↔ order_items ↔ customers)
SELECT o.customer_id, c.name, SUM(qty*unit_price) AS 'total_order_price'
FROM orders o JOIN order_items i ON o.order_id = i.order_id
JOIN customers c ON o.customer_id = c.customer_id
WHERE o.status <> 'CANCELLED'
GROUP BY o.customer_id;

-- 카테고리별 실매출 : CANCELLED 제외, 카테고리별 매출 합계를 구하세요. (order_items ↔ products, orders JOIN)
SELECT category, SUM(qty*unit_price) AS 'total_price'
FROM order_items i JOIN products p ON i.product_id = p.product_id
JOIN orders o ON i.order_id = o.order_id
WHERE p.product_id = i.product_id AND o.status <> 'CANCELLED'
GROUP BY category;

-- 2) 서브쿼리
-- 전체 평균 가격보다 비싼 상품을 조회하세요.
SELECT * FROM products
WHERE price >= (SELECT AVG(price) FROM products);

-- 주문 총액이 가장 큰 주문을 한 건만 출력하세요.
-- 서브쿼리 사용
SELECT order_id, SUM(qty*unit_price) AS 'total_price' FROM order_items
GROUP BY order_id
HAVING total_price = 
	(SELECT SUM(qty*unit_price) AS 't' FROM order_items GROUP BY order_id ORDER BY t DESC LIMIT 1);

-- 서브쿼리 미사용
SELECT o.order_id, SUM(qty*unit_price) AS 'total_order_price' 
FROM orders o JOIN order_items i ON o.order_id = i.order_id
GROUP BY order_id ORDER BY total_order_price DESC LIMIT 1;

-- 같은 도시 고객들의 평균 가입일보다 늦게 가입한 고객을 조회하세요 (상관 서브쿼리)
SELECT * FROM customers c1
WHERE joined_at < 
	(SELECT FROM_DAYS(FLOOR(AVG(TO_DAYS(joined_at)))) 
    FROM customers c2 WHERE c1.city=c2.city GROUP BY city);
    ;
-- 주문에 'Electronics' 카테고리 상품이 포함된 고객을 조회하세요 (EXIST 활용)
SELECT c.* FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN order_items i ON o.order_id = i.order_id 
WHERE EXISTS 
	(SELECT 1 FROM products p WHERE i.product_id = p.product_id AND category='Electronics');


-- 각 카테고리에서 가장 비싼 상품만 출력하세요. ( 카테고리별 MAX 비교 서브쿼리 )
SELECT * FROM products
WHERE price IN (SELECT MAX(price) FROM products GROUP BY category);

-- 3) 윈도우함수
-- 주문별 총액과 함께, 금액 기준 내림차순*RANK() 를 출력하세요.
SELECT o.order_id, SUM(qty*unit_price) AS 'total_order_price', 
RANK() OVER (ORDER BY SUM(qty*unit_price) DESC) AS 'RANKS'
FROM orders o JOIN order_items i ON o.order_id = i.order_id
GROUP BY order_id ORDER BY total_order_price DESC;

-- 고객별 주문 시각 기준 ROW_NUMBER()를 매겨 최근 2건만 표시하세요.
SELECT ROW_NUMBER() OVER (ORDER BY ordered_at DESC) AS 'recently_order_RANK', o.*
FROM orders o JOIN customers c ON o.customer_id = c.customer_id 
ORDER BY recently_order LIMIT 2;

-- 4) 종합문제
-- 각 상품의 카테고리(category)별로, 가장 매출이 큰 고객을 구하세요. 
-- ( CANCELLED 주문 제외, order + order_items + products + 서브쿼리 활용)
SELECT category, name, total_price
FROM (
	SELECT category, name, total_price, ROW_NUMBER() OVER (PARTITION BY category ORDER BY total_price DESC, customer_id ASC) AS 'ranks'
	FROM (
		SELECT c.customer_id, c.name, p.category, SUM(qty*price) AS 'total_price' 
        FROM customers c
			JOIN orders o ON c.customer_id = o.customer_id
			JOIN order_items i ON o.order_id = i.order_id
			JOIN products p ON i.product_id = p.product_id
		WHERE p.product_id = i.product_id AND o.status <> 'CANCELLED'
		GROUP BY c.customer_id, p.category
	) T
) R
WHERE ranks = 1;

