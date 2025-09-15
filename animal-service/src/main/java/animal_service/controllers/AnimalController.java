package animal_service.controllers;

import animal_service.entity.Animal;
import animal_service.service.AnimalService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private final AnimalService repositoryService;
    
    public AnimalController(AnimalService repositoryService) {
        this.repositoryService = repositoryService;
    }
    
    @GetMapping
    public List<Animal> findAll() {
        return repositoryService.findAll();
    }
    
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return repositoryService.createAnimal(animal);
    }
    
    @GetMapping("/not-adopted")
    public List<Animal> findNotAdopted()
    {
        return repositoryService.findNotAdopted();
    }
    
    @GetMapping("/adopted")
    public List<Animal> findAdopted()
    {
        return repositoryService.findAdopted();
    }
    
    @GetMapping("/todos-resgatados")
    public List<Object[]> allRescued(
        @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
        @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        return repositoryService.countByRecebedorAndPeriodo(dataInicio, dataFim);

}}
    

