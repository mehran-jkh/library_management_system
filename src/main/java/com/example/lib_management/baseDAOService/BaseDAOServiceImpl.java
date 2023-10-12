package com.example.lib_management.baseDAOService;

import com.example.lib_management.AAA.commons.exceptions.mException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service

public class BaseDAOServiceImpl<T> implements BaseDAOService<T> {
    protected SessionFactory sessionFactory;

    private Class<T> Classtype;
    private String ClassName;

    public BaseDAOServiceImpl(Class<T> type)
    {
        this.Classtype = type;
        ClassName = Classtype.getSimpleName();
    }

    public BaseDAOServiceImpl(){}




    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
  //  @Transactional
    public String Add(T entity)  throws mException
    {
        System.out.println("entering Add method...!!!");
        Session session=sessionFactory.openSession();

        session.save(entity);

        return "the "+this.ClassName+ " has been added successfully (without exception handling...!!!";
    }

    ///////////////////////////////////////////////////////////
    @Override
    public T Edit(T entity) {
        Session session=sessionFactory.openSession();

        session.getTransaction().begin();
        session.update(entity);
        session.getTransaction().commit();

        return entity;
    }
    /////////////////////////////////////////////////////////// REMOVE
    @Override
    public void Remove(T entity) {

    }

    @Override
    @Transactional

    public void Remove(int id)
    {
        System.out.println("inside Reomove method with id: "+id);
        Session session=sessionFactory.openSession();

        session.getTransaction().begin();

        Query query= session.createQuery("delete from "+ClassName+" e  where e.id="+id);
        query.executeUpdate();

        session.getTransaction().commit();
    }

    ///////////////////////////////////////////////////////////



    ///////////////////////////////////////////////////////////
    @Override
    public List<T> FindAll() {
        Session session=sessionFactory.openSession();

        Query query = session.createQuery("SELECT e FROM " + ClassName + " e");
        return (List<T>) query.getResultList();
    }

    @Override
    public T FindbyId(int id) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

        Query query= session.createQuery("select e from "+ClassName+" e  where e.id="+id);
        List<T> list=query.list();

        session.getTransaction().commit();

        return list.get(0);
    }

    @Override
    public List<T> FindbyField(String fieldname , String operation , Object fieldvalue) {
        Session session=sessionFactory.openSession();
        List<T> list=session.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldname + operation + ":FieldValue")
                .setParameter("FieldValue",fieldvalue).getResultList();


        return list;
    }


}