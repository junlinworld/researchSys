package com.example.sun.service.impl;

import com.example.sun.Dao.ResearchDao;
import com.example.sun.pojo.Answer;
import com.example.sun.pojo.Question;
import com.example.sun.pojo.Research;
import com.example.sun.service.ResearchInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.List;

@Service
public class ResearchService extends BaseServiceImpl implements ResearchInterface {

    @Autowired
    ResearchDao researchDao = null;

    @Override
    public int insertResearch(Research research) throws Exception {
        Validate(research);

        Research research1 = researchDao.getResearchByTitle(research.getResearchTitle());
        if (research1 != null) {
            throw new Exception("该调查已存在");
        }

        return researchDao.insert(research);

    }

    @Override
    public int deleteResearchById(int id) throws Exception {
        Research research = researchDao.getResearchById(id);
        if (research == null) {
            throw new Exception("该调查不存在");
        }

        return researchDao.delete(id);
    }

    @Override
    public int updateResearch(Research research) throws Exception {
        Validate(research);

        Research research1 = researchDao.getResearchByTitle(research.getResearchTitle());
        if (research1 == null) {
            throw new Exception("该调查不存在");
        }
        return researchDao.update(research);
    }

    @Override
    public Research getResearchById(int researchId) throws Exception {
        Research research = researchDao.getResearchById(researchId);
        if (research == null) {
            throw new Exception("该id对应调查不存在");
        }
        return research;
    }

    @Override
    public Research getResearchByTitle(String researchTitle) throws Exception {
        Research research = researchDao.getResearchByTitle(researchTitle);
        if (research == null) {
            throw new Exception("该title对应调查不存在");
        }
        return research;
    }


}
