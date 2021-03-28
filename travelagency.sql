-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 28, 2021 at 05:32 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelagency`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `source` varchar(20) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `departflightcode` varchar(10) NOT NULL,
  `returnflightcode` varchar(10) NOT NULL,
  `fare` int(11) NOT NULL,
  `salutation` varchar(5) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `contact` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`source`, `destination`, `departflightcode`, `returnflightcode`, `fare`, `salutation`, `firstname`, `lastname`, `contact`) VALUES
('Kolkata', 'Mumbai', 'AI2002', 'AI2001', 10710, 'Mr.', '', '', ''),
('Mumbai', 'Delhi', 'JW1001', 'N/A', 4200, 'Mr.', 'ravi', 'sharma', '7863'),
('Banglore', 'Mumbai', 'ID3002', 'ID3001', 8505, 'Mr.', 'unknown', 'xgsh', '93839'),
('Mumbai', 'Banglore', 'ID3001', 'N/A', 4410, 'Mr.', 'xyz', 'prs', '1234'),
('Mumbai', 'Kolkata', 'AI2001', 'N/A', 5460, 'Mr.', 'gasb', 'bdhsbc', '873263');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `flightid` varchar(10) NOT NULL,
  `airline` varchar(10) NOT NULL,
  `source` varchar(20) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `departtime` varchar(10) NOT NULL,
  `arrivaltime` varchar(10) NOT NULL,
  `fare` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`flightid`, `airline`, `source`, `destination`, `departtime`, `arrivaltime`, `fare`) VALUES
('AI2001', 'Air India', 'Mumbai', 'Kolkata', '13.00', '16.00', 5200),
('AI2002', 'Air India', 'Kolkata', 'Mumbai', '17.00', '20.00', 5000),
('ID3001', 'Indigo', 'Mumbai', 'Banglore', '13.30', '16.00', 4200),
('ID3002', 'Indigo', 'Banglore', 'Mumbai', '17.30', '22.00', 3900),
('JW1001', 'Jet Airway', 'Mumbai', 'Delhi', '12.00', '14.00', 4000),
('JW1002', 'Jet Airway', 'Delhi', 'Mumbai', '15.00', '17.00', 4100);

-- --------------------------------------------------------

--
-- Table structure for table `hotelbookings`
--

CREATE TABLE `hotelbookings` (
  `contact` varchar(10) NOT NULL,
  `salutation` varchar(5) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `fare` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotelbookings`
--

INSERT INTO `hotelbookings` (`contact`, `salutation`, `firstname`, `lastname`, `fare`, `date`) VALUES
('3231', 'MR.', 'rvid', 'dsfje', '3674.9998', '3');

-- --------------------------------------------------------

--
-- Table structure for table `new`
--

CREATE TABLE `new` (
  `name` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flightid`);

--
-- Indexes for table `hotelbookings`
--
ALTER TABLE `hotelbookings`
  ADD PRIMARY KEY (`contact`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
