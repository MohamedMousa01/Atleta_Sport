package it.atletasport.model;


import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "datainizio")
    private LocalDate dataInizio;
    @Column(name = "datafine")
    private LocalDate dataFine;

    @Enumerated(EnumType.STRING)
    private TipoSport tipo = null;



    public Sport(){}

    public Sport(String descrizione, LocalDate dataInizio, LocalDate dataFine) {
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public TipoSport getTipo() {
        return tipo;
    }

    public void setTipo(TipoSport tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
