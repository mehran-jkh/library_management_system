package com.example.lib_management.baseUCService;


import com.example.lib_management.AAA.commons.exceptions.RepeatedPassword;
import com.example.lib_management.common.BaseFilterDTO;
import com.example.lib_management.common.base_search_types;
import com.example.lib_management.common.jpaOP;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseUCServiceImpl<MODEL,ENTITY > implements BaseUCService<MODEL>
{

    ///////////////////////////////////////////////////////////////////////////////////////////////// GETTERS AND SETTERS
    protected SessionFactory sessionFactory;
    protected ModelMapper modelMapper;
    private Class<MODEL> modelClass;
    private Class<ENTITY> entityClass;
    private String model_ClassName;
    private String entity_ClassName;



    public BaseUCServiceImpl()
    {}

    public BaseUCServiceImpl(Class<MODEL> modelClass , Class<ENTITY> entityClass)
    {
        this.modelClass=modelClass;
        this.entityClass=entityClass;
        this.entity_ClassName= entityClass.getSimpleName();
        this.model_ClassName= modelClass.getSimpleName();
    }
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////// DAO METHODS

    protected String Add(ENTITY entity)
    {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        return "the " + this.entity_ClassName + " has been added successfully ";
    }

    /////////////////////////////////////////////////////////// UPDATE
    protected ENTITY Edit(ENTITY entity)
    {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(entity);
        session.getTransaction().commit();
        return entity;
    }

    /////////////////////////////////////////////////////////// REMOVE

    protected void Remove(ENTITY entity) {}

    @Transactional
    protected void Remove(int id)
    {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        ENTITY entity=session.find( entityClass, id);
        session.remove(entity);
        session.getTransaction().commit();
    }
    /////////////////////////////////////////////////////////// FINDERS

    protected List<ENTITY> FindAll()
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT e FROM " + entity_ClassName + " e");
        return (List<ENTITY>) query.getResultList();
    }


    protected ENTITY FindbyId(int id)
    {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Query query = session.createQuery("select e from " + entity_ClassName + " e  where e.id=" + id);
        List<ENTITY> list = query.list();

        session.getTransaction().commit();
        return list.get(0);
    }


    protected List<ENTITY> FindbyField(String fieldname, String operation, Object fieldvalue)
    {
        Session session = sessionFactory.openSession();
        List<ENTITY> list = session.createQuery("SELECT e FROM " + entity_ClassName + " e WHERE e." + fieldname + operation + ":FieldValue")
                .setParameter("FieldValue", fieldvalue).getResultList();
        return list;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////// DTO METHODS


    //////////////////////////////////////////////////////////// INSERT

    @Override
    public String add_model(MODEL model)
    {
        ENTITY entity=modelMapper.map(model , entityClass);
        return this.Add(entity) ;
    }
    //////////////////////////////////////////////////////////// UPDATE
    @Override
    public String update_model(MODEL model) throws RepeatedPassword
    {
        this.Edit(modelMapper.map(model , entityClass));
        return "update was successfully" ;
    }

    //////////////////////////////////////////////////////////// DELETE
    @Override
    public void delete_model(int id)
    {
        this.Remove( id);
    }
    //////////////////////////////////////////////////////////// FINDER
    @Override
    public MODEL return_model_by_id(int id)
    {
        return modelMapper.map(this.FindbyId(id) , modelClass);
    }

    @Override
    public List<MODEL> return_models_by_field(String fieldname, String operation, Object fieldvalue) {
        List<ENTITY> entityList=this.FindbyField(fieldname, operation , fieldvalue );
        List<MODEL> modelList=new ArrayList<>();
        modelList=entityList.stream().map(entity -> modelMapper.map(entity , modelClass)).collect(Collectors.toList());
        return modelList;
    }

    @Override
    public List<MODEL> return_all_models()
    {
        List<ENTITY> entityList=this.FindAll();
        List<MODEL> modelList=new ArrayList<>();

        modelList=entityList.stream().map(entity -> modelMapper.map(entity , modelClass)).collect(Collectors.toList());
        return modelList;
    }



    @Override
    public List<MODEL> return_filtered_models(BaseFilterDTO baseFilterDTO) {
        return null;
    }


    // generic search method
    public List<MODEL> return_filtered_models(BaseFilterDTO baseFilterDTO , HashMap<Integer ,String> search_fields)
    {
        base_search_types baseSearchTypes=new base_search_types();
        String search_type= baseSearchTypes.getSearchTypes().get(baseFilterDTO.getSearch_type_code());
        int search_type_code= baseFilterDTO.getSearch_type_code();

        String search_field= search_fields.get(baseFilterDTO.getSearch_field_code());


        String search_value= baseFilterDTO.getValue();


        String query_search_value = search_value;
		String query_search_operation= jpaOP.Eq;


        if(search_value==null || search_value.equals(""))
        {
            return this.return_all_models();
        }


        if(search_type_code==0) //exactly equal
		{
			query_search_operation= jpaOP.Eq;
			query_search_value =search_value;
		}
		else if(search_type_code==1) //contains
		{
			query_search_operation= jpaOP.Like;
			query_search_value ="%"+search_value+"%";
		}
		else if(search_type_code==2) // starts with
		{
			query_search_operation= jpaOP.Like;
			query_search_value =search_value+"%";
		}
		else if(search_type_code==3) //ends with
		{
			query_search_operation= jpaOP.Like;
			query_search_value ="%"+search_value;
		}

        List<ENTITY> entityList =  this.FindbyField(search_field , query_search_operation , query_search_value);

        List<MODEL> modelList=new ArrayList<>();
        for (ENTITY entity:entityList)
        {
            modelList.add(modelMapper.map(entity , modelClass));
        }
        modelList=entityList.stream().map(entity -> modelMapper.map(entity , modelClass)).collect(Collectors.toList());
        return modelList;
    }


}
