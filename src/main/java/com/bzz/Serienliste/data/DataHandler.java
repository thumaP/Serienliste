package com.bzz.Serienliste.data;

import com.bzz.Serienliste.model.Kategorie;
import com.bzz.Serienliste.model.Serie;
import com.bzz.Serienliste.model.Liste;
import com.bzz.Serienliste.service.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.awt.print.Book;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * data handler for reading and writing the csv files
 * <p>
 * M133: Serienliste
 *
 * @author Marcel Suter
 */

public class DataHandler {
    private static final DataHandler instance = new DataHandler();

    private static ArrayList<Serie> serien;
    private static ArrayList<Kategorie> kategorien;
    private static ArrayList<Liste> listen;

    /**
     * default constructor: defeat instantiation
     */
    private DataHandler() {
        Config.getProperty("serieJSON");
        Config.getProperty("kategorieJSON");
        Config.getProperty("listeJSON");
        serien = new ArrayList<Serie>();
        kategorien = new ArrayList<Kategorie>();
        listen = new ArrayList<Liste>();
        readJSON();
    }


    /**
     * reads a single series identified by its id

     * @return book-object
     */

    public static ArrayList<Serie> readSerien() {

        try {
            Gson gson = new Gson();

            Type serienListType = new TypeToken<ArrayList<Serie>>(){}.getType();
            serien = gson.fromJson(String.valueOf(serien), serienListType);





            BufferedReader reader = new BufferedReader(new FileReader(Config.getProperty("serieJSON")));

            serien = gson.fromJson(reader, new TypeToken<Serie>(){}.getType());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * saves a series
     * @param serie  the book to be saved
     */
    public static void saveSerie(Serie serie) {
        getserieMap().put(Integer.toString(serie.getSeriesID()), serie);
        writeJSON();
        String json = new Gson().toJson(serie);
    }

    /**
     * reads a single publisher identified by its uuid
     * @param listID  the identifier
     * @return publisher-object
     */
    public static Liste readListe(String listID) {
        Liste liste;
        if (getListemap().containsKey(listID)) {
            liste = getListemap().get(listID);
        }
        return null;
    }

    /**
     * saves a publisher
     * @param liste  the publisher to be saved
     */
    public static void saveListe(Liste liste) {
        getListemap().put(String.valueOf(liste.getListID()), liste);
        writeJSON();
    }

    /**
     * gets the serieMap
     * @return the serieMap
     */
    public static Map<String, Serie> getserieMap() {
        return null;
    }

    /**
     * gets the publisherMap
     * @return the publisherMap
     */
    public static Map<String, Liste> getListemap() {
        return null;
    }

    public static void setListemap(Map<String, Liste> listemap) {

        //DataHandler.listemap = listemap;
    }

    /**
     * reads the books and publishers
     */
    private static void readJSON() {

        try {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get("serieJSON"));

            //listemap = gson.fromJson(reader, Map.class);

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    /**
     * write the books and publishers
     *
     */
    private static void writeJSON() {

        try {
            //Examples:
            Kategorie adventure = new Kategorie("Adventure");
            Serie fortnite = new Serie(adventure, "Fortnite", "Eine Abenteuer Serie", 12, 7, false);

            serien.add(0, fortnite);

            Gson gson = new Gson();
            Writer writer = new FileWriter(Config.getProperty("serieJSON"));

            gson.toJson(serien, writer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

