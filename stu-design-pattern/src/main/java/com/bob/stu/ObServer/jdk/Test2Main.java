package com.bob.stu.ObServer.jdk;

import com.bob.stu.ObServer.weather.WeatherVo;

/**
 * Created by bob on 2017/3/18.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class Test2Main {
    public static void main(String[] args) {
        //可观察者
        WeatherData weatherData = new WeatherData();
        new BjObserver(weatherData);
        TjObserver tjObserver = new TjObserver(weatherData);
        //创建天气对象
        WeatherVo weatherVo = new WeatherVo();
        weatherVo.setTemperature(23.4f);
        weatherVo.setHumidity(22.455f);
        weatherVo.setPressure(100f);
        //主题内容变化
        weatherData.setWeatherVo(weatherVo);
        tjObserver.unRegister();//取消订阅
        System.out.println("==========天气变化=============");
        weatherVo.setTemperature(900f);
        weatherData.setWeatherVo(weatherVo);
    }
}
