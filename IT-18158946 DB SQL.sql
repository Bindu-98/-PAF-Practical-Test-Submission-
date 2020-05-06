-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 06:51 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `paymendetails`
--

CREATE TABLE `paymendetails` (
  `P_ID` varchar(5) NOT NULL,
  `Paient_id` int(11) NOT NULL,
  `P_amount` int(11) NOT NULL,
  `P_method` varchar(20) NOT NULL,
  `P_Description` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paymendetails`
--

INSERT INTO `paymendetails` (`P_ID`, `Paient_id`, `P_amount`, `P_method`, `P_Description`) VALUES
('p0002', 2, 10000, 'Amex', 'non refundable'),
('p0003', 1, 10000, 'Cash', 'non refundable');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `paymendetails`
--
ALTER TABLE `paymendetails`
  ADD PRIMARY KEY (`P_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
