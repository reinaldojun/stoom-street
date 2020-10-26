CREATE TABLE street (
  id int NOT NULL AUTO_INCREMENT,
  street_name varchar(100) DEFAULT NULL,
  number int DEFAULT NULL,
  complement varchar(100) DEFAULT NULL,
  neighbourhood varchar(100) DEFAULT NULL,
  city varchar(60) DEFAULT NULL,
  state varchar(20) DEFAULT NULL,
  country varchar(60) DEFAULT NULL,
  zipcode varchar(8) DEFAULT NULL,
  latitude double DEFAULT NULL,
  longitude double DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
