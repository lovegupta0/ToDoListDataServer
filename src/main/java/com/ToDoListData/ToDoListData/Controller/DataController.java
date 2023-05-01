package com.ToDoListData.ToDoListData.Controller;

import com.ToDoListData.ToDoListData.Model.ToDoData;
import com.ToDoListData.ToDoListData.Repo.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    DataRepo repo;

    @GetMapping("/")
    public String start(){
        return "server is connected";
    }
    @GetMapping("/api/alldata")
    public List<ToDoData> allData(){
        return repo.findAll();
    }
    @PostMapping("/api/getdata")
    public List<ToDoData> getData(@RequestParam(name="email") String email){
        return repo.findByEmail(email);
    }
    @PostMapping("/api/add")
    public String addData(@RequestBody ToDoData data){
        try {
            repo.save(data);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "success";
    }

    @PostMapping("/api/updatedone")
    public String updateDone(@RequestParam(name="id") int id){

           repo.updateDone(true,id);

        return "success";
    }
    @PostMapping("/api/updatebody")
    public String updateBody(@RequestParam(name="body") String body,@RequestParam(name="id") int id){
            repo.updateBody(body,id);
        return "success";
    }

    @PostMapping("/api/deletedata")
    public String deleteData(@RequestParam(name="id") int id ){
        repo.deleteData(id);
        return "sucess";
    }


}
