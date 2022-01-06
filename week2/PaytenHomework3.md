Q1-Spring dışında dependency injection için kullanabileceğimiz framework’ler / kütüphaneler nelerdir?

A1-.net core için Spring.net,unity,Structure map frameworkleri vardır.Java da guice ,dagger,java ee6 cdi,picocontainer frameworkleri vardır.Python da dependecy injector frameworku ve pinject containerı bulunur.Php de zend framewoku,symfony di,pimple,php-di,container,nette di,auryn,zend servicemanager,acclimate,disco,clancats container kütütphaneleri vardır.Android de koin frameworku bulunur.İos da reseolver bulunur.

Q2-@SpringBootApplication anotasyonu hangi anotasyonları kapsamaktadır ? Görevlerini kısaca açıklayınız

A2-Spring boot projesi oluşturulurken @SpringBootApplication anotasyonu application classa [uygulanır.3 anotasyonu içerir.Bunlar @EnableAutoConfiguration,@ComponentScan ve @Configurationdur.@SpringBootApplication](mailto:uygulanır.@SpringBootApplication) en üst package da yer almalıdır yoksa @componentscan sadece alt packageları izleyebileceği için üst packageları izleyemez.

@Configuration: Bean tanımlanan classlara  uygulanan bir <anotasyondur.@Configuration> bir Xml yapılandırma dosyasına benzer davranan java <sınıfıdır.@Configuration> anotasyonu ile işaretlenmiş java sınıfı,bağımlılıkları başlatma ve yapılandırma yöntemleri de dahil  olan bir yapılandırmadır.

@EnableAutoConfiguration: Main application classında daha çok bu anotasyon bulunur.Class da bulunan beani configure eder.

@ComponentScan: Bean için bir package ararken [@Configuration](mailto:kullanılır.@Configuration) anotasyonu ile kullanılır.Spring components  için aranacak temel packageları da belirtebiliriz.

Q3-@Primary, @Qualifier anotasyonlarının kullanım amaçlarını açıklayınız.

A3-Qualifier bir interface implementasyonu birden fazla ise veya bir classın instanceları birden fazla ise spring ioc yapısında hangi interface ile hangi classı bağlayacağını bilemeyecektir.Hangi java beanini hangi anda kullanmak istediğini daha net belirtmek için Beanin ismini belirterek <kullanılır.@Primary> anotasyonu bir tane olur ve Spring container da aynı typetan birden fazla Bean bulunuyorsa bu ayrımı yapmak için  öncelikli seçeceği Beanin üzerine yazılarak springe belirtir.

Q4-Convention over configuration kavramını seçtiğiniz bir örnek üzerinden açıklayınız.

A4-Çalışılan environment default olarak mantıksal birçok durumun olduğunu varsayar ve her gerektiğinde kendi kurallarımızızı oluşturmak yerine buna adapte olursak programlama daha üretken ve daha basit olur.Amaç programcının karar verme durum sayısını azaltarak development için configure yapılacak yerlerdeki karmaşıklığı azaltmaktır.

Q5-Aspect Oriented Programlama nedir ? Avantajları ve dezavantajları nelerdir ?

A5-Aspect oriented programlama cross cutting concernlerin ayrılması üzerine uygulanır.Geliştirilen modüller de her business işleminde ortak olarak gerçekleşen bazı işlemler vardır.Bunlar kullanıcı yetkisi olup olmaması,gelen isteğin loglanması veya exception handling işlemleri cross cutting concernlerdir.Avantajları ise object oriented programmingin tamamlayıcısıdır.Dependency injection için spring ioc’yi kullanır.Configure yapılması kolaydır.Dezavantajları ise aopli uygulamalar debug edilmesi biraz zordur.Methodları public olmalıdır.


Q6-SOLID prensiplerini kısaca açıklayınız. Sizce her koşulda bu prensipler çerçevesinde mi kod yazılmalıdır ? Neden ?

A6-Solid prensipleri; geliştirilen herhangi bir yazılımın esnek, yeniden kullanılabilir, sürdürülebilir ve anlaşılır olmasını sağlayan, ayrıca kod tekrarını önleyen prensiplerdir.Solid prensiplerine uyarak kod yazılmalıdır.

Single Responsibility Principle: Bir classın yapması gereken sadece bir işi olmalıdır.

Open Closed Principle:Bir class ya da fonksiyon var olan özelliklerini korumalı ve değişikliğe izin vermemelidir.Davranışını korumalı yeni özellikleri de kazanabiliyor olmalıdır.

Liskov Substition Principle:Kodlarımızı herhangi bir değişiklik yapmadan alt classları üst classların yerine kullanabilmeliyiz.

Interface Segregation Principle: Sorumlulukların hepsini bir interface toplamak yerine birden fazla interface oluşturmalıyız.

Dependency Inversion: Classlar arası bağımlılık olabildiğince az olmalıdır ve üst seviye classlar alt seviye classlarla bağımlı olmamalıdır.

Q7-Swagger nedir, ne amaçla kullanılmaktadır ?

A7-Swagger rest api geliştirmek için gereken ve yardımcı araçlar sağlayan bir teknolojidir.Sağladığı bu araçlarla api tasarım,geliştirme,dökümantasyon ve test aşamasında kolaylık sağlar.Restapiler için bir araryüz sağlar.Bu kaynak koda erişmeden Restapilerin özelliklerinin görülmesine,incelenmesine ve anlaşılmasına olanak sağlar.

Q8-Richardson Maturity Model’i seviyeleriyle birlikte açıklayınız.

A8-Richardson Maturity Model Rest apilerimizin hangi seviyede olgun olduğunu gösteren bir olgunluk seviyesidir.RMM 4 seviyeden oluşmaktadır ve 0’dan 3’e başlayan seviyeler, yukarı doğru çıktıkça daha etkin kullanıldığını ifade etmektedir.

İlk seviye Swamp of Poxdur.Servisimizdeki sadece tek method üzerinden post olarak erişebildiğimiz seviyedir.Bu seviye transfer protokolü olarak da adlandırılmaktadır.

İkinci seviye Resorucesdur.Servisimizdeki uri üzerinden bir metot ile erişebildiğimiz seviyedir.Örnek uri http://localhost/students/1 

Üçücncü seviye http verbsdür.Bunlar post,put,get ve delete methodlarını çağırıdığımız seviyedir.

Dördüncü Seviye Hypermedia Controlsdür.Servislerimizde uri’nin istek gönderip cevaba göre tekrar uri’ye istek yapabildiğimiz bir seviyedir.Servis üzerinden gelen cevaba göre akıştaki davranışı görebiliriz.Hateoas kullandığımız seviyedir.Hateoas ise bir rest servisinin response üzerinden tüm içerik bilgilerini görebildiğimiz başka bir kaynağa ya da dokümana gerek kalmadan kullanabilmeye olanak sağlayan bir araçtır.Spring boot içerisine hateoas kullanmak için maven dependencysini eklememiz gerekir.

Q9-URL, URI, URN kavramlarını bir örnek üzerinden açıklayınız.

A9-Uri:  Kayanağa tam olarak tanımlayıcı ile işaret eden ve bu işaretleme için standart bir formata sahip karakter dizgisidir.Url kapsamında olan alt katmanlardır.Uri url ve urn olmak üzere 2 kapsama sahiptir.Urnler ve Urller Uridirler.Urilar hemm bir url ve hem bir uri olabilirler.

[Url: İnternet](Url:İnternet) ile erişilebilecek kaynakların konumu Url ile ifade edilirUrl teknik olarak uriın başlangıç kısmını oluşturur.Yapısal olarak,Urlin ardından ise urn gelmektedir.

Urn: Bir kaynağı benzersiz ve kalıcı bir adla tanımlar ancak bunu internette nasıl bulunacağının söylenmesi gerekmez.Genelde urn: prefixi ile başlar.

Q10-Idempotency nedir ? Hangi HTTP metotları idempotent’ tir ?

A10-Idempotent bir veya daha fazla kez çalıştırıldığında sonucu değişmeyen işlemlerdir.Get,put,delete,head,options,trace methodları idempotenttir.

Q11-RFC (Request For Comment) neyi ifade etmektedir ? HTTP hangi RFC dokümanında açıklanmıştır ? Bu dokümanda HTTP hakkında ne tür bilgiler yer almaktadır ?

A11-Rfc internet standartıdır.İnternet protokolü,mekanizması için bu protokolleri ve mekanizmasını tanımlayan bir rfc vardır. Örnek verecek olursak Udp 768, ip 791,Tcp 793,dns 1034,url 1738,smtp 2821 gibidir.Http ise 2616 dadır. Http , 1990 yılından beri dünya çapında ağ (www) üzerinde küresel bilgi girişimi için kullanılmaktadır.Http/0.9 olarak anılan ilk sürüm http internet üzerinden ham verinin taşınması amaçlı, basit bit iletişim kuralıydı.Rfc 1945 dahilinde tanımlanan http/1.0, taşınan verinin meta-bilgilerini ve istek cevap semantiği düzenleyicilerini içeren bir önceki sürümü detaylandırmıştır.Yine de http/1.0 hieararşik Proxy ,önbelliğin kalıcı bağlantı için gerekenlerin ve sanal sunucuların etkilerini göz önünde bulundurmada yetersiz kalmaktaydı.Ek olarak http/1.0 olarak anılan uygulamaların,tam olarak anlaşılması için yetersiz kalmakta ve bu sürüm içn bir yeniliğe gidilmesi zorunluydu.Http/1.1 olarak bilinen bu yeni sürüm ,iletişim kuralının güvenilir bir biçimde uygular.Http  smtp,nntp,ftp ve wais iletişim kurallarını destekleyen internet sistemleri ile kullanıcı istemleri,proxyler ve gateawayler arasında iletişim için özelleştirilmiş bir iletişim kuralı olarak da kullanılır.


