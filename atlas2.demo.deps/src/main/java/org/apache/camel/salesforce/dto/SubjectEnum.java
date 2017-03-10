/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Mon Mar 02 02:58:34 EST 2015
 */
package org.apache.camel.salesforce.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * Salesforce Enumeration DTO for picklist Subject
 */
public enum SubjectEnum {

    // Call
    CALL("Call"),
    // Email
    EMAIL("Email"),
    // Send Letter
    SEND_LETTER("Send Letter"),
    // Send Quote
    SEND_QUOTE("Send Quote"),
    // Other
    OTHER("Other");

    final String value;

    private SubjectEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static SubjectEnum fromValue(String value) {
        for (SubjectEnum e : SubjectEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
