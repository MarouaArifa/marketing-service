package com.bfi.marketing.repository;
import com.bfi.marketing.models.Fete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface FeteRepository extends JpaRepository<Fete,Long>{
    @Query("select f from Fete f where f.titre like %:titre% ")
    List<Fete> findByTitre(String titre);

    @Query("select f from Fete f where cast( f.date as string) like %:date% ")
    List<Fete> findByDate(String date);



}
