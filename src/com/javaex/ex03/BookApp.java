package com.javaex.ex03;

import java.util.List;

import com.javaex.ex02.AuthorDao;
import com.javaex.ex02.AuthorVo;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();
		AuthorDao authorDao = new AuthorDao();
		
		// 작가 5명등록
//		authorDao.authorInsert("1", "5");
//		authorDao.authorInsert("2", "4");
//		authorDao.authorInsert("3", "3");
//		authorDao.authorInsert("4", "2");
//		authorDao.authorInsert("5", "1");
//		System.out.println("");
		
		// 작가출력
		List<AuthorVo> authorList = authorDao.authorList();
		for (AuthorVo vo : authorList) {
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		System.out.println();
		// 작가 2명 삭제
		authorDao.authorDelete2(30);
		authorDao.authorDelete2(31);
		
		
		// 작가 1명수정

		
		// 작가출력
		
		// 책 출력
		List<BookVo> bookList = bookDao.bookList();
		for (BookVo vo : bookList) {
			System.out.println(vo.getBookId() + ", " + vo.getBookTitle() + ", " + vo.getBookPubs() + ", " 
							+ vo.getBookpub_Date() + ", " + vo.getBookauthorId());
		}
		System.out.println("");
		
		// 책, 작가 1개만 출력
		List<BookVo> bookListOne = bookDao.bookListOne();
		bookListOne.get(4).showInfo();
		System.out.println("");
		
		// 책, 작가 출력
		List<BookVo> bookListAll = bookDao.bookListAll();
		for (BookVo vo : bookListAll) {
			System.out.println(vo.getBookId() + ".\t" + vo.getBookTitle() + "\t" + vo.getBookPubs() + "\t" + vo.getBookpub_Date() 
							+ "\t" + vo.getBookauthorId() + "\t" + vo.getAuthorId() + "\t" + vo.getAuthorName() + "\t" + vo.getAuthorDesc());
		}
		
		
		// 책 5권 등록
		
		// 책 수정
		
		// 책 삭제
		
		
		
	}

}
