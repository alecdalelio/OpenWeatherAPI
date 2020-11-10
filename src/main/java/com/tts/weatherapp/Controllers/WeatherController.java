package com.tts.weatherapp.Controllers;

import com.tts.weatherapp.Models.Request;
import com.tts.weatherapp.Models.Response;
import com.tts.weatherapp.Models.ZipCode;
import com.tts.weatherapp.Services.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
 
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String getIndex(Model model){
        Iterable<ZipCode> zipCodeList = weatherService.findAllZipCode();
		model.addAttribute("zipCodesHistory", zipCodeList);
        model.addAttribute("request", new Request());
        return "index";
    }

    @PostMapping("/")
    public String postIndex(Request request, Model model){

        // Type response, variable data = whatever forecast is returned
        Response weather = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", weather);
        Iterable<ZipCode> zipCodeList = weatherService.findAllZipCode();
		model.addAttribute("zipCodePost", zipCodeList);
        return "index";
    }

}
