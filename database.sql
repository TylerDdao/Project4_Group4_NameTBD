create database project4;

CREATE TABLE Accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fName VARCHAR(100),
    lName VARCHAR(100),
    email VARCHAR(100),
    password varchar(100)
);

Create table Plants(
	id INT auto_increment primary key,
    name varchar(100),
    price float,
    quantity int
);

Create table Orders(
	id INT auto_increment primary key,
    aID int,
    totalPrice float,
    status varchar(100),
    foreign key(aID) references accounts(id)
);

Create table Order_items(
	oId int,
	pId int,
    quantity int,
    foreign key (oId) references Orders(id),
    foreign key (pId) references Plants(id)
);