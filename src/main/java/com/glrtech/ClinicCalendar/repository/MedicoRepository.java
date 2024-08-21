package com.glrtech.ClinicCalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glrtech.ClinicCalendar.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
