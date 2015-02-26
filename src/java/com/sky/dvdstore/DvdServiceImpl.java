package com.sky.dvdstore;

public class DvdServiceImpl implements DvdService {

    private DvdRepository repository;

    @Override
    public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException {
        return repository.retrieveDvd(dvdReference);
    }

    @Override
    public String getDvdSummary(String dvdReference) throws DvdNotFoundException {
        return null;
    }

    public void setRepository(DvdRepository repository) {
        this.repository = repository;
    }
}
