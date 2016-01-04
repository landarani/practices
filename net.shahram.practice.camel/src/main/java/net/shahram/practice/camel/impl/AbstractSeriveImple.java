package net.shahram.practice.camel.impl;

import lombok.extern.slf4j.Slf4j;
import net.shahram.practice.camel.StagedService;

@Slf4j
public abstract class AbstractSeriveImple implements StagedService {

    @Override
    public void doBefore() {
        log.info("[{}.doBefore()]", getServiceName());
    }

    @Override
    public void doAfter() {
        log.info("[{}.doAfter()]", getServiceName());
    }

    @Override
    public void doIt() {
        log.info("[{}.doIt()]", getServiceName());
    }

    protected abstract String getServiceName();
}
