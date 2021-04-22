package com.covid.vaccinaton.centreLocator.dao;

import com.covid.vaccinaton.centreLocator.model.VaccinationCentreDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/*
@author devanshi.dhabalia

This class acts as a repository getting list of all vaccination centres which are available
*/
@Repository
public class VaccinationCentreDao {


    public List<VaccinationCentreDTO> getAvailableVaccinationCentres()
    {
        // currently the list of vaccination centre is hardcoded,
        // later we can fetch these values from database if we want to keep this data configurable
        List<VaccinationCentreDTO> vaccinationCentres= new ArrayList<>();
        VaccinationCentreDTO centre1= new VaccinationCentreDTO();
        centre1.setCentreName("Galway Racecourse");
        centre1.setLatitude(53.298810877564875);
        centre1.setLongitude(-8.997003657335881);

        VaccinationCentreDTO centre2= new VaccinationCentreDTO();
        centre2.setCentreName("City Hall Cork");
        centre2.setLatitude(51.89742637092438);
        centre2.setLongitude(8.465763459121026);

        VaccinationCentreDTO centre3= new VaccinationCentreDTO();
        centre3.setCentreName("Citywest Convention Centre Dublin");
        centre3.setLatitude(53.28603418885669);
        centre3.setLongitude(-6.4444477725802285);

        vaccinationCentres.add(centre1);
        vaccinationCentres.add(centre2);
        vaccinationCentres.add(centre3);

        return vaccinationCentres;



    }
}
