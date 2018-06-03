package com.springboot.beginner.repository;

import com.springboot.beginner.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName GirlRepository
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 11:38
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findGirlsByAge(Integer age);
    public List<Girl> findByAgeLessThan(Integer age);
}
