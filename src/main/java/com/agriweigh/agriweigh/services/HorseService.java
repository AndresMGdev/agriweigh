package com.agriweigh.agriweigh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriweigh.agriweigh.models.Horse;
import com.agriweigh.agriweigh.repositories.IHorseRepository;

@Service
public class HorseService {

    @Autowired
    private IHorseRepository horseRepository;

    public List<Horse> findAll() {
        return horseRepository.findAll();
    }

    public Optional<Horse> findById(Long id) {
        return horseRepository.findById(id);
    }

    public Horse save(Horse horse) {
        horse.setEstimatedWeight(horse.calculateWeight());
        return horseRepository.save(horse);
    }

    public void delete(Long id) {
        horseRepository.deleteById(id);
    }
}
