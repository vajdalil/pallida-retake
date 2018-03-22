package com.greenfoxacademy.retake.repositories;

import com.greenfoxacademy.retake.models.Cloth;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothRepo extends CrudRepository <Cloth, Integer> {

  List<Cloth> findAllByItem(String item);
  List<Cloth> findAllByCategory(String category);
  List<Cloth> findAllBySize(String size);
  List<Cloth> findAllByPriceLessThan(float price);
  List<Cloth> findAllByPriceGreaterThan(float price);
  List<Cloth> findAllByPriceEquals(float price);
  List<Cloth> findAllByManufacturer(String manufacturer);
  Cloth findByItemAndSize(String item, String size);
}
