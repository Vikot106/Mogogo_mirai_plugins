package ink.moku.util;


import org.json.JSONObject;

public class JsonUtil {
    public String getCat(String jsonString) {
        jsonString = jsonString.substring(1,jsonString.length()-1);
        JSONObject j = new JSONObject(jsonString);
        try {
            String url = j.getString("url");
            return url;
        } catch (Exception e) {
            return getException();
        }
    }

    public String getDog(String jsonString) {
        JSONObject j = new JSONObject(jsonString);
        try {
            String url = j.getString("message");
            return url;
        } catch (Exception e) {
            return getException();
        }
    }

    public String getFox(String jsonString) {
        JSONObject j = new JSONObject(jsonString);
        try {
            String url = j.getString("image");
            return url;
        } catch (Exception e) {
            return getException();
        }
    }

    public String getException() {
        return "https://http.cat/404.jpg";
    }
}
