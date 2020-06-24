## 1. 교과서 295쪽 8.a)

```java
void bubbleSort(int[] x, int start, int end){
         int temp;
         for(int i = start ; i < end ; i++) {
           for(int j = start ; j < end-i-1 ; j++) {
                if(x[j] > x[j+1]) {
                        temp = x[j];
                        x[j] = x[j+1];
                        x[j+1] = temp;
                }
           }
    	}
 }
```



## 2. merge sort는 8장에서 배운 sorting 방법들 보다 그 performance특성이 월등히 좋다. 어떻게 이런 결과를 얻게 되었는지 그 키가 되는 아이디어를 설명해 보라.
merge sort는 배열을 두 개의 균등한 크기의 배열로 분할하면서 하나의 단위까지 분할한 후, 분할한 배열들을 정렬하면서 다시 합하여 전체가 정렬된 배열을 만드는 방법입니다.
merge sort의 알고리즘을 구체적으로 접근하자면,
merge sort는 배열을 같은 크기의 2개의 부분 배열로 분할하면서, 부분 배열들을 정렬합니다.
이 과정에서 추가적인 배열(temporary array)이 필요합니다.
부분 배열의 원소의 개수가 2개 이상이라면, recursive call을 이용하여 다시 해당 배열을 분할합니다.
부분 배열의 원소의 개수가 1개라면, 두 부분 배열을 하나의 배열(temporary array)에 정렬하면서 합병합니다.
전체 원소가 정렬된 배열을 합병할 때까지 진행합니다. 
마지막으로 합병된 배열(temporary array)을 원래의 배열에 복사합니다.