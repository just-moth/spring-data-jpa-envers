package com.mndeveci.spring.boot.rest.repository;

import com.mndeveci.spring.boot.rest.model.City;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer>,BaseRepository<City, Integer>{

    List<City> findByName(String name);

}
