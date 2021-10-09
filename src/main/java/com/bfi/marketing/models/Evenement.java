package com.bfi.marketing.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(	name = "events")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 50)
    private String titre;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


    @Size(max = 200)
    private String description;



    @OneToMany (mappedBy="idEvent")
    private Set<publication> publications;


    public Evenement(@Size(max = 50) String titre, Date date, @Size(max = 200) String description) {
        this.titre = titre;
        this.date = date;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description;}

    public Evenement() {}



}
