package net.shahram.practice.camel.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Serive1Imple extends AbstractSeriveImple {
    private final ServiceTypeEnum typeEnum;

    @Override
    protected String getServiceName() {
        return typeEnum.getDesc();
    }
}
