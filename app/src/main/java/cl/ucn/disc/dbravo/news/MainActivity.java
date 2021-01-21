/*
 * Copyright 2020 Diego Bravo, diego.bravo@alumnos.ucn.cl
 *                Daniel Suares, daniel.suares@alumnos.ucn.cl
 *                Raul Ramos, raul.ramos@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dbravo.news;

import android.os.AsyncTask;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;

import java.util.List;

import cl.ucn.disc.dbravo.news.database.AppStorage;
import cl.ucn.disc.dbravo.news.database.AppStorageI;
import cl.ucn.disc.dbravo.news.domain.News;
import cl.ucn.disc.dbravo.news.adapter.NewsItem;
import cl.ucn.disc.dbravo.news.services.System;
import cl.ucn.disc.dbravo.news.services.SystemImplNewsApi;
import cl.ucn.disc.dbravo.news.api.ApiKey;

/**
 * The main activity class.
 *
 * @author Diego Bravo B.
 */
public class MainActivity extends AppCompatActivity {

    // The SwipeRefreshLayout
    private SwipeRefreshLayout swipeRefreshLayout;

    // The database
    AppStorage database;

    /**
     * OnCreate.
     *
     * @param savedInstanceState Used to reload the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Initializate fresco
        Fresco.initialize(this);

        setContentView(R.layout.activity_main);

        // The toolbar
        this.setSupportActionBar(findViewById(R.id.am_t_toolbar));

        // The FastAdapter
        ModelAdapter<News, NewsItem> newsAdapter = new ModelAdapter<>(NewsItem::new);
        FastAdapter<NewsItem> fastAdapter = FastAdapter.with(newsAdapter);
        fastAdapter.withSelectable(false);

        // The Recycler View
        RecyclerView recyclerView = findViewById(R.id.am_rv_news);
        recyclerView.setAdapter(fastAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        // The database instance
        database = AppStorage.getINSTANCE(this.getApplicationContext());

        // If the app doesn't have internet connection when it starts
        if(!getInternetConnection(this)) {

            // Show message
            Toast.makeText(this, "No network connection.", Toast.LENGTH_SHORT).show();
            // Get the news from the database.
            List<News> newsList = database.cache().getAll();

            // Draw the news
            AsyncTask.execute(() ->{

                // Set the adapter
                runOnUiThread(() -> {
                    newsAdapter.add(newsList);
                });

            });

        }

        // The SwipeRefreshLayout
        swipeRefreshLayout = findViewById(R.id.am_swl_refresh);

        // Get the news in the background thread
        AsyncTask.execute(() -> {

            // Get the news
            List<News> newsList = getNewsList();

            // Set the adapter
            runOnUiThread(() -> {
                newsAdapter.add(newsList);
            });
        });

        // The listener of the SwipeRefresh
        swipeRefreshLayout.setOnRefreshListener(() -> {

            // Get the news in the background thread
            AsyncTask.execute(() -> {

                // Get the news from the API
                List<News> newsList = getNewsList();

                // Draw the news
                runOnUiThread(() -> {

                    // Add the news to the adapter
                    newsAdapter.add(newsList);

                    // Show new data
                    fastAdapter.notifyAdapterDataSetChanged();

                    // Stop refreshing
                    swipeRefreshLayout.setRefreshing(false);

                });
            });
        });
    }

    /**
     * The onCreateOptionsMenu method override.
     *
     * @param menu The menu that will be added to the toolbar.
     * @return true if the menu is displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate menu
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // The menu item
        final MenuItem switchBtn = menu.findItem(R.id.mm_sw_daynight);
        final SwitchCompat actionView = (SwitchCompat) switchBtn.getActionView();

        // Setting the listener
        actionView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                actionView.setChecked(true);

                // Set the night mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                // Show message
                Toast.makeText(getApplicationContext(), "Dark mode enabled", Toast.LENGTH_LONG).show();

            } else {

                // Change the switch state
                actionView.setChecked(false);

                // Set the day mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                // Show message
                Toast.makeText(getApplicationContext(), "Dark mode disabled", Toast.LENGTH_LONG).show();

            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    // Method to load the news from the API
    public static List<News> getNewsList() {

        // Instance the class to make the call to the API
        System system = new SystemImplNewsApi(ApiKey.getApiKey());

        // Call to the API and return the list of news
        return system.retrieveNews(30);
    }

    /**
     * Method to check internet connection.
     *
     * @param context The context of the app.
     * @return Boolean value indicating the status of the connection.
     */
    private boolean getInternetConnection(MainActivity context) {

        ConnectivityManager Connection = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check for wifi connection
        NetworkInfo wifiValidation = Connection.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        //Check for internet mobile connection
        NetworkInfo mobileValidation = Connection.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        // Check internet connection
        return wifiValidation != null && wifiValidation.isConnected() || mobileValidation != null && mobileValidation.isConnected();
    }



}
