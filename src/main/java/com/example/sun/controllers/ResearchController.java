package com.example.sun.controllers;

import com.example.sun.Dao.ResearchDao;
import com.example.sun.pojo.Research;
import com.example.sun.result.FailResult;
import com.example.sun.result.ReturnResult;
import com.example.sun.result.SuccessResult;
import com.example.sun.service.impl.ResearchService;
import javafx.scene.transform.Scale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.text.SupplementaryCharacterData;

@RestController
public class ResearchController {

    @Autowired
    ResearchService researchService = null;
    @Autowired
    SuccessResult successResult = null;
    @Autowired
    FailResult failResult = null;

    @RequestMapping(value = "/insertResearch", method = RequestMethod.GET)
    public ReturnResult insertResearch(Research research) {
        boolean flag = false;
        try {
            researchService.insertResearch(research);
            successResult.setStausEmessage("insertResearch successful!");
            successResult.setObject(research);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/deleteResearch")
    public ReturnResult deleteResearch(int researchId) {
        boolean flag = false;
        try {
            successResult.setObject(researchService.getResearchById(researchId));
            researchService.deleteResearchById(researchId);
            successResult.setStausEmessage("deleteResearch successful!");
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag ? successResult : failResult;
    }

    @RequestMapping(value = "/updateResearch", method = RequestMethod.POST)
    public ReturnResult updateResearch(Research research) {
        boolean flag = false;
        try {
            researchService.updateResearch(research);
            successResult.setStausEmessage("更新结果成功");
            successResult.setObject(research);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }

        return flag ? successResult : failResult;

    }

    @RequestMapping(value = "/getResearchById", method = RequestMethod.GET)
    public ReturnResult getResearchById(int researchId) {
        boolean flag = false;
        try {
            Research research = researchService.getResearchById(researchId);
            successResult.setStausEmessage("根据id查找成功");
            successResult.setObject(research);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }


        return flag ? successResult : failResult;
    }

    @RequestMapping("/getResearchByTitle")
    public ReturnResult getResearchByTitle(String researchTitle) {
        boolean flag = false;
        try {
            Research research1 = researchService.getResearchByTitle(researchTitle);
            successResult.setStausEmessage("根据title查找成功");
            successResult.setObject(research1);
            flag = true;
        } catch (Exception e) {
            failResult.setStausEmessage(e.getMessage());
        }
        return flag ? successResult : failResult;
    }
}
