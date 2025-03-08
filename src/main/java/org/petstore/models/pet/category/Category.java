package org.petstore.models.pet.category;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    // Конструкторы
    public Category() {}

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
