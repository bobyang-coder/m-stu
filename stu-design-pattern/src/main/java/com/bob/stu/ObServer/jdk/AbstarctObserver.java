package com.bob.stu.ObServer.jdk;

import com.bob.stu.ObServer.weather.WeatherVo;

import java.util.Observable;
import java.util.Observer;

/**
 * 抽象观察者
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public abstract class AbstarctObserver implements Observer {

    //为什么要由主题的引用?因为后期我们可能去取消订阅
    private Observable observable;

    AbstarctObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void unRegister() {
        observable.deleteObserver(this);
    }

    public void update(Observable o, Object arg) {
        if (!(arg instanceof WeatherVo)) {
            System.out.println("=====传入的数据不是WeatherVo,我不想要=====");
        }
        display((WeatherVo) arg);
    }

    abstract void display(WeatherVo weatherVo);
}
