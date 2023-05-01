package com.ToDoListData.ToDoListData.Repo;

import com.ToDoListData.ToDoListData.Model.ToDoData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DataRepo extends JpaRepository<ToDoData,Integer> {


    public List<ToDoData> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "update to_do_data set done=?1 where id=?2",nativeQuery = true)
    public void updateDone(boolean done,int id);
    @Transactional
    @Modifying
    @Query(value = "update to_do_data set body=?1 where id=?2",nativeQuery = true)
    public void updateBody(String body,int id);
    @Transactional
    @Modifying
    @Query(value = "Delete from ToDoData where id=?1")
    public void deleteData(int id);


}
