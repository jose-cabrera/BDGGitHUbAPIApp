package com.deltadax.bdggithubapiapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deltadax.bdggithubapiapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReposFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String usuario;

    public ReposFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param usuario Parameter 1.
     * @return A new instance of fragment ReposFragment.
     */
    public static ReposFragment newInstance(String usuario) {
        ReposFragment fragment = new ReposFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, usuario);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuario = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repos, container, false);
    }

}
