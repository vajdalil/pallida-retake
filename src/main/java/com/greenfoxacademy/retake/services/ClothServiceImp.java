package com.greenfoxacademy.retake.services;

import com.greenfoxacademy.retake.models.Cloth;
import com.greenfoxacademy.retake.repositories.ClothRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothServiceImp implements ClothService {

  @Autowired
  ClothRepo clothRepo;



  @Override
  public List<Cloth> findAll() {
    return (List<Cloth>) clothRepo.findAll();
  }

  @Override
  public List<Cloth> findAllByItem(String item) {
    return clothRepo.findAllByItem(item);
  }

  @Override
  public List<Cloth> findAllByCategory(String category) {
    return clothRepo.findAllByCategory(category);
  }

  @Override
  public List<Cloth> findAllBySize(String size) {
    return clothRepo.findAllBySize(size);
  }

  @Override
  public List<Cloth> findAllByPriceLessThan(float price) {
    return clothRepo.findAllByPriceLessThan(price);
  }

  @Override
  public List<Cloth> findAllByPriceGreaterThan(float price) {
    return clothRepo.findAllByPriceGreaterThan(price);
  }

  @Override
  public List<Cloth> findAllByPriceEquals(float price) {
    return clothRepo.findAllByPriceEquals(price);
  }

  @Override
  public List<Cloth> findAllByManufacturer(String manufacturer) {
    return clothRepo.findAllByManufacturer(manufacturer);
  }

  @Override
  public Cloth findByItemAndSize(String item, String size) {
    return clothRepo.findByItemAndSize(item,size);
  }

  @Override
  public Cloth findById(int id) {
    return clothRepo.findOne(id);
  }

  public List<String> findUniqueSizes() {
    List <String> uniqueSizes = new ArrayList<>();
    for (Cloth cloth : clothRepo.findAll()) {
      if (!(uniqueSizes.contains(cloth.getSize()))) {
        uniqueSizes.add(cloth.getSize());
      }
    }
    return uniqueSizes;
  }

  public List<String> findUniqueItemNames() {
    List <String> uniqueNames = new ArrayList<>();
    for (Cloth cloth : clothRepo.findAll()) {
      if (!(uniqueNames.contains(cloth.getItem()))) {
        uniqueNames.add(cloth.getItem());
      }
    }
    return uniqueNames;
  }

  public List<String> findUniqueManufacturer() {
    List <String> uniqueManu = new ArrayList<>();
    for (Cloth cloth : clothRepo.findAll()) {
      if (!(uniqueManu.contains(cloth.getManufacturer()))) {
        uniqueManu.add(cloth.getItem());
      }
    }
    return uniqueManu;
  }

  public List<String> findUniqueCategory() {
    List <String> uniqueCategory = new ArrayList<>();
    for (Cloth cloth : clothRepo.findAll()) {
      if (!(uniqueCategory.contains(cloth.getCategory()))) {
        uniqueCategory.add(cloth.getItem());
      }
    }
    return uniqueCategory;
  }
}
