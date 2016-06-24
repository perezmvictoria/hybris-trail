package de.hybris.platform.cuppytrail.daos.impl;

import de.hybris.platform.cuppytrail.daos.StadiumDAO;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vickitoria on 21/06/16.
 */
@Component(value="stadiumDAO")
public class DefaultStadiumDAO implements StadiumDAO{

    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<StadiumModel> findStadiumsByCode(String code) {

        final String queryString = "SELECT {p:" + StadiumModel.PK  + "} FROM {" + StadiumModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code",code);
        return flexibleSearchService.<StadiumModel> search(query).getResult();
    }

    @Override
    public List<StadiumModel> findStadiums() {
        final String queryString = "SELECT {p:" + StadiumModel.PK  + "} FROM {" + StadiumModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<StadiumModel> search(query).getResult();
    }
}
