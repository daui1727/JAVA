**1. 기본 설정

**2. MP_BOARD 테이블 생성
CREATE TABLE MP_BOARD(
    BNO NUMBER NOT NULL,
    TITLE VARCHAR2(100)     NOT NULL,
    CONTENT VARCHAR2(2000)  NOT NULL,
    WRITER VARCHAR2(100)    NOT NULL,
    REGDATE DATE            DEFAULT SYSDATE,
    PRIMARY KEY(BNO)
);

테이블의 게시판 번호를 1부터 자동으로 1씩 증가

CREATE SEQUENCE MP_BOARD_SEQ
START WITH 1
INCREMENT BY 1;

INSERT INTO MP_BOARD(BNO, TITLE, CONTENT, WRITER)
     VALUES (MP_BOARD_SEQ.NEXTVAL, '제목입니다', '내용입니다', 'MELONPEACH');

SELECT * FROM MP_BOARD;
COMMIT;




**3. boardMapper.xml 에 아래 추가
<!-- 게시판 글 작성 -->
<insert id="insert">
	   INSERT INTO MP_BOARD(BNO, TITLE, CONTENT, WRITER)
	   VALUES(MP_BOARD_SEQ.NEXTVAL, #{title}, #{content}, #{writer})
</insert>

**4. src/main/java에 org.zerock.dao / org.zerock.service / org.zerock.vo 패키지 생성
controller의 역할은 웹에서 처리해야할 데이터를 받고, 이 데이터를 담당할 service를 선택하여 호출한다.
그리고 처리한 데이터를 다음 페이지에서 볼 수 있게 세팅하며 이동할 페이지를 리턴한다.

service는 데이터를 dao를 통해 넘겨주거나 받으면서 비즈니스 로직을 수행하는 역할을 한다.

dao는 DB를 통해 데이터를 조회하거나 수정, 삭제하는 역할을 한다.

vo는 DB에 있는 테이블 컬럼 값을 java에서 객체로 다루기 위해 사용한다.

**5. org.zerock.vo 패키지에 BoardVO 클래스 작성
@Data
public class BoardVO {
	
private int bno;
private String title, content, writer;
private Date regdate;

}

**6. org.zerock.dao 패키지 안에 BoardDAO 와 BoardDAOImpl 생성
import org.zerock.vo.BoardVO;

public interface BoardDAO {
	
// 게시글 작성
public void write(BoardVO vo);

}

**

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
 @Autowired
 private SqlSession sqlSession;

 // 게시글 작성
 @Override
 public void write(BoardVO vo) {
 	 sqlSession.insert("boardMapper.insert", vo);
 }

}


**7. org.zerock.service 패키지 안에 BoardService와 BoardServiceImpl 작성
public interface BoardService {
	
// 게시글 작성
public void write(BoardVO vo);
	
}

**

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
 @Autowired
 private BoardDAO dao;

 @Override
 public void write(BoardVO vo) {
 	 dao.write(vo);
 }

}


**8. org.zerock.controller 패키지 안에 BoardController 클래스 작성
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
 private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

 @Autowired
 BoardService service;

 //게시판 글 작성화면
 @RequestMapping(value="/board/writeView", method=RequestMethod.GET)
 public void writeView() {
	logger.info("writeView");
 }

 //게시판 글 작성
 @RequestMapping(value="/board/write", method=RequestMethod.POST)
 public String write(BoardVO vo) {
	logger.info("write");
	service.write(vo);
	return "redirect:/";
 }
	
}

**9. root-context.xml 에 코드 추가
<!-- scan -->
<context:component-scan base-package="org.zerock.service"></context:component-scan>
<context:component-scan base-package="org.zerock.dao"></context:component-scan>
<context:component-scan base-package="org.zerock.vo"></context:component-scan>

**10. servlet-context.xml에
<context:component-scan base-package="org.zerock.controller" />로 수정


**11. views에 board 폴더를 만들고 writeView.jsp파일을 생성하여 코드를 추가























