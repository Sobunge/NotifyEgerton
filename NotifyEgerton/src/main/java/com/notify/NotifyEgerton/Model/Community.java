package com.notify.NotifyEgerton.Model;

public class Community extends cluster {

    private String communityId;

    public Community(String communityId, String name, String description) {
        super(name, description);
        this.communityId = communityId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

}
