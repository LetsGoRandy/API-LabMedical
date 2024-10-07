package com.labmedicine.api_labmedication.services;

import com.labmedicine.api_labmedication.dtos.EstatisticaDTO;
import com.labmedicine.api_labmedication.repositories.MedicamentoRepository;
import com.labmedicine.api_labmedication.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

    private final PacienteRepository pacienteRepository;
    private final MedicamentoRepository medicamentoRepository;

    public EstatisticaDTO listarEstatisticas() {
        long totalPacientes = pacienteRepository.count();
        long totalMedicamentos = medicamentoRepository.count();

        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        estatisticaDTO.setTotalPacientes(totalPacientes);
        estatisticaDTO.setTotalMedicamentos(totalMedicamentos);

        return estatisticaDTO;
    }


}
