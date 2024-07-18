package com.italianrestaurant.Menu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class MenuItem extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private Long categoryId;
    private Long subcategoryId;
    private Long numberOfReviews;
    private Double averageRating;

}
