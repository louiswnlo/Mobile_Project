-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- 主機: sophia
-- 產生時間： 2019 年 12 月 13 日 19:57
-- 伺服器版本: 5.7.28-0ubuntu0.18.04.4
-- PHP 版本： 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `thysung`
--

-- --------------------------------------------------------

--
-- 資料表結構 `service`
--

CREATE TABLE `service` (
  `service_id` varchar(8) NOT NULL,
  `name` varchar(7) DEFAULT NULL,
  `discount` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `service`
--

INSERT INTO `service` (`service_id`, `name`, `discount`) VALUES
('1', 'Nails', '10'),
('2', 'Massage', '0'),
('3', 'Hair', '20'),
('4', 'Brows', '0');

-- --------------------------------------------------------

--
-- 資料表結構 `shop`
--

CREATE TABLE `shop` (
  `shop_id` int(1) NOT NULL,
  `service_id` int(1) DEFAULT NULL,
  `shopname` varchar(26) DEFAULT NULL,
  `location` varchar(12) DEFAULT NULL,
  `discount` int(2) DEFAULT NULL,
  `logo_url` varchar(7931) DEFAULT NULL,
  `photo_url` varchar(11) DEFAULT NULL,
  `district_id` int(2) DEFAULT NULL,
  `shop_info` varchar(89) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `shop`
--

INSERT INTO `shop` (`shop_id`, `service_id`, `shopname`, `location`, `discount`, `logo_url`, `photo_url`, `district_id`, `shop_info`) VALUES
(1, 1, 'FootSpa Jordan', 'Jordan', 10, 'https://i.etsystatic.com/17285564/r/il/ca8580/1497566071/il_794xN.1497566071_hm7p.jpg', 'photo.jpg\'', 10, 'Best foot massage in Jordan'),
(2, 2, 'Levo Spa', 'Sham Shui Po', 0, 'data:image/jpeg;base64,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', '\'photo.jpg\'', 3, 'Enjoy a day off at Levo Spa'),
(3, 3, 'The Foot Room', 'Kowloon Bay', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj8ucnP8PaypQZ4kvOer_aKwjIqs08T5gweNQqWmpNrjUCYpJTEA&s', '\'photo.jpg\'', 2, '腳底按摩'),
(4, 4, 'Beauty Paradise', 'Admiralty', 0, 'http://images.hktvmall.com/g6298001/247041/g6298001_a001908oo84in662wk_190530052454_01_1200.jpg', '\'photo.jpg\'', 15, 'Get glammed up here in Beauty paradise - show another side of u'),
(5, 3, 'Float Hong Kong', 'Central', 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiB_I1RU8YR_K8b8UJKDBH_9T7Am8o5ZEqDBp2EXIcQF6rDWjZ1A&s', '\'photo.jpg\'', 18, 'FLOAT ON - A innovative place to get rid of those stress while floating! Book now to try!'),
(6, 2, 'Charming Beauty & Slimming', 'Central', 20, 'https://static.helpbit.com/upload/images/servicecategories/thumb_servicecategory_188.png?_=ab5944e331ac3c8bee37645897cc398a', '\'photo.jpg\'', 18, 'charming, be u');

-- --------------------------------------------------------

--
-- 資料表結構 `treatment`
--

CREATE TABLE `treatment` (
  `treatment_id` int(1) NOT NULL,
  `shop_id` int(1) DEFAULT NULL,
  `duration` int(3) DEFAULT NULL,
  `price` int(3) DEFAULT NULL,
  `description` varchar(15) DEFAULT NULL,
  `available_time` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `treatment`
--

INSERT INTO `treatment` (`treatment_id`, `shop_id`, `duration`, `price`, `description`, `available_time`) VALUES
(1, 1, 120, 200, 'Gel manicure', '12:00,12:30'),
(2, 2, 45, 165, 'Thai massage', '1:00'),
(3, 3, 60, 300, 'Perm', '4:30,5:00,8:00'),
(4, 4, 120, 680, 'Brow trim', '6:00,9:00,10:00'),
(5, 3, 60, 250, 'Wash and cut', 'null'),
(6, 2, 75, 100, 'Chinese massage', '2:00,3:00');

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `user_id` int(1) NOT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `username` varchar(7) DEFAULT NULL,
  `password` int(6) DEFAULT NULL,
  `email` varchar(16) DEFAULT NULL,
  `photo` int(8) DEFAULT NULL,
  `firstname` varchar(7) DEFAULT NULL,
  `lastname` varchar(4) DEFAULT NULL,
  `display` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `user`
--

INSERT INTO `user` (`user_id`, `gender`, `username`, `password`, `email`, `photo`, `firstname`, `lastname`, `display`) VALUES
(1, 'F', 'tracy', 123456, 'tracy@email.com', 92131902, 'tracy', 'sung', 'tracysung'),
(2, 'M', 'louis', 123456, 'louis@email.com', 98981234, 'louis', 'lo', 'louislo'),
(3, 'F', 'natalie', 123456, 'natalie@emai.com', 91919191, 'natalie', 'kong', 'nataliekong');

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`service_id`);

--
-- 資料表索引 `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`shop_id`);

--
-- 資料表索引 `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`treatment_id`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;