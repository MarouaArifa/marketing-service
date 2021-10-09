package com.bfi.marketing.payload.request;

import com.bfi.marketing.models.EPlateform;
import com.bfi.marketing.models.EType;
import com.bfi.marketing.models.Evenement;
import com.bfi.marketing.models.Fete;
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
public class PublicationRequest {

    private Date date;
    private EPlateform plateform;// peut etre 3 booleans (instagram, fb, twitter)
    private Evenement idEvent;
    private Fete idFete;


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
