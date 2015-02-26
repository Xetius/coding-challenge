package com.sky.dvdstore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DvdServiceImplTest {

    private static final String VALID_DVD_REFERENCE = "DVD-TG423";
    private static final String UNKNOWN_DVD_REFERENCE = "DVD-999";
    private static final String INVALID_DVD_REFERENCE = "INVALID-TEXT";

    private DvdServiceImpl dvdService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void retrieveDvdThrowsExceptionForUnknownDvd() throws Exception {
        expectedException.expect(DvdNotFoundException.class);
        dvdService.retrieveDvd(UNKNOWN_DVD_REFERENCE);
    }

    @Test
    public void retrieveDvdThrowsExceptionForInvalidId() throws Exception {
        expectedException.expect(InvalidDvdReferenceException.class);
        expectedException.expectMessage("Invalid DVD Reference INVALID-TEXT. DVD Reference must start with DVD-");
        dvdService.retrieveDvd(INVALID_DVD_REFERENCE);
    }

    @Test
    public void getDvdSummaryThrowsExceptionForInvalidId() throws Exception {
        expectedException.expect(InvalidDvdReferenceException.class);
        expectedException.expectMessage("Invalid DVD Reference INVALID-TEXT. DVD Reference must start with DVD-");
        dvdService.getDvdSummary(INVALID_DVD_REFERENCE);
    }
}
