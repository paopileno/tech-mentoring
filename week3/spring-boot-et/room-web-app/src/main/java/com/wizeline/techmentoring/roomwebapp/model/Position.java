/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.techmentoring.roomwebapp.model;

import lombok.ToString;

public enum Position {
    HOUSEKEEPING, SECURITY, FRONT_DESK, CONCIERGE;

    public String toString() {
        switch (this) {
            case CONCIERGE:
                return "Concierge";
            case HOUSEKEEPING:
                return "Housekeeping";
            case FRONT_DESK:
                return "Front Desk";
            case SECURITY:
                return "Security";
        }
        return "";
    }
}
