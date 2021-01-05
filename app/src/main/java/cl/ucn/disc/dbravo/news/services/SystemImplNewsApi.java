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

import com.kwabenaberko.newsapilib.models.Article;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import cl.ucn.disc.dbravo.news.domain.News;
import cl.ucn.disc.dbravo.news.utils.Validation;

/**
 * The class to implement the contracts.
 *
 * @author Diego Bravo B
 */
public class SystemImplNewsApi implements System {

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SystemImplNewsApi.class);

    /**
     * The connection to NewsApi
     */
    private final NewsApiService newsApiService;

    /**
     * The constructor.
     *
     * @param theApiKey The API key to use.
     */
    public SystemImplNewsApi(final String theApiKey) {
        // Verify
        Validation.minSize(theApiKey, 10, "Wrong API key");
        this.newsApiService = new NewsApiService(theApiKey);
    }

    /**
     * This function convert an article into a News.
     *
     * @param article The article to convert into a News.
     * @return a News.
     */
    private static News toNews(final Article article) {
        // Verify if the article is null
        Validation.notNull(article, "Article was null");

        // Warning message
        boolean needFix = false;

        // Add more restriction
        if(article.getDescription() == null || article.getDescription().length() == 0) {
            article.setDescription("No description");
            needFix = true;
        }

        if(article.getAuthor() == null || article.getAuthor().length() == 0) {
            article.setAuthor("No author");
            needFix = true;
        }

        if(article.getSource() == null || article.getSource().getName().length() == 0) {
            Objects.requireNonNull(article.getSource()).setName("No source.");
            needFix = true;
        }

        // If need a fix, get a warning message.
        if(needFix) {
            // Debug of an article
            logger.warn("Article with invalid restrictions: {}.", ToStringBuilder
                    .reflectionToString(article, ToStringStyle.MULTI_LINE_STYLE));
        }

        // The time conversion.
        ZonedDateTime publishedAt = ZonedDateTime
                .parse(article.getPublishedAt())
                .withZoneSameInstant(ZoneId.of("-3"));

        // The news.
        return new News(
                article.getTitle(),
                article.getSource().getName(),
                article.getAuthor(),
                article.getUrl(),
                article.getUrlToImage(),
                article.getDescription(), // fixme: Where is the content
                article.getDescription(),
                publishedAt
        );
    }

    /**
     * The predicate of filter function.
     *
     * @param idExtractor The key extractor.
     * @param <T> The type of input of the predicate.
     * @return The filter by key extractor.
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> idExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(idExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * Get the list of news.
     *
     * @param size The size of the list.
     * @return The list that contains the news.
     */
    @Override
    public List<News> retrieveNews(Integer size) {
        try {
            // Get the list of Articles
            List<Article> articles = newsApiService.getTopHeadlines("technology", size);

            // The list of Articles converted into a list of News
            List<News> rarNews = new ArrayList<>();

            for (Article article : articles) {
                rarNews.add(toNews(article));
            }

            // Return the news filtered and sorted by data
            return rarNews.stream()
                    // Remove the duplicated ones
                    .filter(distinctByKey(News::getId))

                    // Order by date
                    .sorted((k1, k2) -> k2.getPublishedAt().compareTo(k1.getPublishedAt()))
                    .collect(Collectors.toList());


        } catch (IOException ex) {
            // TODO: Encapsulate?
            throw new RuntimeException(ex);
        }

    }

    /**
     * Save a new and put it into the system.
     *
     * @param news The new to be added.
     */
    @Override
    public void saveNews(News news) {
        throw new NotImplementedException("Can't save in NewsAPI");
    }
}
