package edu.pro.sample.controllers.web;

import edu.pro.sample.forms.WorkerForm;
import edu.pro.sample.model.Worker;
import edu.pro.sample.services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/worker")
@CrossOrigin("*")
@Controller
public class WorkerWebController {
    @Autowired
    WorkerServiceImpl service;

    @RequestMapping ("/list")
    String showAll(Model model){
        List<Worker> list = service.getAll();
        model.addAttribute("workers",list);

                return "workerList";
    }

    @RequestMapping ("/delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id){

        service.delete(id);

        return new  RedirectView ("/worker/list");

    }

    @RequestMapping ("/get/{id}")
    Worker get(@PathVariable(value = "id")String id){
        return service.get(id);
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addWorker(Model model){
        WorkerForm workerForm = new WorkerForm();

        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("workerForm") WorkerForm workerForm) {

        Worker newWorker = new Worker(workerForm.getName(),
                workerForm.getOccupation(),
                workerForm.getSalary());
        service.create(newWorker);


        return "redirect:/worker/list";

    }
    @PostMapping("/update")
    Worker update(@Valid @RequestBody Worker worker) {
        return service.update(worker);
    }

}