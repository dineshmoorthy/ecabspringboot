package com.ecab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecab.model.Employez;
@Repository
public interface EmployeeRepository extends JpaRepository<Employez, Integer>{

}


