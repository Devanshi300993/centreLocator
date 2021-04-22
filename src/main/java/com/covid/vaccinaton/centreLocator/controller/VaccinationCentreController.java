package com.covid.vaccinaton.centreLocator.controller;

import com.covid.vaccinaton.centreLocator.model.CitizenDTO;
import com.covid.vaccinaton.centreLocator.service.VaccinationCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/*
@author devanshi.dhabalia

This class is responsible for reading the citizen related data and assigning them vaccination centres as per
their Geo co-ordinates.
*/
@RestController
@RequestMapping(value = "/covid/vaccination")
public class VaccinationCentreController {

    @Autowired
    VaccinationCentreService vaccinationCentreService;

    @PostMapping("/centre-details")
    public List<CitizenDTO> getVaccinationCentre(@RequestBody List<CitizenDTO> citizens) {
        return vaccinationCentreService.fetchVaccinationCentresForCitizens(citizens);
    }

}
