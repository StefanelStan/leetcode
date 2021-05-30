DROP TABLE IF EXISTS Weather;
CREATE TABLE Weather(
	id INT PRIMARY KEY AUTO_INCREMENT,
    recordDate DATE NOT NULL UNIQUE,
    temperature INT NOT NULL
);

INSERT INTO Weather(recordDate, temperature) VALUES 
('2015-01-01', 10),
('2015-01-02', 25),
('2015-01-03', 20),
('2015-01-04', 30);

SELECT * FROM weather;

SELECT id from Weather w1 WHERE w1.temperature > 
(SELECT w2.temperature FROM Weather w2 WHERE w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY));








