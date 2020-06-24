## 1. ADT List와 ADT Bag은 어떤 차이가 있는가? 비교해 보라.

ADT Bag는 구성되어 있는 entry들에 순서에 대해서 상관하지 않습니다.
 하지만 List는 Bag와 반대로 구성되어있는 entry의 순서(position)를 중요시 여기며, 메서드를 이용해 entry에 접근할 때 Bag와 다르게 position을 통해서 접근합니다.

즉, Bag는 entry를 단순히 add 메서드와 remove 메서드를 통해 추가하거나 제거해줘도 entry들의 순서를 고려하지 않으므로 상관이 없지만, List는 entry들의 position을 고려하므로, entry를 추가하거나 제거할 때, 또는 retrieve할 때 position을 통해서 접근합니다.

또한 List는 Bag와 달리 내부 요소를 replace할 수 있는 메서드도 가지고 있으며, entry를 받아올 때, remove 메서드를 통해 불특정한 entry를 제거함으로써 받아오는 Bag와 달리List는 getEntry 메서드를 통해 원하는 position의 entry를 제거 없이 받아올 수 있는 차이점이 있습니다.

## 2. 교과서 422쪽 exercise2

```java
public int getCount(T anObject){
         checkInitialization();
         int count = 0;
         for (int index = 1 ; index <= numberOfEntries ; index++){
                 if(anObject.equals(list[index])){
                 count ++;
       					}
      		}
      		return count;
 }
```

