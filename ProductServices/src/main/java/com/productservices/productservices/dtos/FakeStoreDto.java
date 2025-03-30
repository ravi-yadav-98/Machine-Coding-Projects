package com.productservices.productservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {

    private Long id;
    private String title;
    private int price;

    private String category;

    private String description;
    private String image;


}
