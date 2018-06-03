package com.springboot.beginner.service;

import com.springboot.beginner.domain.Girl;
import com.springboot.beginner.enums.ResultEnum;
import com.springboot.beginner.exception.GirlException;
import com.springboot.beginner.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName GirlService
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 15:17
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> findAll() {
        return girlRepository.findAll();
    }

    public Girl save(Girl girl) {
        return girlRepository.save(girl);
    }

    public Girl getOne(Integer id) {
        return girlRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        girlRepository.deleteById(id);
    }

    public List<Girl> findGirlsByAge(Integer age) {
        return girlRepository.findGirlsByAge(age);
    }

    public Long count() {
        return girlRepository.count();
    }

    public boolean existsById(Integer id) {
        return girlRepository.existsById(id);
    }

    public List<Girl> findByAgeLessThan(Integer age) {
        return girlRepository.findByAgeLessThan(age);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    @Transactional
    public void insertTwo() {

        Girl aGirl = new Girl();
        aGirl.setName("limei");
        aGirl.setCupSize("C");
        aGirl.setAge(18);
        girlRepository.save(aGirl);

        Girl bGirl = new Girl();
        bGirl.setName("huanghaibei");
        bGirl.setCupSize("FF");
        bGirl.setAge(18);
        girlRepository.save(bGirl);

    }

}
