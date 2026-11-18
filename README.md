# 39-COLLABORATION-ANDROID-MEEMONG
> PLAY SOPT 합동 세미나 모바일앱 3조 ✂️ 미몽 ✂️ Android 레포지토리 🤖
<br>

<img width="1920" height="1080" alt="발표장표" src="https://github.com/user-attachments/assets/ee3f608e-f958-4185-b9b1-cfda1ecc66a0" />

<br>

## 🤖 Android 팀원 소개

| <img src="https://github.com/doorimng.png" width="250"> | <img src="https://github.com/shinhanseo.png" width="250"> | <img src="https://github.com/cowkite12.png" width="250"> |
| :---: | :---: | :---: |
| **Android Lead** | **Android** | **Android** |
| <b>[김예림](https://github.com/doorimng)</b> | <b>[신한서](https://github.com/shinhanseo)</b> | <b>[정소연](https://github.com/cowkite12)</b> |
| `프로젝트 초기 세팅 및 아키텍처 구성`<br>`디자인 시스템 세팅`<br>`내용 상세 UI 구현`<br>`디자이너 프로필·시술 정보·상세 탭·예약 버튼·SNS·이미지 캐러셀 컴포넌트 구현` | `빠른매칭 UI 구현`<br>`공통 탑바·바텀바 구현`<br>`추천 공고·일반 공고 카드 구현`<br>`플로팅 메뉴·더보기 버튼 구현` | `홈 UI 구현`<br>`홈 탑바·퀵메뉴 구현`<br>`디자이너·헤어템·컨설팅 카드 구현`<br>`헤어템 더보기 버튼 구현` |
<br>

## 🎨 리디자인 포인트
| 포인트 | 설명 |
| --- | --- |
| 상단 메뉴 개편 | 미몽의 메인 컬러를 활용해 중요한 메뉴를 정리하고, 기존과 어울리는 아이콘 활용 |
| 브랜드 일관성 강화 | 미몽의 기존 컬러를 포인트와 버튼에 활용해 디자인 통일성 강화 |
| 카드 레이아웃 개선 | 이미지와 공고 정보를 좌우로 재배치해 시각적 균형을 맞추고, 주요 정보를 한눈에 파악할 수 있도록 개선 |
| 컬러 체계 통일 | 강조 정보는 블루, 비용 안내는 그레이, 기타 속성은 그린으로 통일해 시각적 일관성과 정보 구분 강화 |
| 예약 진입 방식 통일 | '예약하기' 탭을 하단 '예약 진행' 버튼으로 변경해 페이지 간 일관성을 높이고 예약 흐름 개선 |
| 포트폴리오 노출 방식 개선 | 포트폴리오를 기본 9개만 노출하고 '더보기' 버튼을 추가하여 스크롤 부담 감소 및 하단 매장 정보 접근성 향상 |
<br>

## 🛠 기술 스택 및 라이브러리

| 구분 | 사용 기술 |
| :---: | :--- |
| Language | Kotlin `2.2.10` |
| UI | Jetpack Compose (BOM `2026.02.01`), Material3 |
| Architecture | MVVM + UiState / UiEffect (`BaseViewModel`) |
| Navigation | Navigation Compose `2.10.2` (Type-safe, Kotlinx Serialization) |
| Lifecycle | Lifecycle ViewModel Compose, `collectAsStateWithLifecycle` `2.11.0` |
| Network | Retrofit `2.11.0`, Gson Converter, OkHttp `4.12.0` (Logging Interceptor) |
| Image | Coil `3.3.0` |
| Build | AGP `9.4.1`, Version Catalog (`libs.versions.toml`) |
| SDK | minSdk `24` / targetSdk `37` |
<br>

## 🤝 Git Convention

### 🏷 태그 컨벤션

| 태그 | 설명 |
| :---: | :--- |
| `feat` | 새로운 기능 구현 시 사용 |
| `mod` | 리뷰 반영 등 기존 코드 수정 시 사용 |
| `fix` | 버그나 오류 해결 시 사용 |
| `refactor` | 기능 변화 없이 코드 구조를 개선할 시 사용 |
| `style` | 코드 스타일 정렬 시 사용 |
| `add` | 아이콘, 이미지 등 에셋 추가 시 사용 |
| `del` | 불필요한 코드나 파일 삭제 시 사용 |
| `docs` | README, KDoc 등 문서 작성 및 수정 시 사용 |
| `chore` | 그 외 자잘한 수정 시 사용 |
| `init` | 프로젝트 초기 세팅 시 사용 |

<br>

### 📝 커밋 컨벤션

`[태그/#이슈번호] 작업 내용`

```
[feat/#45] 홈 뷰모델 클릭 이벤트 및 화면 이동 연결
[mod/#46] spacedBy 수치 변경
[add/#42] 아이콘 및 이미지 추가
[fix/#12] 일반, 추천 공고 카드에 모델료 유형 및 색상 추가
```

develop을 pull 받았을 때는 아래처럼 작성합니다.

```
[MERGE/#이슈번호] pulled develop
```
<br>

### 🌿 브랜치 컨벤션

`태그/#이슈번호-작업-내용`

```
feat/#42-matching-detail-ui
feat/#45-home-ui
feat/#46-quick-matching-ui
```
<br>

### 🔀 Issue · PR 컨벤션

| 구분 | 형식 | 예시 |
| :---: | :--- | :--- |
| Issue | `[Feat] 작업 내용` | `[Feat] 홈 화면 UI 구현` |
| PR | `[Feat/#이슈번호] 작업 내용` | `[Feat/#45] 홈 화면 UI 구현` |
| Merge | `[MERGE] #이슈번호 -> develop` | `[MERGE] #45 -> develop` |

- 작업 전 develop을 pull 받고 진행합니다.
- 다른 브랜치가 develop에 머지되었다면 pull 받고 충돌을 해결한 뒤 리뷰를 재요청합니다.

<br>

## ⌨️ 코드 컨벤션

- [Kotlin 공식 코딩 컨벤션](https://kotlinlang.org/docs/coding-conventions.html)을 따릅니다.
- 화면은 `Contract`(UiState · UiEffect) / `ViewModel` / `Screen`으로 나눕니다.
  - `Route`가 ViewModel의 상태와 이벤트를 받아 `Screen`에 넘기고, `Screen`은 UI만 그립니다.
  - 화면 이동처럼 한 번만 일어나는 일은 `UiEffect`로 보냅니다.
- `UiState`의 기본값은 의미 없는 값(`emptyList()`, `""`, `0`, `null`)으로 두고, 더미 데이터는 `companion object`에 분리합니다.
- 화면에서만 쓰는 데이터 클래스는 각 화면의 `model` 패키지에 둡니다.
- 공통 컴포넌트는 `core/designsystem/component`에, 화면 전용 컴포넌트는 각 화면의 `component` 패키지에 둡니다.

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
