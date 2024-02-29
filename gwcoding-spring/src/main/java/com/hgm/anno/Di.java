package com.hgm.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})// 可在属性上使用
@Retention(RetentionPolicy.RUNTIME)// 在运行时生效
public @interface Di {
}
