package com.emotibot.annotation.module;

import com.emotibot.annotation.core.annotion.Module;
import org.springframework.stereotype.Service;

@Service
@Module(name = "myModule", timeout = 100, parent = {My1Module.class})
public class MyModule extends BaseModule {

    @Override
    public void process() {
        System.out.println(this.getClass().getName());
    }
}
