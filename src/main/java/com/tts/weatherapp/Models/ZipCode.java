package com.tts.weatherapp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class ZipCode {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long search_id;
	private String zipCode;

    public long getSearch_id() {
        return search_id;
    }

    public void setSearch_id(long search_id) {
        this.search_id = search_id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "ZipCode [search_id=" + search_id + ", zipCode=" + zipCode + "]";
    }

}
