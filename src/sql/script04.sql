DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Salary INT NOT NULL
);

INSERT INTO Employee(Salary) VALUES
(100), (200), (300);

SELECT * FROM Employee;

SELECT Salary AS SecondHighestSalary FROM Employee 
WHERE Salary < (SELECT MAX(Salary) FROM Employee)
ORDER BY SALARY DESC 
LIMIT 1;


SELECT Salary AS SecondHighestSalary FROM Employee 
ORDER BY SALARY DESC 
LIMIT 1 OFFSET 1;