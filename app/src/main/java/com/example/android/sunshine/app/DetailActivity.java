/****************************************************************************************
 * this fragment includes the main view for weather data it also implements the async
 * task that grabs the data from the weather api.
 *
 * Created on Aug 25th 2016 10:23AM
 * Created by @
 *  _   _  ___  _   _____      _                      _
 * | \ | |/ _ \| | |  __ \    | |                    | |
 * |  \| | | | | |_| |__) |___| | _____   _____ _ __ | |_
 * | . ` | | | | __|  _  // _ \ |/ _ \ \ / / _ \ '_ \| __|
 * | |\  | |_| | |_| | \ \  __/ |  __/\ V /  __/ | | | |_
 * |_| \_|\___/ \__|_|  \_\___|_|\___| \_/ \___|_| |_|\__|
 *
 *
 * change log:
 * 1 Aug 25 16 11:59PM implemented intent receive
 * 2 Aug 25 16 04:22AM added settings support
 ****************************************************************************************/
package com.example.android.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivity extends ActionBarActivity {

  //  String weatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //get ID for the option selected
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {

        public DetailFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            Intent intent = getActivity().getIntent();
            String weatherData = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView hello = (TextView) rootView.findViewById(R.id.detail_weather_text);
            hello.setText(weatherData);
            setHasOptionsMenu(true);
//            ((TextView) rootView.findViewById(R.id.detail_weather_text))
//                    .setText(weatherData);

//            TextView hello = (TextView) getView().findViewById(R.id.detail_weather_text);
//            hello.setText(weatherData);
            return rootView;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            return super.onOptionsItemSelected(item);
        }
    }
}
