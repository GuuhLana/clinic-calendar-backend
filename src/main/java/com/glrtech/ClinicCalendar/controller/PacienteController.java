package com.glrtech.ClinicCalendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glrtech.ClinicCalendar.dto.PacienteDTO;
import com.glrtech.ClinicCalendar.model.Paciente;
import com.glrtech.ClinicCalendar.service.PacienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Operações -> Paciente")
@RestController
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@Operation(summary = "Cadastra um novo paciente")
	@PostMapping("/cadastrar")
	public ResponseEntity<?> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {
		try {
			Paciente novoPaciente = new Paciente();
			novoPaciente.setNome(pacienteDTO.getNome());
			novoPaciente.setIdade(pacienteDTO.getIdade());
			novoPaciente.setEmail(pacienteDTO.getEmail());
			novoPaciente.setSenha(pacienteDTO.getSenha());
			novoPaciente.setCpf(pacienteDTO.getCpf());

			Paciente pacienteSalvo = service.criarPaciente(novoPaciente);
			return new ResponseEntity<>(pacienteSalvo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Lista todos os pacientes")
	@GetMapping("/listar")
	public ResponseEntity<?> listarPaciente() {
		try {
			List<Paciente> pacientes = service.listarPaciente();
			return new ResponseEntity<>(pacientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Deleta o paciente com o ID referenciado")
	@DeleteMapping("/deletar")
	public ResponseEntity<?> deletarPaciente(@RequestBody Long id) {
		try {
			if (service.deletarPaciente(id)) {
				return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}
}
