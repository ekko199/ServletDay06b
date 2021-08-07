package com.javacto.service;

import com.javacto.po.Dog;
import com.javacto.utils.PageInfo;

import java.sql.SQLException;
import java.util.List;

public interface DogService { //添加
    public int addDog(Dog dog);
    //删除
    public int deleteDog(int id);
    //修改
    public int updateDog(Dog dog);
    //根据id查询
    public Dog findById(int id);
    //查询所有
    public List<Dog> queryAll();
    //获取总条数
    public  int getTotalCount(Dog dog);
    //分页查询
    public  List<Dog> pageQueryDog(PageInfo pageInfo, Dog dog);
    //根据品种查询
    public boolean findByBreed(String breed);

}
