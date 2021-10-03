package com.bfi.marketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EvalFroidRepository extends JpaRepository<EvalFroid,Long> {
    EvalFroid findByid(Long id);
    //Iterable<EvalFroid> findByUserId(Long id);
    EvalFroid findByUserId(Long id);
}
