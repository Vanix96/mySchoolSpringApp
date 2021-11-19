package it.nttdata.myschoolspring.repository;

import org.springframework.data.repository.CrudRepository;

import it.nttdata.myschoolspring.entity.SchoolClass;

public interface SchoolClassRepo extends CrudRepository<SchoolClass, Long> {
    
}
