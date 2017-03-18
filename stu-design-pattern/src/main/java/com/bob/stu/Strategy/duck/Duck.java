package com.bob.stu.Strategy.duck;

/**
 * Demo1-鸭子应用
 * 鸭子类-环境角色
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/17
 */
public abstract class Duck {

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    protected FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    protected void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    protected QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    protected void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    /**
     * 抽象方法，每个鸭子外观不一样，由具体的鸭子自己实现
     */
    public abstract void display();

    public void swim() {
        System.out.println("鸭子必须会游泳!");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
