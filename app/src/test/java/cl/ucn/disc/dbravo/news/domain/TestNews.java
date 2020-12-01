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
package cl.ucn.disc.dbravo.news.domain;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

/**
 * The test for the class News.
 *
 * @author Diego Bravo B
 */
public class TestNews {

    /**
     * The logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(TestNews.class);

    /**
     * The test for the validations.
     */
    @Test
    public void testValidation() {

        Faker faker = Faker.instance();

        // The attributes of the New
        String title = faker.book().title();
        String author = faker.name().fullName();
        String source = faker.book().publisher();
        String description = faker.lorem().sentence();
        String content = faker.lorem().paragraph();
        String url = faker.company().url();
        String urlImg = faker.company().url();
        ZonedDateTime publishedDate = org.threeten.bp.ZonedDateTime.now(ZoneId.of("-3"));

        // Instance a News
        News news = new News(title, author, source, description, content, url, urlImg, publishedDate);

        // Show the generated id.
        logger.debug("The id: {}.", news.getId());

        // Check for null attribute instance:
        logger.debug("Title null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    null,
                    "The author",
                    "The source",
                    "The description",
                    "The content",
                    "The url",
                    "The URL Image",
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("Author null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    null,
                    "The source",
                    "The description",
                    "The content",
                    "The url",
                    "The URL Image",
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("Source null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    "The author",
                    null,
                    "The description",
                    "The content",
                    "The url",
                    "The URL Image",
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("Description null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    "The author",
                    "The source",
                    null,
                    "The content",
                    "The url",
                    "The URL Image",
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("Content null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    "The author",
                    "The source",
                    "The description",
                    null,
                    "The url",
                    "The URL Image",
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("Url null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    "The author",
                    "The source",
                    "The description",
                    "The content",
                    null,
                    "The URL Image",
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("Url Image null...");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    "The author",
                    "The source",
                    "The description",
                    "The content",
                    "The url",
                    null,
                    ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        logger.debug("PublishedAt null...");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(
                    "The title",
                    "The author",
                    "The source",
                    "The description",
                    "The content",
                    "The url",
                    "The URL Image",
                    null
            );
        });

    }

}
