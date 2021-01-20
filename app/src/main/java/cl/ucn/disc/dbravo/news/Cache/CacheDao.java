package cl.ucn.disc.dbravo.news.Cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cl.ucn.disc.dbravo.news.domain.News;

/**
 * Class CacheDao
 * @author Raul Ramos, Diego Bravo, Daniel Suares
 */
@Dao
public interface CacheDao {

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
