package com.glrtech.ClinicCalendar.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.glrtech.ClinicCalendar.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONSULTA")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "medico_id", nullable = false)
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	private LocalDateTime dataConsulta;
	private Status status;

	public Consulta() {
	}

	public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime dataConsulta, Status status) {
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.dataConsulta = dataConsulta;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDateTime dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataConsulta, id, medico, paciente, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(dataConsulta, other.dataConsulta) && Objects.equals(id, other.id)
				&& Objects.equals(medico, other.medico) && Objects.equals(paciente, other.paciente)
				&& status == other.status;
	}

}
