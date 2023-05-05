package org.example;

import java.sql.*;
import java.util.Arrays;

public class AlbumDAO {
    public void create(int year,String name, int artistid) throws SQLException {
        Connection con = ConnectionPool.getConn();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums_import (year, title, artist_id ) values (?,?, ? )")) {
            pstmt.setInt(1, year);
            pstmt.setString(2,name);
            pstmt.setInt(3,artistid);
            pstmt.executeUpdate();
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = ConnectionPool.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = ConnectionPool.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id="+id)){
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
