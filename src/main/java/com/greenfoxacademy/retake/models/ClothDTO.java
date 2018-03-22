package com.greenfoxacademy.retake.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothDTO {

  private String result;
  private List <Cloth> clothes;
}
