package com.bob.stu.ObServer.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题-天气数据
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class WeatherDataSubject implements Subject {

    private List<Observer> observerList;//记录订阅者信息
    private WeatherVo weatherVo;

    WeatherDataSubject() {//init
        observerList = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public void notifyObServers() {
        int size = observerList.size();
        if (size > 0) {
            for (Observer observer : observerList) {
                observer.update(weatherVo);
            }
        }
    }

    public void measurementsChanged() {
        this.notifyObServers();
    }

    public void setWeatherVo(WeatherVo weatherVo) {
        this.weatherVo = weatherVo;
        this.measurementsChanged();
    }
}
