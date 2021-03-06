/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.dao.CategoriePrdDAO;
import com.psnpsn.stocky.model.CategoriePrd;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author psnpsn
 */
@Service
public class CategoriePrdServiceImp implements CategoriePrdService {
    
        @Autowired
    private CategoriePrdDAO fournDao;

    @Transactional
    @Override
    public boolean create(CategoriePrd instance) {
        fournDao.create(instance);
        return true;
    }

    @Transactional (readOnly=true)
    @Override
    public ObservableList getAll() {
        return fournDao.getAll();
    }
    
    @Transactional
    @Override
    public void delete(int id) {
        fournDao.delete(id);
    }

    @Transactional
    @Override
    public boolean update(CategoriePrd instance) {
        fournDao.update(instance);
        return true;
    }

    @Transactional
    @Override
    public CategoriePrd find(int id) {
        return fournDao.find(id);
    }
    
}
