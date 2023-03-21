import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import daos.CityDao;
import daos.LanguageDao;
import entities.City;
import entities.Language;


//need to add comments --

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<Language> languageList;
        List<City> cityList;

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
        
        System.out.println("Cities printed: ");
        for(City city: cityList) {
            System.out.println(city);
        }

        System.out.println("Language printed: ");
        for(Language language: languageList){
            System.out.println(language);
        }

        // Insert
        City insertCity = new City();
        insertCity.setCountryCode("CAN");
        insertCity.setDistrict("King");
        insertCity.setName("Kingston");
        insertCity.setPopulation(136685);
        
        cityDao.insert(insertCity);

        //Using findById and then executing the update
        //Update
        City updateCity = new City();
        updateCity = cityDao.findById(4075);
        updateCity.setPopulation(10000);
        Boolean success = cityDao.update(updateCity);
        
        //Delete
        Boolean succeeded = cityDao.delete(4080);

    }
    catch(Exception ex)
    {
        System.out.println("Exception " + ex.getMessage());
    }
}

}