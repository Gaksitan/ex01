package com.example.ex01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex01.domain.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
	
	public List<SimpleBbsDto> getList();
	public SimpleBbsDto getDto(@Param("id") String id);

	public void write(String writer, String title, String content);
	public void write2(String writer, String title, String content);
	public void write3(String writer, String title, String content);
	public void write4(@Param("writer") String writer, @Param("title") String title, @Param("content") String content);
	public void write5(@Param("dto") SimpleBbsDto dto);
	public void delete(String id);
}
