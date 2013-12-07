package dao;

import entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 04.11.13
 * Time: 9:12
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDAO <E extends BaseEntity,K extends Serializable> implements BaseDAO <E , K >{
  // @Autowired
    private  SessionFactory sessionFactory;


    /*@Autowired*/
    private Class<E> entityClass;


    /* @SuppressWarnings("unchecked")
     public AbstractDAO() {
         this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
     }*/
//-------------------------------------------------------------------------------------

    @Autowired
    @Qualifier("sessionFactory")  //получить второй bean с идентификатором fooService2
    public void setFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    //-------------------------------------------------------------------------------------
    public void add (E entity){
        getSession().save(entity);
    }
    public K save (E entity){       //если нуежен сразу Id
        K id = (K) entity.getId();
        getSession().saveOrUpdate(entity);
        return id;
    }
    public void update(E entity){
        getSession().saveOrUpdate(entity);
    }
    public void delete (E entity){
        getSession().delete(entity);
    }
    public E get (K id){
        E entity = (E)getSession().get(entityClass.getClass() , id);
        return entity;
    }

   /* @Transactional(readOnly = true)*/
    public List<E> findAll(String sql){
        List<E>  list =  getSession().createSQLQuery(sql).addEntity(entityClass).list();
        return list;
    }





}
