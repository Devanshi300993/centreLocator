package com.covid.vaccinaton.centreLocator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitizenDTOTest {

    CitizenDTO citizen1;
    CitizenDTO citizen2;

    @BeforeEach
    void setup() {
        citizen1 = new CitizenDTO();
        citizen1.setAge(20);
        citizen1.setName("test user");
        citizen1.setLatitude(52.53627304145948);
        citizen1.setLongitude(-6.822509765625001);
        citizen2 = new CitizenDTO();
        citizen2.setAge(20);
        citizen2.setName("test user");
        citizen2.setLatitude(52.53627304145948);
        citizen2.setLongitude(-6.822509765625001);
    }

    @Test
    public void testGetter() {
        Assertions.assertEquals(citizen1.getAge(), citizen2.getAge());
    }

    @Test
    public void testEquals() {
        Assertions.assertFalse(citizen1.equals(citizen2));
    }

}
