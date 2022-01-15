Q1-Imperative Programming ve Declarative Programming kavramlarını kısaca açıklayıp farklarını belirtiniz.

A1-Declarative programlama kontrol akışını tanımlamadan bir hesaplamanın mantığını ifade eden bir programlama paradigmasıdır.Programın Neyi başarması gerektiğine odaklanır.Daha az esneklik sağlar.Programı basitleştirir.Functional,Logic,Query programlama declarative programlama içerisindedir.

İmperative programlama programın durumunu değiştiren ifadeleri kullanan bir programlama paradigmasıdır.Programın nasıl sonuca ulşamasını gerektiğini odaklanır.Daha fazla esneklik sağlar.Programın karmaşıklığını artırabilir.Procedural ve oop imperative programlama içerisindedir.

Q2-Veri tabanlarının sorgu optimizasyonlarında index oluşturmanın avantajı nedir ? Sık index kullanmak bir probleme yol açar mı?

A2-Bir sorguda where clauseu ile eşleşen rowları bulmak için,rowları değerlendirmeden çıkartmak için,joins bir sorgunun parçası olduğunda ve aranan columnların benzer tür ve boyutta olduğu diğer tablelardan rowları almak için,bir column min ve max değerlerini bulmak için,sonuçları sıralamak veya gruplamak için,table da doğrudan arama yapmak yerine sonuçları indexin kendisinden döndürmek için kullanılır.Ancak indexler,select sorgularında veri almak ve bulmak için gereken süreyi hızlandırmalar da iyi olsalar da,tablo değiştiğinde mysqlin verileri yeniden indexe eklemesi gerektiğinden,sorguları update,insert veya delete olarak yavaşlatabilirler.Verileri okumaktan daha sık değiştirilen tablelar varsa,daha hızlı arama amacıyla indexleri kullanmak istenmeyebilir.

Q3-İlişkisel veritabanları için normalizasyon kavramı neyi ifade etmektedir ? İlk 3 normal formu örnek üzerinden açıklayınız.

A3-Normalizasyon veri tabanındaki verileri düzenleme işlemidir.Veri fazlalığını azaltan ve Crud işlemleri gibi istenmeyen özellikleri ortadan kaldıran bir veritabanı tasarım tekniğidir.Bir relationdan veya set of relationsdan fazlalığı en aza indirmek için kullanılır. Daha büyük tabloyu daha küçük tabloya böler ve bunları ilişki kullanarak birbirine bağlar.Veritabanı tablosundaki fazlalığı azaltmak için kullanılır.4 form vardır.Bunlar 1NF,2NF,3NF ve BCNF dir.1NF kuralına göre bir tableın bir columnu birden fazla değer tutamaz.Her kayıt unique olmalıdır.2NF kuralı 1NF kuralının conditionlarını sağlamalı ve partial dependencysi olmamalıdır.3NF kuralı ise 2NF kuralının conditionlarını sağlamalıdır ve transitive dependencysi yoktur.

Q4-ORM kütüphaneleri kullanmak her zaman avantajlı mıdır ? ORM kütüphanelerinin ne gibi dezavantajları olabilir ?

A4-Database bağımsızdır.Databasee özel kod yazmaya gerek yoktur.Sql sorguları yazmaya gerek yoktur.Tablelar arasındaki dependecylerle ilgilenir ve sorguları birleştirir.Bazı orm libraryleri cacheleme desteğine sahiptir.Transaction commit ve roll back lerini ayarlar.Database connection havuzunu korur.Bazı dezavantajları da vardır.Developerlar sql ve database içlerini öğrenmeyi atlarlar. Ormler yavaştır.Sorgu oluşturup bunu databasee iletirler ve birçok bilgi içeren tüm rami tüketen büyük collecttionlar döndürürler.


Q5-Domain Specific Language (DSL) kavramını açıklayınız.

A5-Dsller bir yazılım sisteminin belirli bir yönüne odaklanan küçük dillerdir.Bir dsl ile bütün bir programı oluşturamazsınız,ancak genellikle genel amaçlı bir dilde yazılmış bir sistemde birden çok dsl kullanılabilir.Dsller 2 formda olurlar.Bunlar external ve internaldır.External dsl hostun genel dilinde kendiliğinden ayrışan bir dildir.Regular expressionlar ve css buna bir örnektir.External dsl Unix communitylerinde yeri ayrıdır.Internal dsller ise hostun genel dilinde apiın özel bir formudur ve fluent interface olarak bilinir.İyi tasarlanmış bir dsl library kullanılarak oluşturulan programlara göre daha kolay programlamaya katkı sağlar.Bu sayede çok değerli olan üretkenliği geliştirmiş olur.Özellikle yazılım geliştirmede aşılması zor problemlerden birisi olan domain expertlerle communicationı geliştirir.

Q6-Long lived transaction kavramı hangi tip transactionları ifade etmektedir ? Dezavantajları var mıdır ? Varsa nelerdir ?

A6-Transaction işlemi bir veya birden fazla sorguların aynı anda işlem görmesidir.Beggin commit ve rollback özellikleri vardır.Long lived transactionlar pessimist çalıştırmalarda genelde deadlock oluşturur,optimistic çalıştırmalarda ise genelde deadlock oluşturmaz.

Q7-Thread Pool nedir ? Nerelerde kullanılır ?

A7-Thread poolu daha önceden olutşturlan threadleri o andaki işleri çalıştırmak için yeniden kullanılmasını sağlayan için de threadlerin bulunduğu alanı gösterir.Service provider ile thread pooldaki threadlere iş verilir ve tamamladıktan sonra threadler thread poola geri dönerler.Containerın requesti işlemesi için oluşturduğu thread poollar servlet ve jsplerde kullanılır.Yeni thread oluşturmak için zaman harcamadan thread pooldan bir thread almamızı sağlar. 

Q8-Scalability nedir ? Horizontal ve Vertical Scalability kavramlarını açıklayınız.

A8-Scalability bir programın ölçeklendirebilme yeteneğidir.Bir yazılım çözümünün artan iş yüklerini kaldırabileceği anlamına gelir.Bu daha büyük veri kümeleri daha yüksek talep oranları,boyut ve hız kombinasyonları olabilir.

Horizantal scalability sistemin veritabanının ucuz ve çok sayıda makinenin aynı anda kullanılması anlamına gelirBu sayede yedekleme ve performans artışı sağlanabilir.Daha fazla ram daha fazla donanım eklenebilir.Ayrıca,kullanılan yönlendirme algoritmasına göre gelen aramaları çeşitli sunuculara yönlendirmeye yardımcı olacak yük dengeleyiciyi tanıtılabilir.Yük,sunucular arasında paylaşıldığından uygulama artık daha fazla yük kaldırabilir.

Vertical scalability bir tane çok güçlü aynı zamanda pahalı bir makine/donanım kullanılmasıdır.Uygulama parallel traffic de daha iyi çalışacak şekilde tasarlanır.Belleği,oturumlar ve önbelleği nasıl yönetilmesi gerektiğini kontrol etmenizi sağlar.Kullanıcı bilgilerini korumak için oturumu kullanıyorsanız ağır yük altında tek sunucu sunucuları yönetmekle daha meşgul olabilir,bu durumda stateles gidip gitmediğini kontrol edebilirsiniz.Ayrıca,oturumlar kullanılıyorsa gerçekleşen anlık yanıtlar yerine aynı kullanıcıdan gelen isteklere parallel olarak yanıt verebilir.



Q9-Data replication ve sharding nedir ? Aralarında nasıl bir fark bulunmaktadır ?

A9-Data replication aynı datayı birçok yerde depolama işlemidir.Ana sunucunun herhangi bir sorunla karşılaşması tehlikesine karşın yedek sunucular ile verilerin yedeklenmesi ve ana sunucuda sorun gerçekleştiğinde yedek sunucunun ana sunucu yerine veri kayıplarını engellemesi için gerekli bir özelliktir.

Sharding ise sharding processese göre datayı birkaç farklı kaynakta tutma işlemidir.Büyük ölçekli verilerin sunucular arasında paylaştırılması özelliğidir.Mongodb de performas en öncelikli konu olduğundan bazen veriler çok büyük boyutlara ulaştığında tek bir sunucu yetersiz bir hal alabilir bu nedenle yeni sunucular ile yatay büyümeye giderek veriler bu sunuculara dağıtılır ve yük azaltılmış olur.

