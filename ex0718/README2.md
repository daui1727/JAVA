

**88. list.jsp에 아래처럼 추가

 <!-- 페이지 처리 Start -->
<div class="pull-right">
   <ul class="pagination">
   
   <c:if test="${pageMaker.prev }">
      <li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
   </c:if>
   
   <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
      <li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num }</a></li>
   </c:forEach>

   <c:if test="${pageMaker.next }">
      <li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a></li>
   </c:if>
   </ul>
</div>

<!-- 페이지 처리 End -->

<form id="actionForm" action="/board/list" method="get" >
   <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
   <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
</form>


*************************
0720 - 수업

**89. BoardController.java 클래스를 아래와 같이 수정

@GetMapping({"/get", "/modify"}) // @ModelAttribute("cri") - 데이터를 넘겨줄때 cri로 넘겨주겠다.
public void get(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
	log.info("get................");
	model.addAttribute("board", service.get(bno));
}


**90. get.jsp에 다음과 같이 input 태그 추가

<form id='operForm' action="/board/modify" method="get">
	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}" />'>
	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
	<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
</form>

**91. modify.jsp에
<form action="/board/modify" method="post" role="form"> 바로 밑에 아래 두줄 복붙

<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>

**92. BoardController.java 클래스에 다음과 같이 modify 수정 - 수정하고 리스트로 돌아올때 해당 페이지에 머무르게 25페이지였으면 25페이지로 돌아가게.
@PostMapping("/modify")
public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	log.info("modify : " + vo);
	if(service.modify(vo) == 1) {
		rttr.addFlashAttribute("result", "success");
	}
	rttr.addAttribute("pageNum", cri.getPageNum());
	rttr.addAttribute("amount", cri.getAmount());
	return "redirect:/board/list";
}

**93. BoardController.java 클래스에 remove도 동일하게 수정
@PostMapping("/remove")
public String remove(Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	log.info("delete-----------"+bno);
	if(service.remove(bno) == 1) {
		rttr.addFlashAttribute("result", "success");
	}
	rttr.addAttribute("pageNum", cri.getPageNum());
	rttr.addAttribute("amount", cri.getAmount());
	return "redirect:/board/list";
}

**94. modify.jsp를 아래처럼 수정 /
수정화면에서 리스트로 돌아갈때 현재는 http://localhost:8181/board/list? 로 표현되지만 pageNum 등의 값을 넘기려고 한다
bno 값은 넘겨줄 필요없기 때문에 pageNum과 amount만 넘기도록 한다

<script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form");
	$('button').on("click", function(e){
		e.preventDefault();
		var operation = $(this).data('oper');
		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action","/board/remove");
		}else if(operation === 'list'){
			//self.location = "/board/list";
			formObj.attr("action", "/board/list").attr("method","get");
			var pageNumTag = $("input[name='pageNum']").clone();   // 복제
			var amountTag = $("input[name='amount']").clone();	// 여기서 담아뒀다가
			formObj.empty();
			formObj.append(pageNumTag); // 나중에 추가하겠다.
			formObj.append(amountTag);
		}
		formObj.submit();
	});           		
});
</script>

**95. 전체 게시글의 토탈 수를 알기 위해 BoardMapper.java 인터페이스에 아래 추가

public int getTotalCount(Criteria cri);

**96. BoardMapper.xml에 아래 추가
<select id="getTotalCount" resultType="int">
   	select count(*) from tbl_board where bno > 0
</select>

**97(중요). sql문
select count(*) from tbl_board; -- 전체 카운트 수 확인
select count(*) from tbl_board where bno > 0; -- index를 통해 카운트 수 확인 / 더 빠르다

**98. BoardService.java 클래스에 아래 추가
public int getTotal(Criteria cri);

**99. BoardServiceImpl.java 클래스에 아래 추가
@Override
public int getTotal(Criteria cri) {
	log.info("get total count");
	return mapper.getTotalCount(cri);
}

여기까지 작성하고 실행하면 총 카운트 수가 적용된 게시글이 화면에 나타난다.

*<여기까지 CRUD와 페이징 처리가 완료되었다.>

******************************************************************************************
--> 검색 조건
--> 댓글 처리 진행합니다~


**100. BoardMapper.java 클래스에 아래 추가

//검색조건
public List<BoardVO> searchTest(Map<String, Map<String, String>> map);


**101(중요). sql문 - rownum 2가 11부터 20까지 나오게 하는 sql문 
select * from (
    select rownum rs, title, content, writer, regdate, updatedate
    from TBL_BOARD
    where title like '%2%' and rownum <=20
)
where rs > 10;

-- 2 또는 3
select * from (
    select rownum rs, title, content, writer, regdate, updatedate
    from TBL_BOARD
    where (title like '%2%' or content like '%3%') and rownum <=20
)
where rs > 10;



**102. BoardMapper.xml에 아래 추가
   <!-- 검색 조건 -->
   <select id="searchTest" resultType="org.zerock.domain.BoardVO">
   	  <![CDATA[
     	select * from tbl_board
     	where
     	]]>
     	<trim suffix="and">
     		<foreach collection="map" index="key" item="val">
     			<if test= "key == 'W'.toString()">
     				writer like #{val}
     			</if>
     		</foreach>
     	</trim>
      <![CDATA[
     	rownum < 10
     	 ]]>
    </select>

**103. BoardMapperTests.java 클래스에 아래처럼 작성하고 테스트
@Test
public void testSearchTest() {
	Map<String, String> map = new HashMap<>();
	map.put("T", "2");
	map.put("C", "3");
	map.put("W", "2");
	
	Map<String, Map<String, String>> outer = new HashMap<>();
	
	outer.put("map", map);
	List<BoardVO> list = mapper.searchTest(outer);
	log.info(list);
}

**104. BoardMapper.xml에 아래로 수정
<!-- 검색 조건 -->
   <select id="searchTest" resultType="org.zerock.domain.BoardVO">
   	  <![CDATA[
     	select * from tbl_board
     	where
     	]]>
     	<trim suffix="and">
     		<foreach collection="map" index="key" item="val" separator="or" open="(" close=")">
     			<if test= "key == 'T'.toString()">
     				title like #{val}
     			</if>
     			<if test= "key == 'C'.toString()">
     				content like #{val}
     			</if>
     			<if test= "key == 'W'.toString()">
     				writer like #{val}
     			</if>
     		</foreach>
     	</trim>
      <![CDATA[
		rownum < 10
     	 ]]>
     	 
    </select>
    
**105. Criteria.java 클래스에 아래 추가
private String type;
	private String keyword;
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}

























