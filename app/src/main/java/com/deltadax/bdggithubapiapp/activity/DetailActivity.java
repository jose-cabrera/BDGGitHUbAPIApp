package com.deltadax.bdggithubapiapp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deltadax.bdggithubapiapp.R;

public class DetailActivity extends AppCompatActivity {

    private static final String ARG_ID = "id";

    public static void start(Context context, long id) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra(ARG_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
