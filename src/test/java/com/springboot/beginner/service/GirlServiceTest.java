package com.springboot.beginner.service;

import com.springboot.beginner.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

/**
 * @ClassName GirlServiceTest
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 21:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    GirlService girlService;

    @Test
    public void existsById() {
        Assert.assertTrue(girlService.existsById(53));
    }

    @Test
    public void getOne() {
        Girl girl = girlService.getOne(4);
        System.out.println(girl.getName());
        Assert.assertEquals(girl.getName(), "vivian");
    }


}