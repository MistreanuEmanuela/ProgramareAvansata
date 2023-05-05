package org.example;

import java.sql.*;

public class GenreTabDAO {

        public void create(int id1, int id2) throws SQLException {
            Connection con = ConnectionPool.getConn();
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into album_genres_import (album_id, genre_id) values (?, ?)")) {
                pstmt.setInt(1, id1);
                pstmt.setInt(1, id2);
                pstmt.executeUpdate();
            }
        }
        public Integer findByName(String name) throws SQLException {
            Connection con = ConnectionPool.getConn();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select id from genres where name='" + name + "'")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        public String findById(int id) throws SQLException {
            Connection con = ConnectionPool.getConn();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from genres where id="+id)){
                return rs.next() ? rs.getString(1) : null;
            }
        }
    }

