package edu.pro.sample.controllers;

import edu.pro.sample.model.Worker;
import edu.pro.sample.services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkerController {
    @Autowired
    WorkerServiceImpl service;

    @RequestMapping ("/worker/list")
    List<Worker> showAll(){
        return service.getAll();
    }

    @RequestMapping ("/worker/delete/{id}")
    Worker delete(@PathVariable(value = "id")String id){
        return service.delete(id);
    }
}
