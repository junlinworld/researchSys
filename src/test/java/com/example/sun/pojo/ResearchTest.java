package com.example.sun.pojo;

import com.example.sun.SunApplicationTests;
import com.example.sun.service.impl.ResearchService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ResearchTest extends SunApplicationTests {
    @Autowired
    ResearchService researchService = null;

    @Test
    public void insertResearch() {

        for (int i = 0; i < 10; i++) {
            Research research1 = new Research();
            research1.setResearchTitle("helloworld " + i);
            research1.setResearchGuest(1);
            research1.setResearchStartDate("2019-1-15 09:48:00.0");
            research1.setResearchEndDate("2019-1-17 09:48:00.0");
            try {
                researchService.insertResearch(research1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void updateResearch() {
        Research research2 = new Research();
        research2.setResearchTitle("helloworld 1");
        research2.setResearchGuest(0);
        research2.setResearchStartDate("2019-1-15 09:48:20.0");
        research2.setResearchEndDate("2019-1-17 09:48:20.0");

        try {
            researchService.updateResearch(research2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
