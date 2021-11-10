package com.bfi.marketing.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "publication")
public class publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPlateform plateform;// peut etre 3 booleans (instagram, fb, twitter)

    @ManyToOne(cascade = CascadeType.ALL)
    private Evenement idEvent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFete", referencedColumnName = "id")
    private Fete idFete;


    public publication(Date date, EPlateform plateform, Evenement idEvent, Fete idFete) {
        this.date = date;
        this.plateform = plateform;
        this.idEvent = idEvent;
        this.idFete = idFete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EPlateform getPlateform() {
        return plateform;
    }

    public void setPlateform(EPlateform plateform) {
        this.plateform = plateform;
    }

    public Evenement getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Evenement idEvent) {
        this.idEvent = idEvent;
    }

    public Fete getIdFete() {
        return idFete;
    }

    public void setIdFete(Fete idFete) {
        this.idFete = idFete;
    }


}
