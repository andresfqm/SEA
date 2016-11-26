/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.ComentarioCambioAsesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface ComentarioCambioAsesorFacadeLocal {

    void create(ComentarioCambioAsesor comentarioCambioAsesor);

    void edit(ComentarioCambioAsesor comentarioCambioAsesor);

    void remove(ComentarioCambioAsesor comentarioCambioAsesor);

    ComentarioCambioAsesor find(Object id);

    List<ComentarioCambioAsesor> findAll();

    List<ComentarioCambioAsesor> findRange(int[] range);

    int count();
    
}
