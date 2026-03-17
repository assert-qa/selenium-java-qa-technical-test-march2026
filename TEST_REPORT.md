# Laporan Hasil Pengujian Otomasi — Automation Test Store

---

## Informasi Eksekusi

| Item | Detail |
|---|---|
| **Tanggal Eksekusi** | 17 Maret 2026 |
| **Waktu Mulai** | 18:08:25 WIB |
| **Total Durasi** | ± 30.8 detik |
| **URL Target** | https://automationteststore.com |
| **Browser** | Google Chrome (Headless) |
| **Versi Chrome** | 145.0.7632.160 |
| **Selenium** | 4.31.0 |
| **Java** | 21.0.2 (Oracle JDK) |
| **OS** | Windows 11 (amd64) |
| **Timezone** | Asia/Jakarta (WIB) |
| **Dijalankan oleh** | Mahendra |

---

## Ringkasan Hasil

| Metrik | Nilai |
|---|---|
| ✅ **Total Test Dijalankan** | **10** |
| ✅ **Passed** | **10** |
| ❌ **Failed** | **0** |
| 💥 **Error** | **0** |
| ⏭️ **Skipped** | **0** |
| 📊 **Pass Rate** | **100%** |

> **Kesimpulan: SEMUA TEST BERHASIL (GREEN BUILD)**

---

## Detail Hasil per Test Case

### 🔵 Feature: Home Page

| No | Test Case | Suite | Tag | Status | Durasi |
|---|---|---|---|---|---|
| TC-01 | Home page can be opened successfully | Smoke | `smoke` | ✅ PASS | 12.37 s |
| TC-02 | Home page uses HTTPS and has non-empty title | Smoke | `smoke` | ✅ PASS | 9.61 s |

#### Deskripsi Skenario

**TC-01 — Home page can be opened successfully**
- **Story:** Open storefront home page
- **Langkah:**
  1. Buka URL `https://automationteststore.com`
  2. Ambil URL halaman saat ini dan title halaman
- **Assertions:**
  - URL mengandung `automationteststore.com` ✅
  - Title mengandung kata `automation` (case-insensitive) ✅
- **Hasil:** PASS

---

**TC-02 — Home page uses HTTPS and has non-empty title**
- **Story:** Home page enforces secure protocol
- **Langkah:**
  1. Buka URL `https://automationteststore.com`
  2. Ambil URL dan title halaman
- **Assertions:**
  - URL dimulai dengan `https://` ✅
  - Title tidak kosong / blank ✅
- **Hasil:** PASS

---

### 🟡 Feature: Account Navigation

| No | Test Case | Suite | Tag | Status | Durasi |
|---|---|---|---|---|---|
| TC-03 | User can navigate to login page | Smoke | `smoke` | ✅ PASS | 5.31 s |
| TC-04 | User can navigate to account registration page | Regression | `regression` | ✅ PASS | 6.62 s |

#### Deskripsi Skenario

**TC-03 — User can navigate to login page**
- **Story:** Navigate to login page
- **Langkah:**
  1. Buka URL login page melalui `LoginPage.open(baseUrl)`
  2. Ambil URL halaman saat ini
- **Assertions:**
  - URL mengandung `account/login` ✅
- **Hasil:** PASS

---

**TC-04 — User can navigate to account registration page**
- **Story:** Navigate to registration page
- **Langkah:**
  1. Navigasi langsung ke `https://automationteststore.com/index.php?rt=account/create`
  2. Ambil URL dan title halaman
- **Assertions:**
  - URL mengandung `account/create` ✅
  - Title halaman tidak kosong / blank ✅
- **Hasil:** PASS

---

### 🟢 Feature: Search (Data-Driven)

| No | Test Case | Suite | Keyword | Tag | Status | Durasi |
|---|---|---|---|---|---|---|
| TC-05 | broad keyword keeps product flow | Regression | `a` | `regression` | ✅ PASS | 7.43 s |
| TC-06 | common product keyword works | Regression | `cream` | `regression` | ✅ PASS | 5.96 s |
| TC-07 | skincare keyword opens product route | Regression | `skincare` | `regression` | ✅ PASS | 10.07 s |
| TC-08 | makeup keyword opens product route | Regression | `makeup` | `regression` | ✅ PASS | 9.97 s |
| TC-09 | fragrance keyword opens product route | Regression | `fragrance` | `regression` | ✅ PASS | 10.57 s |
| TC-10 | letter s keyword opens product route | Regression | `s` | `regression` | ✅ PASS | 11.25 s |

#### Deskripsi Skenario

**TC-05 s/d TC-10 — Search product by keyword** *(Parameterized dari `search-cases.json`)*

- **Story:** Search product by keyword
- **Metode Pengujian:** `@ParameterizedTest` — 6 dataset dari file `testdata/search/search-cases.json`
- **Langkah (berlaku untuk semua kasus):**
  1. Buka halaman pencarian dengan keyword yang telah ditentukan via `SearchResultsPage.openWithKeyword(baseUrl, keyword)`
  2. Ambil URL halaman hasil pencarian
  3. Ambil teks breadcrumb
- **Assertions (berlaku untuk semua kasus):**
  - URL hasil pencarian mengandung `rt=product` ✅
  - Teks breadcrumb tidak kosong / blank ✅
- **Dataset digunakan:**

  | # | Nama Kasus | Keyword | Expected URL Contains |
  |---|---|---|---|
  | [1] | broad keyword keeps product flow | `a` | `rt=product` |
  | [2] | common product keyword works | `cream` | `rt=product` |
  | [3] | skincare keyword opens product route | `skincare` | `rt=product` |
  | [4] | makeup keyword opens product route | `makeup` | `rt=product` |
  | [5] | fragrance keyword opens product route | `fragrance` | `rt=product` |
  | [6] | letter s keyword opens product route | `s` | `rt=product` |

---

## Rekap per Suite

### 🔵 Smoke Suite (3 Test Case)

| No | Test Case | Status |
|---|---|---|
| TC-01 | Home page can be opened successfully | ✅ PASS |
| TC-02 | Home page uses HTTPS and has non-empty title | ✅ PASS |
| TC-03 | User can navigate to login page | ✅ PASS |

**Smoke Result: 3/3 PASS (100%)**

---

### 🟢 Regression Suite (7 Test Case)

| No | Test Case | Status |
|---|---|---|
| TC-04 | User can navigate to account registration page | ✅ PASS |
| TC-05 | broad keyword keeps product flow | ✅ PASS |
| TC-06 | common product keyword works | ✅ PASS |
| TC-07 | skincare keyword opens product route | ✅ PASS |
| TC-08 | makeup keyword opens product route | ✅ PASS |
| TC-09 | fragrance keyword opens product route | ✅ PASS |
| TC-10 | letter s keyword opens product route | ✅ PASS |

**Regression Result: 7/7 PASS (100%)**

---

## Rekap per Class

| Test Class | Tests | Passed | Failed | Error | Skip | Durasi |
|---|---|---|---|---|---|---|
| `HomePageTest` | 2 | 2 | 0 | 0 | 0 | 21.97 s |
| `NavigationTest` | 2 | 2 | 0 | 0 | 0 | 11.93 s |
| `SearchTest` | 6 | 6 | 0 | 0 | 0 | 55.27 s* |
| **TOTAL** | **10** | **10** | **0** | **0** | **0** | **≈ 30.8 s (wall)** |

> *Durasi SearchTest adalah total kumulatif per-testcase. Eksekusi berjalan secara paralel antar kelas.

---

## Distribusi Durasi Test

```
TC-01  shouldOpenHomePage                         ████████████ 12.37s
TC-02  shouldUseHttpsOnHomePage                   ██████████   9.61s
TC-03  shouldNavigateToLoginPage                  █████        5.31s
TC-04  shouldNavigateToRegisterPage               ██████       6.62s
TC-05  search: "a"                                ███████      7.43s
TC-06  search: "cream"                            ██████       5.96s
TC-07  search: "skincare"                         ██████████   10.07s
TC-08  search: "makeup"                           █████████    9.97s
TC-09  search: "fragrance"                        ██████████   10.57s
TC-10  search: "s"                                ███████████  11.25s
```

> Test terlama: **TC-01** (12.37s) — Pembukaan halaman utama pertama kali (termasuk startup browser).
> Test tercepat: **TC-03** (5.31s) — Navigasi ke halaman login.

---

## Catatan Teknis

### ⚠️ Warning CDP (Non-Critical)
Selama eksekusi ditemukan warning berikut pada console:
```
WARNING: Unable to find CDP implementation matching 145
WARNING: Unable to find version of CDP to use for 145.0.7632.160.
```
**Analisa:** Warning ini disebabkan oleh perbedaan versi CDP antara Chrome 145 dengan versi
Selenium 4.31.0 yang belum memiliki implementasi CDP untuk Chrome 145 secara resmi.
**Dampak:** **Tidak ada.** Semua test berjalan normal. Warning hanya bersifat informasional.
**Mitigasi yang sudah dilakukan:** Warning sudah di-suppress via `src/test/resources/logging.properties`.

---

### Konfigurasi yang Digunakan
```properties
baseUrl          = https://automationteststore.com
browser          = chrome
headless         = true
timeout.seconds  = 15
```

---

## Cara Membuka Allure Report Interaktif

```bash
# Generate report dari hasil test yang sudah ada
mvn allure:report

# Buka di browser
start target\site\allure-maven-plugin\index.html

# Atau serve langsung
mvn allure:serve
```

Report Allure menyediakan tampilan interaktif dengan:
- Filter berdasarkan Feature / Story / Tag
- Timeline eksekusi test
- Detail setiap step
- Attachment screenshot (otomatis saat test gagal)
- Environment info (browser, OS, URL target)
- Kategorisasi: Passed / Product Defects / Test Defects / Broken

---

## Kesimpulan & Rekomendasi

### ✅ Kesimpulan
Seluruh 10 test case berhasil dieksekusi dan lulus (PASS) tanpa ada kegagalan, error, maupun skip.
Aplikasi **https://automationteststore.com** berperilaku sesuai ekspektasi untuk semua skenario yang diuji.

### 📋 Cakupan Pengujian

| Area | Status |
|---|---|
| Halaman utama dapat dibuka | ✅ Diverifikasi |
| Halaman menggunakan protokol HTTPS | ✅ Diverifikasi |
| Title halaman utama berisi kata kunci yang benar | ✅ Diverifikasi |
| Navigasi ke halaman login berfungsi | ✅ Diverifikasi |
| Navigasi ke halaman registrasi berfungsi | ✅ Diverifikasi |
| Fitur pencarian produk dengan berbagai keyword | ✅ Diverifikasi (6 dataset) |
| Breadcrumb pada halaman hasil pencarian muncul | ✅ Diverifikasi |
| URL hasil pencarian mengandung parameter produk | ✅ Diverifikasi |
---