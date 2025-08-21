CREATE TABLE custom(
	custom_name varchar(10),
    total_purchase decimal(10, 2)
);

INSERT INTO test.custom (custom_name, total_purchase) 
	VALUES ('A',12000), ('B', 8000), ('C', 4500), ('D', 6000), ('E', 15000);
    
-- CASE 조건분기
SELECT custom_name,
	CASE 
		WHEN total_purchase > 10000 THEN 'VVIP'
        WHEN total_purchase > 5000 THEN 'VIP'
		ELSE 'REGULAR'
	END AS membership_status, total_purchase
FROM custom;

-- IF 조건분기
SELECT custom_name,
	IF(total_purchase>10000,'RICH','NORMAL') AS pay, total_purchase
FROM custom;


SELECT * FROM test.employees;

CREATE TABLE `test`.`departments` (
  `department_idx` INT NOT NULL AUTO_INCREMENT,
  `department_name` VARCHAR(45) NULL,
  PRIMARY KEY (`department_idx`));

INSERT INTO `test`.`departments` (`department_name`) VALUES ('인사');
INSERT INTO `test`.`departments` (`department_name`) VALUES ('구매');
INSERT INTO `test`.`departments` (`department_name`) VALUES ('개발');
INSERT INTO `test`.`departments` (`department_name`) VALUES ('영업');

-- INNER JOIN의 INNER는 생략가능.
SELECT e.name, d.department_name FROM test.employees e
JOIN test.departments d ON e.DEPARTMENT_IDX = d.department_idx;

UPDATE test.employees SET DEPARTMENT_IDX = null WHERE employee_idx in(2,4,6);

-- LEFT OUTER JOIN
SELECT e.NAME, d.department_name FROM employees e
LEFT OUTER JOIN departments d ON e.DEPARTMENT_IDX = d.department_idx;

-- RIGHT JOIN
SELECT e.name, department_name FROM employees e
RIGHT JOIN departments d ON e.employee_idx = d.manager_employee_idx;

-- FULL OUTER JOIN (MYSQL 에선 지원안함. UNION을 사용해 똑같이 구현)
SELECT e.NAME, d.department_name FROM employees e
LEFT JOIN departments d ON e.DEPARTMENT_IDX = d.department_idx
UNION
SELECT e.NAME, d.department_name FROM employees e
RIGHT JOIN departments d ON e.employee_idx = d.manager_employee_idx;

-- CROSS JOIN
SELECT e.NAME, d.department_name FROM employees e
CROSS JOIN departments d;

-- SELF JOIN ( INNER 생략 )
SELECT e1.NAME AS employee_name, e2.NAME AS manager_name FROM employees e1
JOIN employees e2 ON e1.manager_idx= e2.employee_idx ;

-- TRIPLE JOIN (전부 LEFT JOIN을 할 경우, e1의 데이터는 다 나옴)
SELECT e1.NAME AS employee_name, e2.NAME AS manager_name, d.department_name FROM employees e1
LEFT JOIN employees e2 ON e1.manager_idx= e2.employee_idx
JOIN departments d ON e1.DEPARTMENT_IDX = d.department_idx;

-- JOIN 테이블의 WHERE 절
SELECT e.NAME, d.department_name FROM employees e
LEFT JOIN departments d ON e.DEPARTMENT_IDX = d.department_idx
WHERE d.department_name = '영업';

SELECT e.NAME, d.department_name, SALARY FROM employees e
LEFT JOIN departments d ON e.DEPARTMENT_IDX = d.department_idx
WHERE SALARY >= 7080;

SELECT e.NAME, d.department_name, SALARY FROM employees e
LEFT JOIN departments d ON e.DEPARTMENT_IDX = d.department_idx
WHERE SALARY >= 7080 AND (d.department_name IS NULL OR d.department_name <> '영업');

CREATE TABLE `test`.`shipping_reates` (
  `rate_idx` INT NOT NULL AUTO_INCREMENT,
  `min` DECIMAL(10,2) NULL,
  `max` DECIMAL(10,2) NULL,
  `fee` DECIMAL(10,2) NULL,
  PRIMARY KEY (`rate_idx`));

-- NON EQUI JOIN (비등가 조인) 중복포함
SELECT custom_name, total_purchase, fee FROM custom c
JOIN shipping_rates s ON c.total_purchase BETWEEN s.min and s.max;

-- 서브쿼리 (복잡한 로직인 경우 서브쿼리 먼저 작성) SELECT, WHERE, FROM, HAVING 다 사용 가능
SELECT NAME, SALARY FROM employees
WHERE DEPARTMENT_IDX = (SELECT department_idx FROM departments WHERE department_name = '인사');

SELECT NAME, SALARY FROM employees
WHERE DEPARTMENT_IDX IN (SELECT department_idx FROM departments WHERE location = '부산');

SELECT NAME, DEPARTMENT_IDX, hire_date FROM employees WHERE (DEPARTMENT_IDX, hire_date) 
IN (SELECT DEPARTMENT_IDX, hire_date FROM employees WHERE SALARY > 6000);

SELECT DEPARTMENT_IDX, AVG_SALARY
FROM 
(SELECT DEPARTMENT_IDX, AVG(SALARY) AS AVG_SALARY FROM employees
GROUP BY DEPARTMENT_IDX) S
WHERE AVG_SALARY > 7000;

SELECT DEPARTMENT_IDX, SUM(SALARY) AS TOTAL_SALARY FROM employees
GROUP BY DEPARTMENT_IDX
HAVING SUM(SALARY) > (SELECT SUM(SALARY) FROM employees WHERE DEPARTMENT_IDX=4);

SELECT NAME, DEPARTMENT_IDX, SALARY FROM employees e1
WHERE SALARY > (SELECT AVG(SALARY) FROM employees e2 WHERE e1.DEPARTMENT_IDX = e2.DEPARTMENT_IDX);


-- SQL 집합연산 ( UNION, UNION ALL, INTERSECT, EXCEPT(MINUS) )
-- 집합연산 시 "열 수와 데이터 타입 일치" 해야함. 정렬의 경우 모든 집합연산이 끝난 뒤 ORDER BY 사용 가능. 중간 중간쿼리에 사용 불가능.
-- UNITON 두개 쿼리결과를 합치는데 중복 행 제거
SELECT NAME, MANAGER_IDX FROM employees
UNION
SELECT NAME, DEPARTMENT_IDX FROM employees;

-- UNION ALL 모든 쿼리 합치고 중복값 제거를 하지않음.
SELECT NAME, MANAGER_IDX FROM employees
UNION ALL
SELECT NAME, DEPARTMENT_IDX FROM employees;

-- INTERSECT 교집합. 공통된 행만 반환 * MYSQL 미지원. INNER JOIN 써야함

-- EXCEPT * MYSQL 미지원, LEFT JOIN 혹은 NOT EXISTS 대체해서 사용
SELECT custom_name FROM custom
WHERE NOT EXISTS (SELECT 1 FROM VIP WHERE custom.custom_name = VIP.NAME);


-- 윈도우 함수 ( GROUP BY 는 데이터를 그룹으로 묶어 개별 행 정보가 사라짐. )
-- 윈도우는 각 행의 결과를 유지하며 그룹단위의 결과를 계산 가능
SELECT DEPARTMENT_IDX, SUM(SALARY) FROM employees GROUP BY DEPARTMENT_IDX;

SELECT NAME, DEPARTMENT_IDX, SUM(SALARY) OVER(PARTITION BY DEPARTMENT_IDX) AS DEPARTMENT_TOTAL_SALARY FROM employees;

-- 순위 함수 (RANK, ROW_NUMBER)
-- RANK 값이 동일한 경우, 순위 부여(중복 존재) 1, 1 인경우 다음은 3임
-- ROW_NUMBER 고유넘버 부여 (중복 없음)
SELECT ROW_NUMBER() OVER (ORDER BY name) AS employee_num,
name, salary, RANK() OVER (ORDER BY salary DESC) AS salary_rank
FROM employees
ORDER BY employee_num;

-- LAG, LEAD 함수
-- LAG(값, n행) 이전 행 값
-- LEAD(값, n행) 다음 행 값
SELECT name, price,
LAG(price, 1) OVER (ORDER BY price) AS previous_p,
LEAD(price, 2) OVER (ORDER BY price) AS next_us
FROM products