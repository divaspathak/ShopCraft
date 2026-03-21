package com.example.demo.schema;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    
    @Column
    private String name; 

    @OneToMany(mappedBy = "category")
    private List<Product> products; 

    public Category(String name){
        this.name = name;
    }
}
