# freelec-springboot2-webservice-2026

스마트 모빌리티 부트캠프 **서버 프로그래밍 과목 (05_server_programming, 7일, 2026-04-27~05-07)** 의 강사 참조 레포.
교재: 이동욱, *스프링 부트와 AWS로 혼자 구현하는 웹 서비스* (프리렉, 2019).

수업 자료는 `/home/anton/projects/YH_teachingagent/subjects/05_server_programming/` 에 있으며, 본 레포는 학생이 따라 만드는 코드의 **정답·시연 레포**입니다.

---

## 환경

- Spring Boot 3.2.0 / Java 17 / Gradle 8.x
- H2(개발) → MariaDB(운영, Day 5~7) / AWS EC2 + RDS
- Lombok / JUnit 5 + AssertJ / Mustache(Day 3) / Spring Security + OAuth2(Day 4)

---

## 브랜치 전략 ⭐

| 브랜치 | 용도 |
|--------|------|
| `main` | **수업 중 강사가 직접 시연하면서 만드는 코드.** Day N 진행 시 main 위에 단계별 커밋을 직접 추가 |
| `day03`, `day04`, … | **학생 비교용 정답.** 각 Day 의 의무 커밋 5~7개를 미리 작성해 두어 학생이 막혔을 때 단계별 diff 를 보고 비교 |

- Day 시작 전 정리 커밋이 필요하면 **`main` 에 먼저 반영 → `git rebase main`** 으로 day 브랜치 정렬.
- 학생 GitHub Issue 본문에는 **단계별 커밋 URL** 이 첨부되므로, 각 day 브랜치 커밋 수 = syllabus 의 "의무 커밋 시점" 개수와 일치해야 함.

---

## 코드 작성 원칙

### 1. 교재 절 순서 엄수 ⭐

- 강사 시연 / day 브랜치 커밋 / dayXX.md 단계 모두 **교재 절 순서 그대로** (예: 4-2 → 4-3 → 4-4 → 4-5).
- 한 절을 끝낸 뒤 다음 절로 넘어가고, 절 간 코드를 섞지 말 것.
- **Why**: Day 2 피드백에서 "코드 순서가 교재와 어긋나 강사 설명이 어렵다"는 명시적 지적.
- 다음 day 자료를 만들기 전 **반드시 본 레포의 현재 상태(작성된 파일·메서드)를 인벤토리** — 다음 day 범위에 해당하는 코드가 이전 day 에 선행 작성되어 있으면 정리 후 진행 (예: `7ab828c` 에서 `delete()` 를 Day 3 강의로 이관).

### 2. 한 단계 = 한 커밋

- syllabus 의 "의무 커밋 시점 N개" = 본 레포 day 브랜치에 있어야 할 커밋 수.
- 커밋 메시지 형식: `[DayNN] type: 한 줄 요약` — type ∈ {feat, test, fix, refactor, docs, chore}.
- 메시지 예: `[Day03] feat: layout(header/footer) 분리 + 글 등록 버튼 (4-3)`.

### 3. Spring Boot 3.x 마이그레이션

- 교재(2019)는 Spring Boot 1.x 기반 → **`javax.*` → `jakarta.*`** 전환 필수.
- 교재 코드를 그대로 복사하면 `package javax.persistence does not exist` 발생.
- 영향 범위: `@Entity`, `@Id`, `@GeneratedValue`, `@Column`, `@MappedSuperclass`, `@EntityListeners`, `HttpSession`, `HttpServletRequest` 등.

### 4. Day 4 OAuth 범위

- **Google 로그인만 다룸.** Naver 는 syllabus 명시로 생략.
- 작년 강사 레포(`AntonSangho/freelec-springboot2-webservice`)에는 Naver 도 포함되어 있으므로 자료 참고 시 주의.
- `application-oauth.properties` 는 반드시 `.gitignore` 등록 (Client Secret 노출 금지).

---

## 알려진 이슈

### `HelloControllerTest` 컨텍스트 로드 실패 (사전 존재)

- 증상: `./gradlew test` 전체 실행 시 `HelloControllerTest` 가 `JpaMetamodelMappingContext` 빈 누락으로 실패.
- 원인: Day 2 에 `Application.java` 에 `@EnableJpaAuditing` 직접 부착 → `@WebMvcTest` (웹 계층만 부트스트랩) 컨텍스트가 JPA 빈을 못 찾음.
- 정식 해결책 (둘 중 택1):
  - ① `@EnableJpaAuditing` 을 별도 `JpaConfig` 클래스로 분리
  - ② `HelloControllerTest` 에 `@MockBean(JpaMetamodelMappingContext.class)` 추가
- 우회: 개별 테스트 단독 실행 (`./gradlew test --tests "...HelloControllerTest"`) 또는 `IndexControllerTest` 같은 `@SpringBootTest` 는 영향 없음.

### `gradlew` 실행 권한 누락

- 레포에 `gradlew` 가 non-executable 상태로 커밋되어 있어 `./gradlew` 실행 시 `Permission denied`.
- 임시: `chmod +x gradlew` (단, git diff 에 mode 변경이 잡힘 → 커밋 전 `git checkout -- gradlew` 로 제외하거나, 별도 chore 커밋으로 영구 반영 권장).

---

## 참고 링크

- 교재 GitHub: https://github.com/jojoldu/freelec-springboot2-webservice
- 작년 강사 레포: https://github.com/AntonSangho/freelec-springboot2-webservice
- 본 레포: https://github.com/AntonSangho/freelec-springboot2-webservice-2026
- 저자 블로그: https://jojoldu.tistory.com/
- Spring Boot 1.x → 3.x 변경사항: https://jojoldu.tistory.com/539
