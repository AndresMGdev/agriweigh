package com.agriweigh.agriweigh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriweigh.agriweigh.models.Horse;

public interface IHorseRepository extends JpaRepository<Horse, Long> {}
