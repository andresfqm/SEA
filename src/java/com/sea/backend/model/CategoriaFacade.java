/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author homero
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> implements CategoriaFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    
    
    @Override
    public List<Categoria> findAllName(String nombre) throws Exception{
        
        List<Categoria> catg;
        Query query = em.createNamedQuery("Categoria.findAllNombre", Categoria.class);
        
        try {
            catg=query.getResultList();
        } catch (Exception e) {
            catg= new ArrayList<>();
            System.out.println("error grave"+e.getMessage());
            throw new Exception("error en el query"+e.getMessage());
        }
        return catg;
    }
    
}
