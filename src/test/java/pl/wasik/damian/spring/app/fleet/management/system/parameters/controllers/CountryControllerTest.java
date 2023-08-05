package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Country;
//import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.CountryRepository;
//
//@SpringBootTest
//public class CountryControllerTest {
//
//    public static final long ID_19 = 19L;
//    public static final long ID_100 = 100L;
//    @Autowired
//    private CountryRepository countryRepository;
//
//    @Test
//    public void testFindCountryById() {
//        //Given
//        Country country = countryRepository.findById(ID_19).orElse(null);
//
//        //When and Then
//        Assertions.assertNotNull(country, "country is NULL");
//    }
//
//    @Test
//    public void testFindCountryByIdNull() {
//        //Given
//        Country country = countryRepository.findById(ID_100).orElse(null);
//
//        //When and Then
//        Assertions.assertNull(country, "country isn't NULL");
//    }
//}