package org.example;

import java.sql.*;

public class ArtistDAO {
    public void create(String name) throws SQLException {
        Connection con = ConnectionPool.getConn();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists_import (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = ConnectionPool.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists_import where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = ConnectionPool.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artist where id="+id)){
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
