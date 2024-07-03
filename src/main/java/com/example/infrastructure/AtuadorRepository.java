package com.example.infrastructure;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface AtuadorRepository extends JpaRepository<Atuador, Long>{
}
