package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.PizzaDto;
import com.duvanlabrador.pizza.persistence.mappers.PizzaMapper;
import com.duvanlabrador.pizza.persistence.repository.PizzaRepository;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;


    @Override
    public List<PizzaDto> getAllPizzas() {
        return List.of();
    }

    @Override
    public PizzaDto getPizzaById(Long idPizza) {
        return null;
    }

    @Override
    public PizzaDto createPizza(PizzaDto pizzaDto) {
        return null;
    }

    @Override
    public PizzaDto updatePizza(Long idPizza, PizzaDto pizzaDto) {
        return null;
    }

    @Override
    public Boolean deletePizzaById(Long idPizza) {
        return null;
    }
}
