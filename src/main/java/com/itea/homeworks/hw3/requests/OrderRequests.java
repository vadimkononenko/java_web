package com.itea.homeworks.hw3.requests;

import com.google.gson.Gson;
import com.itea.homeworks.hw3.models.Order;
import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OrderRequests {
    private static String urlOrder = "https://petstore.swagger.io/v2/store/order/";
    private static Logger log = Logger.getLogger(OrderRequests.class);

    public int getOrder(int id) throws IOException {
        URL url = new URL(urlOrder+ id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        return responseCode;
    }

    public int postOrder(Order order) throws IOException {
        URL url = new URL(urlOrder);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("content-type", "application/json");
        int responseCode = httpURLConnection.getResponseCode();

        try (DataOutputStream os = new DataOutputStream(httpURLConnection.getOutputStream())) {
            os.writeBytes((new Gson().toJson(order)));
            os.flush();
        }

        return responseCode;
    }

    public int putOrder(Order order) throws IOException {
        URL url = new URL(urlOrder);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("content-type", "application/json");
        int responseCode = httpURLConnection.getResponseCode();

        try (OutputStream os = httpURLConnection.getOutputStream()) {
            os.write((new Gson().toJson(order)).getBytes());
            os.flush();
        }

        return responseCode;
    }

    public int deleteOrder(int id) throws IOException {
        URL url = new URL(urlOrder + id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("DELETE");
        int responseCode = httpURLConnection.getResponseCode();

        return responseCode;
    }
}
