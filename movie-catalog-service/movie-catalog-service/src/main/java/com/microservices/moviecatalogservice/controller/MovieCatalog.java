package com.microservices.moviecatalogservice.controller;

import com.microservices.moviecatalogservice.bean.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController

public class MovieCatalog {

    @GetMapping("catalog/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
        return Collections.singletonList(
                new CatalogItem("Transformer","Test",4.0f)
        );
    }
}
