package com.springboot.beginner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @ClassName Girl
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 10:56
 */
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @Length(min = 1, max = 20, message = "name长度必须位于1到20之间!")
    @NotNull(message = "name不能为空!")
    private String name;

    @Max(value = 55, message = "年龄不能大于55岁!")
    @Min(value = 18, message = "必须年满18岁！")
    private Integer age;

    @NotNull(message = "cupSize不能为空!")
    private String cupSize;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
