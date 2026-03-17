# Technical Test Web Automation - Studi Kasus: Automation Test Store

Framework ini dibuat dengan Java + Selenium + JUnit 5 dengan arsitektur Page Object Model agar maintainable, scalable, dan reusable.

## Stack
- Java 21
- Maven
- Selenium 4
- JUnit 5
- AssertJ
- Allure Reporting

## Struktur
- `src/main/java/com/automationteststore/base` : base class untuk page
- `src/main/java/com/automationteststore/core` : config, driver, wait utilities
- `src/main/java/com/automationteststore/components` : reusable UI components
- `src/main/java/com/automationteststore/pages` : Page Objects
- `src/test/java/com/automationteststore/base` : base setup test
- `src/test/java/com/automationteststore/tests` : test suite
- `src/test/java/com/automationteststore/suites` : JUnit Platform Suite runner (SmokeSuite, RegressionSuite)
- `src/test/java/com/automationteststore/support` : test support (screenshot on failure)
- `src/test/java/com/automationteststore/testdata` : JSON loader + data factory
- `src/test/resources/testdata` : dataset JSON

## Menjalankan test
```bash
mvn clean test
```

## Menjalankan test by tag
```bash
mvn clean test -Dgroups=smoke
mvn clean test -Dgroups=regression
```

## Menjalankan test via Suite file
Suite file (`SmokeSuite`, `RegressionSuite`) adalah runner berbasis JUnit Platform Suite —
setara dengan `testng.xml` — yang mengumpulkan dan menjalankan test berdasarkan tag secara terpusat.

```bash
# Jalankan Smoke Suite + generate report
mvn clean test -Psmoke-suite
mvn allure:report

# Jalankan Regression Suite + generate report
mvn clean test -Pregression-suite
mvn allure:report
```

Lokasi suite file:
- `src/test/java/com/automationteststore/suites/SmokeSuite.java`
- `src/test/java/com/automationteststore/suites/RegressionSuite.java`

## Matrix test saat ini
- Smoke: 3 scenario
- Regression: 7 scenario

Komposisi saat ini:
- `HomePageTest`: 2 smoke
- `NavigationTest`: 1 smoke + 1 regression
- `SearchTest` (JSON parameterized): 6 regression

## Override runtime config
```bash
mvn clean test -Dbrowser=firefox -Dheadless=false -Dtimeout.seconds=20
```

## Generate Allure report
```bash
mvn allure:report
```

Lalu buka report pada:
- `target/site/allure-maven-plugin/index.html`

Label report yang dipakai:
- `feature`: Home, Account Navigation, Search
- `story`: objective tiap test method
- `scenario` + `keyword` (khusus Search): ringkasan tiap data-driven case

## Catatan desain
- `DriverManager` memakai `ThreadLocal` agar aman untuk parallel execution.
- Tidak menggunakan implicit wait untuk mengurangi flaky test.
- Screenshot otomatis di-attach ke Allure saat test gagal.
- Locator dan aksi UI dipisahkan ke Page Object/Component.
- Warning CDP Selenium untuk versi Chrome yang belum dipetakan disuppress di runtime test melalui `src/test/resources/logging.properties`.

