# StudentManager

**StudentManager** adalah aplikasi Android sederhana berbasis **Jetpack Compose** untuk mengelola data mahasiswa (pencatatan, pembaruan, pencarian, dan penghapusan data mahasiswa) dengan menyimpan data secara lokal menggunakan **Room Database**.

[Demo Video](https://drive.google.com/file/d/1KGSuStHuKktqJl1F1v4Tsh2vD-k0cnFi/view?usp=sharing)

---

## 🚀 Fitur Utama

- **Halaman Utama (HomeScreen)**:
  - **Daftar Mahasiswa**: Menampilkan seluruh data mahasiswa yang tersimpan di database lokal beserta jumlah total mahasiswa.
  - **Pencarian Realtime**: Memfilter daftar mahasiswa berdasarkan **Nama**, **NIM**, atau **Program Studi**.
  - **Konfirmasi Hapus**: Dialog konfirmasi (`AlertDialog`) sebelum menghapus data mahasiswa.
  - **Navigasi Mudah**: Menggunakan *Floating Action Button* (FAB) untuk menambah mahasiswa baru dan tombol edit pada setiap item mahasiswa.

- **Halaman Form (UpsertStudentScreen)**:
  - **Tambah & Edit (Upsert)**: Form dinamis untuk menambah data baru atau memperbarui data mahasiswa yang sudah ada.
  - **Pilihan Program Studi**: Dropdown kustom (`ProdiDropDown`) untuk memilih program studi.
  - **Validasi & Tombol Batal**: Tombol Simpan untuk menyimpan/memperbarui data dan tombol Batal untuk kembali ke halaman utama.

---

## 🛠️ Teknologi & Library yang Digunakan

- **Bahasa Pemrograman**: Kotlin
- **UI Framework**: Jetpack Compose & Material 3
- **Arsitektur**: MVVM (Model-View-ViewModel)
- **Database Lokal**: Room Database (`androidx.room`) dengan KSP compiler
- **Dependency Injection**: Koin (`koin-android`, `koin-androidx-compose`)
- **Navigasi**: Navigation Compose dengan Type-Safe Routing (`kotlinx-serialization`)
- **Asinkronus & State**: Kotlin Coroutines & `StateFlow`

---

## 📁 Struktur Proyek

```
com.itsrobocon.studentmanager
├── data/
│   ├── Student.kt             # Data class Entity Room (nim, name, department)
│   ├── StudentDao.kt          # Interface DAO untuk operasi CRUD Room
│   └── StudentDatabase.kt     # Kelas abstrak RoomDatabase
├── di/
│   └── AppModule.kt           # Koin Module (Database, DAO, ViewModel)
├── nav/
│   └── Screens.kt             # Definisi rute navigasi aplikasi
├── ui/
│   ├── component/
│   │   ├── GraduationCap.kt   # Komponen visual / ikon
│   │   ├── ProdiDropDown.kt   # Dropdown pilihan program studi
│   │   ├── StudentItem.kt     # Item kartu mahasiswa di daftar
│   │   └── StudentTopBar.kt   # Top App Bar aplikasi
│   ├── screen/
│   │   ├── HomeScreen.kt          # Halaman utama & pencarian
│   │   ├── SplashScreen.kt        # Halaman splash screen
│   │   └── UpsertStudentScreen.kt # Halaman tambah/edit mahasiswa
│   └── viewmodel/
│       └── StudentViewModel.kt    # ViewModel pengelola state & logika bisnis
├── MainActivity.kt               # Entry point & NavHost
└── StudentApplication.kt         # Application class untuk inisialisasi Koin
```

---

## 📝 Struktur Data Student

| Field | Tipe Data | Deskripsi |
|---|---|---|
| `nim` | `String` | Nomor Induk Mahasiswa (**Primary Key**) |
| `name` | `String` | Nama Lengkap Mahasiswa |
| `department` | `String` | Program Studi / Jurusan |

---

## 📖 Cara Menjalankan Aplikasi

1. Buka proyek ini menggunakan **Android Studio** (Disarankan versi terbaru).
2. Lakukan Gradle Sync (`File -> Sync Project with Gradle Files`).
3. Hubungkan perangkat Android (fisik atau Emulator).
4. Jalankan aplikasi dengan menekan tombol **Run** (`Shift + F10`).
