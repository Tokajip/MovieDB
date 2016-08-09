package com.tp.projects.moviedb.persons;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.tp.projects.moviedb.MainActivity;
import com.tp.projects.moviedb.R;
import com.tp.projects.moviedb.util.GeneralRetrofitResponseHandler;
import com.tp.projects.moviedb.util.JSONParser;
import com.tp.projects.moviedb.util.NetworkHandler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonsFragment extends Fragment {

    private Context ctx;
    private List<PersonData> personList;
    private View mainView;

    public PersonsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = getActivity();
        NetworkHandler.getInstance().downloadPersonDataRetrofit(createPersonDBResponseHandler());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment, container, false);
        return mainView;
    }


    private GeneralRetrofitResponseHandler createPersonDBResponseHandler() {
        return new GeneralRetrofitResponseHandler(getActivity()) {
            @Override
            public void responseHandler(Call<JsonElement> mCall, Response<JsonElement> mResponse) {
                parsePersonJSONData(mResponse.body().getAsJsonObject());
                initializeTileLayout();
            }
        };
    }


    private void parsePersonJSONData(JsonObject result) {
        personList = new ArrayList<>();
        JsonArray jsonList = result.getAsJsonArray("results");
        for (JsonElement personJSON : jsonList) {
            PersonData person = (PersonData) JSONParser.returnParsedClass(personJSON, PersonData.class);
            person.setImageURLs();
            personList.add(person);
        }
    }

    private void initializeTileLayout() {
        RecyclerView recyclerView = (RecyclerView) mainView.findViewById(R.id.tiles_container);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
            recyclerView.setAdapter(new PersonTilesAdapter(ctx, personList));
        }
    }


}