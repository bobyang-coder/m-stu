package com.bob.stu.ObServer.jdk;

import com.bob.stu.ObServer.weather.WeatherVo;

import java.util.Observable;

/**
 * 可观察对象
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class WeatherData extends Observable {

    private WeatherVo weatherVo;

    public void setWeatherVo(WeatherVo weatherVo) {
        this.weatherVo = weatherVo;
        setChanged();
        notifyObservers(weatherVo);
    }


}
