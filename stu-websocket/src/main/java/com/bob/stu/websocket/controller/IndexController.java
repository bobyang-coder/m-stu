package com.bob.stu.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bob on 2016/12/19.
 *
 * @author bob tel:15811588260
 * @version 1.0
 * @since 2016/12/19
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("a")
    public String index() {
        return "index";
    }
}
