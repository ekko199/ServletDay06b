package com.javacto.service;

import com.javacto.dao.DogDao;
import com.javacto.dao.DogDaoImpl;
import com.javacto.po.Dog;
import com.javacto.utils.PageInfo;

import java.sql.SQLException;
import java.util.List;

public class DogServiceImpl implements DogService {
    private DogDao dogDao = new DogDaoImpl();

    @Override
    public int addDog(Dog dog) {
        return dogDao.addDog(dog);
    }

    @Override
    public int deleteDog(int id) {
        return dogDao.deleteDog(id);
    }

    @Override
    public int updateDog(Dog dog) {
        return dogDao.updateDog(dog);
    }

    @Override
    public Dog findById(int id) {
        return dogDao.findById(id);
    }

    @Override
    public List<Dog> queryAll() {
        return dogDao.queryAll();
    }

    @Override
    public int getTotalCount(Dog dog) {
        return  dogDao.getTotalCount(dog);
    }

    @Override
    public boolean findByBreed(String breed) {
        return dogDao.findByBreed(breed);
    }

    @Override
    public List<Dog> pageQueryDog(PageInfo pageInfo, Dog dog) {
       return  dogDao.pageQueryDog(pageInfo,dog);

    }
}

