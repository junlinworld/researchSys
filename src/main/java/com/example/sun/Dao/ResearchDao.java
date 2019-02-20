package com.example.sun.Dao;

import com.example.sun.pojo.Answer;
import com.example.sun.pojo.Question;
import com.example.sun.pojo.Research;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ResearchDao {
    int insert(@Param("research") Research research);

    int delete(@Param("researchId") int id);

    int update(@Param("research") Research research);

    Research getResearchById(@Param("researchId") int i);

    Research getResearchByTitle(@Param("researchTitle") String title);


}
