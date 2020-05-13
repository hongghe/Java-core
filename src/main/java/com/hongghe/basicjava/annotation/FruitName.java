package com.hongghe.basicjava.annotation;

import java.lang.annotation.*;

/**
 * @author henry
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}