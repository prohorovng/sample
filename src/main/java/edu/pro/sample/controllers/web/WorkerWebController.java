package edu.pro.sample.controllers.web;

import edu.pro.sample.forms.WorkerForm;
import edu.pro.sample.model.Speciality;
import edu.pro.sample.model.Worker;
import edu.pro.sample.services.speciality.impls.SpecialityServiceImpl;
import edu.pro.sample.services.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/worker")
@CrossOrigin("*")
@Controller
public class WorkerWebController {
    @Autowired
    WorkerServiceImpl service;
    @Autowired
    SpecialityServiceImpl specialityService;
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
        Map<String, String> mavs = specialityService.getAll().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("workerForm") WorkerForm workerForm) {
        System.out.println("Method Create POST was called");
        String specialityId = workerForm.getSpeciality();
        Speciality speciality = specialityService.get(specialityId);
        Worker newWorker = new Worker(workerForm.getName(),
                workerForm.getOccupation(),
                workerForm.getSalary(), speciality);

        service.create(newWorker);


        return "redirect:/worker/list";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateWorker(Model model,  @PathVariable("id") String id){
        Worker workerToUpdate = service.get(id);
        WorkerForm workerForm = new WorkerForm();
        workerForm.setName(workerToUpdate.getName());
        workerForm.setId(id);
        workerForm.setOccupation(workerToUpdate.getOccupation());
        workerForm.setSalary(workerToUpdate.getSalary());
        workerForm.setSpeciality(workerToUpdate.getSpeciality().getName());
        Map<String, String> mavs = specialityService.getAll().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));
        model.addAttribute("workerForm", workerForm);
        model.addAttribute("mavs", mavs);
        return "workerUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    String update(Model model, @ModelAttribute("workerForm") WorkerForm workerForm,
                  @PathVariable("id") String id) {
        System.out.println("Update is called");
        String specialityId = workerForm.getSpeciality();
        Speciality speciality = specialityService.get(specialityId);
        Worker newWorker = new Worker(workerForm.getName(),
                workerForm.getOccupation(),
                workerForm.getSalary(), speciality);
newWorker.setId(id);
        service.create(newWorker);


        return "redirect:/worker/list";

    }
}
