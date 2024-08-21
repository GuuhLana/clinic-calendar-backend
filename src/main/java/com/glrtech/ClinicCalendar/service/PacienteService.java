package com.glrtech.ClinicCalendar.service;

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
}
