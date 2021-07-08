package com.shu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;
import com.shu.entity.Survey;
import com.shu.mapper.SurveyDao;
import com.shu.utils.BeanMapUtils;
import com.shu.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SurveyService {

    @Autowired
    private SurveyDao surveyDao;


    public int create(Survey pi){
        return surveyDao.create(pi);
    }

    public int deleteBatch(String ids){
        int flag = 0;
        List<String> list = Splitter.on(",").splitToList(ids);
        for (String s : list) {
            surveyDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int delete(Integer id){

        return surveyDao.delete(MapParameter.getInstance().addId(id).getMap());

    }

    public int update(Survey survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(survey)).addId(survey.getId()).getMap();
        return surveyDao.update(map);
    }

    public List<Survey> query(Survey survey){
        PageHelper.startPage(survey.getPage(),survey.getLimit());
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyDao.query(map);
    }

    public PageInfo<Survey> queryMySurvey(Survey survey){
        PageHelper.startPage(survey.getPage(),survey.getLimit());
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        PageInfo<Survey> pageInfo = new PageInfo<>(surveyDao.query(map));
        return pageInfo;
    }

    public List<Survey> queryAll(Survey survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyDao.query(map);
    }

    public Survey detail(Integer id){
        return surveyDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Survey survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyDao.count(map);
    }


//    public List<AnswerOpt> queryAnswerOpt(AnswerOpt answerOpt){
//        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(answerOpt)).getMap();
//        return answerOptDao.query(map);
//    }

    public void updateState(){
        List<Integer> list = surveyDao.queryByState(Survey.state_create);
        for (Integer id : list) {
            surveyDao.update(MapParameter.getInstance().add("updateState",Survey.state_exec).add("id",id).getMap());
        }
        List<Integer> list2 = surveyDao.queryByStateForExec(Survey.state_exec);
        for (Integer id : list2) {
            surveyDao.update(MapParameter.getInstance().add("updateState",Survey.state_over).add("id",id).getMap());
        }
    }

//    public Integer submit(List<AnswerOpt> opts,List<AnswerTxt> txts){
//        int flag = 0;
//        for (AnswerOpt opt : opts) {
//            flag = answerOptDao.create(opt);
//        }
//        for (AnswerTxt txt : txts) {
//            flag = answerTxtDao.create(txt);
//        }
//        return flag;
//    }

}
