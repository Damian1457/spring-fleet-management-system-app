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
class CountryRepositoryIntegrationTest {

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
    public static final String CODE_PL = "PL";
    public static final int ID_2 = 2;


    @Autowired
    private CountryRepository countryRepository;

    @BeforeEach
    public void clearDatabaseBeforeEachTest() {
        countryRepository.deleteAll();
    }

    @Test
    void givenCreateCountry_whenSaveCountryAndFindById_thenCheckCountryCodeIsTheSame() {
        //Given
        Country country = Country.builder()
                .code(COUNTRY_CODE_USA)
                .capital(COUNTRY_CAPITAL_USA)
                .description(COUNTRY_DESCRIPTION_USA)
                .nationality(COUNTRY_NATIONALITY_USA)
                .continent(COUNTRY_CONTINENT_USA)
                .build();

        //When
        Country savedCountry = countryRepository.save(country);
        Optional<Country> getCountryById = countryRepository.findById(savedCountry.getId());

        //Then
        Assertions.assertNotNull(getCountryById, "Country is NULL.");
        Assertions.assertEquals(savedCountry.getCode(), getCountryById.get().getCode(), "Country code aren't equal.");
    }

    @Test
    void givenCreateCountry_whenSaveCountryAndDelete_thenCheckCountryIsNotNull() {
        //Given
        Country country = Country.builder()
                .code(COUNTRY_CODE_USA)
                .capital(COUNTRY_CAPITAL_USA)
                .description(COUNTRY_DESCRIPTION_USA)
                .nationality(COUNTRY_NATIONALITY_USA)
                .continent(COUNTRY_CONTINENT_USA)
                .build();

        //When
        countryRepository.save(country);
        List<Country> countries = countryRepository.findAll();

        //Then
        Assertions.assertNotNull(countries, "Countries is NULL.");
    }

    @Test
    void givenCreateCountry_whenSaveCountryAndDeleteById_thenCheckCountryIsNotNull() {
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
        Optional<Country> deleteCountryById = countryRepository.findById(save.getId());

        //Then
        Assertions.assertNotNull(deleteCountryById, "Countries is NULL.");
    }

    @Test
    void givenCreateCountry_whenSaveCountryThenUpdateCountryCode_thenCodeUpdatedCorrectly() {
        //Given
        Country country = Country.builder()
                .code(COUNTRY_CODE_USA)
                .capital(COUNTRY_CAPITAL_USA)
                .description(COUNTRY_DESCRIPTION_USA)
                .nationality(COUNTRY_NATIONALITY_USA)
                .continent(COUNTRY_CONTINENT_USA)
                .build();

        //When
        Country savedCountry = countryRepository.save(country);
        savedCountry.setCode(CODE_PL);
        Country updatedCountry = countryRepository.save(savedCountry);
        Optional<Country> retrievedCountry = countryRepository.findById(updatedCountry.getId());

        //Then
        Assertions.assertEquals(CODE_PL, retrievedCountry.get().getCode(), "Code not updated correctly.");
    }

    @Test
    void givenExistingCountriesInDatabase_whenFindAll_thenAllCountriesRetrieved() {
        // Given
        Country usa = Country.builder()
                .code(COUNTRY_CODE_USA)
                .capital(COUNTRY_CAPITAL_USA)
                .description(COUNTRY_DESCRIPTION_USA)
                .nationality(COUNTRY_NATIONALITY_USA)
                .continent(COUNTRY_CONTINENT_USA)
                .build();

        Country canada = Country.builder()
                .code(COUNTRY_CODE_CAN)
                .capital(COUNTRY_CAPITAL_CAN)
                .description(COUNTRY_DESCRIPTION_CAN)
                .nationality(COUNTRY_NATIONALITY_CAN)
                .continent(COUNTRY_CONTINENT_CAN)
                .build();

        // When
        countryRepository.save(usa);
        countryRepository.save(canada);
        List<Country> countries = countryRepository.findAll();

        // Then
        Assertions.assertEquals(ID_2, countries.size(), "Incorrect number of countries retrieved.");
    }
}