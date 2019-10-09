package edu.pro.sample.services.speciality.impls;

import edu.pro.sample.model.Speciality;
import edu.pro.sample.repository.SpecialityRepository;
import edu.pro.sample.services.speciality.interfaces.ISpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecialityServiceImpl implements ISpecialityService {
    List<Speciality> specialities = new ArrayList<>(
            Arrays.asList(
                    new Speciality("coder",25,100),
                    new Speciality("designer",15,5),
                    new Speciality("tester",3,50)
            )
    );
    @Autowired
    SpecialityRepository repository;
    public List<Speciality> getSpecialities() {
        return specialities;
    }

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(specialities);
    }


    @Override
    public List<Speciality> getAll() {
        return repository.findAll();

    }

    @Override
    public Speciality get(String id) {
        return repository.findById(id).orElse(null);
    }
}
