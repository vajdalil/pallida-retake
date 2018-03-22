package com.greenfoxacademy.retake.controllers;

import com.greenfoxacademy.retake.models.Cloth;
import com.greenfoxacademy.retake.models.SelectCloth;
import com.greenfoxacademy.retake.services.ClothServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

  private int amount;

  @Autowired
  ClothServiceImp clothServiceImp;
  @Autowired
  Cloth cloth;

  @GetMapping("/warehouse")
  public String showWareHouse(Model model) {
    model.addAttribute("items", clothServiceImp.findUniqueItemNames());
    model.addAttribute("sizes", clothServiceImp.findUniqueSizes());
    model.addAttribute("clothes", clothServiceImp.findAll());
    model.addAttribute("newCloth", new SelectCloth());
    return "index";
  }

  @PostMapping("/summary")
  public String buyProduct(Model model, SelectCloth selectCloth) {
    cloth = clothServiceImp.findByItemAndSize(selectCloth.getItem(), selectCloth.getSize());
    model.addAttribute("chosenProduct", cloth);
    model.addAttribute("amount", selectCloth.getAmount());
    model.addAttribute("totalPrice", selectCloth.getAmount() * cloth.getPrice());
    return "summary";
  }

}
