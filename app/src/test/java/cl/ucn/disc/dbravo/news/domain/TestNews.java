/*
 * Copyright 2020 Diego Bravo B
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dbravo.news.domain;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

/**
 * The test for the class News
 *
 * @author Diego Bravo B
 */
public class TestNews {
    /**
     * The test for the validations
     */
    @Test
    public void testValidation() {
        Faker faker = Faker.instance();
        // Attributes for the new
        Long id = Integer.toUnsignedLong(5);
        String title = faker.book().title();
        String author = faker.name().fullName();
        String description = faker.lorem().sentence();
        String content = faker.lorem().paragraph();
        String url = faker.company().url();
        String urlImg = faker.company().url();
        ZonedDateTime zonedDateTime = org.threeten.bp.ZonedDateTime.now(ZoneId.of("-3"));

        News testNew = new News(id, title, author, description, content, url, urlImg, zonedDateTime
        );

        // TODO: finish this part of the code

    }


}