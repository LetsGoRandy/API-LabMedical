package com.labmedicine.api_labmedication.repositories;

import com.labmedicine.api_labmedication.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
