package pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CountryRepositoryTest {

    private static final String COUNTRY_CODE_USA = "USA";
    private static final String COUNTRY_CAPITAL_USA = "Washington D.C.";
    private static final String COUNTRY_DESCRIPTION_USA = "United States of America";
    private static final String COUNTRY_NATIONALITY_USA = "American";
    private static final String COUNTRY_CONTINENT_USA = "North America";
    public static final long NON_EXISTING_ID = 0L;

    @Autowired
    private CountryRepository countryRepository;

    @BeforeEach
    public void clearDatabaseBeforeEachTest() {
        countryRepository.deleteAll();
    }

    @Test
    void givenCreateCountry_whenSaveCountry_thenCheckTheCountryIsInDatabase() {
        //Given
        Country country = Country.builder()
                .code(COUNTRY_CODE_USA)
                .capital(COUNTRY_CAPITAL_USA)
                .description(COUNTRY_DESCRIPTION_USA)
                .nationality(COUNTRY_NATIONALITY_USA)
                .continent(COUNTRY_CONTINENT_USA)
                .build();

        //When
        Country save = countryRepository.save(country);

        //Then
        Assertions.assertNotNull(save, "Country is NULL");
    }

    @Test
    void givenEmptyDatabase_whenFindAll_thenNoCountriesReturned() {
        // Given
        // When
        List<Country> countries = countryRepository.findAll();

        // Then
        Assertions.assertTrue(countries.isEmpty(), "The database is not empty.");
    }

    @Test
    void givenEmptyDatabase_whenFindById_thenCheckIfCountryWithIdIsPresent() {
        // Given
        // When
        Optional<Country> country = countryRepository.findById(NON_EXISTING_ID);

        // Then
        Assertions.assertFalse(country.isPresent(), "A country with this ID exists.");
    }
}
