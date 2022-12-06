package ru.example.controller;

import org.springframework.web.bind.annotation.*;
import ru.example.model.TypeDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeController {

    private final List<TypeDto> types;

    public TypeController(){
        TypeDto one = new TypeDto("Byte", 1L,  "Primitive");
        TypeDto two = new TypeDto("Short", 2L,  "Primitive");
        TypeDto three = new TypeDto("Int",3L, "Primitive");
        TypeDto four = new TypeDto("Long",4L,"Primitive");
        TypeDto five = new TypeDto("Double",5L, "Primitive");
        TypeDto six = new TypeDto("Float", 6L, "Primitive");
        TypeDto seven = new TypeDto("Boolean", 7L, "Primitive");
        TypeDto eight = new TypeDto("Char", 8L, "Primitive");
        types = new ArrayList<>();
        types.add(one);
        types.add(two);
        types.add(three);
        types.add(four);
        types.add(five);
        types.add(six);
        types.add(seven);
        types.add(eight);
    }

    @GetMapping
    public List<TypeDto> getUsers() {
        return types;
    }

    @GetMapping("{id}")
    public TypeDto getType(@PathVariable long id) {
        TypeDto typeDtoResult = null;
        for (int i = 0; i < types.size(); ++i) {
            TypeDto typeDto = types.get(i);
            if (typeDto.getId() == id) {
                return typeDto;
            }
        }
        throw new RuntimeException("Тип данных не найден");
    }

    @PostMapping
    public void createType(@RequestBody TypeDto typeInput) {
        for (int i = 0; i < types.size(); ++i) {
            TypeDto type = types.get(i);
            if (typeInput.getId() == type.getId()) {
                throw new RuntimeException("Тип данных c таким ID уже существует");
            }
        }
        types.add(typeInput);
    }

    @PutMapping("{id}")
    public void updateType(@PathVariable long id, @RequestBody TypeDto typeDto) {
        for (int i = 0; i < types.size(); ++i) {
            TypeDto type = types.get(i);
            if (type.getId() == id) {
                type.setName(typeDto.getName());
                type.setType(typeDto.getType());
                return;
            }
        }
        throw new RuntimeException("Тип данных не найден");
    }

    @DeleteMapping("{id}")
    public void deleteType(@PathVariable long id) {
        for (int i = 0; i < types.size(); ++i) {
            TypeDto type = types.get(i);
            if (type.getId() == id) {
                types.remove(i);
                return;
            }
        }
        throw new RuntimeException("Тип данных не найден");
    }
}
