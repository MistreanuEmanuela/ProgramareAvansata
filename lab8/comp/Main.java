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
            String album="alb";
            int i=1;
            while(album!=null)
            {
                album=albums.findById(i);
                System.out.println(albums.findById(i));
                i++;
            }
            Database.getConnection().commit();
            Database.getConnection().rollback();
            Database.getConnection().close();
            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);

        }
    }
}
