package org.example.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class Persona {
    private String dni;
    private String appPaterno;
    private String appMatterno;

}
