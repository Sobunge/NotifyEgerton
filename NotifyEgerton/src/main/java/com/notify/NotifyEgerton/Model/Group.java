package com.notify.NotifyEgerton.Model;


public class Group extends cluster {
  
    private String groupId;

    public Group(String groupId, String name, String description) {
        super(name, description);
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    
    
}
