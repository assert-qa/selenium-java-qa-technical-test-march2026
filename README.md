# Technical Test Web Automation — Studi Kasus: Automation Test Store

Dibangun dengan **Java + Selenium + JUnit 5** menggunakan arsitektur **Page Object Model (POM)** agar maintainable, scalable, dan reusable.

---

## Tech Stack

| Komponen | Library / Tools | Versi |
|---|---|---|
| Bahasa | Java | 21 |
| Build Tool | Maven | 3.x |
| Browser Automation | Selenium WebDriver | 4.31.0 |
| Test Runner | JUnit 5 (Jupiter) | 5.12.2 |
| Assertions | AssertJ | 3.27.3 |
| Reporting | Allure | 2.29.1 |
| JSON Parsing | Jackson Databind | 2.18.3 |
| Logging | SLF4J Simple | 2.0.17 |

---

## Prasyarat

Pastikan tools berikut sudah terinstall dan tersedia di `PATH`:

- **Java 21** → [https://adoptium.net](https://adoptium.net)
- **Maven 3.8+** → [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
- **Google Chrome** (versi terbaru disarankan)
- **Git** → [https://git-scm.com](https://git-scm.com)

Verifikasi instalasi:
```bash
java -version
mvn -version
git --version
```

---

## Clone Project

```bash
# 1. Clone repository
git clone https://github.com/assert-qa/automationteststore-framework.git

# 2. Masuk ke direktori project
cd automationteststore-framework

# 3. Install dependencies (tanpa menjalankan test)
mvn clean install -DskipTests
```

---

## Menjalankan Test

### Jalankan semua test
```bash
mvn clean test
```

### Jalankan hanya test **Smoke** (via tag)
```bash
mvn clean test -Dgroups=smoke
```

### Jalankan hanya test **Regression** (via tag)
```bash
mvn clean test -Dgroups=regression
```

### Jalankan via **Suite file** (JUnit Platform Suite)
```bash
# Smoke Suite
mvn clean test -Psmoke-suite

# Regression Suite
mvn clean test -Pregression-suite
```

### Jalankan dengan konfigurasi custom (browser, headless, timeout)
```bash
# Ganti browser ke Firefox, matikan headless, timeout 20 detik
mvn clean test -Dbrowser=firefox -Dheadless=false -Dtimeout.seconds=20

# Headless Chrome (default)
mvn clean test -Dbrowser=chrome -Dheadless=true
```

### Jalankan test spesifik (satu class)
```bash
mvn clean test -Dtest=HomePageTest
mvn clean test -Dtest=SearchTest
mvn clean test -Dtest=NavigationTest
```

---

## Generate & Buka Allure Report

```bash
# 1. Generate report HTML dari hasil test
mvn allure:report

# 2. Buka report (Windows)
start target\site\allure-maven-plugin\index.html

# Atau serve secara live di browser
mvn allure:serve
```

Report tersedia di: `target/site/allure-maven-plugin/index.html`

---

## Matrix Test (Smoke vs Regression)

| Test Class | Test Method | Tag |
|---|---|---|
| `HomePageTest` | `homepageTitleIsCorrect` | smoke |
| `HomePageTest` | `homepageBannerIsVisible` | smoke |
| `NavigationTest` | `loginPageIsAccessible` | smoke |
| `NavigationTest` | `cartPageIsAccessible` | regression |
| `SearchTest` | `searchWithKeyword[*]` (6 kasus data-driven) | regression |

**Total: 3 smoke · 7 regression · 10 test case**

---

## Konfigurasi Runtime

Default config ada di `src/main/resources/config.properties`:

| Property | Default | Deskripsi |
|---|---|---|
| `baseUrl` | `https://automationteststore.com` | URL target aplikasi |
| `browser` | `chrome` | Browser yang digunakan (`chrome` / `firefox`) |
| `headless` | `true` | Mode headless browser |
| `timeout.seconds` | `15` | Explicit wait timeout (detik) |

Semua config dapat di-override melalui parameter `-D` saat menjalankan Maven.

---

## Struktur Project

```
automationteststore-framework/
│
├── pom.xml                                          # Konfigurasi Maven: dependencies, plugins, profiles
├── README.md                                        # Dokumentasi project (file ini)
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automationteststore/
│   │   │       │
│   │   │       ├── base/
│   │   │       │   └── BasePage.java               # Kelas induk semua Page Object; menyimpan driver & WaitHelper
│   │   │       │
│   │   │       ├── components/
│   │   │       │   └── TopNavComponent.java         # Komponen navigasi atas (search bar, menu kategori)
│   │   │       │
│   │   │       ├── core/
│   │   │       │   ├── config/
│   │   │       │   │   └── ConfigManager.java       # Membaca config.properties + system properties (-D flags)
│   │   │       │   ├── driver/
│   │   │       │   │   ├── DriverFactory.java       # Membuat instance WebDriver (Chrome/Firefox + headless)
│   │   │       │   │   └── DriverManager.java       # ThreadLocal driver holder; aman untuk parallel execution
│   │   │       │   └── wait/
│   │   │       │       └── WaitHelper.java          # Explicit wait utilities (clickable, visible, dll.)
│   │   │       │
│   │   │       └── pages/
│   │   │           ├── HomePage.java                # Page Object: halaman utama (title, banner, navigasi)
│   │   │           ├── LoginPage.java               # Page Object: halaman login
│   │   │           └── SearchResultsPage.java       # Page Object: halaman hasil pencarian produk
│   │   │
│   │   └── resources/
│   │       └── config.properties                    # Konfigurasi default (baseUrl, browser, headless, timeout)
│   │
│   └── test/
│       ├── java/
│       │   └── com/automationteststore/
│       │       │
│       │       ├── base/
│       │       │   └── BaseTest.java                # Setup & teardown JUnit 5; membuka/menutup browser per test
│       │       │
│       │       ├── suites/
│       │       │   ├── SmokeSuite.java              # JUnit Platform Suite runner untuk tag "smoke"
│       │       │   └── RegressionSuite.java         # JUnit Platform Suite runner untuk tag "regression"
│       │       │
│       │       ├── support/
│       │       │   ├── AllureAttachmentHelper.java  # Utility attach screenshot/log ke Allure report
│       │       │   ├── AllureEnvironmentExtension.java # JUnit Extension: tulis environment.properties Allure
│       │       │   └── FailureWatcher.java          # JUnit Extension: auto-screenshot saat test gagal
│       │       │
│       │       ├── testdata/
│       │       │   ├── JsonTestDataLoader.java      # Membaca file JSON dari classpath menggunakan Jackson
│       │       │   ├── SearchCase.java              # POJO model data untuk satu kasus pencarian
│       │       │   └── SearchTestDataFactory.java   # Factory: memuat search-cases.json → List<Arguments>
│       │       │
│       │       └── tests/
│       │           ├── HomePageTest.java            # [smoke] Verifikasi title & banner halaman utama
│       │           ├── NavigationTest.java          # [smoke+regression] Verifikasi navigasi halaman
│       │           └── SearchTest.java              # [regression] Data-driven search test via JSON
│       │
│       └── resources/
│           ├── allure/
│           │   └── categories.json                  # Definisi kategori custom Allure (Failed, Broken, dll.)
│           ├── testdata/
│           │   └── search/
│           │       └── search-cases.json            # Dataset JSON untuk parameterized SearchTest
│           ├── allure.properties                    # Konfigurasi Allure (allure.results.directory)
│           ├── junit-platform.properties            # Konfigurasi JUnit Platform (parallel, dll.)
│           └── logging.properties                   # Suppress CDP warning dari Selenium di console log
│
└── target/
    ├── allure-results/                              # Raw JSON hasil test — input untuk allure:report
    ├── site/
    │   └── allure-maven-plugin/
    │       └── index.html                           # Allure HTML report (buka setelah mvn allure:report)
    └── surefire-reports/                            # Laporan XML/TXT dari Maven Surefire
```

---

## Allure Report — Label & Kategorisasi

Setiap test dilabeli dengan:

| Label | Deskripsi |
|---|---|
| `@Epic` | Modul besar (contoh: "Store") |
| `@Feature` | Fitur yang diuji (contoh: "Home", "Search", "Navigation") |
| `@Story` | Objective test method yang spesifik |
| `@Severity` | Tingkat keparahan (`BLOCKER`, `CRITICAL`, `NORMAL`, `MINOR`) |

Kategori hasil di report:
- ✅ **Passed** — test berhasil
- ❌ **Product Defects** — assertion gagal (`AssertionError`)
- 🔧 **Test Defects** — error teknis (NPE, timeout, dll.)
- ⚠️ **Broken Tests** — exception lain yang tidak diantisipasi

---

## Tips & Troubleshooting

| Masalah | Solusi |
|---|---|
| Warning CDP Chrome (Selenium vs Chrome version mismatch) | Warning ini aman dan sudah disuppress via `logging.properties`. Tidak mempengaruhi eksekusi test. |
| Test timeout / flaky | Naikkan `timeout.seconds`: `mvn test -Dtimeout.seconds=25` |
| Browser tidak ditemukan | Pastikan Chrome/Firefox terinstall. WebDriverManager otomatis mengunduh driver yang sesuai. |
| Report tidak muncul | Jalankan `mvn allure:report` setelah test selesai, bukan sebelum. |
| Port Allure serve sudah terpakai | Ganti port: `mvn allure:serve -Dallure.serve.port=8081` |
