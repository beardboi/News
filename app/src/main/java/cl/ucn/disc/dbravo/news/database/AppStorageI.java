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

package cl.ucn.disc.dbravo.news.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import cl.ucn.disc.dbravo.news.domain.News;

/**
 * The interface of the class AppStorage.
 *
 * @author Raul Ramos, Diego Bravo, Daniel Suares
 */
@Dao
public interface AppStorageI {

    //Select all news
    @Query("SELECT * FROM News")
    List<News> getAll();

    //Select News by id
    @Query("SELECT * FROM News WHERE id =:id")
    News findById(long id);

    //Insert News in database
    @Insert
    void insert(News news);
}
