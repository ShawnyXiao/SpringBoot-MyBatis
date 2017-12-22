-- --------------------------------------------------------
-- ホスト:                          127.0.0.1
-- サーバーのバージョン:                   5.7.19-log - MySQL Community Server (GPL)
-- サーバー OS:                      Win64
-- HeidiSQL バージョン:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- spring_boot_mybatis のデータベース構造をダンプしています
CREATE DATABASE IF NOT EXISTS `spring_boot_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spring_boot_mybatis`;

--  テーブル spring_boot_mybatis.book の構造をダンプしています
CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_store_id` bigint(20) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `author` varchar(80) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `topic` varchar(80) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- テーブル spring_boot_mybatis.book: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `book_store_id`, `name`, `author`, `price`, `topic`, `publish_date`) VALUES
	(1, 1, '社会研究方法教程', '袁方', 68.00, '社会学', '2015-03-01 00:00:00'),
	(2, 1, '66666', '高德纳', 108.00, '数据结构', '2014-02-13 00:00:00'),
	(3, 1, 'Java核心技术Ⅰ', 'Cay', 93.00, '编程语言', '2011-06-14 00:00:00'),
	(4, 1, '现代操作系统', 'William', 56.50, '操作系统', '2016-08-23 00:00:00'),
	(5, 1, 'Head First设计模式', 'Freeman', 32.00, '设计模式', '2013-10-15 00:00:00'),
	(6, 1, '学习OpenCV', 'Bradski', 46.00, '技术', '2014-02-13 00:00:00'),
	(7, 1, '小王子', '周克希', 15.00, '文学', '2008-07-13 00:00:00'),
	(8, 1, 'Effective Java', 'Bloch', 38.00, '编程语言', '2014-12-03 00:00:00'),
	(9, 1, '编程珠玑', 'Jon', 36.00, '数据结构', '2013-12-03 00:00:00'),
	(10, 1, 'SQL必知必会', 'Ben', 13.00, '数据库', '2015-08-26 00:00:00'),
	(11, 1, '编译器设计', 'Kelth', 59.00, '编译器', '2014-08-13 00:00:00');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

--  テーブル spring_boot_mybatis.book_store の構造をダンプしています
CREATE TABLE IF NOT EXISTS `book_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- テーブル spring_boot_mybatis.book_store: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `book_store` DISABLE KEYS */;
INSERT INTO `book_store` (`id`, `name`, `address`) VALUES
	(1, '新华书店', '湖北省武汉市洪山区文秀街131号');
/*!40000 ALTER TABLE `book_store` ENABLE KEYS */;

--  テーブル spring_boot_mybatis.user の構造をダンプしています
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- テーブル spring_boot_mybatis.user: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`) VALUES
	(1, 'shawn', 'fucksecurity');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
