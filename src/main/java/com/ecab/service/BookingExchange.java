package com.ecab.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecab.model.Employez;

public interface BookingExchange extends JpaRepository<Employez, Integer>{

}


