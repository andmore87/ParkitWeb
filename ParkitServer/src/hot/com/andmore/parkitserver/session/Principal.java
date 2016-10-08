package com.andmore.parkitserver.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;
import org.jboss.seam.faces.FacesMessages;

@Name("principal")
public class Principal {
	
    @Logger private Log log;
	
    @In FacesMessages facesMessages;
    
    public void principal()
    {
        //implement your business logic here
        log.info("Principal.principal() action called");
        facesMessages.add("principal");
    }
	
   //add additional action methods
	public boolean showUser()
	{
        //implement your business logic here
        log.info("Principal.principal() action called");
        facesMessages.add("principal");
        return true;
    }
	
	public boolean showCC()
	{
        //implement your business logic here
        log.info("Principal.principal() action called");
        facesMessages.add("principal");
        return true;
    }
	
}
