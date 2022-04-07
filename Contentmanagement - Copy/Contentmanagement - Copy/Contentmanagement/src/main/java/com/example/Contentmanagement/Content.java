package com.example.Contentmanagement;

import javax.persistence.*;

@Entity
public class Content {

    private Long id;
    private String name;
    private String description;


    protected Content(){

    }

    public Content(String name, String description) {
        this.id=id;
        this.name = name;
        this.description = description;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
