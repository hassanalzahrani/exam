package com.example.exam3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    private int accountNumber;
    private double balance;
    @AssertFalse
    private boolean isAvtive;


    @ManyToOne
    @JsonIgnore
    private Costumer costumers;
}
