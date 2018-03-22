package com.greenfoxacademy.retake.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "warehouse")
public class Cloth {

  @Id
  private int id;
  @Column(name = "item_name")
  @JsonProperty("item_name")
  private String item;
  private String manufacturer;
  private String category;
  private String size;
  @Column (name = "unit_price")
  @JsonProperty ("unit_price")
  private float price;
}
