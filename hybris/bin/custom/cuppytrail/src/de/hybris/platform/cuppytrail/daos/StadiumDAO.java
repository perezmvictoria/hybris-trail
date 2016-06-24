package de.hybris.platform.cuppytrail.daos;

import de.hybris.platform.cuppytrail.model.StadiumModel;
import java.util.List;

/**
 * Created by vicplum on 17/06/16.
 */
public interface StadiumDAO {
    public List<StadiumModel> findStadiums();
    public List<StadiumModel> findStadiumsByCode(String code);
}
