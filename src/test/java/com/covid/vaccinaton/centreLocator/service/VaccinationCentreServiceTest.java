package com.covid.vaccinaton.centreLocator.service;

import com.covid.vaccinaton.centreLocator.dao.VaccinationCentreDao;
import com.covid.vaccinaton.centreLocator.model.CitizenDTO;
import com.covid.vaccinaton.centreLocator.model.VaccinationCentreDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VaccinationCentreServiceTest {

    @Autowired
    VaccinationCentreService vaccinationCentreService;

    @Mock
    VaccinationCentreDao vaccinationCentreDao;


    CitizenDTO citizen1= new CitizenDTO();
    CitizenDTO citizen2= new CitizenDTO();
    List<CitizenDTO> citizenList= new ArrayList<>();
    List<VaccinationCentreDTO> vaccinationCentres= new ArrayList<>();
    VaccinationCentreDTO centre1= new VaccinationCentreDTO();

    @Before
    public void setup() {

        citizen1.setName("Tayna Durr");
        citizen1.setAge(19);
        citizen1.setLatitude(53.09402405506328);
        citizen1.setLongitude(-8.020019531250002);
        citizenList.add(citizen1);
        citizen2.setName("Sebastian Gerth");
        citizen2.setAge(47);
        citizen2.setLatitude(52.53627304145948);
        citizen2.setLongitude(-6.822509765625001);
        citizenList.add(citizen2);

        centre1.setCentreName("Galway Racecourse");
        centre1.setLatitude(53.298810877564875);
        centre1.setLongitude(-8.997003657335881);
        vaccinationCentres.add(centre1);
    }

    //This will test if vaccination centre is assigned to the citizen
    @Test
    public void testFetchVaccinationCentresForCitizensNotNull() throws Exception {
        when(vaccinationCentreDao.getAvailableVaccinationCentres())
                .thenReturn(vaccinationCentres);
       List<CitizenDTO> updatedCitizenList= vaccinationCentreService.fetchVaccinationCentresForCitizens(citizenList);
        assertNotNull(updatedCitizenList.get(0).getVaccinationCentre());
    }

    //This will test if citizens are ordered by Age
    @Test
    public void testAgeOrderOfPatients() throws Exception {
        when(vaccinationCentreDao.getAvailableVaccinationCentres())
                .thenReturn(vaccinationCentres);
        List<CitizenDTO> updatedCitizenList= vaccinationCentreService.fetchVaccinationCentresForCitizens(citizenList);
        assertTrue(updatedCitizenList.get(0).getAge()>updatedCitizenList.get(1).getAge());
    }


}
