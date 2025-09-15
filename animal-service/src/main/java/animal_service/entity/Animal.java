package animal_service.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "qual_animal", nullable = false, length = 20)
    private String qualAnimal;
    
    @Column(nullable = false)      // nome-provisorio
    private String nomeProvisorio;
    
    @Column(nullable = false)
    private Integer idadeEstimada;
    
    @Column(nullable = false)
    private String raca;
    
    @Column(nullable = false)
    private Date dataEntrada;
    
    @Column
    private Date dataAdocao;
    
    @Column
    private Date dataObito;
    
    @Column(nullable = false)
    private String condicoesChegada;
    
    @Column(nullable = false)
    private String nomeRecebedor;
    
    @Column(nullable = false)
    private String porte;
    
    public String getNomeProvisorio() {
        return nomeProvisorio;
    }
    
    public void setNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }
    
    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }
    
    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }
    
    public String getRaca() {
        return raca;
    }
    
    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public Date getDataEntrada() {
        return dataEntrada;
    }
    
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    public Date getDataAdocao() {
        return dataAdocao;
    }
    
    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }
    
    public Date getDataObito() {
        return dataObito;
    }
    
    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }
    
    public String getCondicoesChegada() {
        return condicoesChegada;
    }
    
    public void setCondicoesChegada(String condicoesChegada) {
        this.condicoesChegada = condicoesChegada;
    }
    
    public String getNomeRecebedor() {
        return nomeRecebedor;
    }
    
    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }
    
    public String getPorte() {
        return porte;
    }
    
    public void setPorte(String porte) {
        this.porte = porte;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getQualAnimal() {
        return qualAnimal;
    }
    
    public void setQualAnimal(String qualAnimal) {
        this.qualAnimal = qualAnimal;
    }
}
