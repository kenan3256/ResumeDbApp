package org.example;

import org.example.Dao.CityDaoImpl;
import org.example.Dao.CityDaoInter;

public class Context {
    public static CityDaoInter instanceCityDao(){
        return new CityDaoImpl();
    }
}
