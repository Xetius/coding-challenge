package com.sky.dvdstore;

public class DvdServiceImpl implements DvdService {

    private DvdRepository repository;

    @Override
    public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException {
        final Dvd dvd = repository.retrieveDvd(dvdReference);
        validateDvd(dvd);
        return dvd;
    }

    private void validateDvd(Dvd dvd) throws DvdNotFoundException {
        if (null == dvd) {
            throw new DvdNotFoundException();
        }
    }

    @Override
    public String getDvdSummary(String dvdReference) throws DvdNotFoundException {
        return null;
    }

    public void setRepository(DvdRepository repository) {
        this.repository = repository;
    }
}
