import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import daos.CityDao;
import daos.CountryDao;
import daos.LanguageDao;
import entities.City;
import entities.Country;
import entities.Language;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<Language> languageList;
        List<City> cityList;
        List<Country> countryList;

        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "fishes12";

        try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();) {

        //cityDao
        CityDao cityDao = new CityDao(connection);
        cityList = cityDao.findAll();

        //LanguageDao
        LanguageDao languageDao = new LanguageDao(connection);
        languageList = languageDao.findAll();

        //countryDao
        CountryDao countryDao = new CountryDao(connection);
        countryList = countryDao.findAll();
        
        System.out.println("Cities printed: ");
        for(City city: cityList) {
            System.out.println(city);
        }

        System.out.println("Language printed: ");
        for(Language language: languageList){
            System.out.println(language);
        }

        System.out.println("Countries printed: ");
        for(Country country: countryList){
            System.out.println(country);
        }

        // Insert City
        City insertCity = new City();
        insertCity.setCountryCode("CAN");
        insertCity.setDistrict("King");
        insertCity.setName("Kingston");
        insertCity.setPopulation(136685);
        
        cityDao.insert(insertCity);

        // Insert Country
        Country insertCountry = new Country();
        insertCountry.setCode("MAL");
        insertCountry.setName("Malenkaya Strana");
        insertCountry.setContinent("Asia");
        insertCountry.setRegion("Western Asia");
        insertCountry.setSurfaceArea(50.00);
        insertCountry.setIndepYear(2000);
        insertCountry.setPopulation(20000);
        insertCountry.setLifeExpectancy(60.5);
        insertCountry.setGnp(700.00);
        insertCountry.setGnpOld(250.00);
        insertCountry.setLocalName("Wonderful Country");
        insertCountry.setGovernmentForm("Republic");
        insertCountry.setHeadOfState("Vasilisa");
        insertCountry.setCapital(2345);
        insertCountry.setCode2("AZ");

        countryDao.insert(insertCountry);

        //Using findById and then executing the update
        //Update
        City updateCity = new City();
        updateCity = cityDao.findById(4075);
        updateCity.setPopulation(15000);
        Boolean success = cityDao.update(updateCity);

        Country updateCountry = new Country();
        updateCountry = countryDao.findById("MAL");
        updateCountry.setPopulation(2000);
        Boolean success2 = countryDao.update(updateCountry);
        
        //Delete
        Boolean succeeded = cityDao.delete(4080);
        Boolean succeeded2 = countryDao.delete("MAL");

    }
    catch(Exception ex)
    {
        System.out.println("Exception " + ex.getMessage());
    }
}

}