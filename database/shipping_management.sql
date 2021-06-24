/* Remove Banco se ele existir */
DROP DATABASE IF EXISTS Shipping_Management;

/* Cria Banco de dados*/
CREATE DATABASE Shipping_Management;

/* Usa Banco correto */
USE Shipping_Management;

CREATE TABLE Shipping_Status(
   Id INT auto_increment primary key,
   Description_Type VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE Customer(
   Id INT auto_increment primary key, 
   Customer_Name VARCHAR(225) NOT NULL
) ENGINE = InnoDB;

/* Tabela principal com os Fretes */
CREATE TABLE Shipping(
   Id INT AUTO_INCREMENT PRIMARY KEY,
   Shipping_Description VARCHAR(255) NOT NULL,
   Date_Time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   Shipping_Status_Id INT NOT NULL,
   Customer_Id INT NOT NULL,
   Distance Float NOT NULL,
   FOREIGN KEY (Shipping_Status_Id) REFERENCES Shipping_Status(Id), 
   FOREIGN KEY (Customer_Id) REFERENCES Customer(Id)
) ENGINE=InnoDB;

/* Insere o Tipo de status Entregue*/
INSERT INTO Shipping_Status(Description_Type) VALUES ('Preparando');
INSERT INTO Shipping_Status(Description_Type) VALUES ('Saiu Para Entraga');
INSERT INTO Shipping_Status(Description_Type) VALUES ('Entregue');

/* Insere um cliente com o Nome Vinicius Oliveira*/
INSERT INTO Customer(Customer_Name) VALUES ('Vinicius');

/* Insere uma ocorrencia de entrega com Cliente e tipo da Ocorrencia */
INSERT INTO Shipping(Shipping_Description, Shipping_Status_Id, Customer_Id, Distance) VALUES ('Entrega na Casa Do Vinicius', 1, 1, 3.14 );

/* Mostra Tables */
SHOW TABLES;

/* Da um select em cada uma das tabelas */
SELECT * FROM Shipping;
SELECT * FROM Shipping_Status;
SELECT * FROM Customer;

/* Execute para pegar cada um dos Fretes das lista com os Valores Legiveis*/
SELECT Shipping.Shipping_Description,
       Shipping.Date_Time,
       (SELECT Shipping_Status.Description_Type FROM Shipping_Status WHERE Id = Shipping.Shipping_Status_Id) as `Status`,
       (SELECT Customer.Customer_Name FROM Customer WHERE Id = Shipping.Customer_Id) as Customer,
       Shipping.Distance
FROM Shipping;
