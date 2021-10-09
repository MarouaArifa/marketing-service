package com.bfi.marketing.repository;

import com.bfi.marketing.models.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {

}
