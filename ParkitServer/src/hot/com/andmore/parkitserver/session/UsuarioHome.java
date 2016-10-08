package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.andmore.parkitserver.entity.Usuario;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario>
{

    @RequestParameter 
    Long usuarioId;
    
    @Override
    public Object getId() 
    { 
        if (usuarioId==null)
        {
            return super.getId();
        }
        else
        {
            return usuarioId;
        }
    }
    
    @Override @Begin
    public void create() {
        super.create();
    }
 	
}
