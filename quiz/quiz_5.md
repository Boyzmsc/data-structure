## 1. 2장과 3장에서는 각각 1장의 ADT bag를 구현 했다. 어떤 방식이 어떤 경우에 좋고 어떤 경우에 나쁜가? 비교해 보라.

chain 장점:
linked data를 이용하면 메모리는 데이터가 필요할 때만 사용되며 필요없어진 메모리는 시스템에 리턴할 수 있습니다.
즉 bag의 공간이 필요할 때만 늘리고 필요 없을때는 공간을 줄일 수 있는 유동적인 구조를 갖게 됩니다.
또한 bag entry를 제거하거나 추가할 때 데이터의 이동을 피할 수 있어, 메모리와 시간의 낭비를 방지하게 됩니다.

chain 단점:
같은 길이의 array와 chain이라고 했을 때 특정한 entry를 제거함에 있어 chain이 array 보다 더 많은 메모리와 시간을 소비하게 됩니다.

array 장점:
bag에 entry를 추가하는 것이 빠릅니다.
불특정한 entry를 제거하는 것이 빠릅니다.
특정한 entry를 제거할 때 chain에 비해 index로 접근하기 때문에 
더 적은 시간과 메모리를 소비할 수 있습니다.

array 단점:
array는 한정된 크기를 가지고 있으며 몇개의 낭비되는 공간을 가지고 있을 수도 있습니다.
또한 bag의 공간이 다 찼을 때, 더큰 크기의 새로운 array를 만들어 옮겨주면 되는데 이 과정에서 메모리와 시간의 소비가 발생하게 됩니다.

따라서 bag에 대해서 크기를 정확히 알고, 특정 entry에 대해서 접근하거나 추가,제거의 기능을 빠르게 수행하고 싶을 때는 array를 사용하는 것이 좋고, bag의 정확한 크기를 모른채 계속해서 들어오는 entry에 대해서 이 경우 데이터의 이동이 필요 없는 chain을 사용하는 것이 더욱 바람직합니다. 또한 메모리의 낭비를 최소한으로 줄이고 싶을 때 chain을 사용하는 것이 좋습니다.

## 2. 교과서 141쪽 figure3-7위의 code 를 아래와 같이 바꾸면 어떤 일이 일어날까? 설명하라.
 Node newNode = new Node(newEntry);
 firstNode = newNode;
 newNode.next = firstNode;

두번째 줄인 firstNode = newNode;에서 첫번째 줄에서 만든 newNode를 firstNode에 할당하게 되는데, 이 경우 firstNode가 이전에 생성되었던 노드를 가리키는 경우가 되지 않고 지금 새로 생성된 노드만을 가리키게 됩니다. 이럴 경우 세번째 줄에서 newNode의 next라는 Node객체에 자기자신이 할당되기 때문에 toArray() 메서드에서 모든 node들의 data를 못 가져오는 에러가 발생하게 됩니다. 또한 이전에 생성되었던 node들과의 연결이 되지 않습니다.