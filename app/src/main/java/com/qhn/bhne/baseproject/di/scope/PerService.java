package com.qhn.bhne.baseproject.di.scope;

/**
 * Created by qhn
 * on 2017/2/23 0023.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}
