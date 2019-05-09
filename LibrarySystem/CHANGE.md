# Changelog and descriptions

## 09.05.2019 MF
- Changed date-format in Loan to LocalDate
- Updated LoanDao findLoanFromUserID to filter out loans who has been returned

## 08.05.2019 SB
- Added more functions to the user DAO.
- Fixed STATE in the COPY-DB table now doing int 0 = available, 1= loaned out, 2= deprecated.


## 08.05.2019 10:54 JN
copy.java added

## 06.05.2019 10:36 MF
Made first draft of entity class Loan + LoanDAO based on User + UserDAO. Unsure on how to handle date – as a String, 
or Date-Object? 


## 05.05.2019 16:33 SB
Made the first entity class (User) and its DAO, select using firstname and lastname works flawlessly.
Not added unittests but commits anyway just so you can see how I went about it. :)

## 05.05.2019 12:54 SB
Added a logger function, so to use the logger for debugging and log handling use the LibraryLogger logger and use
appropriate log level and readable log messages.

## 05.05.2019, 08:00 SB
Added the last SQL tables, made a few changes to the ER implementation due to SQLite constraints this is esp. notable
in Primary Key handling. NO TABLES HAVE NATURAL KEYS AS PRIMARY KEYS due to performance troubles when not using
row id or row id derivates as PK:s.

See
http://www.sqlitetutorial.net/sqlite-primary-key/

@SQLite primary key and rowid table