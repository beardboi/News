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

import com.kwabenaberko.newsapilib.models.Article;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * The test for the NewsApiService class.
 *
 * @author Diego Bravo B.
 */
public class TestNewsApiService {

    /**
     * The logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(TestNewsApiService.class);

    /**
     * The test.
     * @throws IOException In case of error.
     */
    @Test
    public void wrongApi() throws IOException {
        logger.debug("Testing ..");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NewsApiService newsApiService = new NewsApiService(null);

        });
        logger.debug("Wrong key...");
        Assertions.assertThrows(RuntimeException.class, () -> {
            NewsApiService newsApiService = new NewsApiService("This is my wrong key");
            List<Article> articles = newsApiService.getTopHeadlines("general", 10);
            logger.debug("Articles: {}.", articles);
        });
        logger.debug("Good key...");
        {
            NewsApiService newsApiService = new NewsApiService("dcc476490d624a60a76f2ab30ec11e47");
            List<Article> articles = newsApiService.getTopHeadlines("general", 10);
            logger.debug("Articles: {}.", articles);
            logger.debug("Articles size: {}.", articles.size());
        }

        logger.debug(".. Done.");
    }
}
