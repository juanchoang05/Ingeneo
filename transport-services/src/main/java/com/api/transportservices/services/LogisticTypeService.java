package com.api.transportservices.services;

import com.api.transportservices.models.LogisticTypeModel;
import com.api.transportservices.repositories.ILogisticTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LogisticTypeService {

    @Autowired
    ILogisticTypeRepository logisticTypeRepository;

    public ArrayList<LogisticTypeModel> getLogistic(){
        return  (ArrayList<LogisticTypeModel>) logisticTypeRepository.findAll();
    };

    public LogisticTypeModel saveLogistic(LogisticTypeModel logisticTypeModel){
        return logisticTypeRepository.save(logisticTypeModel);
    }

    public Optional<LogisticTypeModel> getById(Long id){
        return logisticTypeRepository.findById(id);
    }

    public LogisticTypeModel updateById( LogisticTypeModel request, Long id){

        LogisticTypeModel logisticTypeModel = logisticTypeRepository.findById(id).get();

        logisticTypeModel.setLogisticTypeName(request.getLogisticTypeName());
        logisticTypeModel.setWineryOrPortName(request.getWineryOrPortName());

        return logisticTypeModel;
    }

    public Boolean delete(Long id){
        try {
            logisticTypeRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
