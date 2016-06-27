package de.hybris.platform.cuppytrail.facades.impl;

import de.hybris.platform.cuppytrail.data.StadiumData;

import java.util.List;

/**
 * Created by vickitoria on 27/06/16.
 */
public interface StadiumFacade {

    public StadiumData getStadium(String name);

    public List<StadiumData> getStadiums();
}
