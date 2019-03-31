package com.crawlyfi.lib.dao.core;

import java.util.HashMap;

public interface IGenericDao<T> {
    T findById(Object id);
    void save(HashMap<String,String> values);
}