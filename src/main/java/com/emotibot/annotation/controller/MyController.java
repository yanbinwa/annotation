package com.emotibot.annotation.controller;

import com.emotibot.annotation.core.controller.BaseController;
import com.emotibot.annotation.module.BaseModule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController extends BaseController {
    @GetMapping(value = "/annotation")
    public void annotation() {
        BaseModule module = getModule("myModule", BaseModule.class);
        handlerTasks(module);
    }
}
