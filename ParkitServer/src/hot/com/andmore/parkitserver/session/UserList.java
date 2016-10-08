package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("userList")
public class UserList extends EntityQuery
{
    @Override
    public String getEjbql() 
    { 
        return "select user from Usuario user";
    }
}
