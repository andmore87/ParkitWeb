package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("usuarioList")
public class UsuarioList extends EntityQuery
{
    @Override
    public String getEjbql() 
    { 
        return "select usuario from Usuario usuario";
    }
}
