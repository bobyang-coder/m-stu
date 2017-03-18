package com.bob.stu.Strategy.duck;

/**
 * 抽象策略-呱呱叫-具体策略类
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/17
 */
public class QuackAA implements QuackBehavior {
    public void quack() {
        System.out.println("我就会说AA");
    }
}
