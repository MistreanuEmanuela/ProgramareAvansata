package org.example;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.exceptions.CsvValidationException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectionPool.init();
        String csvFilePath = "C:\\Users\\My Pc\\Desktop\\albumlist.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] row;
            String[] header = reader.readNext(); // Read column headers
            while ((row = reader.readNext()) != null) {
                    var an = row[1];
                    System.out.println(an);
                    int year = Integer.parseInt(an);
                    String album = row[2];
                    String artist = row[3];
                    var artists = new ArtistDAO();
                    artists.create(artist);
                    var albums = new AlbumDAO();
                    albums.create(year, album, artists.findByName(artist));
                    String gen[]=new String[]{row[4]};
                    for (String element : gen) {
                    var genr=new GenreDAO();
                    genr.create(element);
                    var g=new GenreTabDAO();
                   // int nr= Integer.parseInt(row[0]);
                 //   g.create(genr.findByName(element), nr );
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ConnectionPool.getConn().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionPool.closeConnection();
    }
    }