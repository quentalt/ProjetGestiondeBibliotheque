-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 28 nov. 2020 à 13:41
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `CodeBarreExemplaire` int(11) NOT NULL,
  `CodeBarreEmprunteur` int(11) NOT NULL,
  `DateRetourMax` date NOT NULL,
  `DateRetour` date NOT NULL,
  `IDEmprunt` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`IDEmprunt`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emprunteur`
--

DROP TABLE IF EXISTS `emprunteur`;
CREATE TABLE IF NOT EXISTS `emprunteur` (
  `CodeBarre` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(10) NOT NULL,
  `Prenom` varchar(10) NOT NULL,
  `Adresse` varchar(35) NOT NULL,
  `EMail` varchar(25) NOT NULL,
  PRIMARY KEY (`CodeBarre`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emprunteur`
--

INSERT INTO `emprunteur` (`CodeBarre`, `Nom`, `Prenom`, `Adresse`, `EMail`) VALUES
(1, 'Smith', 'John', 'Boussainville', 'John.Smith@johnSmith.com'),
(3, 'You', 'Michael', 'Paris', 'michaelyou@yahoo.fr');

-- --------------------------------------------------------

--
-- Structure de la table `ouvrage`
--

DROP TABLE IF EXISTS `ouvrage`;
CREATE TABLE IF NOT EXISTS `ouvrage` (
  `CodeBarre` int(11) NOT NULL AUTO_INCREMENT,
  `Auteur` varchar(20) NOT NULL DEFAULT 'Jane Doe',
  `Titre` varchar(20) NOT NULL,
  `Prix` float NOT NULL,
  `Resume` varchar(300) NOT NULL DEFAULT 'Le livre est super bien',
  `MotsClefs` varchar(30) NOT NULL,
  `DateDAchat` date DEFAULT NULL,
  `DureeDeVie` int(11) DEFAULT '10',
  PRIMARY KEY (`CodeBarre`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ouvrage`
--

INSERT INTO `ouvrage` (`CodeBarre`, `Auteur`, `Titre`, `Prix`, `Resume`, `MotsClefs`, `DateDAchat`, `DureeDeVie`) VALUES
(1, 'J.K. Rowling', 'Harry Potter', 20, 'Harry va a l\'ecole des sorciers', 'sorcier, magie, jeune enfant', '2020-11-10', 100),
(2, 'Tolkien', 'Le Silmarillon', 15, 'Livre racontant l\'histoire du premier Age de la Terre du Milieu', 'Morgoth, Valar, Sauron, Maiar', '2020-02-18', 50);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
