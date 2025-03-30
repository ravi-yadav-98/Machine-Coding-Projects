package com.productservices.productservices.models;

import java.awt.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String name;
    private String desc;
    private int price;
    private String image;
    private Category category;
}
