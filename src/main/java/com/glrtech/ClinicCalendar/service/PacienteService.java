package com.glrtech.ClinicCalendar.service;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glrtech.ClinicCalendar.model.Paciente;
import com.glrtech.ClinicCalendar.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;

	public Paciente criarPaciente(Paciente paciente) {
		boolean existByCpf = repository.existsByCpf(paciente.getCpf());
		boolean existByEmail = repository.existsByEmail(paciente.getEmail());

		if (!existByCpf && !existByEmail) {
			return repository.save(paciente);
		} else {
			throw new IllegalArgumentException("Paciente com este CPF ou email já existe.");
		}
	}
	
	public java.util.List<Paciente> listarPaciente(){
		try {
			java.util.List<Paciente> listaPacientes = repository.findAll();
			return listaPacientes;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean deletarPaciente(Long id) {
		boolean existsById = repository.existsById(id);
		boolean deletado = false;
		
		try {
			if (existsById) {
				repository.deleteById(id);
				deletado = true;
			}
			System.out.println("Paciente não foi localizado na base de dados");
			return deletado;
		} catch (Exception e) {
			return deletado;
		}
	}
}
