# Macera Oyunu

Sadece Java dili kullanılarak yazılmıştır. Program içerisinde toplam 26 adet sınıf oluşturulmuştur. 26 sınıf içerisinde soyut sınıf olarak tanımlanan 3 adet sınıf bulunmaktadır.

Oyun içerisinde karakterler, canavarlar, silahlar, zırhlar ve bölgeler bulunmaktadır.

3 adet karakter bulunmaktadır. Bu karakterler Samuray, Okçu, Şovalye

| Karakter |ID | Hasar | Sağlık | Para |
| -------- | - | ----- | ------ |----- |
 | Samuray | 1 | 5     | 18 | 20|
|Okçu| 2 | 7 | 18 | 20|
| Şovalye | 3 | 8 | 24 | 5|

4 adet canavar bulunmaktadır.

| Canavar | ID | Hasar | Sağlık | Para         |
|---------|----|-------|--------|--------------|
| Zombi   | 1  | 3     | 10     | 4            |
| Vampir  | 2  | 4     | 14     | 7            |
| Ayı     | 3  | 7     | 20     | 12           |
| Yılan   | 4  | 3-6   | 12     | Eşya Kazanma |

4 adet silah bulunmaktadır.

| Silah  | ID | Hasar | Para |
|--------|----|-------|------|
| Tokmak | 1  | 2     | 15   |
| Kılıç  | 2  | 3     | 35   |
| Ok     | 3  | 7     | 45   |
| Mızrak | 4  | 10    | 60   |

3 adet zırh bulunmaktadır.

| Zırh  | ID | Engelleme | Para |
|-------|----|-----------|------|
| Hafif | 1  | 1         | 15   |
| Orta  | 2  | 3         | 25   |
| Ağır  | 3  | 5         | 45   |

3 adet ilaç bulunmaktadır.

| İlaç    | ID | Hasar | Para |
|---------|----|-------|------|
| Ucuz    | 1  | 5     | 2    |
| Orta    | 2  | 10    | 5    |
| Pahallı | 3  | 20    | 10   |

7 adet bölge bulunmaktadır.

| Bölgeler   | ID | Canavar | Eşya              |
|------------|----|---------|-------------------|
| Güvenli Ev | 1  | -       | -                 |
| Silahçı    | 2  | -       | -                 |
| Eczacı     | 3  | -       | -                 |
| Mağara     | 4  | Zombi   | Yemek             |
| Orman      | 5  | Vampir  | Odun              |
| Nehir      | 6  | Ayı     | Su                |
| Maden      | 7  | Yılan   | Para, Silah, Zırh |
