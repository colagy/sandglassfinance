CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `type` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL unique,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

