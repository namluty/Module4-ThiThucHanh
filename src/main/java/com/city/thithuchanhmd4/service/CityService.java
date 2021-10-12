package com.city.thithuchanhmd4.service;

import com.city.thithuchanhmd4.model.City;
import com.city.thithuchanhmd4.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public void delete(Long id) {
        City city = findById(id);
        cityRepository.delete(city);

    }
}
