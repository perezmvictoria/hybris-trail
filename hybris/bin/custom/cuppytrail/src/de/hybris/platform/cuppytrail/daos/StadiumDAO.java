package de.hybris.platform.cuppytrail.daos;

import de.hybris.platform.cuppytrail.jalo.Stadium;

import java.util.List;

/**
 * Created by vicplum on 17/06/16.
 */
public interface StadiumDAO {
    public List<Stadium> findStadiums();
    public List<Stadium> findStadiumsByCode(String code);
}
