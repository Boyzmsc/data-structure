## 1. 교과서 478쪽 Listing 15-2가 뭔지 설명 해 보라. getIterator()는 꼭 필요한가? 없다면 어떻게 되는가? 설명하라.

교과서 478쪽 Listion 15-3에서 inner class로 IteratorForLinkedList가 구현되고 outer class로 LinkedListWithIterator가 구현되는데, 
이 과정에서 client가 iterator를 생성할 수 있게끔, iterator()라는 메서드를 만들어 줄 필요가 있습니다.
iterator() 메서드는 Iterable 인터페이스 내에 선언되어 있고, Iterator 인터페이스를 준수하는 iterator를 리턴합니다.
iterator() 메서드는 standard한 name을 가지고 있지만, Iterator 인터페이스와 이름이 같아 혼란을 초래할 수 있으므로, iterator() 메서드와 똑같이 동작하는 getIterator()라는 이름의 메서드를 추가적으로 만들어 줍니다. 이 부분에서 이미 iterator() 메서드를 정의한 상태이므로, getIterator()는 iterator() 메서드를 호출합니다.
따라서 getIterator() 메서드와 iterator() 메서드를 수용하기 위해 
Listing 15-2처럼 새로운 interface를 생성한 다음, 인터페이스 Iterable과 ListInterface를 extend해주고 인터페이스 내에 getIterator() 메서드를 
선언해 줍니다.
getIterator() 메서드가 꼭 필요한 것은 아닙니다.
하지만 위에서도 언급했듯이 getIterator() 메서드가 없다면, iterator를 생성하기 위해 오로지 인터페이스 Iterable에 선언된
iterator() 메서드만을 정의하고 사용하게 되는데, 이 경우 Iterator 인터페이스와 이름이 같아 많은 혼란을 초래할 수 있습니다.

## 2. 교과서 574쪽 exercise 4번 4를 찾는 부분만 하라.

array인 '5 8 10 13 15 20 22 26 30 31 34 40'과 함께 binarySearch 함수 매개변수로 first는 0, last는 11, desiredItem은 4가 들어갑니다. 
함수 내에서 mid = 5 가 되고, comparison 조건문에 의해 binarySearch(array, 0, 4, 4)를 재귀 호출하게 됩니다.
binarySearch(array, 0, 4, 4) 함수 내에선 mid = 2, 또다시 comparison 조건문에 의해 binarySearch(array, 0, 1, 4)를 재귀 호출하게 됩니다.
binarySearch(array, 0, 1, 4) 함수 내에선 mid = 0, 또다시 comparison 조건문에 의해 binarySearch(array, 0, -1, 4)를 재귀 호출하게 됩니다.
binarySearch(array, 0, -1, 4) 함수 내에선, comparison 조건문 내에 first > last의 조건문이 true가 되므로, 변수 found = false가 되고 found를 리턴합니다. 
결과적으로 binarySearch(array, 0, 11, 4)는 false를 리턴합니다. 