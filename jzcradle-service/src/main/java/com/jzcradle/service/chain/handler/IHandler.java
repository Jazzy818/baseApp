package com.jzcradle.service.chain.handler;

public interface IHandler<T, R> {

    public R handle(T t);

    void setNextHandler(IHandler<T, R> nextHandler);

    boolean hasNext();
}
