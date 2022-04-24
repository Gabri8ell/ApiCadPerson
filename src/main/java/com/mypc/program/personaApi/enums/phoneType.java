package com.mypc.program.personaApi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum phoneType {

    NOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;

}
