package com.carney.movie.cloudmovieuser.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/17
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2055027988815619687L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
 }
