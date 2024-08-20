package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.PizzaDto;
import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import com.duvanlabrador.pizza.persistence.mappers.PizzaMapper;
import com.duvanlabrador.pizza.persistence.repository.PizzaRepository;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;


    @Override
    public List<PizzaDto> getAllPizzas() {
        List<PizzaEntity> pizza = this.pizzaRepository.findAll();
        if(pizza.isEmpty()){
            throw new RuntimeException("Pizza don't exists!!");
        }
        return  pizza.stream().map(this.pizzaMapper::pizzaToPizzaDto).toList();
    }

    @Override
    public PizzaDto getPizzaById(Long idPizza) {
        verifyPizza(idPizza);
        PizzaEntity pizza = this.pizzaRepository.findById(idPizza).get();
        return this.pizzaMapper.pizzaToPizzaDto(pizza);
    }

    @Override
    public PizzaDto createPizza(PizzaDto pizzaDto) {
        PizzaEntity pizza = this.pizzaMapper.pizzaDtoToPizza(pizzaDto);
        if(pizza.getDateEvent()==null){
            pizza.setDateEvent(LocalDateTime.now());
        }
        PizzaEntity pizzaSave = this.pizzaRepository.save(pizza);
        return this.pizzaMapper.pizzaToPizzaDto(pizzaSave);
    }

    @Override
    public PizzaDto updatePizza(Long idPizza, PizzaDto pizzaDto) {
        return null;
    }

    @Override
    public Boolean deletePizzaById(Long idPizza) {
        return null;
    }

    private void verifyPizza(Long idPizza){
        Optional<PizzaEntity> pizza = this.pizzaRepository.findById(idPizza);
        if(pizza.isEmpty()){
            throw new ResourceNotFoundException("The pizza whit id " + idPizza + " don't exist");
        }
    }
}
