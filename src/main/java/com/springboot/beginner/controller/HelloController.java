package com.springboot.beginner.controller;

import com.springboot.beginner.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 09:13
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("id") Integer id,
                           @RequestParam(value = "age", required = true, defaultValue = "18") Integer age,
                           @RequestParam(value = "cupSize", required = false, defaultValue = "A") String cupSize) {
        return String.format("id: %d, age: %d, cupSize: %s", id, age, cupSize);
    }

}
