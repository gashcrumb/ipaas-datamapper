/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Mon Mar 02 02:58:34 EST 2015
 */
package org.apache.camel.salesforce.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.codehaus.jackson.annotate.JsonProperty;
import org.apache.camel.component.salesforce.api.dto.AbstractSObjectBase;

/**
 * Salesforce DTO for SObject GroupMember
 */
@XStreamAlias("GroupMember")
public class GroupMember extends AbstractSObjectBase {

    // GroupId
    private String GroupId;

    @JsonProperty("GroupId")
    public String getGroupId() {
        return this.GroupId;
    }

    @JsonProperty("GroupId")
    public void setGroupId(String GroupId) {
        this.GroupId = GroupId;
    }

    // UserOrGroupId
    private String UserOrGroupId;

    @JsonProperty("UserOrGroupId")
    public String getUserOrGroupId() {
        return this.UserOrGroupId;
    }

    @JsonProperty("UserOrGroupId")
    public void setUserOrGroupId(String UserOrGroupId) {
        this.UserOrGroupId = UserOrGroupId;
    }

}
