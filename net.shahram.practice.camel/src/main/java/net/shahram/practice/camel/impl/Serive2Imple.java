package net.shahram.practice.camel.impl;

import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
public class Serive2Imple extends AbstractSeriveImple {
    private ServiceTypeEnum typeEnum;

    @Override
    protected String getServiceName() {
        return typeEnum.getDesc();
    }
}
