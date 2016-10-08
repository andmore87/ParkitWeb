package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.andmore.parkitserver.entity.Centro_Comercial;

@Name("centro_ComercialHome")
public class Centro_ComercialHome extends EntityHome<Centro_Comercial>
{

    @RequestParameter 
    Long centro_ComercialId;
    
    @Override
    public Object getId() 
    { 
        if (centro_ComercialId==null)
        {
            return super.getId();
        }
        else
        {
            return centro_ComercialId;
        }
    }
    
    @Override @Begin
    public void create() {
        super.create();
    }
 	
}
