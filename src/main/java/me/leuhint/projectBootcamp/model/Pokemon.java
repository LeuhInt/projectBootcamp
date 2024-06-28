package me.leuhint.projectBootcamp.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.handler.IgnoreErrorsBindHandler;

@Entity(name = "tab_pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "poke_name", length = 50, unique = true)
    private String name;
    @Column(name = "poke_level")
    private int level;
    @Column(name = "poke_element")
    private String element;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
