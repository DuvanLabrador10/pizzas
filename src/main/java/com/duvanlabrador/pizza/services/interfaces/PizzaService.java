package com.duvanlabrador.pizza.services.interfaces;

import com.duvanlabrador.pizza.persistence.dto.PizzaDto;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    public List<PizzaDto> getAllPizzas(int page, int size);
    public PizzaDto getPizzaById(Long idPizza);
    public PizzaDto createPizza(PizzaDto pizzaDto);
    public PizzaDto updatePizza(Long idPizza, PizzaDto pizzaDto);
    public Boolean deletePizzaById(Long idPizza);
    public Optional<List<PizzaDto>> getAllPizzasAvailable();

}
