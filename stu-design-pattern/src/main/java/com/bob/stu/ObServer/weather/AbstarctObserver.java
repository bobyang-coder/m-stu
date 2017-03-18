package com.bob.stu.ObServer.weather;

/**
 * 抽象观察者
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public abstract class AbstarctObserver implements Observer {

    //为什么要由主题的引用?因为后期我们可能去取消订阅
    private Subject subject;

    AbstarctObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void unRegister() {
        subject.removeObserver(this);
    }

    public void update(WeatherVo weatherVo) {
        display(weatherVo);
    }

    abstract void display(WeatherVo weatherVo);
}
