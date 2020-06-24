## 1. 교과서 345쪽 상단( Suppose that we instead… 로 시작하는 문장)에서 이야기하고자 하는 것은 무엇인가?. 즉 무슨 문제를 어떻게 풀라고 하는 이야기 인가? 설명하라.

345쪽 상단 문장에서는 StockLedger 클래스에서 buy를 통해 pricePerShare를 매개변수로 한 StockPurchase 클래스 객체를
queue에 sharesBought 개수 만큼 저장하는 것을, sharesBought와 pricePerShare를 매개변수로 갖는 하나의 객체를 만들어
queue에 저장해보겠다고 가정하고 있습니다. 즉 이전에는 buy 메서드에 sharesBought 매개변수로 30이 들어가면 30개의
StockPurchase 객체를 queue에 저장하게 되어 공간 복잡도의 문제가 발생하게 되는데, sharesBought와 pricePerShare를
매개변수로 갖는 객체를 저장함으로써 이러한 문제를 해결할 수 있습니다.

다만 이러한 방식으로 구현하게 되면, sell을 수행할 때, 주의할 부분이 있습니다.
예를 들어 20개를 판다고 가정했을 때, queue에 front entry의 sharesBought가 20을 넘는다면(만약 30이라면)
20개를 팔고 남은 10개의 shares들은 queue 뒤에 추가하는 것이 아닌 front에 그대로 유지시켜야 합니다.

하지만 queue에는 queue의 front entry를 수정하거나 queue의 front에 entry를 추가하는 operation이 없습니다.
그럼에도 불구하고 각각의 entry가 set 메서드를 가지고 있으면 front entry를 수정할 수 있게 되고, 
위에서 언급한 부분을 해결할 수 있게 됩니다.

## 2. 교과서 369쪽 11.10장 Circular Array with One unused location에서 unused one을 두는 이유는 뭔가? 즉 무슨 문제를 어떻게 풀겠다는 이야기 인가? 설명하라.

Circular Array에서 unused location을 지정하지 않고 그냥 사용하게 되면, queue가 'frontIndex equals (backIndex + 1) % queue.length'의
조건을 만족했을 때, 해당 queue가 empty상태인지 full 상태인지 알 수가 없게 됩니다.

이러한 문제를 queue의 item 개수를 count함으로써 해결할 수 있지만, 이 경우 각각의 enqueue 메서드와 dequeue 메서드에서
count를 항상 update해야하는 extra work가 발생하게 됩니다.

따라서 Circular Array에 unused location, 즉 unused one을 둠으로써 queue가 'frontIndex equals (backIndex + 2) % queue.length'의
조건을 만족했을 때는 해당 queue가 full 상태이고, 'frontIndex equals (backIndex + 1) % queue.length'의 조건을 만족했을 때는
해당 queue가 empty 상태인 것을 구별함으로써 위에서 언급한 문제를 해결할 수 있습니다.