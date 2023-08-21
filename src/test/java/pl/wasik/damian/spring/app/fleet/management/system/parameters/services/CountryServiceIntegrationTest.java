package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.CountryRepository;

import java.util.List;

@SpringBootTest
class CountryServiceIntegrationTest {

    public static final String COUNTRY_CODE_PL = "PL";
    public static final String COUNTRY_CAPITAL_PL = "Warsaw";
    public static final String COUNTRY_DESCRIPTION_PL = "Poland in Europe";
    public static final String COUNTRY_NATIONALITY_PL = "Polish";
    public static final String COUNTRY_CONTINENT_EUROPE = "Europe";
    private static final String COUNTRY_CODE_USA = "USA";
    private static final String COUNTRY_CAPITAL_USA = "Washington D.C.";
    private static final String COUNTRY_DESCRIPTION_USA = "United States of America";
    private static final String COUNTRY_NATIONALITY_USA = "American";
    private static final String COUNTRY_CONTINENT_USA = "North America";
    public static final String COUNTRY_CODE_CAN = "CAN";
    public static final String COUNTRY_CAPITAL_CAN = "Ottawa";
    public static final String COUNTRY_DESCRIPTION_CAN = "Canada";
    public static final String COUNTRY_NATIONALITY_CAN = "Canadian";
    public static final String COUNTRY_CONTINENT_CAN = "North America";

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @BeforeEach
    public void clearDatabaseBeforeEachTest() {
        countryRepository.deleteAll();
    }

    @Test
    void givenCreateCountry_whenSaveCountry_thenCountryShouldBeStoredInDatabase() {
        //Given
        Country poland = Country.builder()
                .code(COUNTRY_CODE_PL)
                .capital(COUNTRY_CAPITAL_PL)
                .description(COUNTRY_DESCRIPTION_PL)
                .nationality(COUNTRY_NATIONALITY_PL)
                .continent(COUNTRY_CONTINENT_EUROPE)
                .build();

        //When
        countryService.save(poland);
        List<Country> countries = countryService.findAll();

        //Then
        Assertions.assertNotNull(countries, "Countries is NULL.");
    }

    @Test
    void givenCreateCountry_whenSaveCountry_thenCountryShouldBeFoundById() {
        //Given
        Country usa = Country.builder()
                .code(COUNTRY_CODE_USA)
                .capital(COUNTRY_CAPITAL_USA)
                .description(COUNTRY_DESCRIPTION_USA)
                .nationality(COUNTRY_NATIONALITY_USA)
                .continent(COUNTRY_CONTINENT_USA)
                .build();

        //When
        countryService.save(usa);
        Country findCountryById = countryService.getById(usa.getId());

        //Then
        Assertions.assertNotNull(findCountryById, "There is no country with the specified ID.");
    }

    @Test
    void givenCreateCountry_whenUpdateCountry_thenCountryShouldBeUpdatedInDatabase() {
        //Given
        Country canada = Country.builder()
                .code(COUNTRY_CODE_CAN)
                .capital(COUNTRY_CAPITAL_CAN)
                .description(COUNTRY_DESCRIPTION_CAN)
                .nationality(COUNTRY_NATIONALITY_CAN)
                .continent(COUNTRY_CONTINENT_CAN)
                .build();

        //When
        countryService.save(canada);
        Country findCountryById = countryService.getById(canada.getId());
        findCountryById.setCode(COUNTRY_CODE_PL);
        countryService.update(findCountryById);
        Country updatedCountry = countryService.getById(canada.getId());

        //Then
        Assertions.assertEquals(COUNTRY_CODE_PL, updatedCountry.getCode(), "Codes are not equal.");
    }

    @Test
    void givenCreateCountry_whenDeleteCountry_thenCountryShouldNotExistInDatabase() {
        //Given
        Country canada = Country.builder()
                .code(COUNTRY_CODE_CAN)
                .capital(COUNTRY_CAPITAL_CAN)
                .description(COUNTRY_DESCRIPTION_CAN)
                .nationality(COUNTRY_NATIONALITY_CAN)
                .continent(COUNTRY_CONTINENT_CAN)
                .build();

        //When
        countryService.save(canada);
        countryService.delete(canada.getId());
        Country getCountryById = countryService.getById(canada.getId());

        //Then
        Assertions.assertNull(getCountryById, "The country exists.");
    }
}