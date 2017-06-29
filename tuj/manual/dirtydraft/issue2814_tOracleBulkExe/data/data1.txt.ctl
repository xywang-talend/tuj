OPTIONS ()
LOAD DATA
CHARACTERSET 'WE8ISO8859P15'
INFILE 'E:/Trunk/tuj/java/issue2814_tOracleBulkExe/data/data1.txt'
BADFILE 'E:/Trunk/tuj/java/issue2814_tOracleBulkExe/data/data1.txt.bad'
DISCARDFILE 'E:/Trunk/tuj/java/issue2814_tOracleBulkExe/data/data1.txt.dsc'
INTO TABLE table_m2ugSG
TRUNCATE
FIELDS TERMINATED BY ";"
("id", 
"text")
