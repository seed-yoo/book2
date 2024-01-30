package com.javaex.ex01;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();
		
		List<AuthorVo> authorList = authorDao.authorList();
		for (AuthorVo authorVo : authorList) {
			int id = authorVo.getAuthorId();
			String name = authorVo.getAuthorName();
			String desc = authorVo.getAuthorDesc();
			System.out.println(id + ",\t" + name + ",\t" + desc);
		}
		
		/*
		for (int i = 0; i < authorList.size(); i++) {
			AuthorVo authorVo = authorList.get(i);
		
			int id = authorVo.getAuthorId();
			String name = authorVo.getAuthorName();
			String desc = authorVo.getAuthorDesc();
			System.out.println(id + ",\t" + name + ",\t" + desc);
		}
		*/
		
		System.out.println(authorList.size() + "명의 작가가 등록되어 있습니다.");
		
		// 작가 등록
//		authorDao.authorInsert("이효리", "제주도민");
		// 작가 삭제
//		authorDao.authorDelete(12);
		// 작가 수정
//		authorDao.authorUpdate(13, "이효리", "제주도민");
		
		
		
		
	}

}
