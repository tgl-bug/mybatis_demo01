package com.test;

import com.offcn.entity.Person;
import com.offcn.mapper.PersonMapper;
import com.offcn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PersonTest {
    @Test
    public void addPerson() {
        SqlSession session = MybatisUtils.getSession();
        //传入接口的Class对象，返回值是这个借口的代理类对象
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = new Person("王五", "男", 66, new Date());
        personMapper.addPerson(person);
        session.commit();
        MybatisUtils.close(session);

    }

    @Test
    public void updatePerson() {
        SqlSession session = MybatisUtils.getSession();
        //传入接口的Class对象，返回值是这个借口的代理类对象
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = new Person("阿巴阿巴", "男", 99, new Date());
        person.setId(2);
        personMapper.updatePerson(person);
        session.commit();
        MybatisUtils.close(session);
    }

    @Test
    public void deletePerson() {
        SqlSession session = MybatisUtils.getSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        personMapper.deletePerson(1);
        session.commit();
        MybatisUtils.close(session);

    }

    @Test
    public void getPersonById() {
        SqlSession session = MybatisUtils.getSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = personMapper.selectPersonById(2);
        System.out.println(person);
        session.commit();
        MybatisUtils.close(session);
    }
    @Test
    public void getPersons(){
        SqlSession session = MybatisUtils.getSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        List<Person> person = personMapper.selectPersons();
        for (Person list : person) {
            System.out.println(list);
        }
        session.commit();
        MybatisUtils.close(session);
    }
    @Test
    public void selectPersonByGenderAndAge(){
        SqlSession session = MybatisUtils.getSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = personMapper.selectPersonByGenderAndAge("男", 20);
        System.out.println(person);
        session.commit();
        MybatisUtils.close(session);
    }
    @Test
    public void selectPersonByGenderAndAge1(){
        SqlSession session = MybatisUtils.getSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("age",20);
        map.put("gender","男");
        List<Person> personList = personMapper.selectPersonByGenderAndAge1(map);
        for (Person person : personList) {
            System.out.println(person);
        }
        session.commit();
        MybatisUtils.close(session);

    }
}
