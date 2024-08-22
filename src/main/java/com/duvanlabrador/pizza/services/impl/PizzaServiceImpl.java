package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.exception.ResourceBadRequestException;
import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.PizzaDto;
import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import com.duvanlabrador.pizza.persistence.mappers.PizzaMapper;
import com.duvanlabrador.pizza.persistence.repository.PizzaRepository;
import com.duvanlabrador.pizza.services.interfaces.PizzaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;


    @Override
    public List<PizzaDto> getAllPizzas(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<PizzaEntity> pizza = this.pizzaRepository.findAll(pageable);
        if (pizza.isEmpty()) {
            throw new RuntimeException("Pizza don't exists!!");
        }

        return pizza.getContent().stream().map(this.pizzaMapper::pizzaToPizzaDto).toList();
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

        if (pizza.getDateEvent() == null) {
            pizza.setDateEvent(LocalDateTime.now());
        }

        try {
            PizzaEntity pizzaSave = this.pizzaRepository.save(pizza);
            return this.pizzaMapper.pizzaToPizzaDto(pizzaSave);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceBadRequestException("The pizza with name '" + pizza.getName() + "' already exists.");
        }
    }


    @Override
    public PizzaDto updatePizza(Long idPizza, PizzaDto pizzaDto) {
        verifyPizza(idPizza);
        PizzaEntity pizza = this.pizzaRepository.findById(idPizza).get();
        pizza.setName(pizzaDto.getName());
        pizza.setDescription(pizzaDto.getDescription());
        pizza.setPrice(pizzaDto.getPrice());
        pizza.setVegetarian(pizzaDto.getVegetarian());
        pizza.setVegan(pizzaDto.getVegan());
        pizza.setAvailable(pizzaDto.getAvailable());
        try {
            PizzaEntity pizzaUpdate = this.pizzaRepository.save(pizza);
            return this.pizzaMapper.pizzaToPizzaDto(pizzaUpdate);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceBadRequestException("The pizza with name '" + pizza.getName() + "' already exists.");
        }
    }

    @Override
    public Boolean deletePizzaById(Long idPizza) {
        verifyPizza(idPizza);
        PizzaEntity pizza = this.pizzaRepository.findById(idPizza).get();
        this.pizzaRepository.delete(pizza);
        return true;
    }

    @Override
    public Optional<List<PizzaDto>> getAllPizzasAvailable() {
        Optional<List<PizzaEntity>> pizzaEntities = this.pizzaRepository.findAllAvailablePizzas();
        if (pizzaEntities.isEmpty()){
            throw new ResourceNotFoundException("The list is empty!");
        }
        List<PizzaDto> pizzaDto = pizzaEntities.get().stream().map(this.pizzaMapper::pizzaToPizzaDto).toList();
        return Optional.of(pizzaDto);
    }

    @Transactional
    @Override
    public void updatePrice(Long idPizza, BigDecimal newPrice) {
        verifyPizza(idPizza);
        this.pizzaRepository.updatePrice(idPizza,newPrice);
    }

    private void verifyPizza(Long idPizza) {
        Optional<PizzaEntity> pizza = this.pizzaRepository.findById(idPizza);
        if (pizza.isEmpty()) {
            throw new ResourceNotFoundException("The pizza whit id " + idPizza + " don't exist");
        }
    }
}
