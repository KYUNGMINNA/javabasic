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