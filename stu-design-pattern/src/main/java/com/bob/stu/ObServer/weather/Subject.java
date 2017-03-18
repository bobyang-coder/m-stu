package com.bob.stu.ObServer.weather;

import com.bob.stu.ObServer.weather.Observer;

/**
 * 主题
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public interface Subject {

    /**
     * 观察者订阅主题
     *
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 观察者取消订阅主题
     *
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知订阅者们主题的变化
     */
    void notifyObServers();

}
