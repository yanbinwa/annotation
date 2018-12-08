package com.emotibot.annotation.module;

import com.emotibot.annotation.core.annotion.Module;
import org.springframework.beans.factory.annotation.Value;

@Module(name = "my1Module", timeout = 100, parent = {My2Module.class})
public class My1Module extends BaseModule {

    @Value("${module.url}")
    String module_url;

    @Override
    public void process() {
        System.out.println(this.getClass().getName());
        System.out.println(module_url);
    }

    public static void main(String[] args) {
        Module module = My1Module.class.getAnnotation(Module.class);
        System.out.println(module);
    }
}
