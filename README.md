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
