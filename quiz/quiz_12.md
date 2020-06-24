## 1. selection sort와 insertion sort는 각각 어떻게 하는 것이고 어떤 경우에 유리한가? 설명하라
selection sort는 이름에 맞게 현재 위치에 들어갈 값을 찾아 정렬하는 알고리즘입니다. 정렬 되지 않은 인덱스의 맨 앞에서부터, 이를 포함한 그 이후의 배열값 중 가장 작은 값을 찾고, 가장 작은 값을 찾으면 그 값을 현재 인덱스의 값과 swap해줍니다. 배열의 끝까지 이 과정을 반복합니다. 배열이 어떻게 상태이던지 간에 전체 비교를 진행하므로 시간복잡도는 O(n^2)입니다.
insertion sort는 현재 위치에서 그 이하의 배열들을 비교하여 자신이 들어갈 위치를 찾아, 그 위치에 삽입하는 정렬 알고리즘입니다. 두 번째 인덱스부터 시작하며, 현재 인덱스의 값과 이전 인덱스들의 값을 비교하며, 이전 인덱스 값에서 현재 인덱스의 값보다 큰 변수가 나오면 현재 인덱스의 값과 해당 값을 swap해줍니다. 만약 현재 인덱스의 값이 이전 인덱스들의 값보다 크면, 현재 인덱스값을 그대로 현재 인덱스 위치에 놔둡니다. insertion sort는 최악의 경우(역으로 정렬되어 있는 배열)엔 n-1,n-2,...1개씩 비교를 하여 시간복잡도가 O(n^2)이 되지만,이미 정렬되어 있는 배열의 경우에는 한번씩만 비교를 하기 때문에 시간복잡도는 O(n)이 됩니다. 
따라서 어떠한 경우에도 시간복잡도가 O(n^2)인 selection sort에 비해 최고의 경우에는 시간복잡도가 O(n)이고 최악의 경우에만 시간복잡도가 O(n^2)인 insertion sort를 이용하는 것이 더욱 유리합니다.

## 2. shell sort의 기본 아이디어는 뭔가? 즉, 어떻게 performance를 향상 시키겠다는 것인지 설명해 보라

shell sort의 기본 아이디어는 삽입 정렬을 하기 전에 정리를 어느정도 해놓는 것입니다. 따라서 어느정도 정렬되어 있는 상태에서의 삽입정렬의 빠른 연산과 시간 복잡도를 이용하자는 개념입니다. 
shell sort는 데이터를 gap만큼 특정 간격 씩 묶어서 그룹화를 한 뒤, 그룹별로 삽입정렬을 수행합니다. 
이후 gap을 다시 줄이고 그룹화 및 그룹별 삽입정렬을 수행합니다. 간격(gap)은 결국 1이 되며, 1이 될 때는 전체 삽입 정렬을 수행하는 것과 동일합니다. 
하지만 이때의 배열은 이미 어느정도 정렬이 되어 있는 상태이기 때문에, 삽입 정렬에 소모되는 시간과 연산이 줄어들게 됩니다. 
따라서 이러한 과정을 통해 정렬을 효율적으로 수행할 수 있게 됩니다.