package animal_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("gato")
public class Gato extends Animal {
    
    @Column
    private String som;
    
    public Gato() {
        this.som = "Miau"; // default em memória
    }
    
    public String getSom() { return som; }
    public void setSom(String som) { this.som = som; }
}