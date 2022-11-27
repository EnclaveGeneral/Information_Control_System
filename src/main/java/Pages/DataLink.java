/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author godpo
 */
public class DataLink {
    
    private static Connection enclaveConnect;
    private static String userName = "root";
    private static String passWord = "300SLR";
    
    
    //Establishing the connection
    public static Connection getConnection()
    {
        
        String url = "jdbc:mysql://localhost:3306/enclavelibrary";
                
        //Connection enclaveConnect = null;
   
        /*MysqlDataSource enclaveDataSource = new MysqlDataSource();
        enclaveDataSource.setServerName(serverName);
        enclaveDataSource.setUser(userName);
        enclaveDataSource.setDatabaseName(dbName);
        enclaveDataSource.setPortNumber(portNumber);
        enclaveDataSource.setPassword(passWord); */
        
        try {
            enclaveConnect = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connection Success!");
        } catch (SQLException ex) {
            System.out.println("Could not connect to the database.");
            ex.printStackTrace();
        }
        
        return enclaveConnect;
    }
}
