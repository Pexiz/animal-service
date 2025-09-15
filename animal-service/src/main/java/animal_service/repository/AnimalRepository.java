package animal_service.repository;

import animal_service.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository <Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();
    
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL ORDER BY a.dataEntrada")
    List<Animal> findAdopted();
    
    @Query("SELECT a.nomeRecebedor, COUNT(a) AS quantidade " +
            "FROM Animal a " +
            "WHERE a.dataEntrada BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY a.nomeRecebedor " +
            "ORDER BY quantidade DESC")
    List<Object[]> countByRecebedorAndPeriodo(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );

    
}

