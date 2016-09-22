package net.shahram.practice.camel.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ServiceTypeEnum {
        SERVICE1("-- Service 1 (with Enums) --"),
        SERVICE2("-- Service 2 (with Enums) --"),

    ;
    private final String desc;
}
