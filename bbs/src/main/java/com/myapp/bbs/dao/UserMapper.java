package com.myapp.bbs.dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myapp.bbs.model.User;

/**
 * 매퍼 클래스
 * board와 달리 loign쪽은 매퍼 XML 파일 없이 이 자바 매퍼에서 쿼리 처리 다함
 */
@Mapper
public interface UserMapper {
	
	/* 유저 입력하기 */
	@Insert("INSERT INTO user VALUES(#{id},#{password}, #{name}, #{userName}, #{email})")
	public int insert(User user);
	/* 유저 비밀번호 업데이트 */
	@Update("UPDATE user SET password = #{password} WHERE id = #{id}")
	public int update(User user);
	/* userName 업데이트 */
	@Update("UPDATE user SET userName = #{userName} WHERE id = #{id}")
	public int updateuserName(User user);
	/* 유저 삭제 하기 */
	@Delete("DELETE from user WHERE id = #{id}")
	public int delete(String id);
	/* 유저 총 숫자 */
	@Select("SELECT count(*) FROM user")
	public int count();
	/* 유저 리스트 검색 */
	@Select("SELECT * FROM user")
	public List<User> selectAll();
	/* 유저 조회하기 */
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User selectById(String id);
}