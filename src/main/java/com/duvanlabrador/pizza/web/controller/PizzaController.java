package com.duvanlabrador.pizza.web.controller;

import com.duvanlabrador.pizza.exception.ResourceBadRequestException;
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
    public List<PizzaDto> getAllPizzas() {
        return this.pizzaService.getAllPizzas();
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaDto> getPizzaById(@PathVariable Long idPizza) throws ResourceNotFoundException {
        PizzaDto pizza = this.pizzaService.getPizzaById(idPizza);
        if (pizza == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PizzaDto> createPizza(@RequestBody PizzaDto pizzaDto) throws ResourceBadRequestException {
        if (pizzaDto.getIdPizza() == null) {
            PizzaDto pizza = this.pizzaService.createPizza(pizzaDto);
            return new ResponseEntity<>(pizza, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{idPizza}")
    public ResponseEntity<PizzaDto> updatePizza(@PathVariable Long idPizza, @RequestBody PizzaDto pizzaDto) throws ResourceNotFoundException {
        PizzaDto pizza = this.pizzaService.updatePizza(idPizza, pizzaDto);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<String> deletePizza(@PathVariable Long idPizza){
        Boolean pizza = this.pizzaService.deletePizzaById(idPizza);
        if (pizza){
            return new ResponseEntity<>("The pizza with id " + idPizza + " has been delete correctly", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
