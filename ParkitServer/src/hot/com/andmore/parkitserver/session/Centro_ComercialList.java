package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("centro_ComercialList")
public class Centro_ComercialList extends EntityQuery
{
    @Override
    public String getEjbql() 
    { 
        return "select centro_Comercial from Centro_Comercial centro_Comercial";
    }
}
