package com.lab.Lab1.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @Column(name = "Username")
    @NotEmpty(message = "Username cannot be empty !") @Size(min = 6, max = 30)
    String username;
    @Column(name = "Password")
    String password;
}

