package com.carney.movie.cloudmovieticket.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/17
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6595252391240354127L;
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
