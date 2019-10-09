package edu.pro.sample.services.speciality.interfaces;

import edu.pro.sample.model.Speciality;

import java.util.List;

public interface ISpecialityService {
    List<Speciality> getAll();
    Speciality get(String id);
}
