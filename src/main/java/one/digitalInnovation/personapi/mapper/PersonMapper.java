package one.digitalInnovation.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import one.digitalInnovation.personapi.dto.PersonDTO;
import one.digitalInnovation.personapi.entity.Person;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
