package de.hybris.platform.cuppytrail.daos.impl;

import de.hybris.platform.cuppytrail.daos.StadiumDAO;
import de.hybris.platform.cuppytrail.jalo.Stadium;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by vicplum on 17/06/16.
 */
public class DefaultStadiumDAOIntegrationTest extends ServicelayerTransactionalTest {


    @Resource
    private StadiumDAO stadiumDAO;

    @Resource
    private ModelService ms;

    private static final String  STADIUM_NAME     = "wembley";
    private static final Integer STADIUM_CAPACITY = Integer.valueOf(12344);

    @Test
    public void stadiumDAOTest() {
        List<Stadium> stadiumByCode = stadiumDAO.findStadiumsByCode(STADIUM_NAME);
        assertTrue("No hay estadios para devolver", stadiumByCode.isEmpty());

        List<Stadium> allStadiums = stadiumDAO.findStadiums();
        final int size = allStadiums.size();

        final Stadium stadiumModel = new Stadium();
        stadiumModel.setCode(STADIUM_NAME);
        stadiumModel.setCapacity(STADIUM_CAPACITY);
        ms.save(stadiumModel);

        allStadiums = stadiumDAO.findStadiums();
        assertEquals(size + 1, allStadiums.size());
        assertEquals("Estadio insesperado", stadiumModel,allStadiums.get(allStadiums.size() - 1));

        stadiumByCode = stadiumDAO.findStadiumsByCode(STADIUM_NAME);
        assertEquals("No se encontro el estadio ",1,stadiumByCode.get(allStadiums.size()-1));
        assertEquals("Retrieved Stadium's name attribute incorrect",
                        STADIUM_NAME, stadiumByCode.get(0).getCode());
        assertEquals("Retrieved Stadium's capacity attribute incorrect",
                        STADIUM_CAPACITY, stadiumByCode.get(0).getCapacity());
    }



}
