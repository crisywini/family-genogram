package co.crisi.controller;

import co.crisi.data.PersonInfo;
import co.crisi.objectmother.PersonInfoMother;
import co.crisi.port.api.PersonServicePort;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;


class FamilyControllerTest {

    private final String BASE_URL = "/people/family";

    @Mock
    private PersonServicePort personServicePort;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new FamilyController(personServicePort))
                .setViewResolvers((ViewResolver) (viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void findMother_whenNormalRequestShouldCallAService() throws Exception {
        var id = 2L;
        var person = PersonInfoMother.randomSonWithBothParents();
        given(personServicePort.findOnlyMotherFamily(id))
                .willReturn(person);

        val result = mockMvc.perform(get(BASE_URL + "/mother/" + id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        val response = result.getResponse().getContentAsString();
        val personResponse = JsonMapperUtils.asObject(response, PersonInfo.class);
        assertThat(personResponse)
                .isNotNull()
                .extracting(PersonInfo::getPersonalId,
                        PersonInfo::getName,
                        PersonInfo::getLastName,
                        PersonInfo::getBirthDate,
                        PersonInfo::getMother,
                        PersonInfo::getFather)
                .contains(person.getPersonalId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthDate(),
                        person.getMother(),
                        person.getFather());
    }

}