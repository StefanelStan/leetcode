-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

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

-- Delete Duplicate Emails
-- https://leetcode.com/problems/delete-duplicate-emails/
WITH minId AS (SELECT MIN(id) as id FROM Person GROUP BY email)
DELETE FROM Person WHERE id NOT IN ( SELECT id from minId);

-- Classes More Than 5 Students
-- https://leetcode.com/problems/classes-more-than-5-students/
SELECT class FROM Courses GROUP BY (class) HAVING count(*) > 4;

-- Customer Placing the Largest Number of Orders
-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
SELECT customer_number FROM Orders
GROUP BY customer_number ORDER BY count(customer_number) DESC LIMIT 1;

-- Game Play Analysis I
-- https://leetcode.com/problems/game-play-analysis-i/
SELECT player_id, MIN(event_date) AS first_login FROM Activity
GROUP BY player_id;

-- Recyclable and Low Fat Products
-- https://leetcode.com/problems/recyclable-and-low-fat-products/
SELECT product_id FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';

-- Bank Account Summary II
-- https://leetcode.com/problems/bank-account-summary-ii/
SELECT u.name AS name, SUM(amount) AS balance FROM Users u
JOIN Transactions t ON u.account = t.account
GROUP BY t.account HAVING balance > 10000;

-- Find Customer Referee
-- https://leetcode.com/problems/find-customer-referee/
SELECT name FROM Customer
WHERE referee_id IS NULL OR referee_id <> 2

-- Daily Leads and Partners
-- https://leetcode.com/problems/daily-leads-and-partners/
SELECT date_id, make_name,
       COUNT(DISTINCT lead_id) AS unique_leads,
       COUNT(DISTINCT partner_id) AS unique_partners
FROM DailySales ds
GROUP BY date_id, make_name;

-- Employees With Missing Information
-- https://leetcode.com/problems/employees-with-missing-information/
SELECT e.employee_id FROM Employees e LEFT JOIN Salaries s ON (e.employee_id = s.employee_id) WHERE s.salary IS NULL
UNION
SELECT s.employee_id FROM Employees e RIGHT JOIN Salaries s ON (e.employee_id = s.employee_id) WHERE e.name IS NULL
ORDER by employee_id;

-- Find Followers Count
-- https://leetcode.com/problems/find-followers-count/
SELECT user_id, COUNT(follower_id) AS followers_count FROM Followers
GROUP BY user_id ORDER BY user_id;