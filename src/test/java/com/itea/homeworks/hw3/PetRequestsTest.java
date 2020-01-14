package com.itea.homeworks.hw3;

import com.itea.homeworks.hw3.models.Pet;
import com.itea.homeworks.hw3.requests.PetRequests;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PetRequestsTest {
    private static PetRequests petRequests;
    private static Logger log;

    @Before
    public void setUp() {
        petRequests = new PetRequests();
        log = Logger.getLogger(PetRequests.class);
    }

    @Test
    public void shouldPostCorrectly() {
        Pet pet = new Pet(234, "Sharik", "sold");
        try {
            assertEquals(404, petRequests.getPet(234));
            assertEquals(200, petRequests.postPet(pet));
            assertEquals(200, petRequests.getPet(234));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void shouldPutCorrectly() {
        Pet pet1 = new Pet(500, "Bobik", "new");
        Pet pet2 = new Pet(500, "Vovik", "sold");

        try {
            petRequests.postPet(pet1);
            assertEquals(200, petRequests.putPet(pet2));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void shouldDeleteCorrectly() {
        Pet pet = new Pet(1000, "Max", "new");
        try {
            petRequests.postPet(pet);
            assertEquals(200, petRequests.deletePet(1000));
            assertEquals(404, petRequests.getPet(1000));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
