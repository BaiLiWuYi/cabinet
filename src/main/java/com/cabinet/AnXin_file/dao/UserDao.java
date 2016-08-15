package com.cabinet.AnXin_file.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cabinet.AnXin_file.entity.UserEntity;

public interface UserDao {

	@Select("select * from user")
	List<UserEntity> findAllUser();
	
	@Select("select * from user where count=#{count}")
	List<UserEntity> findUserByCount(@Param("count") String count);
}
