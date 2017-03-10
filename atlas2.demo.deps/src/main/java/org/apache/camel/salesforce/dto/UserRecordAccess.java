/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Mon Mar 02 02:58:34 EST 2015
 */
package org.apache.camel.salesforce.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.apache.camel.component.salesforce.api.PicklistEnumConverter;
import org.apache.camel.component.salesforce.api.dto.AbstractSObjectBase;

/**
 * Salesforce DTO for SObject UserRecordAccess
 */
@XStreamAlias("UserRecordAccess")
public class UserRecordAccess extends AbstractSObjectBase {

    // UserId
    private String UserId;

    @JsonProperty("UserId")
    public String getUserId() {
        return this.UserId;
    }

    @JsonProperty("UserId")
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    // RecordId
    private String RecordId;

    @JsonProperty("RecordId")
    public String getRecordId() {
        return this.RecordId;
    }

    @JsonProperty("RecordId")
    public void setRecordId(String RecordId) {
        this.RecordId = RecordId;
    }

    // HasReadAccess
    private Boolean HasReadAccess;

    @JsonProperty("HasReadAccess")
    public Boolean getHasReadAccess() {
        return this.HasReadAccess;
    }

    @JsonProperty("HasReadAccess")
    public void setHasReadAccess(Boolean HasReadAccess) {
        this.HasReadAccess = HasReadAccess;
    }

    // HasEditAccess
    private Boolean HasEditAccess;

    @JsonProperty("HasEditAccess")
    public Boolean getHasEditAccess() {
        return this.HasEditAccess;
    }

    @JsonProperty("HasEditAccess")
    public void setHasEditAccess(Boolean HasEditAccess) {
        this.HasEditAccess = HasEditAccess;
    }

    // HasDeleteAccess
    private Boolean HasDeleteAccess;

    @JsonProperty("HasDeleteAccess")
    public Boolean getHasDeleteAccess() {
        return this.HasDeleteAccess;
    }

    @JsonProperty("HasDeleteAccess")
    public void setHasDeleteAccess(Boolean HasDeleteAccess) {
        this.HasDeleteAccess = HasDeleteAccess;
    }

    // HasTransferAccess
    private Boolean HasTransferAccess;

    @JsonProperty("HasTransferAccess")
    public Boolean getHasTransferAccess() {
        return this.HasTransferAccess;
    }

    @JsonProperty("HasTransferAccess")
    public void setHasTransferAccess(Boolean HasTransferAccess) {
        this.HasTransferAccess = HasTransferAccess;
    }

    // HasAllAccess
    private Boolean HasAllAccess;

    @JsonProperty("HasAllAccess")
    public Boolean getHasAllAccess() {
        return this.HasAllAccess;
    }

    @JsonProperty("HasAllAccess")
    public void setHasAllAccess(Boolean HasAllAccess) {
        this.HasAllAccess = HasAllAccess;
    }

    // MaxAccessLevel
    @XStreamConverter(PicklistEnumConverter.class)
    private MaxAccessLevelEnum MaxAccessLevel;

    @JsonProperty("MaxAccessLevel")
    public MaxAccessLevelEnum getMaxAccessLevel() {
        return this.MaxAccessLevel;
    }

    @JsonProperty("MaxAccessLevel")
    public void setMaxAccessLevel(MaxAccessLevelEnum MaxAccessLevel) {
        this.MaxAccessLevel = MaxAccessLevel;
    }

}
