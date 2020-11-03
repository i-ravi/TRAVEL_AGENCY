/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ravisharma
 */
public class DbAccount {
    
    String dbusername="root";
    String dbpassword="";
    String dburl="jdbc:mysql://localhost:3306/travelagency?";
    String dbdriver="com.mysql.jdbc.Driver";
    
    Connection dbcon;
    
    public void dbConnect() throws SQLException, ClassNotFoundException{
        Class.forName(dbdriver);
        dbcon=DriverManager.getConnection(dburl, dbusername, dbpassword);
        
    }
    
    public void dbclose() throws SQLException{
        dbcon.close();
    }
    
    public ResultSet getSourceCity() throws SQLException, ClassNotFoundException{
        dbConnect();
        String sql="select distinct source from flight";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    
    public ResultSet getDestinationCity() throws SQLException, ClassNotFoundException{
        dbConnect();
        String sql="select distinct destination from flight";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    
    public ResultSet getDepartureFlight(String s,String d) throws SQLException, ClassNotFoundException{
        dbConnect();
        String sql="select * from flight where source="+"'"+s+"'"+"and destination="+"'"+d+"'";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    
    public ResultSet getReturnFlight(String s,String d) throws SQLException, ClassNotFoundException{
        dbConnect();
        String sql="select * from flight where source="+"'"+d+"'"+"and destination="+"'"+s+"'";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    
    public ResultSet finaldepart(String s) throws ClassNotFoundException, SQLException{
        dbConnect();
        String sql = "select departtime,fare from flight where flightid = '" + s + "'" ;
        PreparedStatement pstmt = dbcon.prepareStatement(sql); 
        ResultSet rst = pstmt.executeQuery();
        return rst; 
    }
    
    public ResultSet finalreturn(String s) throws ClassNotFoundException, SQLException{
        dbConnect();
        String sql = "select departtime,fare from flight where flightid = '" + s + "'" ;
        PreparedStatement pstmt = dbcon.prepareStatement(sql);
        ResultSet rst = pstmt.executeQuery();
        return rst; 
    }
    
    public int insertdata(String source, String destination, String departflightcode, String returnflightcode, double fare, String salutation,String firstname,String lastname, String contact) throws ClassNotFoundException, SQLException{
        int x;
        dbConnect();
        String sql = "INSERT INTO travelagency.bookings ( source, destination, departflightcode, returnflightcode,fare,salutation,firstname,lastname,contact)VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = dbcon.prepareStatement(sql);
        pstmt.setString(1, source);
        pstmt.setString(2, destination);
        pstmt.setString(3, departflightcode);
        pstmt.setString(4, returnflightcode); 
        pstmt.setDouble(5, fare); 
        pstmt.setString(6, salutation); 
        pstmt.setString(7, firstname); 
        pstmt.setString(8, lastname); 
        pstmt.setString(9, contact);
        x= pstmt.executeUpdate();
        return(x);
    }
    
    public int insertdata1(String s1,String s2,String s3,String s4,String s5,String s6) throws SQLException, ClassNotFoundException{
        int x;
        dbConnect();
        String sql="INSERT INTO travelagency.hotelbookings (contact,salutation,firstname,lastname,fare,date) VALUES (?,?,?,?,?,?)";
        PreparedStatement pstmt1 = dbcon.prepareStatement(sql);
        pstmt1.setString(1, s1);
        pstmt1.setString(2, s2);
        pstmt1.setString(3, s3);
        pstmt1.setString(4, s4); 
        pstmt1.setString(5, s5); 
        pstmt1.setString(6, s6); 
        x= pstmt1.executeUpdate();
        return(x);
    }


}
