package br.com.todo.entity;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
    @SequenceGenerator(name = "category_generator", sequenceName = "category_sequence")
    private Integer id;
    private String name;

    //Getter's n' Setter's
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    //Constructor's
    public Category(){}

    public Category(String name){
        this.name = name;
    }
}
