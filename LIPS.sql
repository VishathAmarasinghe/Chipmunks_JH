-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 22, 2023 at 06:55 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LIPS`
--

-- --------------------------------------------------------

--
-- Table structure for table `Author`
--

CREATE TABLE `Author` (
  `Author_ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Book`
--

CREATE TABLE `Book` (
  `ISBN` int(20) NOT NULL,
  `TItle` varchar(50) NOT NULL,
  `CatID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Book_Author`
--

CREATE TABLE `Book_Author` (
  `ISBN` int(20) NOT NULL,
  `Author_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Book_copy`
--

CREATE TABLE `Book_copy` (
  `Copy_Number` int(11) NOT NULL,
  `ISBN` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Book_rental`
--

CREATE TABLE `Book_rental` (
  `RentalNumber` int(11) NOT NULL,
  `LendingDate` date NOT NULL,
  `ReturnDate` date NOT NULL,
  `Copy_Number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `CatID` int(11) NOT NULL,
  `CatName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Author`
--
ALTER TABLE `Author`
  ADD PRIMARY KEY (`Author_ID`);

--
-- Indexes for table `Book`
--
ALTER TABLE `Book`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `CatID` (`CatID`);

--
-- Indexes for table `Book_Author`
--
ALTER TABLE `Book_Author`
  ADD PRIMARY KEY (`ISBN`,`Author_ID`),
  ADD KEY `Author_ID` (`Author_ID`);

--
-- Indexes for table `Book_copy`
--
ALTER TABLE `Book_copy`
  ADD PRIMARY KEY (`Copy_Number`,`ISBN`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `Book_rental`
--
ALTER TABLE `Book_rental`
  ADD PRIMARY KEY (`RentalNumber`),
  ADD KEY `Copy_Number` (`Copy_Number`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`CatID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Author`
--
ALTER TABLE `Author`
  MODIFY `Author_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Book_rental`
--
ALTER TABLE `Book_rental`
  MODIFY `RentalNumber` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
  MODIFY `CatID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Book`
--
ALTER TABLE `Book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`CatID`) REFERENCES `Category` (`CatID`);

--
-- Constraints for table `Book_Author`
--
ALTER TABLE `Book_Author`
  ADD CONSTRAINT `book_author_ibfk_1` FOREIGN KEY (`ISBN`) REFERENCES `Book` (`ISBN`),
  ADD CONSTRAINT `book_author_ibfk_2` FOREIGN KEY (`Author_ID`) REFERENCES `Author` (`Author_ID`);

--
-- Constraints for table `Book_copy`
--
ALTER TABLE `Book_copy`
  ADD CONSTRAINT `book_copy_ibfk_1` FOREIGN KEY (`ISBN`) REFERENCES `Book` (`ISBN`);

--
-- Constraints for table `Book_rental`
--
ALTER TABLE `Book_rental`
  ADD CONSTRAINT `book_rental_ibfk_1` FOREIGN KEY (`Copy_Number`) REFERENCES `Book_copy` (`Copy_Number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
