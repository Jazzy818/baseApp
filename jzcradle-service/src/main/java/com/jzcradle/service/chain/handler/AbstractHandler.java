package com.jzcradle.service.chain.handler;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.Setter;

@Setter
public abstract class AbstractHandler<T, R> implements IHandler<T, R> {

    public IHandler<T, R> nextHandler;

    public boolean hasNext() {
        return this.nextHandler != null;
    }

    public R handle(T t) {
        if (nextHandler != null) {
            return nextHandler.handle(t);
        }
        return null;
    }
}
