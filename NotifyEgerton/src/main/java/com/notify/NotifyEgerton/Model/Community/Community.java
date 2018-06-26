package com.notify.NotifyEgerton.Model.Community;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Community implements Serializable {

    
    private String Name;
    private String Description;

    @Id
    private long Id;

    public Community() {
    }

    public Community(String Name, String Description) {
        this.Name = Name;
        this.Description = Description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
    

    


    
}
