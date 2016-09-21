package com.joye.basepresentation.internal.di;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */

/**
 * Scopes可是非常的有用，
 * Dagger2可以通过自定义注解限定注解作用域,这是一个非常强大的特点，因为就如前面说的一样
 * ，没必要让每个对象都去了解如何管理他们的实例。
 * 在scope的例子中，我们用自定义的@PerActivity注解一个类，所以这个对象存活时间就和 activity的一样。
 * 简单来说就是我们可以定义所有范围的粒度(@PerFragment, @PerUser, 等等)
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
