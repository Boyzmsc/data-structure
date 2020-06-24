## 1. 교과서 452쪽 exercise 7

```java
public int getCount(T anObject){
   int count = 0;
   Node currentNode = firstNode;
   while(currentNode != null){
     if(anObject.equals(currentNode.getData())){
       count ++;
     }
     currentNode = currentNode.getNextNode();
   }
   return count;
 }
```



## 2. iterator란 무엇이고 왜 필요한가? 설명하라

iterator란 java의 collection에 저장되어 있는 데이터들을 읽어오는 방법을 표준화한 것입니다.
collection을 다룰 때는, 개별적인 클래스에 대해 데이터를 읽는 방법을 일일이 알아야 하므로 각각에 collection에 대한 접근이 힘들어집니다.
하지만 이 부분에서 iterator를 사용하게 되면 어떤 collection이라도 데이터에 동일한 방식으로 접근하기 때문에 사용자에게 보다 편리하고 표준화된 접근 방법을 제공합니다.