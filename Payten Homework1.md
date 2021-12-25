` `Anıl Ünlü   			

Homewrok 1

Q1 - Pass by value, pass by reference kavramları nedir ? Java’ ile ilişkili olarak açıklayınız.

A1 - Java Pass by value ile çalışır.Pass by value kavramı örnek verilecek olursa bir metoda önceden değeri belirlenen bir parametre pass edilir ve bu işlem sırasında pass edlien aslında orijnal parametrenin bir kopyasıdır yani pass by copy of the bits in the variable diyebiliriz.Bu fonksiyonda gönderilen değer değişirse orijinal property değişmez.

Pass by reference da ise fonksiyona adresi ile birlikte gönderilir.Bu işlem sonrasında gönderilen parametre değişirse orijinal property değeri de değişmiş olur.

Q2- Immutability nedir, neden önemlidir ? Bir Java sınıfı nasıl immutable yapılır ?

A2- Immutable nesneler içeriği bir kez oluşturulduktan sonra değişmeyen nesnelerdir.Değişmez bir nesneyi değiştirmek istersek onu klonlamak veya onu klonlarken deiğiştrimek gerekir.Immutable nesneler multi-threaded ortamlarda ve streamlerde işe yarar.Bir sınıfı thread-safe yapmak istiyorsak immutable yapmalıyız.Immutable nesnelerin değeri değişmeyeceği için üzerinde ne kadar thread çalışırsa çalışsın hep aynı değerler üzerinden işlem yapacaktır.Bir classı immutable yapılbilmesi için

-Sınıfı Final keywordu ile işaretleriz böylece class extend yapılamaz.

-Sınıfın tüm propertylerini private yaparız böylece doğrudan erişime izin vermeyiz.

-Değişkenler için setter methodu koymayız.

-Tüm değiştirilen alanları final yaparız böylece yanlızca bir kere atanabilir.

-Tüm alanlara, constructor aracılığıyla ilk değerlerini atarız.

Q3- Framework ve library arasındaki fark nedir ?

A3- Framework uygulama çatısıdır.Uygulama o çatıda geliştirilir.Library ise çaıtnın altındaki basitleştirlimiş kodlardan,metodlardan oluşan yapılardır.

Q4- Java’da Garbage Collector’ un görevi nedir ?

A4- Oluşturulan nesneler yıkılmalıdır.Memory allocationu yapılmazsa bi noktadan sonra ram de yer kalmayacağı için programlar yanıt vermemeye başlayacaktır.Yazılım dili desteklemediğinde bunu  yazılımcı kod yazarak yapmalı ancak java da bunu destekleyen yapılar vardır o da garbage collectordur.

Q5-Memory leak nedir ? Java’da memory leak oluşması mümkün müdür ?

A5- Memory leak programın kullandığı hafıza ile işi bittiği halde ilgili hafıza bloğunu serbest bırakmaması olayıdır.Java da garbage collector ler heap de kullanılmayan nesneleri bulup siliyor ancak bazı anlarda garbage collectorun da silemiyor.Static alanların fazlaca kullanılması,açılan streamlerin kapatılmaması,session nesnelerinin fazlaca kullanılması, collection nesnelerine insertion yapılması ancak deletion yapılmaması java da memory leake sebep olur.

Q6- Yeni Java sürümleri ne sıklıkla çıkmaktadır ?

A6- Java se 8 2014 de , java se 9 2017 de ve java se 10 2018 de çıkmıştır.2-3 yıl ara ile yeni sürümleri çıkmıştır.

Q7- Stack ve Heap nedir ? Java’da hangi yapılar stack ile, hangi yapılar heap ile ilişkilidir ?

A7- Stack ve heap ramin mantıksal bölümleridir.Stack primitve veri tiplerini saklarken Heap de reference tiplerini saklar.Stack te byte,shor,int,long,float,double,char,boolean veri tipleri saklanırken Hep de array,string,class,interface,enumaration,anotations saklanır.

Q8- OpenJDK ve OracleJDK arasındaki farklar nelerdir ?

A8- Oracle her üç yılda bir yeni sürüm sunarken, Openjdk altı ayda bir yeni sürümünü piyasaya sürer. Oracle, sürümleri için uzun vadeli destek sağlar. Öte yandan, Openjdk, yalnızca bir sonraki sürüm yayınlanana kadar bir sürümdeki değişiklikleri destekler.Oracle yanıt verme ve performans açısından çok daha iyidir.Openjdk sürümleri daha sık çıkmıştır.Performans problemleri karşılaşılabilir.

Q9- @FunctionalInterface anotasyonu nerelerde kullanılabilir, neleri sağlar ?

A9- İçerisinde sadece bir tane abstract method bulunduran ve istediği kadar default method bulunduran interfacelere functional interface denir.Functional interfaceler lambda expressionların kullanılabilmesi için tanımlanırlar.

Q10- Java’da hangi functional interface’ler yer almaktadır ? Yaptığınız araştırmada en popüler/göze çarpanlar hangileridir ?

A10- Predicate,UnaryOperator,BinaryOperator,Supllier,Consumer bulunur.En popülerleri predicatelerdir.
