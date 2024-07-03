package com.example.controller;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription
public record AtuadorDTO(Long id, String name, boolean status) {
}
