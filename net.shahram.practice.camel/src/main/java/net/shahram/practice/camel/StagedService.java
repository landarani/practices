package net.shahram.practice.camel;

public interface StagedService {
    void doBefore();

    void doAfter();

    void doIt();
}
