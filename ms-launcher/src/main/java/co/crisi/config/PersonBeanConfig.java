package co.crisi.config;

import co.crisi.adapter.PersonPersistenceJpaAdapter;
import co.crisi.port.api.PersonServicePort;
import co.crisi.port.spi.PersonPersistencePort;
import co.crisi.service.PersonServicePortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonBeanConfig {

    @Bean
    public PersonServicePort personServicePort() {
        return new PersonServicePortImpl(personPersistencePort());
    }

    @Bean
    public PersonPersistencePort personPersistencePort() {
        return new PersonPersistenceJpaAdapter();
    }

}
