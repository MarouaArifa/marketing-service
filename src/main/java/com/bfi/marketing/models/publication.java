package com.bfi.marketing.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "publication")
public class publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EType type;// peut etre 3 booleans (instagram, fb, twitter)

}
