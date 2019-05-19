# Changelog and descriptions

## 19.05.2019 19:26 SB
- Added signinuserpanel.
- Tip, to use the same window for panels look at the implementation of Mainframe in homepanel and signinpanel.
- HomePanel LOCKED by itemDAO for paperItem.

## 16.05.2019 10:02 MF
- Added empty LoanControl. No implemented methods, only declaration for methods in class diagram.
- Added a simple LoanTerminal, preview runs first in App.

## 14.05.2019 16:32 MF
- Updated LoanTest, now working test for insertLoan. 
- Added method findOverDueLoans in LoanDAO

## 15.05.2019 SB 13:09
- Added ViewProperties
- Colors: https://material.io/tools/color/#!/?view.left=1&view.right=0&primary.color=2962FF&secondary.color=43A047
- About material https://material.io/design/
- The view properties also contain window sizes.

## 10.05.2019 SB 17:45
- Added AuthControl with the sign in functionality.


## 09.05.2019 SB 23:55
- Added functions for finding users and staff from email address.

## 09.05.2019 SB 16:30
- For multiple inserts in one DAO save function check my solution for StaffDAO saveStaff.
- Started with the StaffDAO and Stafftest. To be continued.


## 09.05.2019 SB 14:44
- Fixed problem with DBconnection being closed if running two updates during the same initiation.
- Fixed user tests.
- Fixed Tests not being able to connect to DB.

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