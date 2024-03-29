package edu.pro.sample.services.worker.impls;

import edu.pro.sample.model.Speciality;
import edu.pro.sample.model.Worker;
import edu.pro.sample.repository.WorkerRepository;

import edu.pro.sample.services.worker.intefaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class WorkerServiceImpl implements IWorkerService {
    List<Worker> workers = new ArrayList<>();
List<Speciality> specialities;

    @Autowired
    WorkerRepository repository;

    @PostConstruct
    void init(){
       specialities = new ArrayList<>(
                Arrays.asList(

                        new Speciality("1","coder", 25, 100),
                        new Speciality("2","designer", 15, 5),
                        new Speciality("3","tester", 3, 50)
                )
        );
        repository.deleteAll();
        Worker ivan = new Worker("Ivan","coder",1000, specialities.get(0));
        Worker stepan = new Worker("Stephan","coder1",2000, specialities.get(1));
        Worker johnLenon = new Worker("JohnLenon","guitar",20000, specialities.get(2));
        workers.add(ivan);
        workers.add(stepan);
        workers.add(johnLenon);
        repository.saveAll(workers);
    }
    @Override
    public List<Worker> getAll() {
        return repository.findAll();

    }

    @Override
    public Worker get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Worker create(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        Worker worker = this.get(id);
        repository.deleteById(id);
        return worker;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }
}
