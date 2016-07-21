package com.tp.projects.blackswantest.util;

import android.content.Context;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.tp.projects.blackswantest.R;

/**
 * Created by Peti on 2016. 07. 21..
 */
public class NetworkHandler {

    private static String baseURL;
    private static String apiKey;
    private static String imageBaseUrl;
    private static String imageWidth = "w154";

    public static String getBaseURL() {
        return baseURL;
    }

    public static String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public static String createGETUrl(String path) {
        return baseURL + path + "?api_key=" + apiKey;
    }

    public static String createImageURL(String path) {
        return imageBaseUrl+imageWidth+path;
    }

    public static void initialize(Context context) {
        baseURL = context.getString(R.string.base_url);
        apiKey = context.getString(R.string.api_key);
    }

    public static void downloadMovieData(Context ctx, FutureCallback<JsonObject> responseHandler) {
        Ion.with(ctx)
                .load(NetworkHandler.createGETUrl("movie/top_rated"))
                .asJsonObject()
                .setCallback(responseHandler);
    }

    public static void downloadConfig(Context ctx, FutureCallback<JsonObject> responseHandler) {
        Ion.with(ctx)
                .load(NetworkHandler.createGETUrl("configuration"))
                .asJsonObject()
                .setCallback(responseHandler);
    }

    public static void initializeMovieDB(String url) {
        imageBaseUrl = url;
    }

}