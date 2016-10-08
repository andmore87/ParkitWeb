package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("centroComercialList")
public class CentroComercialList extends EntityQuery
{
    @Override
    public String getEjbql() 
    { 
        return "select centroComercial from Centro_Comercial centroComercial";
    }
}
