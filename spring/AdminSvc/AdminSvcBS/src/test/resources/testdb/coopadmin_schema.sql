USE `coopadmin_unittest`;
DELIMITER $$
DROP PROCEDURE IF EXISTS truncateTables $$
CREATE PROCEDURE truncateTables()
BEGIN

  DECLARE n INT DEFAULT 0;
  DECLARE i INT DEFAULT 0;
  DECLARE q VARCHAR(2000);
  
  DROP TEMPORARY TABLE IF EXISTS tempTbl;
  CREATE TEMPORARY TABLE IF NOT EXISTS tempTbl  (
    `query` VARCHAR(50)
  );
  
	INSERT INTO tempTbl SELECT CONCAT('truncate table ',table_name,';')
	FROM INFORMATION_SCHEMA.TABLES
	WHERE TABLE_SCHEMA = 'coopadmin_unittest'
	AND TABLE_TYPE = 'BASE TABLE';
	
	SELECT COUNT(*) FROM tempTbl INTO n;
	SET i=0;
	WHILE i<n DO 
	  	SELECT query into @q FROM tempTbl LIMIT i,1;
	  	PREPARE stmt3 FROM @q;
		EXECUTE stmt3;
		DEALLOCATE PREPARE stmt3;
	  	SET i = i + 1;
	END WHILE;

END $$
DELIMITER ;

--CALL truncateTables();
