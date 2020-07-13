package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

//We will be creating tables for the subclasses that inherit from AbstractEntity but not a table for this parent class. Therefore, give AbstractEntity the @MappedSuperclass annotation.
@MappedSuperclass
public abstract class AbstractEntity {

    //Since all of the subclasses of AbstractEntity will be entities themselves, add the @Id and @GeneratedValue annotations to the field id.
    @Id
    @GeneratedValue
    private int id;

    //a user cannot leave this field blank when creating an object
    @NotBlank
    //there are reasonable limitations on the size of the name string. Keep in mind that the name field will be shared across Job, Employer, and Skill classes.
    @Size(max = 30, message = "Max 30 characters for name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}