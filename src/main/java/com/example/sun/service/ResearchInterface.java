package com.example.sun.service;

import com.example.sun.pojo.Answer;
import com.example.sun.pojo.Question;
import com.example.sun.pojo.Research;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResearchInterface {
    int insertResearch(Research research) throws Exception;

    int deleteResearchById(int id) throws Exception;

    int updateResearch(Research research) throws Exception;

    Research getResearchById(int id) throws Exception;

    Research getResearchByTitle(String researchTitle) throws Exception;
}
