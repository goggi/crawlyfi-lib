package com.crawlyfi.lib.dao.core;

import java.io.Serializable;
import java.util.HashMap;

public class GenericDao<T> implements IGenericDao<T> {

    @Override
    public T findById(Object id) {
        return null;
    }

    @Override
    public void save(HashMap<String, String> values) {
    }

}