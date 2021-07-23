# 자바 코딩테스트 준비

## 문제푸는 방식

1. 문제분석
    - 문제를 명확히 이해
    - 분석 내용 정리
2. 규칙찾기
    - 분석 내용으로 규칙을 찾는다.
3. 코딩화
    - 분석 내용으로 알맞은 구현방법 찾기
4. 알고리즘 적용
    - 알고리즘 정하고 담을 그릇 정한다.(사전지식 요구)

### String

- charAt(i) => 문자열의 위치
- toCharArray() => char[]
- IndexOf(), substring(begin, end) String str = “abcd”
    - ex) str.indexOf (“a”)// 0 // 없으면 -1
      <br/> indexOf( "찾을 특정 문자" , "시작할 위치" )
    - ex) str.substring(0,3)= abc
- startsWith(), endWith(), split()
    - ex)String str =“abc”str. startsWith(“a”); => true 
      <br/> str.endWith(“c”);=true
    - ex)String s = "abc" s.split(".");
      <br/> 스플릿은 그 값이 없다면 원문으로 들어간다.
      <br/> 파라미터로 limit을 주어 원하는 덩어리만큼으로 쪼갤 수 있다. 
- toLowerCase()
- replace()
- Character.isDigit(c), Character.isLetter(c) 
- StringBuilder sb = new StringBuilder(); sb.append(“aa”)
- String.join()

### Array
1. Math.max(max, a) => max 구하기
2. Map+ Array => two sum 문제
3. array+ stack => Daily Temperature
4. sum = sum+ nums[] => sum += nums[]

### 시간복잡도

- O(1) : 스택, 큐,Map
- O(n) : for문 => 데이터를 한번씩 다 호출하니까 (제일 많음)
- O(log N) : sort, prirotiyQueue, binary Search Tree, Tree
- O(Klog N) : k번만큼 소팅하는 경우
- O(n^2) : 이중for문
- O(m*n) : 이중for문인데, n이 다른경우bfs,dfs 류 ( 예 n=100 인데 m=5인경우)

### 참조

- [Java - 자바 코딩테스트 문법 정리](https://gwang920.github.io/java/Java-condingGrammer/#string)
- [정말 쉽게 풀어보는 코딩 테스트 top 기본 문제 (with 자바)](https://www.inflearn.com/course/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94/dashboard)
- [[JAVA] Java Collection API 시간복잡도 및 정렬 알고리즘 , 자료구조 별 시간복잡도.](https://unordinarydays.tistory.com/194)
- [자바 컬렉션(Java Collection)들의 Big O (시간 복잡도, Time Complexity)](https://soft.plusblog.co.kr/74)

