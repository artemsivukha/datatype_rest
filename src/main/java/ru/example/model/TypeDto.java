package ru.example.model;

public class TypeDto {
    private String name;
    private long id;
    private String type;


    public TypeDto(String name, long id, String type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void remove(int i) {
    }
}
