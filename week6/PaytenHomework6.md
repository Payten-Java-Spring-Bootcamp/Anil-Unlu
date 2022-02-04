Q1-Conway’in Kanunu’ nu (Conway’s Law) açıklayınız.

A1-Sistem tasarlayan kuruluşlar,bu kuruluşların iletişim yapılarının kopyaları olan tasarımlar üretmekle sınırlıdır.Conway law olarak bilinen bu ifade deneysel olarak kanıtlanmış ve titiz çalışmalarda gösterilmiştir.Conway yasasının pratik anlamı, organizasyonlarımızı “düşünme şeklimizin” geliştirdiğimiz sistemler üzerinde doğrudan bir etkiye sahip olmasıdır.Monolitik olarak organize edilmiş bir ekiple bir organizasyonda microserviceler tasarlamak mümkün değildir.Loosely coupled ve verimli componentler istiyorsak, ekipler bu şekilde çalışan ekipler olmalıdır.Özerk ancak hizalanmamış ekipler, birlikte iyi çalışmayan loosely coupled componentlar üretirler.Bir sistemdeki iki component çakışıyorsa organizasyonda çakışan iki takım vardır.

Q2-Software as a Service (SaaS), Platform as a Service (PaaS), Infrastructure as a Service (IaaS), On-Premises kavramlarını örneklerle açıklayınız.

A2-Software as a service uygulamaların clouddan hizmet vermesine Saas denir.Kullanıcılar sadece uygulama arayüzlerine erişebilir.Kendilerine ait bilgileri bu yazılımlara girerek, bilgilerini cloud üzerinde saklar ve buradan kullanırlar.

Platform as a service cloud üzerinde bir java,ruby,node gibi yazılım dillerinde uygulama gelişitirilmek isteniyorsa ve işletim sistemi,network.sunucu gibi sistemler ile uğraşılmak istenmiyorsa sadece uygulama geliştirilmek isteniyorsa tercih edilebilecek bir platformdur.Run time dosyaları platforma atılıp çalışması sağlanır.

Infrastructure as a service cloud üzerinden sanal compute,storage,networking satıldığı,kiralandığı cloud hizmeti olarak düşünülebilir.Bilgisayar,disk ve network kartları almak yerine bunları sanal olarak clouddan kiralanıp üzerine istenilen işletim sistemi kurulup işlemlere devam edilebilir.

Q3-Continuous Integration, Continuous Delivery ve Continuous Deployment kavramlarını açıklayınız.

A3-Continuous integration kod üzerinde yapılan değişiklik sonrasında sistemin çalışır durumda olduğunu,yapılan değişikliğin problemlere yol açmadığını tespit etmek için kullanılan yöntemdir.Problemleri ve kırılımları tespit edebilmek için unit testleri kullanır.Yapılan değişiklikler yeni bir yapının parçası olduğundan dolayı,testlerde oluşan hatalar,yapılan değişikliğin sistemi kırdığı anlamına gelir.Bu durumda tüm programcılar bilgilendirilierek hatanın bir an önce düzeltilmesi sağlanır.Continuos integration ile programcılar tarafından kod üzerinde yapılan çalışmalar sonucunda her zaman çalışır bir sürümün oluşması sağlanmış olur.Continuos integration,developerların kod değişiklikleirini daha sık geliştirmesine yardımcı olur.Developerların bir uygulamadaki değişiklikleri birleştirdiğinde,bu dğeişikliklerin uygulamayı bozmadığından emin olmak için uygulamayı otomatik olarak oluşturarak ve farklı düzeylerde testler ile doğrulanmalıdır.

Continuous delivery başarılı olan bir yapıyı bir ortama atma durumunun otomatik olan yoludur.Conutinuos integration ile continuouıs delivery arasındaki fark continuous deliverynin otomatik olmasıdır.

Continuous deployment bir codebasedeki değişikliklerin bir üretim ortamına  anında dağıtım için otomatik test kullanan bir yazılım sürecidir.


Q4-API Gateway pattern’ı açıklayınız

A4- Api gateway patterni dış dünyadan uygulamaya giriş noktası olan bir hizmettir.Apı oluşturma ve kimlik doğrulama gibi diğer işlevlerden sorumludur.Bir apı gateway uygulamanın iç mimarisini kapsar ve istemcilerine bir api sağlar.Api gateway birden çok istemci uygulamasıyla karmaşık ve büyük microservice uygulamaları oluşturulurken kullanılmalıdır.

Q5-Backend for frontend (BFF) pattern’ ı açıklayınız

A5-Bir projede microserviceler,frontend tarafından kullanılacak apiları ortaya çıkarır.Ancak microserviceler tarafından frontende döndürülen veriler,frontendin bunları tam olarak temsil etmesi gereken şekilde biçimlendiremez veya filtreleyemez.Bu durumda, front end bu verileri yeniden biçimlendirmek için kendi kendine bir mantığı olması gerekir.Front endde böyle bir mantığın olması,daha fazla tarayıcı kaynağı kullandırtacaktır.Böyle bir durumda, front end mantığının bir kısmını bir ara katmana kaydırmak için bir back end for front end kullanılabilir.Ara katman back end for front enddir.Bir front end bazı verileri istediğinde,back end for front end bir api arayacaktır.Back end for front end şunları yapıcaktır.

-İlgili microservice apilarını arayıp gerekli verileri alır.

-Verileri front end temsiline göre biçimlendirir.

-Biçimlendirilmiş verileri front ende gönderir.

Sonuç olarak front end de minimum mantık olacaktır.Bu nedenle de bir back end for front end, veri gösterimini kolaylaştırmaya yardımcı olur ve front end için iyi odaklanmış bir interface sağlama sorumluluğu üstlenir.

Q6-Circuit-breaker pattern’ ı açıklayınız.

A6-Serviceler her zaman düzgün çalışmayabilir down olabilir ve requestlere cevap vermezse bütün akışı aksatıp bir dizi ardışık hataya sebep olabilir.Bu cevap dönmeyen requesti yapan çok fazla caller olursa kaynak tüketimi olmaması gereken seviyelere çıkar,bir çok servicei ve hatta sistemi etkileyecek bir dizi ciddi problemlere yol açabilir.Bu gibi durumlarda circuit breaker bir devre anahtarı gibi davranarak belli bir thresholdun üstünde hata aldığında response dönemeyen servicee gelen requestleri iletmeden, requestlere bir hata mesajı veya bilgi verici mesajla dönüş yaparak sistemin gereksiz yere aşırı yüklenmesini engeller.Belli bir timeouttan sonra gelen requestlerin bir kısmını service ileterek test yapıp sistem durumunu kontrol eder.Eğer problem çözülmüşse bütün isteklerin geçmesine izin verir ve sistem düzenli korunmuş olur.Eğer test çağırıları da hata mesajı alıyorsa, yine requestlere error dönüp bu döngüyü devam ettirir.

Q7-Microservice chassis pattern’ ı kısaca açıklayınız.

A7-Microservice chassis pattern temelde işlevsel mantığı tek bir modülde birleştirmeyi ve onu çeşitli servicelerde yeniden kullanım için hazırlamayı amaçlar.Aopnin dışa dönük uygulama özelliklerini ayrı kod birimlerine ayırması gibi,chassis modeli de microservice mimarilerini çoğaltan back end işlevleri için ayrı modüller oluşturur.Microservice chassisin bazı avantajları vardır.

-Cross cutting concernleri ele almak için developerların yazması gereken kod miktarını azaltır.

-Business logic bir uygulamanın işlevsel kaygılarından ayırmaya yardımcı olur.

-Servicelerin standartlaştırılmış bir dizi yönergeyi izlemesini sağlayarak tutarlılığı arttırır.

Microservice chassis için dikkat edilmesi gereken bazı özellikler vardır.

-Fazlalık olup olmadığına dikkatlice bakarak mekanizmanın kodunu mümkün olduğunca hafif olmalıdır.

-Gereksiz özellikler ayrı bir library arşivine taşınmalıdır.

-Microservice mimarisi birden çok yazılım dili içeriyorsa, microservice chassisin yazılım dilinden bağımsız yapısını azaltmak için sidecar Proxy kullanılmalıdır.

-Temel çerçeve önemli ölçüde değişmediyse, chassisyi tekrar tekrar test etmekten kaçınılmalıdır.
