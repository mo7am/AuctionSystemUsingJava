-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2017 at 02:06 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.5.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auction`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Date_Id` int(15) NOT NULL,
  `User_ID` int(15) NOT NULL,
  `DM_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(8, '2017-04-18'),
(9, '2017-05-15'),
(10, '1999-12-15'),
(11, '1999-12-18'),
(12, '1999-04-02'),
(13, '2017-05-13'),
(14, '2017-05-14'),
(15, '2017-05-19'),
(16, '2017-05-20');

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

-- --------------------------------------------------------

--
-- Table structure for table `details_winner`
--

CREATE TABLE `details_winner` (
  `Details_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Item_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dm_work_table`
--

CREATE TABLE `dm_work_table` (
  `ID` int(11) NOT NULL,
  `DM_ID` int(11) NOT NULL,
  `DATE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `during_auction`
--

CREATE TABLE `during_auction` (
  `During_Auction_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Item_ID` int(11) NOT NULL,
  `Price` float NOT NULL
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

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `ID` int(15) NOT NULL,
  `Minimum_Price` double NOT NULL,
  `Weight` int(25) NOT NULL,
  `Perioud_Usage` int(25) NOT NULL,
  `User_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `State_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mobile`
--

CREATE TABLE `mobile` (
  `ID` int(15) NOT NULL,
  `BatteryVolt` int(25) NOT NULL,
  `ToatlSize` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nonreserved`
--

CREATE TABLE `nonreserved` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Accepted_Price` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `notification_after_session_end`
--

CREATE TABLE `notification_after_session_end` (
  `ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Notification` text NOT NULL,
  `Price` float NOT NULL,
  `Item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `number_of_deals`
--

CREATE TABLE `number_of_deals` (
  `ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Total_Money` float NOT NULL,
  `Item_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `observer`
--

CREATE TABLE `observer` (
  `Observer_id` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Content` text NOT NULL,
  `State_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `observers`
--

CREATE TABLE `observers` (
  `ID` int(11) NOT NULL,
  `Admin_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_of_item`
--

CREATE TABLE `order_of_item` (
  `ID` int(15) NOT NULL,
  `BidderID` int(15) NOT NULL DEFAULT '0',
  `AdminID` int(15) NOT NULL DEFAULT '0',
  `DM_ID` int(15) NOT NULL DEFAULT '0',
  `Avilabletime_ID` int(15) NOT NULL DEFAULT '0',
  `Item_ID` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for table `region_d_m`
--

CREATE TABLE `region_d_m` (
  `Region_DM_ID` int(11) NOT NULL,
  `Region_ID` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `region_d_m`
--

INSERT INTO `region_d_m` (`Region_DM_ID`, `Region_ID`, `user_id`) VALUES
(1, 1, 3),
(2, 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

CREATE TABLE `reserved` (
  `ID` int(15) NOT NULL,
  `Item_ID` int(15) NOT NULL,
  `Start_Date_ID` int(15) NOT NULL,
  `End_Date_ID` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for table `sequrityq_user`
--

CREATE TABLE `sequrityq_user` (
  `SequrityQ_U_ID` int(11) NOT NULL,
  `SequrityQ_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Answer_Question` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequrityq_user`
--

INSERT INTO `sequrityq_user` (`SequrityQ_U_ID`, `SequrityQ_ID`, `User_ID`, `Answer_Question`) VALUES
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
(11, 1, 11, 'radwan'),
(15, 3, 26, 'red'),
(16, 3, 28, 'red'),
(17, 3, 29, 'red'),
(18, 3, 32, 'red'),
(19, 1, 33, 'Hello'),
(20, 1, -1, ''),
(21, 1, -1, 'aaa'),
(22, 3, -1, 'red'),
(23, 1, 34, 'asdasdasd'),
(24, 3, 35, 'red'),
(25, 3, 36, 'Hello');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Staff_id` int(11) NOT NULL,
  `SSN` varchar(20) NOT NULL,
  `Salary` double NOT NULL,
  `Age` int(11) NOT NULL,
  `Birth_Date` varchar(50) NOT NULL,
  `work_hours` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_id`, `SSN`, `Salary`, `Age`, `Birth_Date`, `work_hours`, `User_ID`) VALUES
(1, '12345678912345', 100, 20, '1996-06-01', 6, 1),
(2, '14785236985214', 100, 21, '1995-07-05', 8, 2),
(3, '15984762314785', 100, 50, '1996-06-03', 24, 3),
(4, '123456789963214', 2000.2, 20, '1-6-1996', 6, 31),
(5, '123456789963214', 2000.2, 20, '1-6-1996', 6, 32),
(6, '9', 9, 9, '9', 9, 9),
(7, 'aaa', 10000, 25, '1996-04-01', 11, 33),
(8, '1', 1, 1, '1', 1, 12),
(9, 'aaa', 200000, 20, '1996-06-01', 1, 36);

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE `state` (
  `State_id` int(11) NOT NULL,
  `State` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`State_id`, `State`) VALUES
(1, 'Seen'),
(2, 'Not Seen'),
(3, 'Block'),
(4, 'UnBlock');

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
  `Balance` double DEFAULT NULL,
  `Country_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_ID`, `F_NAME`, `L_NAME`, `Email`, `Password`, `Type_User_id`, `Balance`, `Country_ID`) VALUES
(1, 'Mohamed', 'Salah', 's', '1', 1, 700012, 1),
(2, 'K', 'Alaa', 'k', 'aaaa1111', 2, 99119, 1),
(3, 'Emad', 'Sayed', 'e', '1', 3, 6042, 2),
(4, 'Mahmoud', 'Abdelrazek', 'm', '1', 4, 15241, 2),
(5, 'Abdalla', 'mohamed', 'a', '1', 5, 29474, 3),
(6, 'asmaa', 'Ali', 'Asmaa123@gmail.com', '74125896', 4, 200000, 1),
(7, 'ola', 'Ahmed', 'Olaahmed14@gmail.com', '32147896', 5, 8000, 2),
(8, 'Omar', 'Mohamed', 'Omarmohamed12@gmail.com', '1234578', 5, 500078, 4),
(9, 'waleed', 'mohamed', 'waleed15@gmail.com', '15984762', 3, 10, 1),
(10, 'Sara', 'Ali', 'sara12@gmail.com', '12345678', 5, 9000, 4),
(11, 'Reda', 'Salem', 'redasalem147@gmail.com', '14785236', 4, 1000, 1),
(12, 'abdo', 'mohamed', 'abdo@yahoo.com', '123456', 2, 10000.2, 1),
(26, 'abdo', 'mohamed', 'abdo1@yahoo.com', '12345678', 5, 40000, 2),
(27, 'medo', 'medo', 'Eng.mohamed@gmail.com', '14785236', 5, 15000, 5),
(29, 'ahmed', 'ahmed', 'Eng.mohamed1@gmail.com', '14785236', 5, 20000, 5),
(30, 'mostafa', 'ragab', 'mostafa@yahoo.com', '123456', 3, 2000, -1),
(31, 'mostafa', 'ragab', 'mostafa1@yahoo.com', '123456', 3, 2020, 1),
(32, 'mostafa', 'ragab', 'mostafa2@yahoo.com', '123456', 3, 2000, 1),
(33, 'Emo', 'Sayed', 'Emo@gmail.com', 'emosayed123', 2, 0, -1),
(34, 'emooo', 'emmo', 'emad@gmail.com', '1111aaaaaa', 4, 0, 1),
(35, 'mohamed', 'salah', 'momo@yahoo.com', 'mo123456', 5, 1982, 1),
(36, 'mohamed', 'salah', 'mohamed@yahoo.com', '123456mo', 2, 0, -1);

-- --------------------------------------------------------

--
-- Table structure for table `user_avilable_time`
--

CREATE TABLE `user_avilable_time` (
  `ID` int(15) NOT NULL,
  `User_ID` int(15) NOT NULL,
  `Date_ID` int(15) NOT NULL,
  `Item_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Indexes for table `details_winner`
--
ALTER TABLE `details_winner`
  ADD PRIMARY KEY (`Details_ID`);

--
-- Indexes for table `dm_work_table`
--
ALTER TABLE `dm_work_table`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `during_auction`
--
ALTER TABLE `during_auction`
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
-- Indexes for table `notification_after_session_end`
--
ALTER TABLE `notification_after_session_end`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `number_of_deals`
--
ALTER TABLE `number_of_deals`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `observer`
--
ALTER TABLE `observer`
  ADD PRIMARY KEY (`Observer_id`);

--
-- Indexes for table `observers`
--
ALTER TABLE `observers`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `order_of_item`
--
ALTER TABLE `order_of_item`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `region_d_m`
--
ALTER TABLE `region_d_m`
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
-- Indexes for table `sequrityq_user`
--
ALTER TABLE `sequrityq_user`
  ADD PRIMARY KEY (`SequrityQ_U_ID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`State_id`);

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
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `date`
--
ALTER TABLE `date`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `details_winner`
--
ALTER TABLE `details_winner`
  MODIFY `Details_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dm_work_table`
--
ALTER TABLE `dm_work_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `during_auction`
--
ALTER TABLE `during_auction`
  MODIFY `During_Auction_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `laps`
--
ALTER TABLE `laps`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `links`
--
ALTER TABLE `links`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mobile`
--
ALTER TABLE `mobile`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `nonreserved`
--
ALTER TABLE `nonreserved`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `notification_after_session_end`
--
ALTER TABLE `notification_after_session_end`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `number_of_deals`
--
ALTER TABLE `number_of_deals`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `observer`
--
ALTER TABLE `observer`
  MODIFY `Observer_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `observers`
--
ALTER TABLE `observers`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `order_of_item`
--
ALTER TABLE `order_of_item`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `securityq`
--
ALTER TABLE `securityq`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `sequrityq_user`
--
ALTER TABLE `sequrityq_user`
  MODIFY `SequrityQ_U_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `Staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `state`
--
ALTER TABLE `state`
  MODIFY `State_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `type_user`
--
ALTER TABLE `type_user`
  MODIFY `Type_User_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `user_avilable_time`
--
ALTER TABLE `user_avilable_time`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;
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
