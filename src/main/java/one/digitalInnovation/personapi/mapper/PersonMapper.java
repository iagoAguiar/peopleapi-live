package one.digitalInnovation.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import one.digitalInnovation.personapi.dto.PersonDTO;
import one.digitalInnovation.personapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
