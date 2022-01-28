Q1-Concurrent programlama ve Parallel Programlama nedir ? Aralarında çalışma şekli olarak nasıl bir fark bulunmaktadır ?

A1-Concurent programlama aynı anda birden fazla taski yürütmek anlamına gelir,ancak aynı anda olması gerekmez.Eğer tek bir cpu varsa uygulama aynı anda birden fazla taskde ilerleme kaydedemeyebilir.Bir task tamamlanmadan onu bırakıp diğer taske başlayabilir sonra bıraktığı taskden devam edip onu bitirebilir.Parallel programlama bir uygulamanın tasklerini birden fazla cpu da parallel olarak işlenebilen daha küçük alt tasklere ayırması anlamına gelir.Her taske veya alt taske bir çekirdek atayarak,cpunun çok çekirdekli alt yapısını kullanarak aynı anda tasklerin bölümlerini veya birden fazla taski fiziksel olarak çalıştırır.Farkları ise

-Concurrent programlama birçok şeyle bir kerede uğraşmaktır.Parallel programlama birçok şeyi aynı anda yapmaktır

-Bir uygulama concurrent olabilir ancak parallel olmayabilir bu aynı anda birden fazla task işlediği,ancak aynı anda 2 taskin yürütülmediği anlamına gelir.

-Bir uygulama parallel olabilir,ancak concurrent olmayabilir;bu aynı anda çok çekirdekli cpu da bir taskin birden çok alt taski işlediği anlamına gelir.

-Bir uygulama ne parallel ne de concurrent olabilir;bu tüm taskleri birer birer sırayla işlediği anlamına gelir.

-Bir uygulama hem parallel hem de concurrent olabilir;bu,aynı anda çok çekirdekli cpu da birden çok taski eşzamanlı olarak işlediği anlamına gelir.

Q2-Mutex ve Semaphore kavramlarını açıklayınız. Hangi tür durumlarda bunlara başvurmamız gerekir ?

A2-Semaphore bir işlem senkronizasyon aracıdır.Semaphore tipik olarak,mevcut kaynak sayısına göre başlatılan bir tamsayı değişkeni S dir ve semaphoreun değeri,başlatma dışında sadece wait() ve signal() işlevleri ile değiştirilebilir.Wait() ve Signal() işlemi semaphore değerini ayrı ayrı değiştirir.Bu da bir işlem semaphoreun değerini değiştirirken başka hiçbir işlemin semaphoreun değerini aynı anda değiştiremeyeceği anlamına gelir.Bir işlem kaynağa erişmek istediğinde  semaphore üzerindeki wait() işlemini çalıştırır ve semaphoreun değerini bir azaltır.Kaynağı serbest bıraktığında,semaphore üzerindeki signal() işlemini gerçekleştirir ve semaphoreun değerini bir artırır.Semaphore sayısı 0 olduğunda tüm kaynaklar işlemler tarafından kullanılıyor demektir.Bir işlem, semaphore sayısı 0 iken bir kaynak kullanmak isterse, wait() komutu çalışır ve semaphoreun değeri 0 dan büyük olana kadar o işlemin kaynağı kullanması engellenir.

Mutex ise bir kilitleme mekanizmasıdır ve bir nesnedir.Birden fazla program dizisinin tek bir kaynağa erişmesine izin verir;ancak aynı anda değil.Bir program başlatıldığında, sistemin belirli bir kaynak için mutex nesnesini oluşturmasını ister.Sistem mutex nesnesini unique bir ad ve kimliğe göre oluşturur.program iş parçacığı,mutex nesnesindeki kilidi kaynağı kullanır ve kullandıktan sonra mutex nesnesindeki kilidi serbest bırakır.Sonra bir sonraki işlem için mutex nesnesindeki kilidi elde etmesine izin verilir.Mutex kilidini bir sonraki işlem aldıktan sonra hiçbir işlem bu kaynağa erişemez ve kaynağı almak isteyen işlem beklemek zorundadır.

Birden fazla kaynak varsa semaphore kullanılmalıdır.Tek bir ortak kaynak varsa mutex kullanılmalıdır.

Q3-Java’da Error ve Exception arasındaki fark nedir ? Throwable ile ilişkileri nasıldır ? Hangi tür durumlarda Error hangi tür durumlarda Exception meydana gelebilir ? Örneklerler açıklayınız

A3-Class yapıları açısından farkı yoktur.2side throwable clasından türeyen classlardır.Errorlar sistem kaynaklarının eksikliğinden kaynaklanan bir hatadır.Program koduyla erroru handle etmenin yolu yoktur.Error tespit edildiğinde program kendiliğinden sonlanır.Errorlar java.lang.Error packageı olarak tanımlanır.Örnek olarak da OutOfMemory veya StackOverFlow gibi…

Exceptionlar ise developera bilgi verme amaçlıdır.Programcının kodda yaptığı hata nedeniyle exceptione sebep olur.Try,catch ve throw keywordleri vradır.Exceptionlar java.lang.Exception packageında tanımlanmıştır.Örnek olarak ise handle edilmiş exceptionlar NoSuchMethod,ClassNotFound gibi…Handle edilmemiş exceptionlar NullPointer,IndexOutOfBounds gibi.

Q4-Spring’te yer alan @Scheduled anotasyonunun kullanım amaçlarını ve kullanım şeklini açıklayınız.

A4-Scheduling, belirli bir  zaman dilimi için taskları yürütme işlemidir.İşletim sisteminde bu threadler ile sağlanır.Spring boot, spring uygulamalarına Schedule yazmayı destekler.Spring boot projesinde planlanmış task çalıştırmak için öncelikle Main clasına @EnableScheduling anotasyonu eklenmelidir.Planlı olarak çalıştırmak istediğimiz methoda @Scheduled anotasyonu eklemeliyiz.4 tane planlanmış task çalıştırma methodlarından 1sini daha eklememiz gerekiyor.Bunlar fixedRate,fixedDelay,initialDelay ve cronExpressiondur.FixedRate ve fixedDelay bize methodun kaç saniye de bir çalışacağını söyler.InitialDelay program başladıktan kaç saniye sonra method çalışması gerektiğini söyler. CronExpression ise bir çalışma patterni verilir ve methodun ona göre çalışması beklenir.Örneğin her saatte bir, her 30 saniyede bir, her gün saat 8de ve 9da, saat8 ile 10 arasında 30 dakika da bir şeklinde çalıştırmamız fayda sağlar.Spring planlanmış taskleri,veritabanı kontrolü,uygulama durum değişikliği,günlük e posta iletimi veya farklı birçok durumda planlanan çerçevede methodların çalıştırılarak uygulamamızın daha etkin olmasını sağlar.

Q5-Spring’te yer alan @Async anotasyonunun kullanım amaçlarını ve kullanım şeklini açıklayınız.

A5-Bir beanin methoduna @Async anotasyonu ekleyerek o beani main threadden farklı olarak ayrı bir threadde çalıştırılması sağlarnır.Yani call edilen methodun tamamlanmasını call eden kısım beklemez.Kod böylece asnyc olarak çalışmış olur.Asynchronous processler için, main classa @EnableAsync anotasyonunu <eklemeliyiz.@EnableAsync> anotationu @Async anotationlarına sahip methodları arayacak ve bu methodları backgrounda thread poollarında <çalıştıracak.@Async> anotationu kullanan methodlar public olmalıdır.Aynı class içerisinden @Async bir method çağırılırsa method asynchronous olarak çalışmaz.Methodun proxied olabilmsei için public olmalıdır.Bir Proxy üzerinden değil de direkt olarak methodun çağırılmasından dolayı asynchronous çalışmaz.Çünkü Springin Proxy patterni sadece bean üzerinden bir methodu asynchronous hale getirebilir.Yani bean kullanarak methodu çağırmalıyız.Aynı şey Transactional için de geçerlidir.Async method için başka bir service oluşturmak ve bunu serviceden call etmemiz gerekir.Spring common anotationları kullanarak oluşturulan her service ve component için bir Proxy oluşturur.Yalnızca bu proxyler @async anotationu olan methodların istenen davranışı yapmasını sağlar


Q6-High Availability (HA) kavramını kısa açıklayınız.

A6-High availability hizmetin sürekliliğini ifade eder.Örneğin bir web sitesi ya da uygulamanın sürekli ulaşılabilir olması hedeflenir.Hiçbir sistem %100 ulaşılabilir denemeyebilir ancak bu oranı en üst seviyede tutmak için çeşitli sistemler ve yöntemler kullanılır.Bunlar redundancy,monitoring ve failoverdır.Redundancy bir sistem içerisinde aynı işleve sahip bileşenlerin çokça bulunmasıdır.Örnek olarak birden fazla veritabanı olduğunda serverlardan birinde bir problem çıkarsa diğer veritabanı serverı gelen istekleri yanıtlayabilir.Böyle sistemlerde replication çok önemlidir.Tüm veritabanları aynı veriye sahip olmalıdır.

Monitoringde ise high availability sistemler sürekli olarak bileşenlerin durumunu izlemelidir.Bir problem durumunda yedekte bulunan bileşenin birincil bileşen yani aktif duruma geçmesi failover olarak adlandırılır.

Q7-Entity ve Value Object kavramlarını Domain Driven Design (DDD) kapsamında açıklayınız.

A7-Entityler özellikleri ile değil,bir süreklilik ve kimlik dizisiyle tanımlanır.Kimliğiyle tanımlanan nesneye entity denir.Entity, lifecycleı boyunca sürekliliği olan ve uygulamanın kullanıcısı için önemli olan niteliklerden bağımsız ayrımları olan herhangi bir şeydir,ancak sisteme özgü olması gerekir.Bulunan subdomaine göre kimlik ve entity değişebilir.Value objectlerde kimlik kavramı olmadığı için entitylerden farklıdırlar.Kim olduklarıyla değil ne olduklarıyla önemlidirler.Attributelarıyla tanımlanırlar ve immutable olmalıdırlar.3 özelliği vardır.Bunlar value equality,immutability ve self validationdır.Atributeları eşit olan value objectler aynıdır.Bir kez oluşturuludaktan sonra, bir value object her zaman aynı ise immutabledır.Bir value object oluşturulurken attributelarının geçerliliğini doğrulamalıdır.Attributelardan herhangi birisi geçersizse nesne oluturulmamalı ve error veya exception atılmalıdır. 

Q8-Ubiquitous Language kavramını DDD kapsamında açıklayınız. Sizce neden önemli olabileceğini belirtiniz

A8-Ubiquitous language developerlar ve userlar arasında ortak,titiz bir dil oluşturma pratiği için ddd de kullanılan bir terimdir.Bu dil yazılımda kullanılan ddd ye dayanmalıdır.Ubiquitous language kullanmak ddd modelini test etmenin önemli bir parçasıdır. 

Q9-Core Domain, Supporting Domain, Generic Domain kavramlarını DDD kapsamında açıklayınız

A9-Core domain business için gerekli olan en önemli domaindir.Bu olmadan business başarısız olur.

Supporting sub domain business için core domainden daha az değerli olan domaindir.Onsuz business bir süre çalışabilir,ancak yine de oldukça önemlidir.Core domaine benzer.Sistem internaldır.Bir e-ticaret sistemi,üyelik gibi iş sistemleri bu domaine örnektir.

Generic domain gözlemlenebilir loglama,mimari tasarımda metricler ve tracingler, çeşitli cloud serviceler genel olarak endüstri tarafından çözüldüğü kabul edilir.Bunlar daha iyi uygulama şemalarına sahiptir ve bağlanabilir.Erp, crm,donanım sistemleri, endüstri çözümleri gibi çözümleri vardır. 

Q10-Anemic Domain Model ve Rich Domain Model kavramlarını kıyaslayarak açıklayınız.

A10-Anemic domain modeli içinde mantığı olmayan bir modeldir.Domian classlar,classın istemcisinin,classın nasıl başlatılacağı ve değiştirileceği üzerinde kontrole sahip olduğu domain mantığı olmayan bir grup getter ve setterlara benzer.Bu modellerde client,classın amacını ve kullanımını yorumlamalıdır.Genellikle mantık, service, helper, manager ve domain classının adı gibi bir şey olarak adlandırılan diğer classlara push edilir. Mantık başka bir class da otururken,clientın model sınıfında gezinmesine veya kullanmasına yardımcı olacak hiçbir şey yoktur.Bu yaklaşım birçok dezavantaja yol açabilir.

-Encapsulaiton ihlali

-Bakımı zor

-Yinelenen business mantığı

-Modeldeki varlıkların tutarlı bir durumda olduğundan emin olunamaz

-Düşük uyum

Rich domain model ise anemic domain modellerinin dezavantajlarını handle etmenin iyi bir yoludur.Anemic domain modelden farkı ise domain mantığımızın ve domain varlıklarımızın,veri ve davranışımızın bir parçası olmasıdır.Bu mantık,varlığın nasıl başlatıldığını,doğrulandığını,işletildiğini yönlendirir ve kontrol eder.
