## 1. 교과서 257쪽 exercise 5

```java
void reverseArray(int[] x, int start, int end){

  	if(start<end){

    	int tmp = x[start];

    	x[start] = x[end];

    	x[end] = tmp;

    	reverseArray(x, ++start, --end);

  	}
}

```



## 2. 교과서 249쪽 “A poor solution to a simple problem”에서는 Fibonacci 수열의 합을 구하는 프로그램을 recursion을 사용해서 구하는 방법을 보였다. 무엇이 문제이고 어떻게 하면 된다는 이야기 인가? 교과서에서 하고자 하는 이야기가 뭔지 설명하라.

249쪽에서의 Fibonacci 수열의 합을 구하는 프로그램은 한 알고리즘에서 recursive call을 두번하게 됩니다. 이 경우 같은 recursive call이 반복적으로 일어나 efficiency가 감소하는 문제가 발생하게 되는데, recursive solution 대신 iterative solution을 이용해 프로그램을 구현해줌으로써 efficiency를 해결해주었습니다.
결론적으로, recursive solution을 사용한 프로그램이 더욱 간단하고 명료하게 보일지라도, recursive calls에서 동일한 동작이 반복적으로 나타나는 recursive solution은 efficiency 측면에서 안좋기 때문에 사용하면 안됩니다. 