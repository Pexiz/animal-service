package animal_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cachorro")
public class Cachorro extends Animal{
    
    @Column
    private String som;
    
    public Cachorro() {
        this.som = "Latir";
    }
    
    public String getSom() { return som; }
    public void setSom(String som) { this.som = som; }
}
