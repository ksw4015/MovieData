## 소개

작년 한 스타트업 면접 전 과제입니다

## 내용

안드로이드 어플리케이션을 간단하게 만드는 과제고

봐야할 사항은 크게 2가지 입니다

첫째, RestFul API를 사용해 원하는 데이터를 끌어 올 수 있는지

둘째, API를 사용해 데이터를 가져왔다면 어떻게 파싱해서 안드로이드 UI로 표현을 할 것인지


## 

과제내용을 요약하자면

현재 상영작들을 가져와 순위로 정렬해서 리사이클러뷰로 보여주고(영화당 3~4가지 정보)

해당 영화를 터치하면 좀 더 자세한 정보를 볼 수 있게 하는 어플리케이션 입니다(영화당 7~8가지 정보)


JSON데이터 파싱은 GSON으로 하였고, RestFul Api를 연결하기 위해 Retrofit2를 