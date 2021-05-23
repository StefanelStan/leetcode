create schema leetcode;
use leetcode;
DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    Salary INT NOT NULL,
    ManagerId INT
);

INSERT INTO Employee VALUES 
(1, 'Joe', 70000, 3),
(2, 'Henry', 80000, 4),
(3, 'Sam', 60000, NULL),
(4, 'Max', 90000, NULL);

SELECT * FROM Employee;

SELECT e.Name as Employee from Employee e
INNER JOIN Employee x ON (e.ManagerId = x.Id AND e.Salary > x.Salary);
























