# 39-COLLABORATION-ANDROID-MEEMONG
> PLAY SOPT 합동 세미나 모바일앱 3조 ✂️ 미몽 ✂️ Android 레포지토리 🤖
<br>

<img width="1920" height="1080" alt="발표장표" src="https://github.com/user-attachments/assets/ee3f608e-f958-4185-b9b1-cfda1ecc66a0" />

<br>

## 🤖 Android 팀원 소개

| <img src="https://github.com/doorimng.png" width="200"> | <img src="https://github.com/shinhanseo.png" width="200"> | <img src="https://github.com/cowkite12.png" width="200"> |
| :---: | :---: | :---: |
| **Android Lead** | **Android** | **Android** |
| <b>[김예림](https://github.com/doorimng)</b> | <b>[신한서](https://github.com/shinhanseo)</b> | <b>[정소연](https://github.com/cowkite12)</b> |
| `초기 세팅`<br>`디자인 시스템 구축 · 아이콘 추가`<br>`상세 페이지 UI 및 공통 컴포넌트 구현`<br>`내용 상세 조회 · 디자이너 정보 조회 API 연결` | `빠른 매칭 UI 및 공통 컴포넌트 구현`<br>`디자이너 카드 목록 조회 API 연결`<br>`찜 등록 · 찜 취소 API 연결` | `홈 UI 및 공통 컴포넌트 구현`<br>`일반 공고 목록 조회 API 연결`<br>`README 작성` |
<br>

## 📱 구현 범위

### Main Flow

**홈 → 빠른 매칭 → 상세 페이지**

| 화면 | 담당 | 주요 구현 |
| :---: | :---: | :--- |
| 🏠 홈 | 정소연 | 디자이너 섹션 4종 가로 스크롤<br>미몽추천 빠른매칭글 좋아요 · 카드 클릭 시 상세 페이지 이동 · 더보기 클릭 시 빠른 매칭 이동<br>퀵메뉴 빠른매칭 클릭 시 빠른 매칭 이동<br>헤어템 · 헤어컨설팅 섹션, 플로팅 메뉴 |
| ⚡ 빠른 매칭 | 신한서 | 디자이너 / 모델 탭 전환<br>미몽추천 공고 · 일반 공고 목록<br>공고 좋아요, 광고 배너, 플로팅 메뉴 |
| 📄 상세 페이지 | 김예림 | 이미지 캐러셀, 디자이너 프로필, 시술 정보 카드<br>내용 상세 / 디자이너 정보 탭 전환<br>포트폴리오 · 매장 정보 · SNS, 좋아요, 하단 예약 버튼 |

<br>

## 🛠 기술 스택 및 라이브러리

| 구분 | 사용 기술 |
| :---: | :--- |
| Language | Kotlin `2.2.10` |
| UI | Jetpack Compose (BOM `2026.02.01`), Material3 |
| Architecture | MVVM, Google 권장 아키텍처 |
| Activity 구조 | Single Activity Architecture (SAA) |
| DI | 수동 주입 (`ViewModelFactory`) |
| Async | Coroutines, Flow |
| Navigation | Navigation Compose `2.10.2` (Kotlinx Serialization) |
| Lifecycle | Lifecycle ViewModel Compose `2.11.0` |
| Network | Retrofit `2.11.0`, Gson Converter, OkHttp `4.12.0` |
| Image | Coil `3.3.0` |
| Build | AGP `9.4.1`, Version Catalog (`libs.versions.toml`) |
| SDK | minSdk `24` / targetSdk `37` |
<br>

## 🤝 Git Convention

### 🌿 브랜치

**브랜치 유형**

| 브랜치 | 설명 |
| :---: | :--- |
| `develop` | 개발이 진행되는 동안 완성된 코드를 저장하는 브랜치 |
| `feature` | 작은 단위의 작업이 진행되는 브랜치 |
| `hotfix` | 긴급한 오류를 해결하는 브랜치 |

**브랜치명**

`유형/#이슈번호-what`

```
feat/#25-search-api
feat/#30-home-ui
init/#1-add-font
```

**브랜치명 카테고리**

| 카테고리 | 설명 |
| :---: | :--- |
| `feat` | 구현 |
| `mod` | 수정 |
| `add` | 추가 |
| `del` | 삭제 |
| `fix` | 버그 수정 |
| `refactor` | 리팩토링 |

<br>

### 📝 커밋

`[커밋 카테고리/#이슈번호] 커밋 내용`

```
[feat/#30] 홈 뷰 구현
[add/#1] 폰트 파일 추가
```

**커밋 카테고리**

| 카테고리 | 설명 |
| :---: | :--- |
| `feat` | 새로운 기능 구현 |
| `mod` | 코드 수정 |
| `add` | feat 이외의 부수적인 코드 추가, 라이브러리 추가 |
| `del` | 쓸모없는 코드 삭제 |
| `chore` | 변수명 및 함수명 수정과 같은 사소한 수정 |
| `fix` | 버그 수정 |
| `docs` | 문서 추가, 수정, 삭제 |
| `init` | 프로젝트 초기 세팅 |

**머지 커밋**

```
[MERGE] #이슈번호 -> develop
```

<br>

### 🔀 Git Flow

기본적으로 Git Flow 전략을 이용합니다.

1. Issue를 생성한다.
2. Branch를 생성한다.
3. Add - Commit - Push - Pull Request의 과정을 거친다.
    - commit은 최대한 잘게!!
    - PR 시 issue를 연결한다.
4. Pull Request가 작성되면 작성자 이외의 다른 팀원이 Code Review를 한다.
5. Code Review가 완료되면 Pull Request 작성자가 develop 브랜치로 merge 한다.
    - merge 후 카톡방에 무조건 말하기!
6. merge된 작업이 있을 경우, 다른 브랜치에서 작업을 진행 중이던 개발자는 본인의 브랜치로 merge된 작업을 pull 받아온다.

**협업 규칙**

1. develop 브랜치에서의 작업은 원칙적으로 금지한다. 단, 초기 세팅 및 README 작성은 develop 브랜치에서 수행한다.
2. 본인의 Pull Request는 본인이 merge한다.
3. Commit, Push, Merge, Pull Request 등 모든 작업은 앱이 정상적으로 실행되는지 확인(빌드) 후 수행한다.

<br>

## ⛳ 그라운드 룰

- 모르는 건 바로 질문하고 서로 열심히 도와주기
- 연락 잘 확인하기
- 핵심을 찌르되 둥글게 말하자 둥글둥글

### ✅ PR 규칙

- 코드 리뷰는 해당 PR이 올라온 후 24시간 이내에 진행합니다.
- 리뷰를 반영했다면 re-request(🔄)를 눌러 재검토를 요청해주세요.
- 팀원 모두의 Approve를 받은 후 본인이 직접 머지합니다.
- 머지한 이후에는 단톡방에 꼭!! 남겨주세요. → 나머지 인원은 그 즉시 pull 받아오기

### 🍀 안드 그라운드 룰

| 김예림 | 신한서 | 정소연 |
| :---: | :---: | :---: |
| 둥글게 말하기 (진짜 중요함)<br>코리 3개 이상 달기<br>합세하는 동안 싸우지 말기<br>잠도 잘 자기 (이것도 진짜 중요함) | 간단한 질문이라도 서슴치 않고 질문하기 | 커밋푸쉬 해주었거나 / 코리 달았거나 / 코리 반영했을 때 카톡으로 알려주기!! |

<br>

## ⌨️ 코드 컨벤션

| 이름 | 네이밍 규칙 | 예시 |
| :---: | :---: | :--- |
| const val | Screaming Snake Case | `const val MILLIES_VALUE` |
| class | Upper Camel Case | `class MilliesClass` |
| interface | Upper Camel Case | `interface MilliesInterface` |
| dto class | Upper Camel Case | `SignUpRequestDto` |
| variable | Lower Camel Case | `val/var milliesVariable` |
| function | Lower Camel Case, Upper Camel Case | `fun milliesFunction`, `fun BasicMilliesButton` |
| retrofit function | Lower Camel Case | `post[what]`, `get[what]`, `put[what]`, `patch[what]`, `delete[what]` |
| drawable file name | 디자이너 지정 | |

<br>

## 📂 폴더 구조

```
💇🏻‍♀️ com.sopt.meemong
├── MeemongApplication.kt
│
├── 📂 core
│   ├── 📂 base
│   ├── 📂 common
│   │   ├── 📂 extensions
│   │   ├── 📂 navigation
│   │   └── 📂 util
│   ├── 📂 designsystem
│   │   ├── 📂 component
│   │   └── 📂 theme
│   ├── 📂 di
│   ├── 📂 model
│   └── 📂 network
│
├── 📂 data
│   ├── 📂 home
│   ├── 📂 matchingdetail
│   └── 📂 quickmatching
│       ├── 📂 mapper
│       ├── 📂 model
│       ├── 📂 remote
│       │   ├── 📂 datasource
│       │   ├── 📂 dto
│       │   └── 📂 service
│       └── 📂 repository
│
└── 📂 presentation
    ├── 📂 main
    ├── 📂 home
    │   ├── 📂 component
    │   └── 📂 model
    ├── 📂 matchingdetail
    │   └── 📂 component
    └── 📂 quickmatching
        ├── 📂 component
        └── 📂 model
```
