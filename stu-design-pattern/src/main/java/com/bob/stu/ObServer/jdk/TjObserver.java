package com.bob.stu.ObServer.jdk;

import com.bob.stu.ObServer.weather.WeatherVo;

import java.util.Observable;

/**
 * Created by bob on 2017/3/18.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/18
 */
public class TjObserver extends AbstarctObserver {

    TjObserver(Observable observable) {
        super(observable);
    }

    void display(WeatherVo weatherVo) {
        System.out.println("天津接收到天气更新\n" + weatherVo.toString());

    }
}
