package edu.pro.sample.repository;

import edu.pro.sample.model.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends MongoRepository<Speciality,String> {

}
