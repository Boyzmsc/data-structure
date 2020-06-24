## 1. Time complexity의 개념을 가지고 우리가 2장과 3장의 두 구현을 비교 분석 해 보고자 한다. add(anEntry), remove(), remove(anEntry), 그리고 contains(anEntry)만 비교 해 보라. 어떤 것이 어떻게 유리한가? 설명하라.
add(anEntry) // LinkedBag 같은 경우, Node를 하나 생성하여 LinkedBag의 firstnode로 설정하기 때문에 바로 저장공간에 접근하는 
ArrayBag과 비교해서 조금 느릴 수 있습니다.

remove() // 가장 최근에 추가된 요소를 제거하기 때문에 시간복잡도면에서 차이점이 없습니다.

remove(anEntry) // LinkedBag 같은 경우 getReferenceTo에서 O(n), ArrayBag 같은 경우 getIndexOf 에서 O(n)입니다. 
자료의 삭제 매커니즘은 동일하기에 시간복잡도면에서 차이점이 없습니다.

contains(anEntry) // LinkedBag 같은 경우 getReferenceTo에서 O(n), ArrayBag 같은 경우 getIndexOf에서 O(n)입니다. 
저장공간의 처음부터 시작해 끝까지 찾아내는 매커니즘이기에 시간복잡도면에서 차이점이 없습니다.

## 2. 교과서 1장 - 3장에서는 ADT bag를 구현 했다. 이번에 구현하고자 하는 ADT Stack과는 어떤 것이 같고 어떤 것이 다른가? 비교해 보라.

bag와 stack의 같은 점은 어떠한 한 요소를 추가하고 제거할 때(bag는 remove(),stack은 pop() 함수) bag와 stack 모두 가장 최근에 
추가한 요소부터 제거하게 됩니다.
하지만 차이점으로는 stack은 객체가 추가된 순서에 의존성이 높은 부분에 사용되게 되고 bag는 객체의 추가된 순서가 상관없는 부분에 사용되게 됩니다.

bag는 자신이 원하는 entry를 bag에서 제거가 가능하지만 stack은 가장 상위에 있는 entry에 대해서만 접근이 가능하고 
그 아래 요소에 대해서는 접근이 제한됩니다.
stack은 가장 상위에 있는 entry를 제거 없이 가져올 수 있는 반면에 bag에서는 remove()없이는 entry만 따로 가져올 수는 없습니다.