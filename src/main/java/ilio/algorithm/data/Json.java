package ilio.algorithm.data;

import com.google.gson.Gson;

public class Json {

    private static final Gson GSON = new Gson();

    public static String toJsonString(Object obj) {
        return GSON.toJson(obj);
    }
}
