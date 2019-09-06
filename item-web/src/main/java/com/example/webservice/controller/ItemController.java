package com.example.webservice.controller;

import item.api.ItemService;
import item.pojoEs.Listing;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-02 14:30
 */
@Slf4j
@RestController
public class ItemController {


    @Reference
    ItemService itemService;


    @RequestMapping("searchItem")
    public Page searchItem(String desc) {
      return  itemService.queryItemByDesc(desc);
    }

    @GetMapping("getAll")
    public List<Listing> searchItem() {
        return  itemService.queryAll();
    }
}
