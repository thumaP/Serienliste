package com.bzz.Serienliste.data;


import com.bzz.Serienliste.model.Serie;
import com.bzz.Serienliste.model.Liste;
import com.bzz.Serienliste.service.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private static Map<String, Serie> serieMap;
    private static Map<String, Liste> listemap;

    /**
     * default constructor: defeat instantiation
     */
    private DataHandler() {
        serieMap = new HashMap<>();
        listemap = new HashMap<>();
        readJSON();
    }

    /**
     * reads a single book identified by its uuid
     * @param bookUUID  the identifier
     * @return book-object
     */
    public static Serie readSerie(String bookUUID) {
        Serie serie = new Serie();
        if (getserieMap().containsKey(bookUUID)) {
            serie = getserieMap().get(bookUUID);
        }
        return serie;
    }

    /**
     * saves a series
     * @param serie  the book to be saved
     */
    public static void saveSerie(Serie serie) {
        getserieMap().put(serie.getSeriesID(), serie);
        writeJSON();
    }

    /**
     * reads a single publisher identified by its uuid
     * @param listID  the identifier
     * @return publisher-object
     */
    public static Liste readListe(String listID) {
        Liste liste = new Liste();
        if (getListemap().containsKey(listID)) {
            liste = getListemap().get(listID);
        }
        return liste;
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
        return serieMap;
    }

    /**
     * gets the publisherMap
     * @return the publisherMap
     */
    public static Map<String, Liste> getListemap() {
        return listemap;
    }

    public static void setListemap(Map<String, Liste> listemap) {
        DataHandler.listemap = listemap;
    }

    /**
     * reads the books and publishers
     */
    private static void readJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(Config.getProperty("serieJSON")));
            ObjectMapper objectMapper = new ObjectMapper();
            Serie[] series = objectMapper.readValue(jsonData, Serie[].class);

            for (Serie serie : series) {
                int serienID = serie.getSeriesID();
                Liste liste;

                if (getListemap().containsKey(serienID)) {
                    liste = getListemap().get(publisherUUID);

                }
                else {
                    publisher = book.getPublisher();
                    getPublisherMap().put(publisherUUID, publisher);
                }

                book.setPublisher(publisher);
                getserieMap().put(book.getBookUUID(), book);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * write the books and publishers
     *
     */
    private static void writeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer;
        FileOutputStream fileOutputStream = null;

        String bookPath = Config.getProperty("serieJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectMapper.writeValue(writer, getserieMap().values());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}



    private static void readJSON() {
        try {

            byte[] jsonData = Files.readAllBytes(Paths.get(Config.getProperty("bookJSON")));
            ObjectMapper objectMapper = new ObjectMapper();
            Liste[] listen = objectMapper.readValue(jsonData, Liste[].class);

            for (Serie serie : listen) {

                String publisherUUID = book.getPublisher().getPublisherUUID();
                Publisher publisher;

                if (getPublisherMap().containsKey(publisherUUID)) {
                    publisher = getPublisherMap().get(publisherUUID);

                }
                else {
                    publisher = book.getPublisher();
                    getPublisherMap().put(publisherUUID, publisher);
                }

                book.setPublisher(publisher);
                getBookMap().put(book.getBookUUID(), book);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }