package com.labmedicine.api_labmedication.repositories;

import com.labmedicine.api_labmedication.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
