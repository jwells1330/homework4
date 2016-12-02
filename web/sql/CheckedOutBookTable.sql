/**
 * Author:  jwells8
 * Created: Dec 2, 2016
 */

USE appsbyjacobwells;
DROP TABLE IF EXISTS checkedOutBooks;

CREATE TABLE checkedOutBooks (
BookID INT NOT NULL AUTO_INCREMENT,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
Email VARCHAR(30) NOT NULL,
BookTitle VARCHAR(50) NOT NULL,
DueDate DATE,

PRIMARY KEY(BookID)
);