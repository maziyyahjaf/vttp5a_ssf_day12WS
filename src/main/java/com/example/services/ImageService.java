package com.example.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private static final int MAX_NUMBER = 30;

    public List<String> getRandomImages(int count) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<String> imagePath = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            int number = numbers.get(i);
            String path = "/images/number" + number + ".png";
            imagePath.add(path);
        }

        return imagePath;

    }
    
}
