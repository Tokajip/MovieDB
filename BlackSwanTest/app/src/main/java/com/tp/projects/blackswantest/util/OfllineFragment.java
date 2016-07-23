package com.tp.projects.blackswantest.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tp.projects.blackswantest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OfllineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OfllineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfllineFragment extends Fragment {

    public OfllineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_oflline, container, false);
    }

}