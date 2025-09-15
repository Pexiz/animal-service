package animal_service.service;

import animal_service.entity.Animal;
import animal_service.entity.Cachorro;
import animal_service.entity.Gato;
import animal_service.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@Transactional
public class AnimalService {
    
    private final AnimalRepository repository;
    
    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }
    
    public List<Animal> findAll() {
        return repository.findAll();
    }
    
    public Animal createAnimal(Animal animal) {
        if (animal.getQualAnimal().equalsIgnoreCase("gato"))
        {
            Gato gato = passingAnimaltoCat(animal);
            return repository.save(gato);
        }
        Cachorro cachorro = passingAnimaltoDog(animal);
        return repository.save(cachorro);
    }
    
    public List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }
    
    public List<Animal> findAdopted() {
        return repository.findAdopted();
    }
    
    public List<Object[]> countByRecebedorAndPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        
        Period periodo = Period.between(dataInicio, dataFim);
        
        if (periodo.getYears() >= 1) {
            throw new IllegalArgumentException("O período máximo permitido é de 1 ano.");
        }
        
        return repository.countByRecebedorAndPeriodo(dataInicio, dataFim);
    }
    
    
    private Gato passingAnimaltoCat(Animal animal) {
        Gato gato = new Gato();
        copyCommon(animal, gato);
        return gato;
    }
    
    private Cachorro passingAnimaltoDog(Animal animal) {
        Cachorro cachorro = new Cachorro();
        copyCommon(animal, cachorro);
        return cachorro;
    }
    
    private void copyCommon(Animal animalApi, Animal animalBanco) {
        animalBanco.setCondicoesChegada(animalApi.getCondicoesChegada());
        animalBanco.setDataEntrada(animalApi.getDataEntrada());
        animalBanco.setRaca(animalApi.getRaca());
        animalBanco.setPorte(animalApi.getPorte());
        animalBanco.setNomeProvisorio(animalApi.getNomeProvisorio());
        animalBanco.setIdadeEstimada(animalApi.getIdadeEstimada());
        animalBanco.setNomeRecebedor(animalApi.getNomeRecebedor());
        animalBanco.setQualAnimal(animalApi.getQualAnimal());
        if (animalApi.getDataObito() != null) animalBanco.setDataObito(animalApi.getDataObito());
        if (animalApi.getDataAdocao() != null) animalBanco.setDataAdocao(animalApi.getDataAdocao());
    }
}
