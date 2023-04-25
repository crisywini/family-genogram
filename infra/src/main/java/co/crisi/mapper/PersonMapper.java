package co.crisi.mapper;

import co.crisi.data.PersonInfo;
import co.crisi.entity.Person;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    PersonInfo mapToInfo(Person person);

    Person mapToEntity(PersonInfo personInfo);

    List<PersonInfo> mapToInfos(List<Person> entities);

    List<Person> mapToEntities(List<PersonInfo> infos);

}
