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

import net.openhft.hashing.LongHashFunction;
import org.threeten.bp.ZonedDateTime;
import cl.ucn.disc.dbravo.news.utils.Validation;

/**
 * The domain model: News
 *
 * @author Diego Bravo B
 */
public class News {

    /**
     * Unique id
     */
    private Long id;

    /**
     * The new's title
     * Restrictions: not null, size > 2
     */
    private String title;

    /**
     * The author of the new
     * Restrictions: Not null, size > 2
     */
    private String author;

    /**
     * The source of the new
     *
     */
    private String source;

    /**
     * The description of the new
     * Restrictions: Not null, size > 2
     */
    private String description;

    /**
     * The content of the new
     * Restrictions: Not null, size > 2
     */
    private String content;

    /**
     * The url of the new
     * Restrictions: Not null, size > 2
     */
    private String url;

    /**
     * The url of the image
     * Restrictions: Not null
     */
    private String urlImg;

    /**
     * The date of publish
     * Restrictions: Not null
     */
    private ZonedDateTime publishedAt;

    /**
     * The constructor.
     *
     * @param title       The title.
     * @param author      The author of the new.
     * @param source      The source of the new.
     * @param description The description of the new.
     * @param content     The content of the new.
     * @param url         The url of the new.
     * @param urlImg      The url of the image.
     * @param publishedAt The date of the new.
     */
    public News(String title, String author, String source, String description, String content, String url, String urlImg, ZonedDateTime publishedAt) {
        // Validations for the title
        Validation.minSize(title, 2, "title");
        this.title = title;

        // Validation for the author
        Validation.minSize(author, 2, "author");
        this.author = author;

        // Validation for the author
        Validation.minSize(source, 2, "source");
        this.source = source;

        // Assignment of the id
        this.id = LongHashFunction.xx()
                .hashChars(title + "|" + author  + "|" + source);

        // Validation for the description
        Validation.minSize(description, 2, "description");
        this.description = description;

        // Validation for the content
        Validation.notNull(content, "content");
        this.content = content;

        // Validation for the date of the new
        Validation.notNull(publishedAt, "publishedAt");
        this.publishedAt = publishedAt;

        // Validation for the URL
        Validation.notNull(url, "url");
        this.url = url;

        // Validation for the URL
        Validation.notNull(urlImg, "urlImg");
        this.urlImg = urlImg;

    }

    /**
     * This function return a string with the attributes of an instance object.
     *
     * @return The string with the attributes.
     */
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }

    /**
     * @return The id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set for the id attribute.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set for the title attribute.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set for the author attribute.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set for the description attribute.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Set for the content attribute.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return The url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set for the url attribute.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The urlImg.
     */
    public String getUrlImg() {
        return urlImg;
    }

    /**
     * Set for the urlImg attribute.
     */
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    /**
     * @return The publishedAt.
     */
    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }

    /**
     * Set for the publishedAt attribute.
     */
    public void setPublishedAt(ZonedDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * @return The source
     */
    public String getSource() {
        return source;
    }

    /**
     * Set for the source attribute.
     */
    public void setSource(String source) {
        this.source = source;
    }
}
