package com.agriweigh.agriweigh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriweigh.agriweigh.models.Pig;

public interface IPigRepository extends JpaRepository<Pig, Long> {}
