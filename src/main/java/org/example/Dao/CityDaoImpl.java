package org.example.Dao;

import org.example.AbstractDao.AbstractDao;
import org.example.City.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl extends AbstractDao implements CityDaoInter {
    @Override
    public List<City> getAll() {
        List<City> resualt = new ArrayList<>();
        try {
            Connection c = connection();
            Statement stmt = c.createStatement();
            stmt.execute("select * from city");
            ResultSet rs = stmt.getResultSet();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String countryCode = rs.getString("CountryCode");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                resualt.add(new City(id, name, countryCode, district, population));
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resualt;

    }

    @Override
    public City getById(int cityid) {
        City resualt = new City();
        try {
            Connection c = connection();
            Statement stmt = c.createStatement();
            stmt.execute("select * from city where id=" + cityid);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String countryCode = rs.getString("CountryCode");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                resualt = new City(id, name, countryCode, district, population);
            }
            c.close(); //Connection c = connection() - bub eyni isi gorur
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resualt;

    }

    @Override
    public List<City> populationAsc() {
        List<City> resualt = new ArrayList<>();
        try (Connection c = connection()) {
            Statement stmt = c.createStatement();
            stmt.execute("  select population from world.city order by Population");
            ResultSet rs = stmt.getResultSet();


            while (rs.next()) {
                int population = rs.getInt("Population");
                resualt.add(new City(population));

            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return resualt;
    }

    @Override
    public boolean updateCity(City c1) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("update world.city set Name=?,CountryCode=?,District=?,Population=? where id=?");
            stmt.setString(1, c1.getName());
            stmt.setString(2, c1.getCountryCode());
            stmt.setString(3, c1.getDistrict());
            stmt.setInt(4, c1.getPopulation());
            stmt.setInt(5, c1.getId());
            return stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean addCitty(City city) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement
                    ("INSERT INTO world.city (ID, Name, CountryCode, District,Population) VALUES (?,?,?,?,?);");
            stmt.setInt(1, city.getId());
            stmt.setString(2, city.getName());
            stmt.setString(3, city.getCountryCode());
            stmt.setString(4, city.getDistrict());
            stmt.setInt(5, city.getPopulation());
            return stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }



        @Override
        public boolean removeCity ( int id){
            try (Connection c = connection()) {

                Statement stmt = c.createStatement();
                stmt.execute("delete from world.city  where id=" + id);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;


        }


    }


