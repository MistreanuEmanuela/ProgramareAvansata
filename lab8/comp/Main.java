package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database.createConnection();
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            System.out.println(artists.findById(1));
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            var albums = new AlbumDAO();
            int[] a={1,2};
            albums.create(1979, "The Wall", "Pink Floyd",a);
            int[] a2={1,3};
            albums.create(1982, "Thriller", "Michael Jackson",a2);
            Database.getConnection().commit();
            Database.getConnection().close();
           // Database.rollback();
        } catch (SQLException e) {
            System.err.println(e);

        }
    }
}