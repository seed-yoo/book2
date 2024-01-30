package com.javaex.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/book_db";
	private String id = "book";
	private String pw = "book";

	// 생성자

	// 메소드 - getter/setter

	// 메소드 - 일반
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	} // getConnection()

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 북리스트
	public List<BookVo> bookList() {

		// 리스트 준비
		List<BookVo> bookList = new ArrayList<BookVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " select book_id, ";
			query += "        title, ";
			query += "        pubs, ";
			query += "        pub_date, ";
			query += "        author_id ";
			query += " from book ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);

			// - 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				int bno = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubdate = rs.getString("pub_date");
				int authorid = rs.getInt("author_id");

				// Vo묶기
				BookVo bookVo = new BookVo(bno, title, pubs, pubdate, authorid);

				// 리스트에 추가
				bookList.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return bookList;
	}

	// 북리스트(작가 + 북) One
	public List<BookVo> bookListOne() {

		// 리스트 준비
		List<BookVo> bookListOne = new ArrayList<BookVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " select * ";
			query += " from book b ";
			query += " left join author a on b.author_id = a.author_id ";
			query += " order by book_id asc ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);

			// - 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				int bno = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubdate = rs.getString("pub_date");
				int authorid = rs.getInt("author_id");

				// Vo묶기
				BookVo bookVo = new BookVo(bno, title, pubs, pubdate, authorid);

				// 리스트에 추가
				bookListOne.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return bookListOne;
	}

	// 북리스트(작가 + 북) All
	public List<BookVo> bookListAll() {

		// 리스트 준비
		List<BookVo> bookListAll = new ArrayList<BookVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " select * ";
			query += " from book b ";
			query += " left join author a on b.author_id = a.author_id ";
			query += " order by book_id asc ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);

			// - 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				int bookno = rs.getInt("b.book_id");
				String booktitle = rs.getString("b.title");
				String bookpubs = rs.getString("b.pubs");
				String bookpub_date = rs.getString("b.pub_date");
				int bookauthorid = rs.getInt("b.author_id");
				
				int authorno = rs.getInt("a.author_id");
				String authorname = rs.getString("a.author_name");
				String authordesc = rs.getString("a.author_desc");

				// Vo묶기
				BookVo bookVo = new BookVo(bookno, booktitle, bookpubs, bookpub_date, bookauthorid, authorno, authorname, authordesc);

				bookListAll.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return bookListAll;
	}

	// 작가 등록
	public int bookInsert(BookVo bookVo) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// - sql문 준비
			String query = "";
			query += " insert into book ";
			query += " value(null, ?, ?, ?, ?) ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookVo.getBookTitle());
			pstmt.setString(2, bookVo.getBookPubs());
			pstmt.setString(3, bookVo.getBookpub_Date());
			pstmt.setInt(4, bookVo.getBookauthorId());

			// - 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}
 
	
}
