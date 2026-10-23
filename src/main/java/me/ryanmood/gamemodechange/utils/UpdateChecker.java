package me.ryanmood.gamemodechange.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.ryanmood.gamemodechange.GamemodeChange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {

    private GamemodeChange plugin;

    public UpdateChecker(GamemodeChange plugin) {
        this.plugin = plugin;
    }

    public void updateCheck() {
        HttpURLConnection connection = null;
        try {
            connection = createHttpURLConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                throw new IOException("Update server returned HTTP " + responseCode);
            }
            String response = readFromInputStream(connection.getInputStream());

            JsonObject object = new JsonParser().parse(response).getAsJsonObject();
            if (object.has("plugins")) {
                JsonObject pluginsObject = object.get("plugins").getAsJsonObject();
                processPluginsInformation(pluginsObject);
            } else {
                this.plugin.getMessageUtil().sendConsole(true, "&cWrong response from update api, please report this to Ryan");
            }
        } catch (Exception e) {
            this.plugin.getMessageUtil().sendConsole(true, "&cFailed to get update check. (" + e.getMessage() + ")");
        } finally {
            if (connection != null) connection.disconnect();
        }
    }

    private HttpURLConnection createHttpURLConnection() throws IOException {
        String urlString = "https://updatecheck.ryanmood.me";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        return connection;
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder response = new StringBuilder();
            String input;
            while ((input = reader.readLine()) != null) {
                response.append(input);
            }
            return response.toString();
        }
    }

    private void processPluginsInformation(JsonObject plugins) {
        JsonObject info = plugins.get("GamemodeChange").getAsJsonObject();
        String version = info.get("version").getAsString();

        boolean sameVer = version.equals(this.plugin.getDescription().getVersion());

        if (!sameVer) {
            this.plugin.getMessageUtil().sendConsole(true, "&cYour &bGamemode Change &cversion &6(" + this.plugin.getDescription().getVersion() + ") &c is out of date! Newest version is: " + version);
        } else {
            this.plugin.getMessageUtil().sendConsole(true, "&aYour &bGamemode Change &ais on the latest version.");
        }
    }

}
