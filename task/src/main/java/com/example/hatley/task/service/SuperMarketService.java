package com.example.hatley.task.service;

import com.example.hatley.task.entity.SuperMarket;
import com.example.hatley.task.exception.ResourceNotFoundException;
import com.example.hatley.task.repository.SuperMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SuperMarketService {
    @Autowired
    private SuperMarketRepository superMarketRepository;

    public List<SuperMarket> getAllSuperMarkets(){
        return this.superMarketRepository.findAll();
    }

    public SuperMarket getSuperMarketById(long superMarketId){
        return this.superMarketRepository.findById(superMarketId)
                .orElseThrow(() -> new ResourceNotFoundException("Supermarket not found with id :" + superMarketId));
    }

    public SuperMarket createSuperMarket(SuperMarket superMarket){
        return this.superMarketRepository.save(superMarket);
    }

    public ResponseEntity<HttpStatus> uploadFileToSuperMarket(MultipartFile image, long superMarketId) throws IOException {
        SuperMarket existingSuperMarket = this.superMarketRepository.findById(superMarketId)
                .orElseThrow(() -> new ResourceNotFoundException("SuperMarket not found with id :" + superMarketId));
        existingSuperMarket.setImage(image.getBytes());
        this.superMarketRepository.save(existingSuperMarket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public SuperMarket updateSuperMarket(SuperMarket superMarket, long superMarketId) {
        SuperMarket existingSuperMarket = this.superMarketRepository.findById(superMarketId)
                .orElseThrow(() -> new ResourceNotFoundException("SuperMarket not found with id :" + superMarketId));
        existingSuperMarket.setArabicName(superMarket.getArabicName());
        existingSuperMarket.setEnglishName(superMarket.getEnglishName());
        existingSuperMarket.setAddress(superMarket.getAddress());
        existingSuperMarket.setActive(superMarket.getActive() ? superMarket.getActive() : true);

        return this.superMarketRepository.save(existingSuperMarket);
    }

    public SuperMarket activateSuperMarket(long superMarketId) {
        SuperMarket existingSuperMarket = this.superMarketRepository.findById(superMarketId)
                .orElseThrow(() -> new ResourceNotFoundException("SuperMarket not found with id :" + superMarketId));
        existingSuperMarket.setActive(true);

        return this.superMarketRepository.save(existingSuperMarket);
    }

    public SuperMarket deactivateSuperMarket(long superMarketId) {
        SuperMarket existingSuperMarket = this.superMarketRepository.findById(superMarketId)
                .orElseThrow(() -> new ResourceNotFoundException("SuperMarket not found with id :" + superMarketId));
        existingSuperMarket.setActive(false);

        return this.superMarketRepository.save(existingSuperMarket);
    }

    public ResponseEntity<SuperMarket> deleteSuperMarket(long superMarketId) throws ResourceNotFoundException{
        SuperMarket existingSuperMarket = this.superMarketRepository.findById(superMarketId)
                .orElseThrow(() -> new ResourceNotFoundException("SuperMarket not found with id :" + superMarketId));
        this.superMarketRepository.delete(existingSuperMarket);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
