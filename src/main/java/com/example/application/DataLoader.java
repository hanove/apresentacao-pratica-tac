package com.example.application;

import com.example.infrastructure.Atuador;
import com.example.infrastructure.AtuadorRepository;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

@Singleton
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    private final AtuadorRepository atuadorRepository;

    public DataLoader(AtuadorRepository atuadorRepository) {
        this.atuadorRepository = atuadorRepository;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        atuadorRepository.save(new Atuador("Atuador 1", true));
    }
}
