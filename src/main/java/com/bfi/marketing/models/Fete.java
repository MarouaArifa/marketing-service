package com.bfi.marketing.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(	name = "fetes")
public class Fete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @Size(max = 50)
    private String titre;

    @Size(max = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EType type;

   /* @OneToOne(mappedBy = "idFete")
    private publication publication;*/

    public Fete( @Size(max = 50) String titre,Date date,  @Size(max = 200) String description, EType type) {
        this.titre = titre;
        this.date = date;

        this.description = description;
        this.type = type;

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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }


    public Fete() {
    }
}
