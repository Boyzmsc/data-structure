## 1. Quick Sort의 기본 아이디어는 뭔가? Merge Sort와는 어떻게 다른가? 설명하라.
Quick Sort의 기본 아이디어는 기준이 되는 pivot 숫자를 정하고 pivot 보다 작은 원소면 왼쪽으로, pivot 보다 큰 원소면 오른쪽으로 이동합니다.
해당 교재에서는 배열의 첫번째, 중간, 마지막 원소를 선 정렬하고 중간에 있는 값을 pivot으로 선택한 후, 나머지 남은 원소에 대해서 partition을 진행합니다.
이때 재귀 호출을 이용해 quick sort를 반복 동작하게 되는데, 배열의 크기가 특정 사이즈보다 작으면 Insertion Sort를 이용해 적은 수의 원소들을 정렬해줍니다.
Merge Sort는 배열을 두 개의 균등한 크기의 배열로 분할하면서 하나의 단위까지 분할한 후, 분할한 배열들을 정렬하면서 다시 합하여 결국 전체가 정렬된 배열을 만드는 점에서 Quick Sort와 차이점이 있다고 할 수 있습니다.
또한 Merge Sort는 어떠한 case에도 O(nlogn)의 시간복잡도를 가지고 있지만,
Quick Sort는 평균적인 case가 O(nlogn)이며, 각각의 partition 과정에서 한개의 비어져있는 subarray가 나오면, 두번의 recursive call에서 하나의 call에서는 아무 동작을 안하고, 나머지 call에서 n-1개의 원소들을 정렬하기 때문에 최악의 case에서는 시간 복잡도가 O(n^2)이 됩니다.
마지막으로 Quick Sort는 Merge Sort와는 달리 추가적인 메모리를 요구하지 않습니다.

## 2. 지금까지 본 Data structure들과 Queue는 어떤 면이 비슷하고 어떤 면이 다른가? 그래서 어떤 경우에 사용 하는가? 설명해 보라.

Queue는 first-in,first-out이라는 성격을 가지고 있는데, 이는 last-in,first-out의 성격을 가지고 있는 Stack과는 다르다고 할 수 있습니다. 또한 첫번째 entry외에 나머지 entry에 대한 접근이 제한되어있는 점에서 순서에 상관없이 특정 entry에 접근하고 remove할 수 있는 Bag와 다르다고 할 수 있습니다.
Queue는 해당 원소의 첫번째 entry에만 접근할 수 있고 나머지 원소들에 대한 접근은 제한되어 있는데, 이러한 점은
마지막 entry에만 접근 할 수 있는 Stack과 비슷하다고 할 수 있습니다.
이러한 경우로 보았을 때, Queue는 데이터를 입력된 시간 순서대로 처리하고 싶을 때 사용합니다.