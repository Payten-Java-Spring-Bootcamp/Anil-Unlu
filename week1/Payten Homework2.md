Anıl Ünlü

`				`Homework 2

Collection Pipeline:

`	`Collection pipelinelar yazılımı nasıl modülerleştirebileceğimizin ve oluşturabileceğimizin bir modelidir.Çoğu pattern gibi bir çok yerde kullanılır.Collection pipelinelar aralarında bir collection ileten  işlem düzenlerler.Her işlem de input olarak collection alır output olarak da collection iletir.İşlemler arasında iletilen collectionlar farklı biçimlerde olabilirler.

Exploring more pipelines and operations

`	`Pipelinelar çok fazladır.Bunlardan bir tanesi map dir.Map propertydeki input collectiondaki her nesneye verilen lambda uygulamasının sonucu olan collection returnler.Diğer bir collection pipline reducedur.Bu işlem bir input fonksiyonunu tek bir sonuca indirger.Bunu yapan fonksiyona da indirgeme denir.

Nested Operator Expressions:

`	`Birden çok ifadeye & ve | veya logic operatörleriyle bağlayan iç içe olan operatörlerdir.

Laziness:

`	`Laziness bir methodda take ile beraber kullanılır ve take içerisindeki sayı kadar en  yüksek olanlarını işler.Özel bir koleksiyon sınıfı grubuna dahil edilebilir.Bazı collection pipeline işlemleri lazinessla çalışmaz.Sort buna örnektir.

Immutability:

`	`Collection pipelinelar immutable veri yapılarına uygundur.

Paralellism:

`	`Mapleme yaparken performansı artırmak için çekirdek sayısı da fazlaysa kullanılabilir.Gerçekten performans iyileştirmesi olup olmadığını anlamak için performans testleri uygulanmalıdır

When to use it :

`	`Dil desteğinin olmadığı zamanlarda kullanılmamalıdır.Pipeline doğrusal oldukarlında çok iyi çalışırlar.Her işlemde tek collection input ve output vardır.İnputları ve outputları ayırmak da mümkündür.
