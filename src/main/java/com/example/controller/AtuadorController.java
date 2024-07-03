package com.example.controller;

import com.example.service.AtuadorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller("/atuador")
public class AtuadorController {

    private final AtuadorService atuadorService;

    public AtuadorController(AtuadorService atuadorService) {
        this.atuadorService = atuadorService;
    }

    @Get
    public HttpResponse<List<AtuadorDTO>> findAll() {
        return HttpResponse.ok(atuadorService.findAll());
    }

    @Get("/{id}")
    public HttpResponse<AtuadorDTO> findById(@PathVariable Long id) {
        var atuador = atuadorService.findById(id);
        if (atuador.isEmpty()) {
            return HttpResponse.notFound();
        }
        return HttpResponse.ok(atuador.get());
    }

    @Post
    public HttpResponse<AtuadorDTO> create(@Body AtuadorDTO atuadorDTO) {
        return HttpResponse.created(atuadorService.create(atuadorDTO));
    }

    @Put("/{id}")
    public HttpResponse<AtuadorDTO> update(@PathVariable Long id, @Body AtuadorDTO atuadorDTO) {
        Optional<AtuadorDTO> atuador = atuadorService.update(id, atuadorDTO);
        if (atuador.isEmpty()) {
            return HttpResponse.notFound();
        }
        return HttpResponse.ok(atuador.get());
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteById(@PathVariable Long id) {
        var deleted = atuadorService.deleteById(id);

        return deleted ? HttpResponse.ok() : HttpResponse.notFound();
    }
}
