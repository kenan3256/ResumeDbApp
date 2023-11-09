package org.example.Dao;

import org.example.City.City;

import java.util.List;

public interface CityDaoInter {

    //DAO=Data Acces Objekt

    public List<City> getAll();
    public City getById(int id);
    public  List<City>populationAsc();
    public boolean updateCity (City c);
    public boolean addCitty (City c);
    public boolean removeCity(int id);






}
