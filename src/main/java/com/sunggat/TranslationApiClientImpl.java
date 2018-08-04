package com.sunggat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class TranslationApiClientImpl implements TranslationApiClient {

    @Override
    public TranslationResult translate(String text) {

        TranslationResult translationResult = null;
        try {
            InputStream response = openConnection(text).getInputStream();
            translationResult = parse(response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return translationResult;
    }

    private HttpsURLConnection openConnection(String text) throws IOException {
        String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/translate" +
                "?key=trnsl.1.1.20180731T082120Z.348b4012bd6bc9ec.1a8d74df1a8f740892d84cbcfdcc6ef5ef330a6d";

        URL urlObj = new URL(urlStr);

        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(text, "UTF-8") + "&lang=en-ru");

        return connection;
    }

    private TranslationResult parse(InputStream response) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(new JsonReader(new InputStreamReader(response))).getAsJsonObject();

        int code = jsonObject.get("code").getAsInt();
        String lang = jsonObject.get("lang").getAsString();
        String translatedText = jsonObject.get("text").getAsString();

        return new TranslationResult(code, lang, translatedText);
    }
}
