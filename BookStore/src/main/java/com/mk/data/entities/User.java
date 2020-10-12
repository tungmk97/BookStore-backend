package com.mk.data.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100)
  @NotNull(message = "First name cannot be null")
  private String firstName;

  @Column(length = 100, unique = true)
  @NotNull(message = "Email cannot be null")
  private String email;

  @Column(length = 100)
  @NotNull(message = "Last name cannot be null")
  private String lastName;

  @Column(length = 100)
  @NotNull(message = "Username cannot be null")
  private String userName;

  @Column()
  @Min(value = 6, message = "Password has length minimum is 6")
  @Max(value = 12, message = "Password has length maximum is 12")
  @NotNull(message = "First name cannot be null")
  private String password;

  private String street;
  private String ward;
  private String district;
  private String city;
  private String phoneNumber;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Set<Role> roles;

}