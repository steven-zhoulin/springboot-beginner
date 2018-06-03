package com.springboot.beginner.controller;

import com.springboot.beginner.domain.Girl;
import com.springboot.beginner.domain.Result;
import com.springboot.beginner.service.GirlService;
import com.springboot.beginner.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName GirlController
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 11:37
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> findAll() {
        return girlService.findAll();
    }

    @GetMapping(value = "/girl-liaos/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    /**
     * 添加一个女生
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> save(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.failure(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl = girlService.save(girl);
        return ResultUtil.success(girl);

    }

    /**
     * 根据ID获取一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl getOne(@PathVariable("id") Integer id) {
        return girlService.getOne(id);
    }

    /**
     * 修改一个女生
     *
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Girl save(@PathVariable("id") Integer id,
                     @RequestParam Integer age,
                     @RequestParam String cupSize) {

        Girl girl = girlService.getOne(id);

        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlService.save(girl);

    }

    /**
     * 删除一个女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {

        try {
            girlService.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 根据年龄查询女生列表
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age) {
        return girlService.findGirlsByAge(age);
    }

    /**
     * 计数
     *
     * @return
     */
    @GetMapping(value = "/girl/count")
    public Long count() {
        return girlService.count();
    }

    /**
     * 判断是否存在
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/exists/{id}")
    public boolean existsById(@PathVariable("id") Integer id) {
        return girlService.existsById(id);
    }

    /**
     * 查询比给定年龄小的女生列表
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girl/ageless/{age}")
    public List<Girl> findByAgeLessThan(@PathVariable("age") Integer age) {
        return girlService.findByAgeLessThan(age);
    }

    /**
     * 同时插入两个女生
     */
    @PostMapping(value = "/girls/two")
    public void insertTwoGirl() {
        girlService.insertTwo();
    }

}
