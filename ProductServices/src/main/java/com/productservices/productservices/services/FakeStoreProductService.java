package com.productservices.productservices.services;

import com.productservices.productservices.dtos.FakeStoreDto;
import com.productservices.productservices.dtos.GenricProductDto;
import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products/";

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenricProductDto convertToGenericProductDto(FakeStoreDto fakeStoreProductDto) {
        GenricProductDto genericProductDto = new GenricProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }

    @Override
    public GenricProductDto getProductById(Long id) {
        //implementation
        //Integrate FakeStore APIs

        //RestTemplate: Make call to external API
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenricProductDto> responseEntity =   restTemplate.getForEntity(specificProductUrl, GenricProductDto.class, id);
        GenricProductDto genricProductDto = new GenricProductDto();
        FakeStoreDto fakeStoreDto = new FakeStoreDto();


        return responseEntity.getBody();
    }
    @Override
    public List<GenricProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl, FakeStoreDto[].class);

        List<GenricProductDto>  result = new ArrayList<>();
        List<FakeStoreDto> fakeStoreDtos = List.of(responseEntity.getBody());

        for(FakeStoreDto fakeStoreDto: fakeStoreDtos)
        {
            result.add(convertToGenericProductDto(fakeStoreDto));
        }
        return result;

    }

    @Override
    public GenricProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return  null;
    }

    @Override
    public void updateProductById() {

    }

    @Override
    public GenricProductDto createProduct(GenricProductDto genricProductDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> responseEntity =
                restTemplate.postForEntity(genericProductUrl, genricProductDto, FakeStoreDto.class);

        return convertToGenericProductDto(responseEntity.getBody());
    }
}
