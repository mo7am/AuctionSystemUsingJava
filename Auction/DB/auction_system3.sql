-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 26, 2017 at 09:29 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auction_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `ID` int(15) NOT NULL,
  `User_ID` int(15) NOT NULL,
  `Region_ID` int(15) NOT NULL,
  `Address_Details` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`ID`, `User_ID`, `Region_ID`, `Address_Details`) VALUES
(1, 1, 1, 'Cairo/Rab3a'),
(2, 2, 1, 'Ain Shams/Elshorafa'),
(3, 3, 1, 'Embaba/behind Ehbrens'),
(4, 4, 1, 'helwan/Ain helwan'),
(5, 5, 1, 'ElGiza ');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Date_Id` int(15) NOT NULL,
  `Price` int(15) NOT NULL,
  `User_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`ID`, `Item_ID`, `Date_Id`, `Price`, `User_ID`) VALUES
(1, 2, 1, 2000, 4),
(2, 1, 2, 5000, 5),
(3, 4, 3, 4000, 7),
(4, 3, 4, 8000, 6);

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `ID` int(15) NOT NULL,
  `CarSpeed` int(25) NOT NULL,
  `MotorPower` int(25) NOT NULL,
  `NumberOfPassengers` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`ID`, `CarSpeed`, `MotorPower`, `NumberOfPassengers`) VALUES
(101, 220, 100, 4),
(102, 320, 120, 2),
(103, 240, 150, 4),
(104, 210, 140, 2);

-- --------------------------------------------------------

--
-- Table structure for table `date`
--

CREATE TABLE `date` (
  `ID` int(15) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `date`
--

INSERT INTO `date` (`ID`, `Date`) VALUES
(1, '2017-04-11'),
(2, '2017-04-12'),
(3, '2017-04-13'),
(4, '2017-04-14'),
(5, '2017-04-15'),
(6, '2017-04-16'),
(7, '2017-04-17'),
(8, '2017-04-18');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `ID` int(15) NOT NULL,
  `DeptName_ID` int(15) NOT NULL,
  `Auction_ID` int(15) NOT NULL,
  `CompanyName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`ID`, `DeptName_ID`, `Auction_ID`, `CompanyName`) VALUES
(1, 2, 1, 'Dell'),
(2, 1, 2, 'Samsong'),
(3, 101, 102, 'BMW'),
(4, 104, 101, 'lanser'),
(5, 202, 3, 'samsong'),
(6, 201, 103, 'HTC');

-- --------------------------------------------------------

--
-- Table structure for table `Details_Winner`
--

CREATE TABLE `Details_Winner` (
  `Details_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Item_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Details_Winner`
--

INSERT INTO `Details_Winner` (`Details_ID`, `User_ID`, `Item_ID`) VALUES
(1, 4, 2),
(2, 6, 3),
(3, 10, 4),
(4, 11, 1);

-- --------------------------------------------------------

--
-- Table structure for table `During_Auction`
--

CREATE TABLE `During_Auction` (
  `During_Auction_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Item_ID` int(11) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Ratenum` int(25) NOT NULL,
  `SysQuality` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`ID`, `Item_ID`, `Ratenum`, `SysQuality`) VALUES
(1, 4, 50, 70),
(2, 1, 40, 60),
(3, 3, 60, 80),
(4, 2, 30, 40);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `ID` int(15) NOT NULL,
  `Minimum_Price` int(25) NOT NULL,
  `Weight` int(25) NOT NULL,
  `Perioud_Usage` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`ID`, `Minimum_Price`, `Weight`, `Perioud_Usage`) VALUES
(1, 3000, 20, 5),
(2, 7000, 25, 8),
(3, 7000, 22, 6),
(4, 6000, 21, 10);

-- --------------------------------------------------------

--
-- Table structure for table `laps`
--

CREATE TABLE `laps` (
  `ID` int(15) NOT NULL,
  `ScreenSize` varchar(100) NOT NULL,
  `Processor` varchar(100) NOT NULL,
  `Hard` varchar(100) NOT NULL,
  `Ram` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `laps`
--

INSERT INTO `laps` (`ID`, `ScreenSize`, `Processor`, `Hard`, `Ram`) VALUES
(1, '15', '2.1', 'tera', '4'),
(2, '17', '3.2', '750', '8');

-- --------------------------------------------------------

--
-- Table structure for table `links`
--

CREATE TABLE `links` (
  `ID` int(15) NOT NULL,
  `Furi_Name` varchar(100) NOT NULL,
  `Phy_Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `links`
--

INSERT INTO `links` (`ID`, `Furi_Name`, `Phy_Name`) VALUES
(1, 'Delete', 'Delete.java'),
(2, 'Add', 'Add.java'),
(3, 'Update', 'Update.java'),
(4, 'Search', 'Search.java'),
(5, 'Login', 'Login.java'),
(6, 'Regist', 'Regist.java');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `ID` int(15) NOT NULL,
  `Sender_ID` int(15) NOT NULL,
  `Reciever_ID` int(15) NOT NULL,
  `Content` varchar(150) NOT NULL,
  `Date_ID` int(15) NOT NULL,
  `Time` time(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`ID`, `Sender_ID`, `Reciever_ID`, `Content`, `Date_ID`, `Time`) VALUES
(1, 2, 1, 'hi manager my name is Kareem', 1, '05:33:48.899999'),
(2, 4, 5, 'hi seller i''m bidder', 3, '03:20:29.071735'),
(3, 5, 2, 'hi Admin i''m Seller', 4, '02:24:13.750579');

-- --------------------------------------------------------

--
-- Table structure for table `mobile`
--

CREATE TABLE `mobile` (
  `ID` int(15) NOT NULL,
  `BatteryVolt` int(25) NOT NULL,
  `ToatlSize` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobile`
--

INSERT INTO `mobile` (`ID`, `BatteryVolt`, `ToatlSize`) VALUES
(201, 200, 5),
(202, 220, 6);

-- --------------------------------------------------------

--
-- Table structure for table `nonreserved`
--

CREATE TABLE `nonreserved` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Accepted_Price` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nonreserved`
--

INSERT INTO `nonreserved` (`ID`, `Item_ID`, `Accepted_Price`) VALUES
(1, 2, 8000),
(2, 1, 7000);

-- --------------------------------------------------------

--
-- Table structure for table `Notification_After_Session_End`
--

CREATE TABLE `Notification_After_Session_End` (
  `ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Notification` text NOT NULL,
  `Price` float NOT NULL,
  `Item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Observer`
--

CREATE TABLE `Observer` (
  `Observer_id` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `ID` int(15) NOT NULL,
  `BidderID` int(15) NOT NULL,
  `AdminID` int(15) NOT NULL,
  `DM_ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Avilabletime_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`ID`, `BidderID`, `AdminID`, `DM_ID`, `Item_ID`, `Avilabletime_ID`) VALUES
(1, 6, 2, 3, 1, 1),
(2, 4, 2, 3, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE `region` (
  `ID` int(15) NOT NULL,
  `Region` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`ID`, `Region`) VALUES
(1, 'Egypt'),
(2, 'America'),
(3, 'China'),
(4, 'Korea'),
(5, 'Canada'),
(6, 'Brazil');

-- --------------------------------------------------------

--
-- Table structure for table `Region_D_M`
--

CREATE TABLE `Region_D_M` (
  `Region_DM_ID` int(11) NOT NULL,
  `Region_ID` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Region_D_M`
--

INSERT INTO `Region_D_M` (`Region_DM_ID`, `Region_ID`, `user_id`) VALUES
(1, 1, 3),
(2, 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

CREATE TABLE `reserved` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Time` time(6) NOT NULL,
  `Start_Date_ID` int(15) NOT NULL,
  `End_Date_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reserved`
--

INSERT INTO `reserved` (`ID`, `Item_ID`, `Time`, `Start_Date_ID`, `End_Date_ID`) VALUES
(101, 4, '03:24:13.618805', 2, 4),
(102, 3, '03:21:37.425214', 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `securityq`
--

CREATE TABLE `securityq` (
  `ID` int(15) NOT NULL,
  `Question` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `securityq`
--

INSERT INTO `securityq` (`ID`, `Question`) VALUES
(1, 'What is the name of your favorite childhood friends?\r\n'),
(2, 'What is your oldest cousin''s first and last name ?'),
(3, 'What is favorite color ?    ');

-- --------------------------------------------------------

--
-- Table structure for table `SequrityQ_User`
--

CREATE TABLE `SequrityQ_User` (
  `SequrityQ_U_ID` int(11) NOT NULL,
  `SequrityQ_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Answer_Question` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SequrityQ_User`
--

INSERT INTO `SequrityQ_User` (`SequrityQ_U_ID`, `SequrityQ_ID`, `User_ID`, `Answer_Question`) VALUES
(1, 3, 1, 'red'),
(2, 2, 2, 'Alaa Mohamed'),
(3, 1, 3, 'Ali'),
(4, 3, 4, 'Black'),
(5, 2, 5, 'Ahmed abdo'),
(6, 2, 6, 'mohamed salah'),
(7, 1, 7, 'omar'),
(8, 3, 8, 'yellow'),
(9, 3, 9, 'red'),
(10, 2, 10, 'sayed ahmed'),
(11, 1, 11, 'radwan');

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE `Staff` (
  `Staff_id` int(11) NOT NULL,
  `SSN` varchar(20) NOT NULL,
  `Salary` double NOT NULL,
  `Age` int(11) NOT NULL,
  `Birth_Date` date NOT NULL,
  `work_hours` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`Staff_id`, `SSN`, `Salary`, `Age`, `Birth_Date`, `work_hours`, `User_ID`) VALUES
(1, '12345678912345', 20000.5, 20, '1996-06-01', 6, 1),
(2, '14785236985214', 5000.5, 21, '1995-07-05', 8, 2),
(3, '15984762314785', 200.5, 20, '1996-06-01', 24, 3);

-- --------------------------------------------------------

--
-- Table structure for table `type_user`
--

CREATE TABLE `type_user` (
  `Type_User_id` int(15) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Parent_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_user`
--

INSERT INTO `type_user` (`Type_User_id`, `Name`, `Parent_ID`) VALUES
(1, 'Manager', 0),
(2, 'Admin', 1),
(3, 'Delivary man', 2),
(4, 'Bidder', 2),
(5, 'Seller', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `User_ID` int(15) NOT NULL,
  `F_NAME` varchar(100) NOT NULL,
  `L_NAME` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Type_User_id` int(15) NOT NULL,
  `Balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_ID`, `F_NAME`, `L_NAME`, `Email`, `Password`, `Type_User_id`, `Balance`) VALUES
(1, 'Mohamed', 'Salah', 'Eng.mohamed161996@gmail.com', '12345678', 1, 9000001),
(2, 'Kareem', 'Alaa', 'Kareemalaa45@gmail.com', '14785236', 2, 20000),
(3, 'Emad', 'Sayed', 'EmadSayed12@gmail.com', '36985214', 3, 20),
(4, 'Mahmoud', 'Abdelrazek', 'MahmoudAbdelrazek14@gmail.com', '25874136', 4, 25841),
(5, 'Abdalla', 'mohamed', 'AbdallaMohamed78@gmail.com', '36974125', 5, 25874),
(6, 'asmaa', 'Ali', 'Asmaa123@gmail.com', '74125896', 4, 5000),
(7, 'ola', 'Ahmed', 'Olaahmed14@gmail.com', '32147896', 5, 8000),
(8, 'Omar', 'Mohamed', 'Omarmohamed12@gmail.com', '1234578', 5, 500078),
(9, 'waleed', 'mohamed', 'waleed15@gmail.com', '15984762', 3, 10),
(10, 'Sara', 'Ali', 'sara12@gmail.com', '12345678', 4, 2000),
(11, 'Reda', 'Salem', 'redasalem147@gmail.com', '14785236', 4, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `user_avilable_time`
--

CREATE TABLE `user_avilable_time` (
  `ID` int(15) NOT NULL,
  `User_ID` int(15) NOT NULL,
  `Date_ID` int(15) NOT NULL,
  `Avilable-Time` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_avilable_time`
--

INSERT INTO `user_avilable_time` (`ID`, `User_ID`, `Date_ID`, `Avilable-Time`) VALUES
(1, 6, 1, 8),
(2, 4, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `user_option`
--

CREATE TABLE `user_option` (
  `User_Option_id` int(15) NOT NULL,
  `Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_option_selected`
--

CREATE TABLE `user_option_selected` (
  `ID` int(15) NOT NULL,
  `User_Type_ID` int(15) NOT NULL,
  `User_Option_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_option_selected_value`
--

CREATE TABLE `user_option_selected_value` (
  `ID` int(15) NOT NULL,
  `User_Option_ID` int(15) NOT NULL,
  `User_ID` int(15) NOT NULL,
  `Value` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_type_links`
--

CREATE TABLE `user_type_links` (
  `ID` int(15) NOT NULL,
  `User_Type_ID` int(15) NOT NULL,
  `Links_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_type_links`
--

INSERT INTO `user_type_links` (`ID`, `User_Type_ID`, `Links_ID`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 2, 2),
(7, 2, 3),
(8, 2, 4),
(9, 2, 5),
(10, 3, 3),
(11, 3, 4),
(12, 3, 5),
(13, 4, 3),
(14, 4, 4),
(15, 4, 5),
(16, 4, 6),
(17, 5, 2),
(18, 5, 3),
(19, 5, 4),
(20, 5, 5),
(21, 5, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `date`
--
ALTER TABLE `date`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Details_Winner`
--
ALTER TABLE `Details_Winner`
  ADD PRIMARY KEY (`Details_ID`);

--
-- Indexes for table `During_Auction`
--
ALTER TABLE `During_Auction`
  ADD PRIMARY KEY (`During_Auction_ID`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `laps`
--
ALTER TABLE `laps`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `links`
--
ALTER TABLE `links`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mobile`
--
ALTER TABLE `mobile`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nonreserved`
--
ALTER TABLE `nonreserved`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Notification_After_Session_End`
--
ALTER TABLE `Notification_After_Session_End`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Observer`
--
ALTER TABLE `Observer`
  ADD PRIMARY KEY (`Observer_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Region_D_M`
--
ALTER TABLE `Region_D_M`
  ADD PRIMARY KEY (`Region_DM_ID`);

--
-- Indexes for table `reserved`
--
ALTER TABLE `reserved`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `securityq`
--
ALTER TABLE `securityq`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `SequrityQ_User`
--
ALTER TABLE `SequrityQ_User`
  ADD PRIMARY KEY (`SequrityQ_U_ID`);

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Indexes for table `type_user`
--
ALTER TABLE `type_user`
  ADD PRIMARY KEY (`Type_User_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_ID`);

--
-- Indexes for table `user_avilable_time`
--
ALTER TABLE `user_avilable_time`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_option`
--
ALTER TABLE `user_option`
  ADD PRIMARY KEY (`User_Option_id`);

--
-- Indexes for table `user_option_selected`
--
ALTER TABLE `user_option_selected`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_option_selected_value`
--
ALTER TABLE `user_option_selected_value`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_type_links`
--
ALTER TABLE `user_type_links`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;
--
-- AUTO_INCREMENT for table `date`
--
ALTER TABLE `date`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `laps`
--
ALTER TABLE `laps`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `links`
--
ALTER TABLE `links`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `mobile`
--
ALTER TABLE `mobile`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;
--
-- AUTO_INCREMENT for table `nonreserved`
--
ALTER TABLE `nonreserved`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;
--
-- AUTO_INCREMENT for table `securityq`
--
ALTER TABLE `securityq`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `type_user`
--
ALTER TABLE `type_user`
  MODIFY `Type_User_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `user_avilable_time`
--
ALTER TABLE `user_avilable_time`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_option`
--
ALTER TABLE `user_option`
  MODIFY `User_Option_id` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_option_selected`
--
ALTER TABLE `user_option_selected`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_option_selected_value`
--
ALTER TABLE `user_option_selected_value`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_type_links`
--
ALTER TABLE `user_type_links`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
