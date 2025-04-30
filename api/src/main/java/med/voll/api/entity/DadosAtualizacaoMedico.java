package med.voll.api.entity;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEnderecos;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String crm,
        String email,
        String telefone,
        DadosEnderecos endereco) {
}
