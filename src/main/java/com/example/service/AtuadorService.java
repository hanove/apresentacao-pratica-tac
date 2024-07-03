package com.example.service;

import com.example.controller.AtuadorDTO;
import com.example.infrastructure.Atuador;
import com.example.infrastructure.AtuadorRepository;
import io.micronaut.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@Bean
public class AtuadorService {

    private final AtuadorRepository atuadorRepository;

    public AtuadorService(AtuadorRepository atuadorRepository) {
        this.atuadorRepository = atuadorRepository;
    }

    public List<AtuadorDTO> findAll() {
        return atuadorRepository.findAll()
                .stream()
                .map(it -> new AtuadorDTO(it.getId(), it.getNome(), it.getStatus()))
                .toList();
    }

    public Optional<AtuadorDTO> findById(Long id) {
        return atuadorRepository.findById(id)
                .map(it -> new AtuadorDTO(it.getId(), it.getNome(), it.getStatus()));
    }

    public AtuadorDTO create(AtuadorDTO atuadorDTO) {
        var atuador = atuadorRepository.save(new Atuador(atuadorDTO.name(), atuadorDTO.status()));
        return new AtuadorDTO(atuador.getId(), atuador.getNome(), atuador.getStatus());
    }

    public Optional<AtuadorDTO> update(Long id, AtuadorDTO atuadorDTO) {
        var atuadorById = atuadorRepository.findById(id);
        return atuadorById.map(atuador -> {
            atuador.setNome(atuadorDTO.name());
            atuador.setStatus(atuadorDTO.status());
            var atuadorUpdated = atuadorRepository.update(atuador);
            return new AtuadorDTO(atuadorUpdated.getId(), atuadorUpdated.getNome(), atuadorUpdated.getStatus());
        });
    }

    public boolean deleteById(Long id) {
        var atuadorById = atuadorRepository.findById(id);
        if (atuadorById.isEmpty()) {
            return false;
        }
        atuadorRepository.deleteById(id);
        return true;
    }
}
