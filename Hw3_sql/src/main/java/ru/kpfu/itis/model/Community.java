package ru.kpfu.itis.model;

import java.sql.Date;

public class Community {
    private Long id;
    private Long founder_id;
    private String name;
    private String description;
    private Date created_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFounder_id() {
        return founder_id;
    }

    public void setFounder_id(Long founder_id) {
        this.founder_id = founder_id;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
