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
public class DbaseAccount {
    String dbuser="root";
    String dbpass="";
    String dburl="http://localhost/phpmyadmin/db_structure.php?db=travelagency";
    Connection dbcon;
    void dbConnect() throws SQLException{
        dbcon=DriverManager.getConnection(dburl, dbuser,dbpass);
    }
    void dbClose() throws SQLException{
        dbcon.close();
    }
    public ResultSet getSourceCity() throws SQLException{
        dbConnect();
        String sql="select distinct source from flight";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    public ResultSet getDestinationCity() throws SQLException{
        dbConnect();
        String sql="select distinct destination from flight";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    public ResultSet getDepartureFlight(String s,String d) throws SQLException{
        dbConnect();
        String sql="select * from flight where source="+"'"+s+"'"+"and destination ="+"'"+d+"'";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst;
    }
    public ResultSet getReturnFlight(String s,String d) throws SQLException{
        dbConnect();
        String sql="select * from flight where source="+"'"+d+"'"+"and destination ="+"'"+s+"'";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst; 
    }
    public ResultSet finaldept(String s) throws SQLException{
        dbConnect();
        String sql="select departure,fare from flight where flightid="+"'"+s+"'";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst; 
    }
    public ResultSet finalreturn(String s) throws SQLException{
        dbConnect();
        String sql="select departure,fare from flight where flightid="+"'"+s+"'";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        ResultSet rst=pstmt.executeQuery();
        return rst; 
    }
    public int insertdata(String source,String destination,String departflightcode,String returnflightcode,double fare,String salutation,String firstname,String lastname,String contact) throws SQLException{
        int x;
        dbConnect();
        String sql="INSERT INTO travelagency.booking(source,destination,departflightcode,returnflightcode,fare,salutation,firstname,lastname,contact)VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt=dbcon.prepareStatement(sql);
        pstmt.setString(1, source);
        pstmt.setString(2, destination);
        pstmt.setString(3, departflightcode);
        pstmt.setString(4, returnflightcode);
        pstmt.setDouble(5, fare);
        pstmt.setString(6, salutation);
        pstmt.setString(7, firstname);
        pstmt.setString(8, lastname);
        pstmt.setString(9, contact);
        x=pstmt.executeUpdate();
        return x;
    }
}
