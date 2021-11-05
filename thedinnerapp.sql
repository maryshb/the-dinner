-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Lis 2021, 11:35
-- Wersja serwera: 10.4.20-MariaDB
-- Wersja PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `thedinnerapp`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `titem`
--

CREATE TABLE `titem` (
  `itemId` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `itemName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pieces` int(11) NOT NULL,
  `price` double NOT NULL,
  `restaurantId` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `titem`
--

INSERT INTO `titem` (`itemId`, `description`, `itemName`, `pieces`, `price`, `restaurantId`) VALUES
(3, '9 sztuk pierogów ze szpinakiem i serem. Sposób podania do wyboru.', 'Chińskie pierogi ze szpinakiem', 0, 18.5, 4),
(4, '4 sztuki. Z wieprzowiną, kapustą, marchewką i grzybami mun.', 'Sajgonki z mięsem', 0, 15.5, 4),
(5, '4 sztuki. Sposób podania do wyboru.', 'Pierogi z krewetkami na parze', 0, 15, 4),
(6, 'Sos pomidorowy, mozzarella, ananas', 'Pizza Hawaii', 0, 25.9, 3),
(7, 'Sos pomidorowy, mozzarella, pieczarki', 'Pizza Capricciosa', 0, 26.9, 3),
(8, '26 sztuk. Futumak łosoś, uramak surimi, hosomak omlet', 'Tokio Set', 0, 47, 5),
(9, '50 sztuk. Futomak łosoś, futomak z krewetką w tempurze, uramak tuńczyk, uramak wege, hosomak ogórek, hosomak kanpyo, hosomak surimi', 'Tai Set', 0, 122, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `trestaurant`
--

CREATE TABLE `trestaurant` (
  `restaurantId` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cuisine` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `restaurantName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `trestaurant`
--

INSERT INTO `trestaurant` (`restaurantId`, `address`, `cuisine`, `phone`, `restaurantName`) VALUES
(4, 'ul. Krakowska 12, 31-315 Kraków', 'ASIAN', '+48 000 000 000', 'Pierogarnia pekińska'),
(3, 'ul. Krakowska 1, 31-315 Kraków', 'PIZZA', '+48 000 000 000', 'Pizza Italia'),
(5, '	ul. Polarna 170, 31-315 Kraków', 'ASIAN', '+48 000 000 000', 'Sushi Bar'),
(6, 'ul. Piaskowa 27, 31-315 Kraków', 'PIZZA', '+48 000 000 000', 'New York Pizza'),
(7, 'ul. Konopnicka 42, 31-314 Kraków', 'POLISH', '+48 000 000 000', 'Polska pierogarnia'),
(8, '	ul. Keplina 101, 31-315 Kraków', 'BURGER', '+48 000 000 000', 'BEEF SISTERS'),
(9, '	ul. Reżyserska 176, 31-315 Kraków', 'KEBAB', '+48 000 000 000', 'Fabryka Kebaba'),
(10, 'ul. Trzeciego Maja 3, 31-315 Kraków', 'POLISH', '+48 000 000 000', 'Leczo u Ady'),
(11, '	ul. Kowalszczyzna 27, 31-315 Kraków', 'ITALIAN', '+48 000 000 000', 'Carbonara Premium'),
(12, '	ul. Struga Andrzeja 140, 31-315 Kraków', 'ASIAN', '+48 000 000 000', 'Bar Orientalny Phomg'),
(13, '	ul. Brzozowa 160, 31-315', 'BURGER', '+48 000 000 000', 'Zapieksy i Burgery'),
(14, '	ul. Kołobrzeska 92, 31-315 Kraków', 'AMERICAN', '+48 000 000 000', 'Alabama Fried Chicken'),
(15, 'ul. Franciszkańska 68, 31-315 Kraków', 'AMERICAN', '+48 000 000 000', 'McMata'),
(16, '	ul. Kukułek 169, 31-315 Kraków', 'KEBAB', '+48 000 000 000', 'Boss Kebab');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuser`
--

CREATE TABLE `tuser` (
  `userId` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tuser`
--

INSERT INTO `tuser` (`userId`, `email`, `lastname`, `login`, `name`, `pass`, `role`) VALUES
(1, 'admin@admin.pl', 'admin', 'admin123', 'admin', '$2a$12$w5CjeBmuyM0F25bCdW1yEO5rh831Yfrlww6CWGR7z7UDzAyXq4ggi', 0),
(4, 'adamnowak@email.com', 'Nowak', 'adanow123', 'Adam', '$2a$12$LwYS11it/elHqJIgmQCTMO/VmB54Kh7.g4Au6HxZt4wmkvDlcJ/wa', 1),
(5, 'marjew@email.com', 'Jewuła', 'marjew', 'Maria', '$2a$12$veWJJWAYZczXJhIIKxy4HepN26Q3ryJE9JuS3u2BqxGIDZKoiaHae', 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `titem`
--
ALTER TABLE `titem`
  ADD PRIMARY KEY (`itemId`),
  ADD KEY `FKo3ulwc4y8dsehjs198fblb0t4` (`restaurantId`);

--
-- Indeksy dla tabeli `trestaurant`
--
ALTER TABLE `trestaurant`
  ADD PRIMARY KEY (`restaurantId`);

--
-- Indeksy dla tabeli `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `titem`
--
ALTER TABLE `titem`
  MODIFY `itemId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT dla tabeli `trestaurant`
--
ALTER TABLE `trestaurant`
  MODIFY `restaurantId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT dla tabeli `tuser`
--
ALTER TABLE `tuser`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
