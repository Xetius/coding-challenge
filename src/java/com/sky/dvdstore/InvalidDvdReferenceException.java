package com.sky.dvdstore;

import java.security.InvalidParameterException;

public class InvalidDvdReferenceException extends InvalidParameterException {
    public static final String ERROR_MESSAGE_TEMPLATE = "Invalid DVD Reference %s. DVD Reference must start with DVD-";

    public InvalidDvdReferenceException(String dvdReference) {
        super(String.format(ERROR_MESSAGE_TEMPLATE, dvdReference));
    }
}
