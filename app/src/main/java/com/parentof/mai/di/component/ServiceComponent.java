package com.parentof.mai.di.component;

import com.parentof.mai.di.ServiceScoped;
import com.parentof.mai.di.module.ServiceModule;

import dagger.Component;

/**
 * Created by gaurav on 21/11/17.
 */

@ServiceScoped
@Component(dependencies = ApplicationComponent.class, modules = {ServiceModule.class})
public interface ServiceComponent {

}
