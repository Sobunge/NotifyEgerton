package com.notify.NotifyEgerton.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Community {

    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "community_id")
    private Long communityId;

    @NotNull
    @Column(name = "icon")
    @Lob
    private byte[] icon;

    @NotNull
    @Size(min = 6, max = 8)
    @Column(name = "privacy")
    private String privacy;

    @NotNull
    @Size(min = 8, max = 200)
    @Column(name = "description")
    private String description;

   
    @ManyToMany
    private List<User> user;
    
    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    public Community() {
    }

    public Community(String name, Long communityId, byte[] icon, String privacy, String description, List<User> user) {
        this.name = name;
        this.communityId = communityId;
        this.icon = icon;
        this.privacy = privacy;
        this.description = description;
        this.user = user;
    }
    
    public void addUser(User users){
        user.add(users);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
