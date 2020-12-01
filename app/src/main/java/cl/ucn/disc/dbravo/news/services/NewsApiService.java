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
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.network.APIClient;
import com.kwabenaberko.newsapilib.network.APIService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cl.ucn.disc.dbravo.news.utils.Validation;
import retrofit2.Response;

/**
 * The NewsApi implementation.
 *
 * @author Diego Bravo B
 */
public final class NewsApiService {

    /**
     * The key.
     */
    private final String apiKey;

    /**
     * The sub-service.
     */
    private final APIService apiService;

    /**
     * The constructor.
     *
     * @param apiKey The API Key to use.
     */
    public NewsApiService(String apiKey) {
        Validation.notNull(apiKey, "API key");
        this.apiKey = apiKey;
        this.apiService = APIClient.getAPIService();
    }

    /**
     * This is the getTopHeadlines adaptor.
     *
     * @param category The category to search.
     * @param pageSize The page size.
     * @return The list of Article.
     * @throws IOException in case of error.
     */
    public List<Article> getTopHeadlines(final String category, final Integer pageSize) throws IOException {
        // Verify nullity
        Validation.notNull(category, "category");
        Validation.notNull(pageSize, "pageSize");

        // Check if the page size is valid (Needs to be bigger than zero)
        if (pageSize < 1) {
            throw new IllegalArgumentException("Error: pageSize need to be bigger than 0.");
        }

        /* TODO: Implement the correct map to request parameters (?).
        https://newsapi.org/docs/endpoints/top-headlines */

        // The map of the parameters.
        Map<String, String> query = new HashMap<>();
        query.put("apiKey", this.apiKey);
        query.put("category", category);
        query.put("pageSize", pageSize.toString());

        // The response (synchronous)
        Response<ArticleResponse> response = apiService.getTopHeadlines(query).execute();

        if (response.isSuccessful()) {
            return response.body().getArticles();
        } else {
            throw new RuntimeException("Errors: " + response.code() + " --> " + response.errorBody().string());
        }

    }
}
