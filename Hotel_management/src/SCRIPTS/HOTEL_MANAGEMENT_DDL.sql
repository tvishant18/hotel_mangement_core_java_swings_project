CREATE TABLE `bill_info` (
  `bill_no` int(11) NOT NULL,
  `table_no` int(11) NOT NULL,
  `department` varchar(45) NOT NULL,
  `guest_name` varchar(45) NOT NULL,
  `pax` int(11) NOT NULL,
  `steward_id` int(11) NOT NULL,
  `steward_name` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `discount` float NOT NULL,
  `service_tax` float NOT NULL,
  `total_after_discount` float NOT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `kitchen_order_ticket` (
  `kot_no` int(11) NOT NULL,
  `table_no` int(11) NOT NULL,
  `item_code` varchar(45) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `quantity` float NOT NULL,
  `price` float NOT NULL,
  `date` varchar(45) NOT NULL,
  `Department` varchar(45) NOT NULL,
  `steward_id` int(11) NOT NULL,
  `steward_name` varchar(45) NOT NULL,
  `vat` float NOT NULL,
  `sr no` int(11) NOT NULL AUTO_INCREMENT,
  `total_price` float NOT NULL,
  `total_cost` float NOT NULL,
  `s_no` int(11) NOT NULL,
  PRIMARY KEY (`sr no`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
CREATE TABLE `kot_record` (
  `sr_no` int(11) NOT NULL AUTO_INCREMENT,
  `Kot_no` int(11) NOT NULL,
  `table_no` int(11) NOT NULL,
  `item_code` varchar(45) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `quantity` float NOT NULL,
  `date` varchar(45) NOT NULL,
  `vat` float NOT NULL,
  `price` float NOT NULL,
  `department` varchar(45) NOT NULL,
  `steward_id` int(11) NOT NULL,
  `steward_name` varchar(45) NOT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`sr_no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
CREATE TABLE `master_info_table` (
  `master_name` varchar(10) NOT NULL,
  `master_password` varchar(45) NOT NULL,
  `secret_ques` varchar(45) NOT NULL,
  `secret_ans` varchar(45) NOT NULL,
  PRIMARY KEY (`master_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `menu` (
  `item_code` varchar(5) NOT NULL,
  `item` varchar(45) NOT NULL,
  `dept` varchar(45) NOT NULL,
  `price(in RS)` float NOT NULL,
  `VAT` float NOT NULL,
  `total_price` float DEFAULT NULL,
  PRIMARY KEY (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `steward_boy_details` (
  `steward_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`steward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `table_info` (
  `table_no` int(11) NOT NULL,
  `guest_name` varchar(45) DEFAULT NULL,
  `pax` int(11) DEFAULT NULL,
  `Availiability` varchar(45) NOT NULL,
  `Date_time` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `Steward_id` int(11) NOT NULL,
  `Steward_name` varchar(45) NOT NULL,
  PRIMARY KEY (`table_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
