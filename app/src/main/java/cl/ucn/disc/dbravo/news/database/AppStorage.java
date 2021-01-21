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

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import cl.ucn.disc.dbravo.news.utils.ZonedDateTimeConverter;
import cl.ucn.disc.dbravo.news.domain.News;

/**
 * The class for the database of the app.
 *
 * @author Raul Ramos, Diego Bravo
 */
@Database(entities = {News.class}, version = 1)
@TypeConverters(ZonedDateTimeConverter.class)
public abstract class AppStorage extends RoomDatabase {

    // CacheDao cache
    public abstract AppStorageI cache();

    // Initialization INSTANCE
    public static AppStorage INSTANCE;

    /**
     * Static method to get the instance.
     * @param context The context.
     * @return Instance.
     */
    public static AppStorage getINSTANCE(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppStorage.class, "checklist.db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
