package edu.pro.sample.services.worker.intefaces;

import edu.pro.sample.model.Worker;

import java.util.List;

public interface IWorkerService {
    List<Worker> getAll();
    Worker get(String id);
    Worker create(Worker worker);
    Worker update(Worker worker);
    Worker delete(String id);

}
