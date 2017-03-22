package io.github.bibekshakya35.ehealth.exception;

import io.github.bibekshakya35.ehealth.exception.config.AppMessageType;

/**
 * {Insert class description here}
 *
 * @author bibek
 */
public class EhealthException extends RuntimeException {

    private final AppMessageType appMessageType;

    public EhealthException(AppMessageType appMessageType) {
        this.appMessageType = appMessageType;
    }

    public AppMessageType getAppMessageType() {
        return appMessageType;
    }

}
