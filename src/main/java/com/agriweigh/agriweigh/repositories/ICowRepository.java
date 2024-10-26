package com.agriweigh.agriweigh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriweigh.agriweigh.models.Cow;

public interface ICowRepository extends JpaRepository<Cow, Long> {}
