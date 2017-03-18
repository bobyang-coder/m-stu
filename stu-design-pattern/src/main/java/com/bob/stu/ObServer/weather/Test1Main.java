package com.bob.stu.ObServer.weather;

/**
 * Demo1测试
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class Test1Main {
    public static void main(String[] args) {
        //开启主题
        WeatherDataSubject weatherDataSubject = new WeatherDataSubject();
        //观察者订阅
        new BjObserver(weatherDataSubject);
        new ShObserver(weatherDataSubject);
        TjObserver tjObserver = new TjObserver(weatherDataSubject);
        //创建天气对象
        WeatherVo weatherVo = new WeatherVo();
        weatherVo.setTemperature(23.4f);
        weatherVo.setHumidity(22.455f);
        weatherVo.setPressure(100f);
        //主题内容变化
        weatherDataSubject.setWeatherVo(weatherVo);
        tjObserver.unRegister();//取消订阅
        System.out.println("==========天气变化=============");
        weatherVo.setTemperature(900f);
        weatherDataSubject.setWeatherVo(weatherVo);

    }
}
