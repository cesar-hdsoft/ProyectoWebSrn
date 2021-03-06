/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.persistencia;

import com.proyectoweb.srn.modelo.SrnTblRol;
import com.proyectoweb.srn.utilidades.UtilidadesSeguridad;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TSI
 */
@Stateless
public class SrnTblRolFacade extends AbstractFacade<SrnTblRol> {
    @PersistenceContext(unitName = UtilidadesSeguridad.NOMBRE_PERSISTENCIA)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SrnTblRolFacade() {
        super(SrnTblRol.class);
    }
    
    public Integer findMaxId() {
        Integer id = 1;
        try {
            Integer maxId = (Integer) em.createNamedQuery("SrnTblRol.findMaxId").getSingleResult();
            if (maxId != null) {
                maxId++;
                id = maxId;
            }
        } catch (Exception e) {
            System.out.println("error metodo findMaxId: " + e.getMessage() + "level: " + Level.SEVERE + " .::. " + e);
//            LogUtil.log("error metodo findMax:" + e.getMessage(), Level.SEVERE, e);
        }
        return id;

    }
}
