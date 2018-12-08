package com.emotibot.annotation.module;

import com.emotibot.annotation.core.annotion.Module;

@Module(name = "my2Module", timeout = 100)
public class My2Module extends BaseModule {
    @Override
    public void process() {
        System.out.println(this.getClass().getName());
    }
}
