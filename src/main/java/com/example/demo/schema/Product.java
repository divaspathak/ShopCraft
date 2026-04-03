package com.example.demo.schema;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity{

    @NotBlank(message = "Title cannot be blank")  
    @Size(min = 3)
    String title; 

    String description; 

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Category category; 

    String image; 

    BigDecimal rating; 
}
