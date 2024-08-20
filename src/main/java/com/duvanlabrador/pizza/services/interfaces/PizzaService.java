package com.duvanlabrador.pizza.services.interfaces;

import com.duvanlabrador.pizza.persistence.dto.PizzaDto;

import java.util.List;

public interface PizzaService {

    public List<PizzaDto> getAllPizzas();
    public PizzaDto getPizzaById(Long idPizza);
    public PizzaDto createPizza(PizzaDto pizzaDto);
    public PizzaDto updatePizza(Long idPizza, PizzaDto pizzaDto);
    public Boolean deletePizzaById(Long idPizza);

}
