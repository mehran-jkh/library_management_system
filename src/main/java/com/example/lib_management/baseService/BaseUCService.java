package com.example.lib_management.baseService;

import com.example.lib_management.AAA.commons.exceptions.mException;

import java.util.List;

public interface BaseUCService<T>{
    public String Add(T entity) throws mException;
    public T Edit(T entity);
    public void Remove(T entity);
    public void Remove(int id);
    public List<T> FindAll();
    public T FindbyId(int id);
    public List<T> FindbyField(String fieldname , String operation , Object fieldvalue);







}
