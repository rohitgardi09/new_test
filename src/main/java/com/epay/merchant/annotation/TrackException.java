package com.epay.merchant.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackException {

    boolean storeStackTrace() default true;

    boolean rethrow() default true;
}