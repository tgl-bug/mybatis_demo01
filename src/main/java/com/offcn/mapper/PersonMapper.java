package com.offcn.mapper;

import com.offcn.entity.Person;

import java.util.HashMap;
import java.util.List;

public interface PersonMapper {
    public void addPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Integer id);
    public Person selectPersonById(Integer id);
    public List<Person> selectPersons();
    public Person selectPersonByGenderAndAge(String gender,Integer age);
    //括号里面的值不同，方法重载
    public List<Person> selectPersonByGenderAndAge1(HashMap<String,Object> map);
}