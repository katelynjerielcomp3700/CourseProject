CREATE DATABASE StoreManagementSystem;

CREATE TABLE products (
	ProductName char(25),
	ProductID char(10),
	Quantity int,
	Price decimal,
	TaxRate decimal,
	ExpiryDate date,
	Supplier char(35),
	Unit decimal
);

CREATE TABLE orders (
	OrderID char(10),
	PaymentType char(20),
	TotalAmount decimal,
	OrderDate date,
	StoreInfo char(35)
);

INSERT INTO products
VALUES ('Rice', '11111', 15, 10.69, 0.20, '10/21/2018', 'Woo Ah Moy Trading Company', 20);
VALUES ('Noodles', '11112', 20, 8.69, 0.20, '10/21/2018', 'Woo Ah Moy Trading Company', 10);
VALUES ('Soy Sauce', '11113', 45, 4.20, 0.10, '1/13/2015', 'Panda Express', 25);
VALUES ('Chopsticks', '11114', 100, 0.69, 0.50, NULL, 'Auburn University', 5);
VALUES ('Prawn', '11115', 18, 12.69, 0.90, '4/20/2013', 'Woo Ah Moy Trading Company', 30);

INSERT INTO orders
VALUES ('22221', 'Debit', 69.00, '4/20/2017', 'Mr. Smith Goods');
VALUES ('22222', 'Credit', 17.38, '9/15/2017', 'Mr. Smith Goods');
VALUES ('22223', 'Cash', 4.20, '9/16/2017', 'Mr. Smith Goods');
VALUES ('22224', 'Credit', 35.69, '9/11/2017', 'Mr. Smith Goods');
VALUES ('22225', 'Cash', 3.50, '4/20/2017', 'Mr. Smith Goods'); 
