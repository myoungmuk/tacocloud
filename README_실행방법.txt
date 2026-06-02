25-3은 Render hosting 실습입니다. 25-2 기능에 Dockerfile과 Render 배포용 설정을 추가했습니다.

1. IntelliJ IDEA에서 이 폴더를 Open 합니다.
2. application.properties의 MONGODB_URI를 설정합니다.
   - IntelliJ Run Configuration > Environment variables에 아래처럼 입력합니다.
   - MONGODB_URI=mongodb+srv://아이디:비밀번호@cluster0.xxxxx.mongodb.net/tacoclouddb?retryWrites=true&w=majority&appName=Cluster0
3. src/main/java/tacos/TacoCloudApplication.java를 우클릭해서 실행합니다.
4. 브라우저에서 http://localhost:8085 로 접속합니다.
5. Register here → 회원가입 → Login → Design your taco → Order 순서로 테스트합니다.

테스트 입력 예시
- Username: myoungmuk
- Password: 1234
- Full name: 강명묵
- Street: 123 hknu
- City: Anseong
- State: Gyeonggi
- Zip: 17579
- Credit Card #: 4111111111111111
- Expiration: 12/25
- CVV: 123

모든 화면에 2022810001 강명묵이 보이도록 작성했습니다.
