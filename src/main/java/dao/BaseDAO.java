package dao;

import entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 04.11.13
 * Time: 9:09
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDAO <E extends BaseEntity, K extends Serializable> {

    public void add (E entity);
    public K save (E entity);
    public void update(E entity);
    public void delete (E entity);
    public E get (K id);
    public List<E> findAll(String sql);
    public List<E> findAll();
}