01. implementation 'org.springframework.boot:spring-boot-devtools' 의존성을 추가하고 html 페이지 편집 후 build에서 recompile을 해주면 서버를 다시 띄우지 않아도 html 페이지에 반영이 된다.
02. h2 데이터베이스는 처음에는 파일 모드로 파일을 생성을 하지만 그 이후로는 tcp를 붙여서 네트워크 모드로 접속하게 한다.
03. @Repository는 component scan 대상이다.
04. spring-boot-stater-data-jpa를 통해서 엔티티 매니저 생성이나 팩토리 생성 등을 자동으로 해준다.
05. @PersistenceContext 애노테이션을 통해 스프링 부트를 사용하기 때문에 스프링 컨테이너 위에서 동작하는데 컨테이너에서 entity manger 주입을 해준다.
06. 스타일의 차일순 있지만 커맨드와 쿼리를 분리하라는 원칙으로 인해 저장을 한 뒤 멤버 객체를 반환하는 것이 아닌 id를 넘겨서 다시 조회가 가능하기 때문에 리턴을 long으로 해주게 된다.
07. **모든 엔티티 매니저 통한 모든 데이터 변경은 트랜잭션에서 이루어 져야 한다.**
08. @Transactional 애노테이션이 test에 있으면 테스트가 끝난 뒤 롤백을 해버린다.
09. **같은 영속성이라면 Member와 find 한 Member는 같아야 한다.**
10. **Order와 Member는 다대일 관계. 때문에 Order 엔티티에 @ManyToOne**
11. **@OneToMany(mappedBy = "member") 애노테이션이 있는 경우는 나는 맵핑이 된 것이다 라는 표현. 즉 나는 거울이다. 주인을 넣어준다. 즉 주인은 member**
12. Setter를 열어두지 말자.
13. 
