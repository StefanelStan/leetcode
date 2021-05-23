DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;

CREATE TABLE Department (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL
);

CREATE TABLE Employee (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    Salary INT NOT NULL,
    DepartmentId  INT NOT NULL,
    CONSTRAINT `fk-dept` FOREIGN KEY(DepartmentId) REFERENCES Department(Id)
);

INSERT INTO Department VALUES
(1, 'IT'),
(2, 'Sales');

INSERT INTO Employee VALUES
(1, 'Joe', 70000, 1),
(2, 'Jim', 90000, 1),
(3, 'Henry', 80000, 2),
(4, 'Sam', 60000, 2),
(5, 'Max', 90000, 1);

SELECT * FROM Department;
SELECT * FROM Employee;

SELECT d.Name AS Department, e.Name AS Employee, Salary FROM Employee e
INNER JOIN Department d ON (e.DepartmentId = d.Id AND e.Salary = (
	SELECT Max(salary) from Employee WHERE DepartmentId = d.Id
));




