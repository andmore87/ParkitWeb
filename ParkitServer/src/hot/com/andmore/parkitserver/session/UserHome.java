package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.andmore.parkitserver.entity.Usuario;

@Name("userHome")
public class UserHome extends EntityHome<Usuario>
{

    @RequestParameter 
    int userId;
    
    @Override
    public Object getId() 
    { 
        if (userId==0)
        {
            return super.getId();
        }
        else
        {
            return userId;
        }
    }
    
    @Override @Begin
    public void create() {
        super.create();
    }
 	
}
