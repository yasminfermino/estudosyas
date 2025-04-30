package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.entity.DadosAtualizacaoMedico;
import med.voll.api.entity.DadosCadastroMedico;
import med.voll.api.entity.Medico;
import med.voll.api.entity.DadosListagemMedico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    //metodo de CREATE
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        //System.out.println(dados);
        repository.save(new Medico(dados)); //atribuindo o retorno as classes para construção dos dados da tabela
    }

    //metodo de READ
    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

    //metodo de UPDATE
    @PutMapping
    @Transactional //necessario transferencia de dados como no post
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    //metodo de DELETE
    @DeleteMapping("/{id}")//complemento para a URL {id}
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
