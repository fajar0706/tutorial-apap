# Tutorial APAP
## Authors
* **Fajar Anugerah Subekti** - *1806146940* - *APAP - A*

---
## Tutorial 1
### What I have learned today

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Jawab: Issue Tracker merupakan salah satu fitur yang dimiliki github untuk melakukan pelacakan masalah yang terjadi dalam suatu konten/project/task yang sedang dikembangkan. Masalah yang dapat terselesaikan dengan issue tracker,antara lain: 
   a. Kita dapat mengetahui pembagian tugas yang diberikan kepada masing - masing individu dengan memasukannya pada Assignees.
   b. Dapat mengetahui konten apa yang sedang dilakukan oleh masing - masing individu.
   c. Dapat memberikan feedback kepada individu yang bertanggung jawab atas task tersebut sehingga masing - masing individu dapat melakukan review kembali terkait task yang dikerjakannya.
   d. Dapat menyelesaikan masalah - masalah yang ada pada konten/task yang dibuat.
2. Apa perbedaan dari git merge dan git merge --squash?
   Jawab: Merge menggunakan git merge membuat semua history commit yang ada pada source branch akan digabungkan menjadi satu pada history commit target branch. Sedangkan, git merge --squash menyatukan semua history commit pada source branch kemudian digabungkan dengan target branch. 
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
   Jawab: Version Control System adalah sebuah sistem yang merekam perubahan-perubahan berkas atau sekumpulan berkas yang sedang dikerjakan atau sudah dikerjakan. Pada pengembangan aplikasi version control system ini dapat memudahkan kita dalam melakukan pembagian task dan masing - masing development dapat melakukan pengerjaan task tanpa mengganggu task development lainnya, serta mempermudah dalam melakukan tracking terhadap error yang terjadi sehingga development dapat dengan mudah menyelesaikan error tersebut.
### Spring
4. Apa itu library & dependency?
   Jawab: Library: Sekumpulan program atau fungsi yang telah ada pada compiler atau interpreter untuk memudahkan seorang programmer dalam membuat suatu program. Dependency: Pembuatan suatu program oleh seorang programmer dimana code/module yang akan dijalankan bergantung pada code/module lainnya.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Jawab: Maven adalah sebuah tools yang menggunakan konsep Project Object Model (POM) dalam penggunaannya Maven dapat memudahkan kita dalam memanage dependency serta Maven ini dapat membuat struktur project sendiri sehingga project tersebut akan dapat dibuka dengan IDE. Alternatif dari Maven, yaitu Bower, Gradle, Terraform, CMake dll.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
   Jawab: Spring Framework dapat digunakan untuk pengembangan aplikasi enterprise perusahaan, seperti:  
   a. Melakukan connection dan manipulasi DataBase
   b. REST API: API merupakan bagian yang sangat penting dalam bisnis dan Spring menyediakan Sping MVC untuk Traditional Servlet style dan Spring Webflux untuk performance para penulis ahli Reactive API.
   c. Caching: Dapat melakukan boost performance.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
   Jawab: @RequestParam digunakan untuk mengekstrak nilai dari parameter query yang diminta. Sedangkan, @PathVariable digunakan untuk mengekstrak data langsung dari URI. @RequestParam lebih digunakan pada aplikasi web tradisional dimana data sebagian besar diteruskan dalam parameter kueri, sedangkan @PathVariable lebih cocok untuk layanan web Restfull dimana URL akan berisikan nilai yang di assign.


Sumber: 
- https://qastack.id/programming/13715811/requestparam-vs-pathvariable
- https://mindmajix.com/12-open-source-devops-build-tools
- https://komputernsc.wordpress.com/2013/07/05/pengenalan-pustaka-library-pada-bahasa-pemrograman/#:~:text=Pustaka%20atau%20Library%20adalah%20kumpulan,langsung%20sistem%20komputer%20untuk%20memprogram.
- https://git-scm.com/book/id/v2/Memulai-Tentang-Version-Control

### What I did not understand
- [ ] Skema atau *flow* dari jalannya program spring boot.

--
## Tutorial 2
### What I have learned today

### Pertanyaan 
1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
   http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
   &noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
   **Jawab:** Terdapat tampilan error "Whitelabel Error Page" error ini terjadi karena template yang di return 
   pada package controller yang mengembalikan "add-hotel" dimana template tersebut belum dibuat.
2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? 
   Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
   **Jawab:** Menurut saya anotasi @Autowired merupakan implementasi dari konsep Dependency Injection 
   dimana pada class HotelController bergantung dengan interface HotelService. Lalu class HotelInMemoryService
   mengimplementasikan interface HotelService. Sehingga HotelController dapat digunakan pada properti HotelService
   di class HotelController. Kemudian pada properti HotelService terdapat anotation @Autowired digunakan untuk menginjeksi
   bean class HotelController.
3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
   http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
   Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?
   **Jawab:** Terdapat tampilan error "Whitelabel Error Page" error ini terjadi karena 
   pada link yang tertera tersebut memiliki parameter yang kurang yaitu, noTelepon. 
   Dimana pada Controller yang mengembalikan add-hotel yaitu pada link /hotel/add memerlukan
   parameter "noTelepon" dengan sifat "required = true" yang berarti harus ada parameternya. 
   Sehingga Jika link yang diberikan tidak ada parameter yang sesuai maka akan terjadi error.
4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?
   **Jawab:** Dengan asumsi bahwa Papa APAP hanya mengetahui idHotel saja kemudian Papa APAP dapat mengakses 
   link http://localhost:8080/hotel/view?idHotel={idhotel} nanti akan keluar tampilan yang menampilkan 
   data mengenai idHotel yang dicari.
5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall , 
   apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
   **Jawab:** Tampilan yang dikeluarkan adalah semua daftar hotel yang ditambahkan, berikut 
   screenshoot dari tampilannya https://ibb.co/9YQqdYk
