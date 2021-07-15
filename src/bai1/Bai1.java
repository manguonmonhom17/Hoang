/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Hoang Pham
 */
public class Bai1 {

    public static void main(String[] args) throws SQLException {
        var server = "DESKTOP-Q2K97E5";
        var user = "sa";
        var pass = "123456";
        var db= "SanPham";
        var port = 1433;
        SQLServerDataSource ds= new SQLServerDataSource();
        ds.setServerName(server);
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setDatabaseName(db);
        ds.setPortNumber(port);
        try( Connection conn = ds.getConnection())
        {
            System.out.println("kết nối thành công");
            System.out.println(conn.getCatalog());
		Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from SanPham");
            // show data
            while (rs.next()) {
                System.out.println(rs.getString("MaSP") + "  " + rs.getString("TenSP")
                        + "  " + rs.getString("NhaSX") + " " + rs.getString("MaLoaiSP"));
            }
            // close connection
            conn.close();
        }catch(SQLException ex)
        {
        ex.printStackTrace();       
        }

    }
   
	    

    
    
}
