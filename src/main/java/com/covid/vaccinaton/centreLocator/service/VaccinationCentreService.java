package com.covid.vaccinaton.centreLocator.service;

import com.covid.vaccinaton.centreLocator.dao.VaccinationCentreDao;
import com.covid.vaccinaton.centreLocator.model.CitizenDTO;
import com.covid.vaccinaton.centreLocator.model.VaccinationCentreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class VaccinationCentreService {

    private static final Logger LOG = LoggerFactory.getLogger(VaccinationCentreService.class);

    @Autowired
    VaccinationCentreDao vaccinationCentreDao;


    public List<CitizenDTO> fetchVaccinationCentresForCitizens(List<CitizenDTO> citizens) {
        List<VaccinationCentreDTO> vaccinationCentres = vaccinationCentreDao.getAvailableVaccinationCentres();
        if (!CollectionUtils.isEmpty(citizens)) {
            setVaccinationCentre(citizens, vaccinationCentres);
        }
        //here we are comparing by age to prioritize order of vaccination to be given to citizens
        Comparator<CitizenDTO> compareByAge = Comparator.comparing(CitizenDTO::getAge).reversed();
        Collections.sort(citizens, compareByAge);
        return citizens;
    }

    /* This method iterates through citizens and centres and finds the nearest centre
       to set the details in CitizenDTO*/
    private void setVaccinationCentre(List<CitizenDTO> citizens, List<VaccinationCentreDTO> centres) {
        citizens.forEach(citizen -> {
            String selectedCentre = null;
            double selectedDistance = Double.MAX_VALUE;
            for (VaccinationCentreDTO centre : centres) {
                if (Objects.nonNull(centre) && Objects.nonNull(citizen)) {
                    try {
                        double calculatedDistance = calculateDistance(citizen.getLatitude(), citizen.getLongitude(), centre.getLatitude(), centre.getLongitude());
                        if (calculatedDistance < selectedDistance) {
                            selectedDistance = calculatedDistance;
                            selectedCentre = centre.getCentreName();
                        }
                    } catch (Exception e) {
                        LOG.error("Error in calculation of shortest distance" + e);
                    }
                }
            }
            citizen.setVaccinationCentre(selectedCentre);

        });
    }

    /* This is the standard method used to calculate the distance between two Geo Co-ordinates
     * It returns distance in miles*/
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // haversine great circle distance approximation, returns meters
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60; // 60 nautical miles per degree of seperation
        dist = dist * 1852; // 1852 meters per nautical mile
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
