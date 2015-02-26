package com.sky.dvdstore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DvdServiceImplTest {

    private static final String VALID_DVD_REFERENCE = "DVD-TG423";

    private DvdServiceImpl dvdService;

    @Before
    public void setUp() throws Exception {
        dvdService = new DvdServiceImpl();
        dvdService.setRepository(new DvdRepositoryStub());
    }

    @Test
    public void retrieveDvdRetrievesDvdByReferenceForValidReference() throws Exception {
        final Dvd dvd = dvdService.retrieveDvd(VALID_DVD_REFERENCE);
        assertEquals(dvd.getTitle(), "Topgun");
    }
}