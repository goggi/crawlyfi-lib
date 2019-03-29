package com.crawlyfi.lib.dao.core;

public interface IGenericDao<T> {

    T findById(Object id);

}