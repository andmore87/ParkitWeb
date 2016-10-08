package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.andmore.parkitserver.entity.Centro_Comercial;

@Name("centroComercialHome")
public class CentroComercialHome extends EntityHome<Centro_Comercial>
{

    @RequestParameter 
    Long centroComercialId;
    
    @Override
    public Object getId() 
    { 
        if (centroComercialId==null)
        {
            return super.getId();
        }
        else
        {
            return centroComercialId;
        }
    }
    
    @Override @Begin
    public void create() {
        super.create();
    }
 	
}
