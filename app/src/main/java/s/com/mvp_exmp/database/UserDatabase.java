package s.com.mvp_exmp.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {DataModel.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase userDatabase_instance;
    public  abstract I_DatabaseAccess i_databaseAccess();


    public static UserDatabase getRoomDatabase(final Context context)
    {
        if (userDatabase_instance !=null)
        {
            return userDatabase_instance;

        }else {

            userDatabase_instance = Room.databaseBuilder(context,UserDatabase.class,"UserDetailsDB").build();
        }

        return userDatabase_instance;
    }


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
