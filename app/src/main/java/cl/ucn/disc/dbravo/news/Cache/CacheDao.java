package cl.ucn.disc.dbravo.news.Cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cl.ucn.disc.dbravo.news.domain.News;

public interface CacheDao {

    @Query("SELECT * FROM News")
    List<News> getAll();

    @Query("SELECT * FROM News WHERE id =:id")
    News findById(long id);

    @Insert
    void insert(News news);
}
