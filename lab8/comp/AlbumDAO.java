package org.example;

import java.sql.*;
import java.util.Arrays;

public class AlbumDAO {
    public void create(int year,String name, String artistName, int[] id_gen) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist , genre_ids ) values (?,?, ? , ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2,name);
            pstmt.setString(3,artistName);
            pstmt.setArray(4,con.createArrayOf("INTEGER", Arrays.stream(id_gen).boxed().toArray(Integer[]::new)));
            pstmt.executeUpdate();
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                    "select title from albums where id="+id)){
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id="+id)){
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
