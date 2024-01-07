- 영속 상태는 식별자 값이 반드시 있어야 한다.
- 엔티티 매니저는 트랜잭션을 커밋하기 전에 INSERT 쿼리를 차곡차곡 저장하고 한꺼번에 데이터베이스에 보냄 -> 쓰기 지연
- @DynamicUpdate는 변경된 컬럼만 찾아서 업데이트를 진행한다.
- @Entity가 달린 클래스는 기본 생성자는 필수
- @Entity가 달린 클래스에서 저장할 필드에 final을 붙이면 안됨
- ddl.auto 속성
  - create: 기존 테이블을 삭제하고 새로 생성
  - create-drop: create 속성에 종료할 때 drop
  - update: 변경 된 부분만 update
  - vlidate: 변경 된 부분 감지하고 알람 -> 변경 된 부분이 있으면 어플리케이션 실행 시키지 않음
  - none: 자동 생성 기능 X -> 유효하지 않은 옵션 값
- Mysql에서 사용하는 기본 키 생성 전략은 IDENTITY

  # 연관관계

  ## 다대일(N:1)
  - 회원과 팀이 있다.
  - 회원은 하나의 팀에 소속될 수 있다.
  - 회원과 팀은 다대일 관계이다.

```SQL
SELECT *
FROM MEMBER M
JOIN TEAM T ON M.TEAM_ID = T.ID
```   
