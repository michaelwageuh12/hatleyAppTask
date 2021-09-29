package com.example.hatley.task.controller;

import com.example.hatley.task.entity.SuperMarket;
import com.example.hatley.task.service.SuperMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/supermarkets")
public class SuperMarketController {

    @Autowired
    private SuperMarketService superMarketService;

    @GetMapping
    public List<SuperMarket> getAllSuperMarkets(){
        return this.superMarketService.getAllSuperMarkets();
    }

    @GetMapping("/{id}")
    public SuperMarket getSuperMarketById(@PathVariable ("id") long superMarketId){
        return this.superMarketService.getSuperMarketById(superMarketId);
    }

    @PostMapping("/create")
    public SuperMarket createSuperMarket(@RequestBody SuperMarket superMarket){
        return this.superMarketService.createSuperMarket(superMarket);
    }

    @PostMapping("/upload-file/{id}")
    public ResponseEntity<HttpStatus> uploadFileToSuperMarket(@RequestParam ("image") MultipartFile image,
                                                    @PathVariable ("id") long superMarketId) throws IOException {
        return this.superMarketService.uploadFileToSuperMarket(image, superMarketId);
    }

    @PutMapping("/update/{id}")
    public SuperMarket updateSuperMarket(@RequestBody SuperMarket superMarket,
                                         @PathVariable ("id") long superMarketId) {
        return this.superMarketService.updateSuperMarket(superMarket, superMarketId);
    }

    @PutMapping("/activate/{id}")
    public SuperMarket activateSuperMarket(@PathVariable ("id") long superMarketId) {
        return this.superMarketService.activateSuperMarket(superMarketId);
    }

    @PutMapping("/deactivate/{id}")
    public SuperMarket deactivateSuperMarket(@PathVariable ("id") long superMarketId) {
        return this.superMarketService.deactivateSuperMarket(superMarketId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuperMarket> deleteSuperMarket(@PathVariable ("id") long superMarketId){
        this.superMarketService.deleteSuperMarket(superMarketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
