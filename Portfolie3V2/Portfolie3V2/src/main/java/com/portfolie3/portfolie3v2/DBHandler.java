package com.portfolie3.portfolie3v2;

import java.sql.*;
import java.util.ArrayList;

public class DBHandler {

    Connection conn = null;
    DBHandler(){
        if(conn==null)open();
    }
    public void open(){
        try {
            String url = "jdbc:sqlite:logistics.sqlite";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("cannot open");
            if (conn != null) close();
        };
    }
    public void close(){
        try {
            if (conn != null) conn.close();
        } catch (SQLException e ) {
            System.out.println("cannot close");
        }
        conn=null;
    }
    public void cmd(String sql){
        if(conn==null)open();
        if(conn==null){System.out.println("No connection");return;}
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e ) {
            System.out.println("Error in statement "+sql);
        }
        try {
            if (stmt != null) { stmt.close(); }
        } catch (SQLException e ) {
            System.out.println("Error in statement "+sql);
        }
    }
    public ArrayList<String> query(String query, String fld){
        ArrayList<String> res=new ArrayList<>();
        if(conn==null)open();
        if(conn==null){System.out.println("No connection");return res;}
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(fld);
                res.add(name);

            }
        } catch (SQLException e ) {
            System.out.println("Error in statement "+query+" "+fld);
        }
        try {
            if (stmt != null) { stmt.close(); }
        } catch (SQLException e ) {
            System.out.println("Error in statement "+query+" "+fld);
        }
        return res;
    }
}

// the rs.next() method is used in a while loop to iterate over the rows of a ResultSet object.
//A ResultSet object represents the results of a SQL query that has been executed on a database.
// It can be thought of as a table of data, where each row represents a record, and each column represents a field.
// The next() method moves the cursor to the next row of the ResultSet, and returns true if there is another row to process, or false if there are no more rows.
