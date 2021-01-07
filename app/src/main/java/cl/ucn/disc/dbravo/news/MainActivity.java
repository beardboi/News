/*
 * Copyright 2020 Diego Bravo B
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dbravo.news;

import android.os.AsyncTask;
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
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import java.util.List;
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

    /**
     * OnCreate.
     *
     * @param savedInstanceState Used to reload the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        // The SwipeRefreshLayout
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.am_swl_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> {

            // Call to the API
            List<News> newsList = getNewsList();

            // Add the news to the adapter
            newsAdapter.add(newsList);

            // Show new data
            fastAdapter.notifyAdapterDataSetChanged();

            // Stop refreshing
            swipeRefreshLayout.setRefreshing(false);

        });

        // Get the news in the background thread
        AsyncTask.execute(() -> {

            // Get the news
            List<News> newsList = getNewsList();

            // Set the adapter
            runOnUiThread(() -> {
                newsAdapter.add(newsList);
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

                // Set the night mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                // Show message
                Toast.makeText(getApplicationContext(), "Dark mode enabled", Toast.LENGTH_LONG).show();

                // TODO: Apply the change


            } else {
                // Change the switch state
                switchBtn.setChecked(false);

                // Set the day mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                // Show message
                Toast.makeText(getApplicationContext(), "Dark mode disabled", Toast.LENGTH_LONG).show();

                // TODO: Apply the change
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
}
