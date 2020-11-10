package com.tts.weatherapp.Services;

import com.tts.weatherapp.Models.Response;
import com.tts.weatherapp.Models.ZipCode;
import com.tts.weatherapp.Repositories.ZipCodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private ZipCodeRepository zipcodeRepository;

    @Value("${api_key}")
    private String apiKey;

    public Response getForecast(String zipCode) {

        // MAKES CALL TO OPENWEATHER API, WITH DYNAMIC ZIPCODE & APIKEY
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        ZipCode zipCodeHistory = new ZipCode();
        zipCodeHistory.setZipCode(zipCode);
        zipcodeRepository.save(zipCodeHistory);

        // MAKES A CALL TO "URL"
        // SHOVE THE RESPONSE IN A RESPONSE "OBJECT"

        try {

            return restTemplate.getForObject(url, Response.class);

        } catch (HttpClientErrorException exception) {
            Response response = new Response();
            response.setName("ERROR");
            return response;
        }
    }

    public Iterable<ZipCode> findAllZipCode() {
        return zipcodeRepository.findAll();
    }
}
