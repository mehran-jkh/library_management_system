package com.example.lib_management.baseDTOServices;


import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.baseDAOService.BaseDAOServiceImpl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDTOServiceImpl<MODEL,ENTITY > implements BaseDTOService<MODEL>
{

   public BaseDAOServiceImpl<ENTITY> baseDAOService;
   public ModelMapper modelMapper;
   public Class<MODEL> modelClass;
   public Class<ENTITY> entityClass;

    public BaseDAOServiceImpl<ENTITY> getBaseDAOService() {
        return baseDAOService;
    }

   @Autowired
    public void setBaseDAOService(BaseDAOServiceImpl<ENTITY> baseDAOService) {
        this.baseDAOService = baseDAOService;
    }
    public void my_method(Class<MODEL> modelClass, Class<ENTITY>  entityClass) throws InstantiationException, IllegalAccessException
   {
      this.baseDAOService.set_class_info(entityClass);
      this.modelClass=modelClass;
      this.modelClass=modelClass;
   }
   public BaseDTOServiceImpl()
   {}

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public List<MODEL> return_all_models() {
        return null;
    }

    @Override
    public String add_model(MODEL model) throws mException
    {

        ENTITY entity=modelMapper.map(model , entityClass);

        baseDAOService.Add(entity);

        return "a message without exception handling...";
    }

    @Override
    public MODEL return_model_by_id(int id) {
        return null;
    }
}
