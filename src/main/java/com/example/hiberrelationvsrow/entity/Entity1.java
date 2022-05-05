package com.example.hiberrelationvsrow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Entity1 {

  @Id
  private Integer field1;

//  @ManyToOne
//  private Entity2 field2;

}
