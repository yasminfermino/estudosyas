package med.voll.api.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEnderecos;


public record DadosCadastroMedico(

        @NotBlank // não pode ser branco ou nulo
        String nome,

        @NotBlank
        @Email // valida se email esta no formato de email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // validacao se o crm está dentro do padrao que é de 4 a 6 digitos
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid // validar as variaveis dentro dessa classe
        DadosEnderecos endereco) {
    }
