package com.sky.dvdstore;

public class DvdServiceImpl implements DvdService {

    private static final String DVD_REFERENCE_PREFIX = "DVD-";
    private DvdRepository repository;

    @Override
    public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException {
        return getDvd(dvdReference);
    }

    @Override
    public String getDvdSummary(String dvdReference) throws DvdNotFoundException {
        getDvd(dvdReference);
        return null;
    }

    private Dvd getDvd(String dvdReference) throws DvdNotFoundException {
        validateReference(dvdReference);
        final Dvd dvd = repository.retrieveDvd(dvdReference);
        validateDvd(dvd);
        return dvd;
    }

    private void validateDvd(Dvd dvd) throws DvdNotFoundException {
        if (null == dvd) {
            throw new DvdNotFoundException();
        }
    }

    private void validateReference(String dvdReference) {
        if(!dvdReference.startsWith(DVD_REFERENCE_PREFIX)) {
            throw new InvalidDvdReferenceException(dvdReference);
        }
    }

    public void setRepository(DvdRepository repository) {
        this.repository = repository;
    }
}
