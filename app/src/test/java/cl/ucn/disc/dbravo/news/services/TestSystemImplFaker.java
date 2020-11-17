/*
 * Copyright 2020 Diego Bravo B
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dbravo.news.services;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.List;

import cl.ucn.disc.dbravo.news.domain.News;

/**
 * The test for the class SystemImplFaker
 *
 * @author Diego Bravo B
 */
public class TestSystemImplFaker {
    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(TestSystemImplFaker.class);

    /**
     * The test of retrieve news method
     */
    @Test
    public void testRetrieveNews() {
        // FIXME: The logger is not showing!

        logger.debug("Testing... in");

        // The implementation
        System system = new SystemImplFaker();

        // Call the method
        List<News> newsList = system.retrieveNews(5);

        // Test if the list is not null
        Assertions.assertNotNull(newsList, "List was null");
        // Test if the list is not empty
        Assertions.assertFalse(newsList.isEmpty(), "Empty was list?");
        // Test if the size is equal to 5
        Assertions.assertEquals(5, newsList.size(), "List size != 5");
        // Test if the size given is bigger than the actual
        Assertions.assertTrue(system.retrieveNews(10).size() <= 10, "List size != 10");

        // For each New in newsList
        for (News n : newsList) {
            logger.debug("New: {}:", n.toString());
        }

        logger.debug("Done.");
    }

    /**
     * The test of the saveNews method
     */
    @Test
    public void testSaveNews() {
        logger.debug("Testing... in");

        // The implementation
        System system = new SystemImplFaker();

        // Create a "New"
        Faker faker = Faker.instance();
        // The attributes of the New
        Long id = Integer.toUnsignedLong(5);
        String title = faker.book().title();
        String author = faker.name().fullName();
        String description = faker.lorem().sentence();
        String content = faker.lorem().paragraph();
        String url = faker.company().url();
        String urlImg = faker.company().url();
        ZonedDateTime zonedDateTime = org.threeten.bp.ZonedDateTime.now(ZoneId.of("-3"));

        // Instance the New
        News aNew = new News(id, title, author, description, content, url, urlImg, zonedDateTime
        );
        // Save the New into the system
        system.saveNews(aNew);

        // Test if the New is not null
        Assertions.assertNotNull(aNew);
        // Test if the size of the list is 5 (the initial values) + 1 (the one that was added)
        Assertions.assertEquals(6, system.retrieveNews(5+1).size(), "The size is not 6");

        logger.debug("Done.");
    }

}
