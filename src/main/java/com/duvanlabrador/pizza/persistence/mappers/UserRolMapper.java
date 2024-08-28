package com.duvanlabrador.pizza.persistence.mappers;

import com.duvanlabrador.pizza.persistence.dto.UserRolDto;
import com.duvanlabrador.pizza.persistence.entity.UserRolEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserRolMapper {

    UserRolDto userRolToUserRolDto(UserRolEntity userRolEntity);

    @InheritInverseConfiguration
    UserRolEntity userRolDtoToUserRol(UserRolDto userRolDto);

}
