package com.duvanlabrador.pizza.web.controller;

import com.duvanlabrador.pizza.exception.ResourceBadRequestException;
import com.duvanlabrador.pizza.exception.ResourceForbidden;
import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.PizzaDto;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pizzas")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping("")
    public ResponseEntity<List<PizzaDto>> getAllPizzas(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden{
        List<PizzaDto> pizzas = this.pizzaService.getAllPizzas(page, size);
        if (pizzas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaDto> getPizzaById(@PathVariable Long idPizza) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
        PizzaDto pizza = this.pizzaService.getPizzaById(idPizza);
        if (pizza == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @GetMapping("/available")
    public Optional<List<PizzaDto>> getAvailablePizzas() throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
       return this.pizzaService.getAllPizzasAvailable();
    }

    @PostMapping("")
    public ResponseEntity<PizzaDto> createPizza(@RequestBody PizzaDto pizzaDto) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
        if (pizzaDto.getIdPizza() == null) {
            PizzaDto pizza = this.pizzaService.createPizza(pizzaDto);
            return new ResponseEntity<>(pizza, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{idPizza}")
    public ResponseEntity<PizzaDto> updatePizza(@PathVariable Long idPizza, @RequestBody PizzaDto pizzaDto) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
        PizzaDto pizza = this.pizzaService.updatePizza(idPizza, pizzaDto);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @PutMapping("/price/{idPizza}")
    public ResponseEntity<String> updatePricePizza(@PathVariable Long idPizza, @RequestParam BigDecimal newPrice) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden {
        this.pizzaService.updatePrice(idPizza,newPrice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<String> deletePizza(@PathVariable Long idPizza) throws ResourceNotFoundException, ResourceBadRequestException, ResourceForbidden{
        Boolean pizza = this.pizzaService.deletePizzaById(idPizza);
        if (pizza){
            return new ResponseEntity<>("The pizza with id " + idPizza + " has been delete correctly", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
