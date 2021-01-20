package cl.ucn.disc.dbravo.news.Cache;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import cl.ucn.disc.dbravo.news.domain.News;

/**
 * Class AppCache
 * @author Raul Ramos, Daniel Suares, Diego Bravo
 */
@Database(entities = {News.class}, version = 1)
public abstract class AppCache extends RoomDatabase {

    //CacheDao cache
    public abstract CacheDao cache();

    //Initialization INSTANCE
    public static AppCache INSTANCE;

    /**
     * Static method to get the instance
     * @param context
     * @return Instance
     */
    public static AppCache getINSTANCE(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppCache.class, "checklist.db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
