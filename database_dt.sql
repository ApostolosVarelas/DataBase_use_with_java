-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220530.a2456aa9a3
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 06 Ιουν 2022 στις 16:15:22
-- Έκδοση διακομιστή: 10.4.24-MariaDB
-- Έκδοση PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `database_dt`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `accessories`
--

CREATE TABLE `accessories` (
  `CODE` varchar(5) NOT NULL,
  `STORAGE_BIN_CODE` int(11) NOT NULL,
  `ASSEMBLED_CODE` int(11) NOT NULL,
  `PECEIPT_BATCH_CODE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `accessories`
--

INSERT INTO `accessories` (`CODE`, `STORAGE_BIN_CODE`, `ASSEMBLED_CODE`, `PECEIPT_BATCH_CODE`) VALUES
('1515', 1234, 1010, 1111),
('1616', 4561, 2020, 3490);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `address`
--

CREATE TABLE `address` (
  `CITY_NAME` varchar(20) NOT NULL,
  `ADDRESS_NAME` varchar(14) NOT NULL,
  `ADDRESS_NUMBER` int(11) NOT NULL,
  `POSTAL_CODE` varchar(5) NOT NULL,
  `EMPLOYEE_CODE` varchar(11) NOT NULL,
  `A_CODE` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `address`
--

INSERT INTO `address` (`CITY_NAME`, `ADDRESS_NAME`, `ADDRESS_NUMBER`, `POSTAL_CODE`, `EMPLOYEE_CODE`, `A_CODE`) VALUES
('Petroupoli', 'Anagnwstara', 24, '13232', '1234', '1010'),
('Ilion', 'Anagnwstara', 23, '13231', '5678', '2002');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `assembled`
--

CREATE TABLE `assembled` (
  `CODE` int(11) NOT NULL,
  `PECEIPT_BATCH_CODE` int(11) NOT NULL,
  `DATA_BASE_CODE` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `assembled`
--

INSERT INTO `assembled` (`CODE`, `PECEIPT_BATCH_CODE`, `DATA_BASE_CODE`) VALUES
(1010, 1111, 'ABCD'),
(2020, 3490, 'EFGH');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `data_base`
--

CREATE TABLE `data_base` (
  `CODE` varchar(4) NOT NULL,
  `PORTION_CHECK` int(11) NOT NULL,
  `MANAGER` varchar(20) NOT NULL,
  `ORDER_DATE` date NOT NULL,
  `ORDER_QUANTIRY` int(11) NOT NULL,
  `ENTRY_DATE` date NOT NULL,
  `QUANTITY` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `data_base`
--

INSERT INTO `data_base` (`CODE`, `PORTION_CHECK`, `MANAGER`, `ORDER_DATE`, `ORDER_QUANTIRY`, `ENTRY_DATE`, `QUANTITY`) VALUES
('ABCD', 10, 'ANDREAS', '2022-06-01', 15, '2022-06-10', 18),
('DKLP', 15, 'TAKIS', '2022-06-01', 15, '2022-06-10', 18),
('EFGH', 20, 'APOSTOLOS', '2022-07-01', 16, '2022-07-10', 19);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `employee`
--

CREATE TABLE `employee` (
  `CODE` varchar(11) NOT NULL,
  `NAME` varchar(10) NOT NULL,
  `SURNAME` varchar(10) NOT NULL,
  `Father's_Name` varchar(10) NOT NULL,
  `MANAGER_NAME` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `employee`
--

INSERT INTO `employee` (`CODE`, `NAME`, `SURNAME`, `Father's_Name`, `MANAGER_NAME`) VALUES
('1234', 'Takis', 'Mpakos', 'Kostakis', 'ANDREAS'),
('5678', 'Mpampis', 'Tsousis', 'Giorgakis', 'APOSTOLOS');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `manager`
--

CREATE TABLE `manager` (
  `NAME` varchar(10) NOT NULL,
  `CHECK_DATE` date NOT NULL,
  `DATA_BASE_CODE` varchar(4) NOT NULL,
  `PECEIPT_BATCH_CODE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `manager`
--

INSERT INTO `manager` (`NAME`, `CHECK_DATE`, `DATA_BASE_CODE`, `PECEIPT_BATCH_CODE`) VALUES
('ANDREAS', '2020-08-20', 'ABCD', 1111),
('APOSTOLOS', '2017-08-09', 'EFGH', 3490);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `peceipt_batch`
--

CREATE TABLE `peceipt_batch` (
  `CODE` int(11) NOT NULL,
  `DATE_ENTRY` date NOT NULL,
  `QUANTIRY` int(11) NOT NULL,
  `STORAGE_CODE` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `peceipt_batch`
--

INSERT INTO `peceipt_batch` (`CODE`, `DATE_ENTRY`, `QUANTIRY`, `STORAGE_CODE`) VALUES
(1111, '2020-08-20', 9, 'DGBA'),
(3490, '2017-08-09', 15, 'QKLP');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `phonenumbers`
--

CREATE TABLE `phonenumbers` (
  `PHONE` varchar(10) DEFAULT NULL,
  `PHONECODE` varchar(6) NOT NULL,
  `EMPLOYEE_CODE` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `phonenumbers`
--

INSERT INTO `phonenumbers` (`PHONE`, `PHONECODE`, `EMPLOYEE_CODE`) VALUES
('6930138896', '1', '1234'),
('6994475433', '2', '1234');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `piece`
--

CREATE TABLE `piece` (
  `CODE` int(11) NOT NULL,
  `PECEIPT_BATCH_CODE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `piece`
--

INSERT INTO `piece` (`CODE`, `PECEIPT_BATCH_CODE`) VALUES
(1230, 1111),
(9876, 3490);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `storage`
--

CREATE TABLE `storage` (
  `CODE` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `storage`
--

INSERT INTO `storage` (`CODE`) VALUES
('1234'),
('DGBA'),
('QKLP');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `storage_bin`
--

CREATE TABLE `storage_bin` (
  `CODE` int(11) NOT NULL,
  `CAPACITY` int(11) NOT NULL,
  `STORAGE_CODE` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `storage_bin`
--

INSERT INTO `storage_bin` (`CODE`, `CAPACITY`, `STORAGE_CODE`) VALUES
(1234, 55, 'QKLP'),
(4561, 10, 'DGBA');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `accessories`
--
ALTER TABLE `accessories`
  ADD PRIMARY KEY (`CODE`),
  ADD KEY `ACCESSORIES_ASSEMBLED_FK` (`ASSEMBLED_CODE`),
  ADD KEY `ACCESSORIES_PECEIPT_BATCH_FK` (`PECEIPT_BATCH_CODE`),
  ADD KEY `ACCESSORIES_STORAGE_BIN_FK` (`STORAGE_BIN_CODE`);

--
-- Ευρετήρια για πίνακα `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`A_CODE`),
  ADD KEY `ADDRESS_EMPLOYEE_FK` (`EMPLOYEE_CODE`);

--
-- Ευρετήρια για πίνακα `assembled`
--
ALTER TABLE `assembled`
  ADD PRIMARY KEY (`CODE`),
  ADD KEY `ASSEMBLED_DATA_BASE_FK` (`DATA_BASE_CODE`),
  ADD KEY `ASSEMBLED_PECEIPT_BATCH_FK` (`PECEIPT_BATCH_CODE`);

--
-- Ευρετήρια για πίνακα `data_base`
--
ALTER TABLE `data_base`
  ADD PRIMARY KEY (`CODE`);

--
-- Ευρετήρια για πίνακα `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`CODE`),
  ADD KEY `EMPLOYEE_MANAGER_FK` (`MANAGER_NAME`);

--
-- Ευρετήρια για πίνακα `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`NAME`),
  ADD KEY `MANAGER_DATA_BASE_FK` (`DATA_BASE_CODE`),
  ADD KEY `MANAGER_PECEIPT_BATCH_FK` (`PECEIPT_BATCH_CODE`);

--
-- Ευρετήρια για πίνακα `peceipt_batch`
--
ALTER TABLE `peceipt_batch`
  ADD PRIMARY KEY (`CODE`),
  ADD KEY `PECEIPT_BATCH_STORAGE_FK` (`STORAGE_CODE`);

--
-- Ευρετήρια για πίνακα `phonenumbers`
--
ALTER TABLE `phonenumbers`
  ADD PRIMARY KEY (`PHONECODE`),
  ADD KEY `PHONENUMBERS_EMPLOYEE_FK` (`EMPLOYEE_CODE`);

--
-- Ευρετήρια για πίνακα `piece`
--
ALTER TABLE `piece`
  ADD PRIMARY KEY (`CODE`),
  ADD KEY `PIECE_PECEIPT_BATCH_FK` (`PECEIPT_BATCH_CODE`);

--
-- Ευρετήρια για πίνακα `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`CODE`);

--
-- Ευρετήρια για πίνακα `storage_bin`
--
ALTER TABLE `storage_bin`
  ADD PRIMARY KEY (`CODE`),
  ADD KEY `STORAGE_BIN_STORAGE_FK` (`STORAGE_CODE`);

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `accessories`
--
ALTER TABLE `accessories`
  ADD CONSTRAINT `ACCESSORIES_ASSEMBLED_FK` FOREIGN KEY (`ASSEMBLED_CODE`) REFERENCES `assembled` (`CODE`),
  ADD CONSTRAINT `ACCESSORIES_PECEIPT_BATCH_FK` FOREIGN KEY (`PECEIPT_BATCH_CODE`) REFERENCES `peceipt_batch` (`CODE`),
  ADD CONSTRAINT `ACCESSORIES_STORAGE_BIN_FK` FOREIGN KEY (`STORAGE_BIN_CODE`) REFERENCES `storage_bin` (`CODE`);

--
-- Περιορισμοί για πίνακα `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `ADDRESS_EMPLOYEE_FK` FOREIGN KEY (`EMPLOYEE_CODE`) REFERENCES `employee` (`CODE`);

--
-- Περιορισμοί για πίνακα `assembled`
--
ALTER TABLE `assembled`
  ADD CONSTRAINT `ASSEMBLED_DATA_BASE_FK` FOREIGN KEY (`DATA_BASE_CODE`) REFERENCES `data_base` (`CODE`),
  ADD CONSTRAINT `ASSEMBLED_PECEIPT_BATCH_FK` FOREIGN KEY (`PECEIPT_BATCH_CODE`) REFERENCES `peceipt_batch` (`CODE`);

--
-- Περιορισμοί για πίνακα `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `EMPLOYEE_MANAGER_FK` FOREIGN KEY (`MANAGER_NAME`) REFERENCES `manager` (`NAME`);

--
-- Περιορισμοί για πίνακα `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `MANAGER_DATA_BASE_FK` FOREIGN KEY (`DATA_BASE_CODE`) REFERENCES `data_base` (`CODE`),
  ADD CONSTRAINT `MANAGER_PECEIPT_BATCH_FK` FOREIGN KEY (`PECEIPT_BATCH_CODE`) REFERENCES `peceipt_batch` (`CODE`);

--
-- Περιορισμοί για πίνακα `peceipt_batch`
--
ALTER TABLE `peceipt_batch`
  ADD CONSTRAINT `PECEIPT_BATCH_STORAGE_FK` FOREIGN KEY (`STORAGE_CODE`) REFERENCES `storage` (`CODE`);

--
-- Περιορισμοί για πίνακα `phonenumbers`
--
ALTER TABLE `phonenumbers`
  ADD CONSTRAINT `PHONENUMBERS_EMPLOYEE_FK` FOREIGN KEY (`EMPLOYEE_CODE`) REFERENCES `employee` (`CODE`);

--
-- Περιορισμοί για πίνακα `piece`
--
ALTER TABLE `piece`
  ADD CONSTRAINT `PIECE_PECEIPT_BATCH_FK` FOREIGN KEY (`PECEIPT_BATCH_CODE`) REFERENCES `peceipt_batch` (`CODE`);

--
-- Περιορισμοί για πίνακα `storage_bin`
--
ALTER TABLE `storage_bin`
  ADD CONSTRAINT `STORAGE_BIN_STORAGE_FK` FOREIGN KEY (`STORAGE_CODE`) REFERENCES `storage` (`CODE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



