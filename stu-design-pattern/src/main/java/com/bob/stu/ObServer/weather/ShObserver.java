package com.bob.stu.ObServer.weather;

/**
 * 上海订阅者
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class ShObserver implements Observer, IDisplayElement {

    //为什么要由主题的引用?因为后期我们可能去取消订阅
    private Subject subject;

    ShObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void unRegister() {
        subject.removeObserver(this);
    }
    public void update(WeatherVo weatherVo) {
        this.display(weatherVo);
    }

    public void display(WeatherVo weatherVo) {
        System.out.println("上海接收到天气更新\n" + weatherVo.toString());
    }
}
