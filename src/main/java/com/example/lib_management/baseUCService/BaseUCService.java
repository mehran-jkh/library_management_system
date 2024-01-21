package com.example.lib_management.baseUCService;

import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.common.BaseFilterDTO;

import java.util.List;

public interface BaseUCService<MODEL>
{

    public String add_model(MODEL model) throws RepeatedPassword;


    public String update_model(MODEL model) ;


    public void delete_model(int id);


    public MODEL return_model_by_id(int id);
    public List<MODEL> return_models_by_field(String fieldname, String operation, Object fieldvalue);
    public List<MODEL> return_all_models();
    public List<MODEL> return_filtered_models(BaseFilterDTO baseFilterDTO );

}
