package com.bfi.marketing.repository;

import com.bfi.marketing.models.publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<publication,Long> {
}
