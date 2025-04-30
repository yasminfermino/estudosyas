package med.voll.api.repository;

import med.voll.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository <Medico, Long>{

}
/*Interface herdando do jparepository os metodos,
para isso passamos a entidade e a tipagem do seu id */