package com.enigmacamp.repo;

import java.util.List;

public interface IBaseRepo <T> {
    void create(T data);
    T getRow(int id);
    List<T> getRows(int page, int pageSize);
    void update(T data);
}
