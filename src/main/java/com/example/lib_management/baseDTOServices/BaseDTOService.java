package com.example.lib_management.baseDTOServices;

import com.example.lib_management.AAA.commons.exceptions.mException;

import java.util.List;

public interface BaseDTOService <MODEL>{


    public List<MODEL> return_all_models();

    public String add_model(MODEL model) throws mException;

    public MODEL return_model_by_id(int id);





}
