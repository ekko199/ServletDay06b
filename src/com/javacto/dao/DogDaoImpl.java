package com.javacto.dao;

import com.javacto.po.Dog;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogDaoImpl implements DogDao {
    @Override
    public int addDog(Dog dog) {
        String sql = "INSERT INTO dog (breed,gender,price,birthday,numbers) VALUES(?,?,?,NOW(),?)";
        Object object[]={dog.getBreed(),dog.getGender(),dog.getPrice(),dog.getNumbers()};
        return BaseDao.myExecuteUpdate(sql,object);
    }

    @Override
    public int deleteDog(int id) {
         String sql ="DELETE FROM dog WHERE id = ?";
         Object object[]={id};
         return BaseDao.myExecuteUpdate(sql,object);
    }

    @Override
    public int updateDog(Dog dog) {
        String sql ="UPDATE   dog SET breed=?,gender=?,price=?,birthday=?,numbers=? WHERE  id=?";
        Object object[]={dog.getBreed(),dog.getGender(),dog.getPrice(),dog.getBirthday(),dog.getNumbers(),dog.getId()};
        return BaseDao.myExecuteUpdate(sql,object);
    }

    @Override
    public Dog findById(int id) {
        Dog dog =null;

        try {
            //1.加载驱动 DriverManager
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接  Connection
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM dog WHERE id=?");
            //4.如果SQL语句 有？ 号必需给? 赋值
            /**
             * java.sql.SQLException: No value specified for parameter 4
             */
            pstm.setObject(1,id);

            ResultSet re = pstm.executeQuery();
            while (re.next()){
                dog = new Dog();
                dog.setBreed(re.getString(1));
                dog.setGender(re.getString(2));
                dog.setPrice(re.getDouble(3));
                dog.setBirthday(re.getDate(4));
                dog.setNumbers(re.getInt(5));
                dog.setId(re.getInt(6));
                System.out.println(dog);
            }
            //6.释放资源
            pstm.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dog;
    }

    @Override
    public List<Dog> queryAll() {
        List<Dog> list = new ArrayList<Dog>();

        try {
            //1.加载驱动 DriverManager
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接  Connection
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM dog ");
            //4.如果SQL语句 有？ 号必需给? 赋值
            /**
             * java.sql.SQLException: No value specified for parameter 4
             */
            ResultSet re = pstm.executeQuery();
            while (re.next()){
                Dog dog = new Dog();
                dog.setBreed(re.getString(1));
                dog.setGender(re.getString(2));
                dog.setPrice(re.getDouble(3));
                dog.setBirthday(re.getDate(4));
                dog.setNumbers(re.getInt(5));
                dog.setId(re.getInt(6));

                list.add(dog);
            }

            //6.释放资源
            pstm.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int getTotalCount(Dog dog) {
        int count = 0;
        Connection conn=BaseDao.getCollections();
        PreparedStatement pstm=null;
        ResultSet rs =null;
        try{
            String sql="SELECT COUNT(*) FROM dog";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
                count=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }
        return count;
    }
//分页查询
    @Override
    public List<Dog> pageQueryDog(PageInfo pageInfo, Dog dog) {
        List<Dog> list = new ArrayList<Dog>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=BaseDao.getCollections();
            String sql="SELECT * FROM dog LIMIT ?,?";
            pstm = conn.prepareStatement(sql);
            int begin= (pageInfo.getPageNo()-1)*pageInfo.getPageSize();
            int end =pageInfo.getPageSize();
            pstm.setObject(1,begin);
            pstm.setObject(2,end);
            rs = pstm.executeQuery();
            while (rs.next()){
                Dog dog1 =new Dog();
                dog1.setBreed(rs.getString(1));
                dog1.setGender(rs.getString(2));
                dog1.setPrice(rs.getDouble(3));
                dog1.setBirthday(rs.getDate(4));
                dog1.setNumbers(rs.getInt(5));
                dog1.setId(rs.getInt(6));
                list.add(dog1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }
        return list;
    }
//根据种类查询
    @Override
    public boolean findByBreed(String breed) {
        boolean b=false;
        Connection conn= null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=BaseDao.getCollections();
            String sql ="SELECT * FROM dog where breed=?";
            pstm=conn.prepareStatement(sql);
            pstm.setObject(1,breed);
            rs=pstm.executeQuery();
            //6.循环遍历
            while (rs.next()){
                b=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao.closeAll(conn,pstm,rs);
        }
        return b;

        }
    }


