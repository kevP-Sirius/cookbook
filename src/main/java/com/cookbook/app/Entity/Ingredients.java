package com.cookbook.app.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Ingredients {
    @Id
    private Long Id;
    private String name;
    private String description;
}
