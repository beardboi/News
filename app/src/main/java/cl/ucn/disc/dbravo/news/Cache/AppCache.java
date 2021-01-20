package cl.ucn.disc.dbravo.news.Cache;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import cl.ucn.disc.dbravo.news.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppCache extends RoomDatabase {

    public abstract CacheDao cache();

    public static AppCache INSTANCE;

    public static AppCache getINSTANCE(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppCache.class, "checklist.db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();


        }
        return INSTANCE;
    }
}
