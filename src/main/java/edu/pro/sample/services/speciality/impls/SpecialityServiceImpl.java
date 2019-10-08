package edu.pro.sample.services.speciality.impls;

import edu.pro.sample.model.Speciality;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecialityServiceImpl {
    List<Speciality> specialities = new ArrayList<>(
            Arrays.asList(
                    new Speciality("coder",25,100),
                    new Speciality("designer",15,5),
                    new Speciality("tester",3,50)
            )
    );
    public List<Speciality> getSpecialities() {
        return specialities;
    }
}
