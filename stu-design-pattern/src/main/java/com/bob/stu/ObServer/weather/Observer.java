package com.bob.stu.ObServer.weather;

/**
 * 观察者
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public interface Observer {

    void unRegister();

    void update(WeatherVo weatherVo);
}
