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
 * Salesforce DTO for SObject ObjectPermissions
 */
@XStreamAlias("ObjectPermissions")
public class ObjectPermissions extends AbstractSObjectBase {

    // ParentId
    private String ParentId;

    @JsonProperty("ParentId")
    public String getParentId() {
        return this.ParentId;
    }

    @JsonProperty("ParentId")
    public void setParentId(String ParentId) {
        this.ParentId = ParentId;
    }

    // SobjectType
    @XStreamConverter(PicklistEnumConverter.class)
    private SobjectTypeEnum SobjectType;

    @JsonProperty("SobjectType")
    public SobjectTypeEnum getSobjectType() {
        return this.SobjectType;
    }

    @JsonProperty("SobjectType")
    public void setSobjectType(SobjectTypeEnum SobjectType) {
        this.SobjectType = SobjectType;
    }

    // PermissionsCreate
    private Boolean PermissionsCreate;

    @JsonProperty("PermissionsCreate")
    public Boolean getPermissionsCreate() {
        return this.PermissionsCreate;
    }

    @JsonProperty("PermissionsCreate")
    public void setPermissionsCreate(Boolean PermissionsCreate) {
        this.PermissionsCreate = PermissionsCreate;
    }

    // PermissionsRead
    private Boolean PermissionsRead;

    @JsonProperty("PermissionsRead")
    public Boolean getPermissionsRead() {
        return this.PermissionsRead;
    }

    @JsonProperty("PermissionsRead")
    public void setPermissionsRead(Boolean PermissionsRead) {
        this.PermissionsRead = PermissionsRead;
    }

    // PermissionsEdit
    private Boolean PermissionsEdit;

    @JsonProperty("PermissionsEdit")
    public Boolean getPermissionsEdit() {
        return this.PermissionsEdit;
    }

    @JsonProperty("PermissionsEdit")
    public void setPermissionsEdit(Boolean PermissionsEdit) {
        this.PermissionsEdit = PermissionsEdit;
    }

    // PermissionsDelete
    private Boolean PermissionsDelete;

    @JsonProperty("PermissionsDelete")
    public Boolean getPermissionsDelete() {
        return this.PermissionsDelete;
    }

    @JsonProperty("PermissionsDelete")
    public void setPermissionsDelete(Boolean PermissionsDelete) {
        this.PermissionsDelete = PermissionsDelete;
    }

    // PermissionsViewAllRecords
    private Boolean PermissionsViewAllRecords;

    @JsonProperty("PermissionsViewAllRecords")
    public Boolean getPermissionsViewAllRecords() {
        return this.PermissionsViewAllRecords;
    }

    @JsonProperty("PermissionsViewAllRecords")
    public void setPermissionsViewAllRecords(Boolean PermissionsViewAllRecords) {
        this.PermissionsViewAllRecords = PermissionsViewAllRecords;
    }

    // PermissionsModifyAllRecords
    private Boolean PermissionsModifyAllRecords;

    @JsonProperty("PermissionsModifyAllRecords")
    public Boolean getPermissionsModifyAllRecords() {
        return this.PermissionsModifyAllRecords;
    }

    @JsonProperty("PermissionsModifyAllRecords")
    public void setPermissionsModifyAllRecords(Boolean PermissionsModifyAllRecords) {
        this.PermissionsModifyAllRecords = PermissionsModifyAllRecords;
    }

}
