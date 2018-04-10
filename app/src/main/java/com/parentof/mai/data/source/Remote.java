package com.parentof.mai.data.source;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by gaurav on 22/11/17.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Remote {

}
