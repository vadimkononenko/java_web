package com.itea.homeworks.hw3.requests;

import com.google.gson.Gson;
import com.itea.homeworks.hw3.models.Pet;
import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PetRequests {
    private static String urlPet = "http://petstore.swagger.io/v2/pet/";
    private static Logger log = Logger.getLogger(PetRequests.class);

    public int getPet(int id) throws IOException {
        URL url = new URL(urlPet + id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        return responseCode;
    }

    public int postPet(Pet pet) throws IOException {
        URL url = new URL(urlPet);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("content-type", "application/json");
        int responseCode = httpURLConnection.getResponseCode();

        try (DataOutputStream os = new DataOutputStream(httpURLConnection.getOutputStream())) {
            os.writeBytes((new Gson().toJson(pet)));
            os.flush();
        }

        return responseCode;
    }

    public int putPet(Pet pet) throws IOException {
        URL url = new URL(urlPet);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("content-type", "application/json");
        int responseCode = httpURLConnection.getResponseCode();

        try (OutputStream os = httpURLConnection.getOutputStream()) {
            os.write((new Gson().toJson(pet)).getBytes());
            os.flush();
        }

        return responseCode;
    }

    public int deletePet(int id) throws IOException {
        URL url = new URL(urlPet + id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("DELETE");
        int responseCode = httpURLConnection.getResponseCode();

        return responseCode;
    }
}
