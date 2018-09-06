package s.com.mvp_exmp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface I_DatabaseAccess {

    @Query("Select * from UserData")
    List<DataModel> getAllUser();

    @Query("Select * from UserData where name = :name")
    List<String> searchuser(String name);

    @Insert
    void insertAll(DataModel user);
}
