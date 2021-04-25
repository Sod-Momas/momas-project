CREATE TABLE brand(
       brandId INT NOT NULL PRIMARY KEY, --品牌id
       brandName VARCHAR2(30)            --品牌名字
);

CREATE TABLE carmodal(
       modelId INT NOT NULL PRIMARY KEY,--汽车型号id
       modalName VARCHAR2(30) NOT NULL ,--型号名
       brandId INT ,                   --品牌名
       FOREIGN KEY (brandId) REFERENCES brand(brandid)
) ;

CREATE TABLE carInfo(
       carId INT NOT NULL PRIMARY KEY ,--汽车id
       carName VARCHAR2(30) NOT NULL,	--汽车名
       carPrice NUMBER(32,2) NOT NULL,	--汽车价格
       carDisplacement VARCHAR2(30),	--汽车排量
       carModalId INT ,					--汽车型号id
       carClutch VARCHAR2(30),			--汽车换档(变速器)类型
       carColor VARCHAR2(30),			--汽车颜色
       FOREIGN KEY (carModalId) REFERENCES carModal(Modelid)
);
CREATE sequence hibernate_sequence START WITH 10;

INSERT INTO Brand VALUES(1,'大奔');
INSERT INTO Brand VALUES(2,'奥迪');
INSERT INTO Brand VALUES(3,'保时捷');
INSERT INTO Brand VALUES(4,'路虎');

COMMIT;

INSERT INTO carModal VALUES(1,'A级车',1);
INSERT INTO carModal VALUES(2,'B级旅行',1);
INSERT INTO carModal VALUES(3,'C级运动轿车',1);
INSERT INTO carModal VALUES(4,'GLA SUV',1);
INSERT INTO carModal VALUES(5,'A5 sportBack',2);
INSERT INTO carModal VALUES(6,'A8L W12',2);
INSERT INTO carModal VALUES(7,'Q5S',2);
INSERT INTO carModal VALUES(8,'奥迪TT Coupé',2);
INSERT INTO carModal VALUES(9,'911 Carrera',3);
INSERT INTO carModal VALUES(10,'911 Turbo S',3);
INSERT INTO carModal VALUES(11,'Panamera',3);
INSERT INTO carModal VALUES(12,'Cayenne',3);
INSERT INTO carModal VALUES(13,'718 Boxster',3);
INSERT INTO carModal VALUES(14,'全新揽胜星脉',4);
INSERT INTO carModal VALUES(15,'路虎揽胜',4);
INSERT INTO carModal VALUES(16,'路虎揽胜极光',4);
INSERT INTO carModal VALUES(17,'路虎发现神行',4);

COMMIT;