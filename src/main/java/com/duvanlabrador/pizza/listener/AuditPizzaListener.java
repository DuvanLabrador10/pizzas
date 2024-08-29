package com.duvanlabrador.pizza.listener;

import com.duvanlabrador.pizza.persistence.entity.HistoryEntity;
import com.duvanlabrador.pizza.persistence.entity.PizzaEntity;
import com.duvanlabrador.pizza.persistence.entity.UserEntity;
import com.duvanlabrador.pizza.persistence.repository.HistoryRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor(onConstructor_ = @__(@Lazy))
public class AuditPizzaListener {

    private final HistoryRepository historyRepository;

    //Method for INSERT
    @PrePersist
    private void prePersist(PizzaEntity pizza) {
        createHistory(pizza, "INSERT");
    }

    //Method for UPDATE
    @PreUpdate
    private void preUpdate(PizzaEntity pizza) {
        createHistory(pizza, "UPDATE");
    }

    private void createHistory(PizzaEntity pizza, String operation) {
        // Obtener el nombre de usuario del usuario autenticado
        String username = getAuthenticatedUsername();

        HistoryEntity history = new HistoryEntity();
        history.setName(pizza.getName());
        history.setUsername(username);
        history.setDate(LocalDateTime.now());
        history.setOperation(operation);
        this.historyRepository.save(history);
    }

    private String getAuthenticatedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
