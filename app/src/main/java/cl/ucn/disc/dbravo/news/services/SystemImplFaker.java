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

package cl.ucn.disc.dbravo.news.services;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;
import cl.ucn.disc.dbravo.news.domain.News;

/**
 * The concrete class that implements the contracts
 *
 * @author Diego Bravo B
 */
public class SystemImplFaker implements System {
    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SystemImplFaker.class);
    /**
     * The list that contains the news.
     */
    private final List<News> newsList = new LinkedList<>();

    /**
     * The constructor
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public SystemImplFaker() {
        // The faker instance
        final Faker faker = Faker.instance();

        for (int i = 0; i < 5; i++) {
            // The attributes of the New
            Long id = Integer.toUnsignedLong(i);
            String title = faker.book().title();
            String author = faker.name().fullName();
            String description = faker.lorem().sentence();
            String content = faker.lorem().paragraph();
            String url = faker.company().url();
            String urlImg = faker.company().url();
            ZonedDateTime zonedDateTime = org.threeten.bp.ZonedDateTime.now(ZoneId.of("-3"));
            // Instance a New
            News aNew = new News(id, title, author, description, content, url, urlImg, zonedDateTime);
            // Add it to the list
            this.newsList.add(aNew);
        }

    }

    /**
     * This function return a list with news.
     *
     * @param size The size of the list.
     * @return The list with the News.
     */
    @Override
    public List<News> retrieveNews(final Integer size) {
        // If the size given is bigger than the one from the list, return actual list.
        if (size > this.newsList.size()) {
            return this.newsList;
        }

        // It returns a sublist between the index 0 - newList.size.
        return this.newsList.subList(newsList.size() - size, newsList.size());
    }

    /**
     * Save a New and put it into the system.
     *
     * @param news The new to be added.
     */
    @Override
    public void saveNews(final News news) {
        boolean duplicated = false;
        // Verify duplicated
        for (News n : newsList) {
            if (news.equals(n)) {
                logger.debug("Duplicated news not allowed.");
                duplicated = true;
            }

        }
        // If the new is not duplicated, added it
        if (!duplicated) {
            this.newsList.add(news);
        }

    }

}
