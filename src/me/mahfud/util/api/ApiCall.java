package me.mahfud.util.api;

import me.mahfud.util.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiCall {

    public String getApiResult(String uri) {
        try {
            URL url = new URL(Constant.BASE_URL + uri);

            URLConnection urlConnection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuilder inputLine = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                inputLine.append(line);
            }

            in.close();

            return inputLine.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Constant.BLANK_STRING;
    }
}
