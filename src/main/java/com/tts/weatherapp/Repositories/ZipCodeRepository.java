package com.tts.weatherapp.Repositories;

import java.util.List;

import com.tts.weatherapp.Models.ZipCode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository <ZipCode, Long> {
    
}
