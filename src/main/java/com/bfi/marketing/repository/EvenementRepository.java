package com.bfi.marketing.repository;

import com.bfi.marketing.models.Evenement;
import com.bfi.marketing.models.Fete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
    @Query("select e from Evenement e where e.titre like %:titre%  or cast( e.date as string) like %:titre%")
    List<Evenement> findByTitre(String titre);

    @Query("select e from Evenement e where cast( e.date as string) like %:date% ")
    List<Evenement> findByDate(String date);

}
