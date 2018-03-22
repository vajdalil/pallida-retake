package com.greenfoxacademy.retake.services;

import com.greenfoxacademy.retake.models.Cloth;

import java.util.List;


public interface ClothService {
  List<Cloth> findAll();
  List<Cloth> findAllByItem(String item);
  List<Cloth> findAllByCategory(String category);
  List<Cloth> findAllBySize(String size);
  List<Cloth> findAllByPriceLessThan(float price);
  List<Cloth> findAllByPriceGreaterThan(float price);
  List<Cloth> findAllByPriceEquals(float price);
  List<Cloth> findAllByManufacturer(String manufacturer);
  Cloth findByItemAndSize(String item, String size);
  Cloth findById(int id);
}
