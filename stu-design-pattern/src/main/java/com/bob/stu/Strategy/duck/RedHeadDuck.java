package com.bob.stu.Strategy.duck;

/**
 * Created by bob on 2017/3/17.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/17
 */
public class RedHeadDuck extends Duck {

    RedHeadDuck() {
        this.setFlyBehavior(new FlyWithWings());
        this.setQuackBehavior(new QuackAA());
    }

    public void display() {
        System.out.println("我的外观一看就是红头鸭");
    }
}
