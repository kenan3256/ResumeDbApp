package org.example.AbstractDao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public  Connection connection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "admin";
        Connection c = DriverManager.getConnection(url,username,password);
        return c;
    }
}
