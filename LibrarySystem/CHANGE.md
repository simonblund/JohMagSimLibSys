# Changelog and descriptions

## 05.05.2019, 08:00 SB
Added the last SQL tables, made a few changes to the ER implementation due to SQLite constraints this is esp. notable
in Primary Key handling. NO TABLES HAVE NATURAL KEYS AS PRIMARY KEYS due to performance troubles when not using
row id or row id derivates as PK:s.

See
http://www.sqlitetutorial.net/sqlite-primary-key/

@SQLite primary key and rowid table