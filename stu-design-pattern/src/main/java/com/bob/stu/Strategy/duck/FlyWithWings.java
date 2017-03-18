package com.bob.stu.Strategy.duck;

/**
 * 具体策略角色
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/17
 */
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("我用翅膀飞行!");
    }
}
