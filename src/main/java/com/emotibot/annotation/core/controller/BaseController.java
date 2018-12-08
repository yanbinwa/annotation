package com.emotibot.annotation.core.controller;

import com.emotibot.annotation.module.BaseModule;
import com.emotibot.annotation.core.annotion.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 循环调用module以及其子module，可以保证module的
 *
 */
public class BaseController {

    @Autowired
    private ApplicationContext applicationContext;

    public void handlerTasks(BaseModule module) {
        Set<String> moduleNameSet = new HashSet<>();
        handlerTasks(module, moduleNameSet);
    }

    /**
     * 避免循环调用，这里是递归的调用方式
     *
     * @param module
     * @param moduleNameSet
     */
    private void handlerTasks(BaseModule module, Set<String> moduleNameSet) {
        Module moduleAnntion = module.getClass().getAnnotation(Module.class);
        Class<?>[] parentModuleClassList = moduleAnntion.parent();
        for (Class<?> clazz : parentModuleClassList) {
            if (moduleNameSet.contains(clazz.getName())) {
                continue;
            }
            BaseModule parentModule = (BaseModule)applicationContext.getBean(clazz);
            handlerTasks(parentModule, moduleNameSet);
        }
        if (moduleNameSet.contains(module.getClass().getName())) {
            return;
        }
        module.process();
        moduleNameSet.add(module.getClass().getName());
    }

    public  <T> T getModule(String name, Class<T> aClass){
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(Module.class);
        Object obj = beanMap.get(name);
        if(obj!=null)
            return  (T)obj;
        return null;
    }
}
