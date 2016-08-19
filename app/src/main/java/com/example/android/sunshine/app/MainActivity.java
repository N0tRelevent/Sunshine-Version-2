package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            //Create dummy data that we will use to populate the list view in
            //R.layout.list_item_forecast

            String[] dummys = {
                    "Friday - Sunny - 99/85",
                    "Saturday - Sunny - 101/55",
                    "Sunday - Sunny - 99/85",
                    "Monday - Sunny - 101/55",
                    "Tuesday - Sunny - 99/85",
                    "Wednesday - Sunny - 101/55"
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(dummys));

            /*Now that we have the dummy data, we create an array adapter that will
            * take data from any source and populate the listView attached to it*/
            ArrayAdapter<String> dummysAdapter = new ArrayAdapter<String>(
                    //The current context
                    getActivity(),
                    // ID of list item layout
                    R.layout.list_item_forecast,
                    // ID of the textview to populate
                    R.id.list_item_forecast_textview,
                    // Forecast source data (dummy data so far)
                    weekForecast);





            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //Initialize forecastList list view and bind it to dummyAdapter
            ListView forecastList = (ListView) rootView.findViewById(R.id.listview_forcast);
            forecastList.setAdapter(dummysAdapter);


            return rootView;
        }
    }
}
