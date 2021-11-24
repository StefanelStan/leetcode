-- Employees Earning More Than Their Managers
-- https://leetcode.com/problems/employees-earning-more-than-their-managers/
SELECT e.Name as Employee from Employee e
INNER JOIN Employee x ON (e.ManagerId = x.Id AND e.Salary > x.Salary);

-- Department Highest Salary
-- https://leetcode.com/problems/department-highest-salary/
SELECT d.Name AS Department, e.Name AS Employee, Salary FROM Employee e
    INNER JOIN Department d ON (e.DepartmentId = d.Id AND e.Salary = (
        SELECT Max(salary) from Employee WHERE DepartmentId = d.Id
));
-- Duplicate Emails
-- https://leetcode.com/problems/duplicate-emails/
SELECT Email FROM Person
GROUP BY Email HAVING COUNT(*) > 1;

-- Combine Two Tables
-- https://leetcode.com/problems/combine-two-tables/
SELECT p.FirstName, p.LastName, a.City, a.State FROM Person p
LEFT JOIN Address a ON (p.PersonId = a.PersonId);

-- Rising Temperature
-- https://leetcode.com/problems/rising-temperature/
SELECT id from Weather w1 WHERE w1.temperature >
(SELECT w2.temperature FROM Weather w2 WHERE w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY));

-- Second Highest Salary
-- https://leetcode.com/problems/second-highest-salary/
SELECT Salary AS SecondHighestSalary FROM Employee
ORDER BY SALARY DESC
LIMIT 1 OFFSET 1;

OR

SELECT Salary AS SecondHighestSalary FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee)
ORDER BY SALARY DESC
LIMIT 1;

-- Customers Who Never Order
-- https://leetcode.com/problems/customers-who-never-order/
SELECT c.name as Customers from Customers c
WHERE c.id NOT IN (SELECT customerId FROM Orders);