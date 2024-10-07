import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MedicamentoUpdateDTO {

    private Long tipoMedicamento; // Aqui você vai usar o ID do enum

    @NotNull(message = "Quantidade é obrigatória")
    private Long quantidade;

    private String observacoes;


}

