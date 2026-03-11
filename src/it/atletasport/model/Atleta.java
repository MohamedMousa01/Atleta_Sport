package it.atletasport.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "atleta")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "datanascita")
    private LocalDate datanascita;
    @Column(name = "codice")
    private String codice;
    @Column(name = "numeromedaglievinte")
    private int numeroMedaglieVinte;

    @ManyToMany
    @JoinTable(name = "atleta_sport", joinColumns = @JoinColumn (name = "atleta_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sport_id" , referencedColumnName = "id"))

    private Set<Sport> sport = new HashSet<>(0);


    public Atleta(){}

    public Atleta(String nome, String cognome, LocalDate datanascita, String codice, int numeroMedaglieVinte) {
        this.nome = nome;
        this.cognome = cognome;
        this.datanascita = datanascita;
        this.codice = codice;
        this.numeroMedaglieVinte = numeroMedaglieVinte;
    }

    public Atleta(String nome, String cognome, LocalDate datanascita, String codice, int numeroMedaglieVinte, Set<Sport> sport) {
        this.nome = nome;
        this.cognome = cognome;
        this.datanascita = datanascita;
        this.codice = codice;
        this.numeroMedaglieVinte = numeroMedaglieVinte;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(LocalDate datanascita) {
        this.datanascita = datanascita;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getNumeroMedaglieVinte() {
        return numeroMedaglieVinte;
    }

    public void setNumeroMedaglieVinte(int numeroMedaglieVinte) {
        this.numeroMedaglieVinte = numeroMedaglieVinte;
    }

    public Set<Sport> getSport() {
        return sport;
    }

    public void setSport(Set<Sport> sport) {
        this.sport = sport;
    }


    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", datanascita=" + datanascita +
                ", codice='" + codice + '\'' +
                ", numeroMedaglieVinte='" + numeroMedaglieVinte + '\'' +
                '}';
    }
}
