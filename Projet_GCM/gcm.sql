-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 16 Décembre 2017 à 00:44
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gcm`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE IF NOT EXISTS `consultation` (
  `idconsultation` int(15) NOT NULL AUTO_INCREMENT,
  `nom_maladie` varchar(20) NOT NULL,
  `prescription_medicale` varchar(50) NOT NULL,
  `observation` varchar(50) NOT NULL,
  `analyse` varchar(50) NOT NULL,
  `date_consultation` varchar(12) NOT NULL,
  `numero_cnam` int(6) NOT NULL,
  PRIMARY KEY (`idconsultation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=121 ;

--
-- Contenu de la table `consultation`
--

INSERT INTO `consultation` (`idconsultation`, `nom_maladie`, `prescription_medicale`, `observation`, `analyse`, `date_consultation`, `numero_cnam`) VALUES
(1, 'ali', 'doliprane/stopalgic', '3 fois/jours', '--', '0000-00-00', 258963),
(112, 'ali ', 'doliprane/stopalgic', '3 fois/jours', '--', '0000-00-00', 987456),
(117, 'aaaaa', 'aaaaaaaa', 'aaaaaaa', 'nnnnnnnnnn', '2017-12-02', 789654),
(118, 'a', 'a', 'a', 'a', '2017-12-07', 14),
(119, 'ayadi', '--', '--', '--', '2017-12-12', 12456),
(120, 'a', 'a', 'a', 'a', '2017-12-23', 78888);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `referencefacture` int(15) NOT NULL,
  `montant` float NOT NULL,
  `nompatient` varchar(20) NOT NULL,
  `date_paiement` varchar(12) NOT NULL,
  PRIMARY KEY (`referencefacture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`referencefacture`, `montant`, `nompatient`, `date_paiement`) VALUES
(789654, 95, 'aaaaa', '2017-12-15'),
(125478963, 54, 'roufaida', '2017-12-22');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE IF NOT EXISTS `medecin` (
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medecin`
--

INSERT INTO `medecin` (`login`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `numcnam` int(6) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `tel` int(14) NOT NULL,
  `date_naissance` varchar(12) NOT NULL,
  `maladie_chronique` varchar(50) NOT NULL,
  `sang` varchar(5) NOT NULL,
  PRIMARY KEY (`numcnam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `patient`
--

INSERT INTO `patient` (`numcnam`, `nom`, `prenom`, `adresse`, `mail`, `tel`, `date_naissance`, `maladie_chronique`, `sang`) VALUES
(9, 'jj', 'p', 'o', 'i', 8, '2017-12-02', 'k', 'j'),
(77, 'a', 'a', 'a', 'a', 11, '2017-12-01', 'a', 'a'),
(89652, 'salhi', 'roufaida', 'tunis', 'salhi@gmail.com', 123457, '1994-08-13', '--', 'o+'),
(147258, ' ayadi', 'khouloud', 'sousse', 'ayadikhouloud@gmail.com', 93593324, '2017-12-06', '--', 'o+'),
(528796, 'amal', 'amal', 'kairouan', 'amalamal@yahoo.fr', 65423178, '2017-12-12', 'diabete', 'A'),
(789657, 'afef', 'ferchichi', 'hammam sousse', 'afef12@gmail.com', 14785236, '2017-12-19', 'diabete', 'o-'),
(895421, 'manel', 'manel', 'sousse,hammam sousse', 'manel@yahoo.fr', 98752317, '2017-12-28', '--', 'o-');

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE IF NOT EXISTS `rdv` (
  `idrdv` int(15) NOT NULL AUTO_INCREMENT,
  `date` varchar(12) NOT NULL,
  `heure` varchar(12) NOT NULL,
  `nom_patient` varchar(20) NOT NULL,
  PRIMARY KEY (`idrdv`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `rdv`
--

INSERT INTO `rdv` (`idrdv`, `date`, `heure`, `nom_patient`) VALUES
(1, '2017-12-02', '09:23', 'khouloud'),
(2, '2017-12-02', '09:23', 'afef ferchichi'),
(3, '2017-12-02', '09:23', 'roufaida salhi'),
(4, '2017-12-02', '09:23', 'samar samar'),
(12, '2017-12-02', '09:23', 'd MMM yyyy'),
(13, '2017-12-02', '09:23', '2017-12-14'),
(14, 'aaaaaaaaa', '12:36', '2017-12-08');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
