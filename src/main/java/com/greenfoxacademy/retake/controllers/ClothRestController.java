package com.greenfoxacademy.retake.controllers;

import com.greenfoxacademy.retake.models.ClothDTO;
import com.greenfoxacademy.retake.models.JsonMessage;
import com.greenfoxacademy.retake.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClothRestController {

  @Autowired
  ClothService clothService;

  @GetMapping("/warehouse/query")
  public ResponseEntity<?> lowerThan50(
          @RequestParam(required = false) Float price,
          @RequestParam(required = false) String type) {
    if ((price == null || price == 0) && type == null ) {
      return ResponseEntity.badRequest().body("Price and Type are required as the following example shows: http://localhost:8080/warehouse/query?price=50&type=lower");
    }
    else if (price != null) {
      if (type.equals("lower")) {
        return ResponseEntity.ok().body(new ClothDTO("ok", clothService.findAllByPriceLessThan(price)));
      } else if (type.equals("equal")) {
        return ResponseEntity.ok().body(new ClothDTO("ok", clothService.findAllByPriceEquals(price)));
      } else if (type.equals("greater")) {
        return ResponseEntity.ok().body(new ClothDTO("ok", clothService.findAllByPriceGreaterThan(price)));
      } else {
        return ResponseEntity.badRequest().body(new JsonMessage("no valid type is provided"));
      }
    }
      return ResponseEntity.badRequest().body(new JsonMessage("no price is provided"));
  }
}
