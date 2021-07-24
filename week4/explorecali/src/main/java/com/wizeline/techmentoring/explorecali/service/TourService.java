package com.wizeline.techmentoring.explorecali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wizeline.techmentoring.explorecali.domain.Difficulty;
import com.wizeline.techmentoring.explorecali.domain.Region;
import com.wizeline.techmentoring.explorecali.domain.Tour;
import com.wizeline.techmentoring.explorecali.domain.TourPackage;
import com.wizeline.techmentoring.explorecali.repository.TourPackageRepository;
import com.wizeline.techmentoring.explorecali.repository.TourRepository;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;


    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration,
                           String bullets, String keywords, String tourPackageName,
                           Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package does not exists" + tourPackageName));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords,
                tourPackage, difficulty, region));
    }

    public long total() {
        return tourRepository.count();
    }
}
