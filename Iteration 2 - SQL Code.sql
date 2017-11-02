CREATE TABLE "Product" (
    `ProductID` INTEGER,
    `Name` TEXT,
    `Price` REAL,
    `Quantity` REAL,
    `TaxRate` NUMERIC,
    `ExpirationDate` BLOB,
    `Supplier` TEXT,
    `Unit` REAL
)
CREATE TABLE "Orders" (
    `OrderID` INTEGER,
    `PaymentType` TEXT,
    `Amount` REAL,
    `Date` TEXT,
    `StoreInfo` TEXT,
    PRIMARY KEY(`OrderID`)
)
CREATE TABLE "User" (
    `UserID` INTEGER NOT NULL,
    `UserName` TEXT NOT NULL,
    `Password` TEXT NOT NULL,
    `DisplayName` TEXT,
    `IsManager` INTEGER DEFAULT 0,
    PRIMARY KEY(`UserID`)
)

INSERT INTO Product values(11111, 'Rice', 10.69, 15.0, 0.2, '10/21/2018', 'Woo Ah Moy Trading Company', 20.0);
INSERT INTO Product values(11112, 'Noodles', 8.69, 20.0, 0.2, '10/21/2018', 'Woo Ah Moy Trading Company', 10.0);
INSERT INTO Product values(11113, 'Soy Sauce', 4.2, 45.0, 0.1, '1/13/2015', 'Woo Ah Moy Trading Company', 25.0);
INSERT INTO Product values(11114, 'Chopsticks', 0.69, 100.0, 0.5, 'nil', 'Auburn University', 5.0);
INSERT INTO Product values(11115, 'Prawn', 12.69, 18.0, 0.9, '4/20/2013', 'Woo Ah Moy Trading Company', 30.0);

INSERT INTO Orders values(22221, 'Debit', 69, '4/20/2017', 'Mr. Smith Goods');
INSERT INTO Orders values(22222, 'Credit', 17.38, '9/15/2017', 'Mr. Smith Goods');
INSERT INTO Orders values(22223, 'Cash', 4.2, '9/16/2017', 'Mr. Smith Goods');
INSERT INTO Orders values(22224, 'Credit', 35.69, '9/11/2017', 'Mr. Smith Goods');
INSERT INTO Orders values(22225, 'Cash', 3.5, '4/20/2017', 'Mr. Smith Goods');