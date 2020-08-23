package com.example.bankproject.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bankproject.Model.User;
import com.example.bankproject.Model.UserRequest;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllDAO(List<User> users);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUSerDAO(User user);

    @Query("SELECT * FROM Usuario")
    List<User> getAllUSerDAO();

    @Query("SELECT * FROM Usuario WHERE server_id LIKE :server_id")
    User findUserByIdDAO(String server_id);

    @Update
    void updateUserDAO(User user);
}
