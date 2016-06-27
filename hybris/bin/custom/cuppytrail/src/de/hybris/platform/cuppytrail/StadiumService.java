package de.hybris.platform.cuppytrail;

import de.hybris.platform.cuppytrail.model.StadiumModel;

import java.util.List;


/**
 * Created by vickitoria on 27/06/16.
 */
public interface StadiumService {

    /**
     * Gets all stadiums of the system.
     *
     * @return all stadiums of system
     */
    public List<StadiumModel> getStadiums();

    /**
     * Gets the stadium for given code.
     *
     * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException
     * in case more then one stadium for given code is found
     * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException
     * in case no stadium for given code can be found
     */
    public StadiumModel getStadiumForCode(String code);


}
