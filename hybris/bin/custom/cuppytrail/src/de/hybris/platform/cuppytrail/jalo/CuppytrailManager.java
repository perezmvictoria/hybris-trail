/*
 *  
 * [y] hybris Platform
 *  
 * Copyright (c) 2000-2011 hybris AG
 * All rights reserved.
 *  
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *  
 */
package de.hybris.platform.cuppytrail.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;


public class CuppytrailManager extends GeneratedCuppytrailManager
{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( CuppytrailManager.class.getName() );
	
	public static final CuppytrailManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (CuppytrailManager) em.getExtension( "cuppytrail");
	}
	
}
