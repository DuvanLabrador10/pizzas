package com.duvanlabrador.pizza.web.controller;

import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.PizzaDto;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizzas")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping("")
    public List<PizzaDto> getAllPizzas(){
        return this.pizzaService.getAllPizzas();
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaDto> getPizzaById(@PathVariable Long idPizza) throws ResourceNotFoundException {
       PizzaDto pizza = this.pizzaService.getPizzaById(idPizza);
       if(pizza == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(pizza,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PizzaDto> createPizza(@RequestBody PizzaDto pizzaDto){
        PizzaDto pizza = this.pizzaService.createPizza(pizzaDto);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

}
