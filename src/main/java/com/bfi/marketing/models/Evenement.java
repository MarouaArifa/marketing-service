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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "events")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @NotBlank
    @Size(max = 50)
    private String titre;

    @NotBlank
    @Size(max = 200)
    private String description;
}
