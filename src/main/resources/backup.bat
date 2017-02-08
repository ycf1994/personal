@echo off
set "Ymd=%date:~,4%%date:~5,2%%date:~8,2%"
C:\mysqldump --opt -u root --password=root tongniu> D:/db_backup/tongniu_%Ymd%.sql
@echo on