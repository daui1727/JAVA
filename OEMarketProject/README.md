
*<새 작업 진행하실 때는 항상 변경사항을 README에 작성해주세요.>

***************************************************

DGVO 작성
CrawlingMapper.java 작성
CrawlingMapper.xml 작성

CrawlingMapperTests.java 작성 후 테스트 성공

- C Read U D 파트
CrawlingMapper.java 코드 추가 -> public DGVO read(int no);

CrawlingMapper.xml에 아래 코드 추가
<select id="read" resultType="com.oe.domain.DGVO">
  	select * from crawlingTest where no = #{no}
</select>

CrawlingMapperTests.java 읽기 테스트 성공

pom.xml에 jsoup 추가
CrawlingTestController.java 작성
