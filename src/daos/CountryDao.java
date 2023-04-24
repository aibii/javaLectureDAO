package daos;

import java.util.List;

import entities.Country;

public class CountryDao implements Dao<Country,String> {

    public List<Country> findAll() {
        return null;
    }

    public Country findById(String code) {
        return null;
    }

    public void insert(Country item) {

    }

    public Boolean update(Country item) {
        return true;
    }

    public Boolean delete(String code) {
        return true;
    }
    
}
