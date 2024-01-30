package com.javaex.ex02;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();
		authorDao.authorInsert("서장훈", "농구선수");
		authorDao.authorInsert("안정환", "축구선수");
		
		
		AuthorVo authorVo = new AuthorVo("유영수", "개발학생");
		authorDao.authorInsert2(authorVo);
		
		authorDao.authorDelete(21);
		authorDao.authorDelete(22);
		authorDao.authorDelete(1);
		
		List<AuthorVo> authorList = authorDao.authorList();
		for (AuthorVo vo : authorList) {
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		
		
		
		
		
	}

}
