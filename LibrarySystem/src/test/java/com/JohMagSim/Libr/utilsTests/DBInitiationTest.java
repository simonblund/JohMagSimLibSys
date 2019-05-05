package com.JohMagSim.Libr.utilsTests;

import com.JohMagSim.Libr.utils.*;
import org.junit.*;

import java.sql.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

public class DBInitiationTest {

    /**
     * This function tests that there are 10 tables in the database after the initialisation-script is run.
     * It's not a very good test, but it does what it is supposed to.
     */
    @Test
    public void createTablesTest(){
        DBInitiation.createTables();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT \n" +
                "    COUNT(name)\n" +
                "FROM \n" +
                "    sqlite_master \n" +
                "WHERE \n" +
                "    type ='table' AND \n" +
                "    name NOT LIKE 'sqlite_%';";
        ResultSet rs = null;
        int tables = 0;

        try{
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            tables = rs.getInt(1);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            assertEquals(tables, 10);
            DBConnection.closeConnection(connection);
        }


    }
}

