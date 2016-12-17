/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.converters;

import com.sea.backend.entities.Subcategoria;
import com.sea.backend.entities.Usuario;
import com.sea.frontend.controller.SubcategoriaController;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

/**
 *
 * @author EdisonArturo
 */
public class Conversor {
    public static SelectItem[] getSelectItems(List<?> lol, boolean selectOne) {
        int size = selectOne ? lol.size() + 1 : lol.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "Seleccione una opcion: ");
            i++;
        }
        for (Object x : lol) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }
    
    @FacesConverter(forClass = Subcategoria.class)
    public static class SubcategoriaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SubcategoriaController controller = (SubcategoriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "SubcategoriaController");
            return controller.getSubcategoria(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Subcategoria) {
                Subcategoria o = (Subcategoria) object;
                return getStringKey(o.getIdSubcategoria());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Subcategoria.class.getName());
            }
        }
    }
    
    @FacesConverter(forClass = Usuario.class)
    public static class usuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SubcategoriaController controller = (SubcategoriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getSubcategoria(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getIdUsuario());

            if (object instanceof Subcategoria) {
                Subcategoria o = (Subcategoria) object;
                return getStringKey(o.getIdSubcategoria());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Subcategoria.class.getName());
            }
        }
    }

}
