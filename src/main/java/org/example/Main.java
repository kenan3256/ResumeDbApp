package org.example;


import org.example.City.City;
import org.example.Dao.CityDaoImpl;
import org.example.Dao.CityDaoInter;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void addCity(){
        Scanner sc=new Scanner(System.in);
        CityDaoInter cityDaoContex=Context.instanceCityDao();

        System.out.println("id= ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("name= ");
        String name=sc.nextLine();
        System.out.println("country code= ");
        String countrycode=sc.nextLine();
        System.out.println("distinc= ");
        String distinc=sc.nextLine();
        System.out.println("population= ");
        int poupulation=sc.nextInt();

        City c=new City();
        c.setId(id);
        c.setName(name);
        c.setCountryCode(countrycode);
        c.setDistrict(distinc);
        c.setPopulation(poupulation);
        cityDaoContex.addCitty(c);

    }



    public static void updateCity(){
        Scanner sc=new Scanner(System.in);
       System.out.println("Deyismek istediyiniz setrin id daxil edin = ");
        int id=sc.nextInt();
      // sc.nextLine();

        CityDaoInter cityDao = new CityDaoImpl();
        City c = cityDao.getById(id);
//         eyer biz bunu "City c1=new City();" - bele yazsaydiq bu zaman bize bos
//         yeni setir getiri ve biz bu bos setri doldururuq
//         indi yazdigimizda ise biz id 2 olan setiri verir ve biz hemin setrin icindeki datalari deyisirik
//City c = new City(); ve  c.setId(2);

        sc.nextLine();
        System.out.println("name= ");
        String name=sc.nextLine();
        c.setName(name);

        System.out.println("country code= ");
        String countrycode=sc.nextLine();
        c.setCountryCode(countrycode);

        System.out.println("distinc= ");
        String distinc=sc.nextLine();
        c.setDistrict(distinc);

        System.out.println("population= ");
        int poupulation=sc.nextInt();
        c.setPopulation(poupulation);

        cityDao.updateCity(c);
    }

    public static void getAllCity(){
        CityDaoImpl cityDaoImpl=new CityDaoImpl();
        List<City>getAllCity=cityDaoImpl.getAll();
        System.out.println("City" +getAllCity);
    }


    public static void remove(){
        Scanner sc=new Scanner(System.in);
        CityDaoImpl cityDaoImpl=new CityDaoImpl();
        System.out.println("silinecek setr idsini daxil edin: ");
        int removColum=sc.nextInt();
        cityDaoImpl.removeCity(removColum);
        System.out.println(removColum+"-setir silindi");
    }

    public static void main(String[] args) throws Exception {

        updateCity();
        getAllCity();
    }


}
