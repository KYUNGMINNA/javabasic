# 자바 프로젝트 기본 설정

1. 플러그인 설치
- file -> settings 
- 왼쪽 plugins 선택
- 검색창에 korean language pack
- material theme, atom material icon 설치

2. 폰트 크기 조절 설정
- 파일 -> 설정 
- 마우스 검색 후 에디터 -> 일반 탭
- Ctrl + wheel 로 글꼴크기 설정 체크

3. 한글 깨짐 설정
- shift 두번 누르고 검색창에 vm 검색
- 사용자 지정 vm 옵션 편집 클릭
- `-Dfile.encoding=UTF-8`입력 후 재실행
- 파일 -> 설정 클릭 후 
- 빌드 도구 -> gradle 탭 클릭
- 실행환경과 테스트 환경을 gradle에서 intellij로 변경


## 자바 8 람다 문법
- 여러가지 람다 표현식
    1. `(String s) -> s.length()` : String형식의 파라미터 하나를 가지며 int를 반환한다. 람다표현식에는 return이 함축되어 있다.
    1. `(Apple a) -> a.getWeight() > 150` : Apple형식의 파라미터 하나를 가지며 boolean을 반환한다.
    1. int형식의 2개의 파라미터를 가지며 리턴값이 없다.
        ```
             (int x, int y) -> {
                 System.out.println("Result:");
                 System.out.println(x + y);
             }
        ```
    1. `() -> 42` : 파라미터가 없으며 42를 반환한다.

- 제공되는 함수형 인터페이스

함수형 인터페이스 | 함수 디스크립터 |
---|---|
Predicate<T> | T -> boolean
Consumer<T> | T -> void
Function<T, R> | T -> R
Supplier<T> | () -> T
UnaryOperator<T> | T -> T
BinaryOperator<T> | (T, T) -> T
BiPredicate<L, R> | (T, U) -> boolean
BiConsumer<T, U> | (T, U) -> void
BiFunction<T, U, R> | (T, U) -> R

- 메서드 참조
    - `(args) -> ClassName.staticMethod(args)` => `ClassName::staticMethod`
        - `() -> Math.random()` => `Math::random`
        - `message -> System.out.println(message)` => `System.out::println`

    - `(args0, rest) -> args0.instanceMethod(rest)` => `ClassName::instanceMethod`
        - `(str, i) -> str.substring(i)` => `String::substring`
        - `(apple) -> apple.getWeight()` => `Apple::getWeight`
    - `(args) -> expr.instanceMethod(args)` => `expr::instanceMethod`
        - `(s) -> this.isValidName(s)` => `this::isValidName`

- 생성자 참조
    - `() -> new Constructor()` => `ClassName::new`
        - `() -> new Apple()`  => `Apple::new`
    - `(args) -> new Constructor(args)` => `ClassName::new`
        - `(weight) -> new Apple(weight)` => `Apple::new`