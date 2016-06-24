package de.hybris.platform.cuppytrail.daos.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import de.hybris.platform.cuppytrail.daos.StadiumDAO;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.cuppytrail.model.StadiumModel;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;


/**
 * Created by vicplum on 17/06/16.
 */


public class DefaultStadiumDAOIntegrationTest extends ServicelayerTransactionalTest {

    /** As this is an integration test the test to class gets injected here. */
    @Resource
    private StadiumDAO stadiumDAO;

    /** ModelService used for creation of test data. */
    @Resource
    private ModelService modelService;

    /** Name of test stadium. */
    private static final String STADIUM_NAME_NONE = "cualquier cosay si";
    private static final String STADIUM_NAME = "Wembley";

    /** Capacity of test stadium. */
    private static final Integer STADIUM_CAPACITY = Integer.valueOf(12345);

    @Test
    public void stadiumDAOTest() {
        List<StadiumModel> stadiumsByCode = stadiumDAO.findStadiumsByCode(STADIUM_NAME_NONE);
        assertTrue("There should be no Stadium found", stadiumsByCode.isEmpty());

        List<StadiumModel> allStadiums = stadiumDAO.findStadiums();
        final int size = allStadiums.size();

        final StadiumModel stadiumModel = new StadiumModel();
        stadiumModel.setCode(STADIUM_NAME);
        stadiumModel.setCapacity(STADIUM_CAPACITY);
        modelService.save(stadiumModel);

        allStadiums = stadiumDAO.findStadiums();
        assertEquals(size + 1, allStadiums.size());
        assertEquals("Unexpected stadium found", stadiumModel, allStadiums.get(allStadiums.size() - 1));

        stadiumsByCode = stadiumDAO.findStadiumsByCode(STADIUM_NAME);
        assertEquals("Find the one we just saved", 1, stadiumsByCode.size());
        assertEquals("Check the names", STADIUM_NAME, stadiumsByCode.get(0).getCode());
        assertEquals("Check the capacity", STADIUM_CAPACITY, stadiumsByCode.get(0).getCapacity());
    }

    @Test
    public void testFindStadiums_EmptyStringParam()
    {
        //calling findStadiumsByCode() with an empty String - returns no results
        final List<StadiumModel> stadiums = stadiumDAO.findStadiumsByCode("");
        assertTrue("No Stadium should be returned", stadiums.isEmpty());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testfindStadiums_NullParam()
    {
        //calling findStadiumByCode with null should throw an IllegalArgumentException
        stadiumDAO.findStadiumsByCode(null); //method's return value not captured
    }



}
