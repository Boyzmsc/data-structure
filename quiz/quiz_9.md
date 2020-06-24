## 1. 교과서 207쪽 exercise11.

stack을 이용해 palindrome을 만들 때,
빈칸(space)과 문장부호를 무시하기 때문에 java string에 replace(),replaceAll() 함수를 이용해서 기존 문자열의 
모든 빈칸(space)과 문장부호를 공백("")으로 바꿔줍니다.

또한 exercise11 예제에서, 대소문자 구분도 안하기 때문에 java string에 toUpperCase() 함수를 이용해 기존 문자열의 모든 영문자를 대문자로 바꿔줍니다.

기존 문자열에 길이만큼의 for문을 돌려 문자열 첫번째 문자부터 stack에 차례대로 push()해 줍니다.

그렇게 되면 stack에는 맨 아래 요소부터 가장 위쪽 요소까지 모든 문자가 순서대로 쌓여있게 됩니다.

기존 문자열과 비교할 string temp를 만들고 가장 위쪽 요소부터 맨 아래 요소까지 pop() 함수를 이용해 temp에 순서대로 추가해주면,
temp는 기존 문자열 내용의 거꾸로 되어 있는 문자열 내용을 가지게 됩니다.

기존 문자열이 palindrome일 시, 기존 문자열과 temp는 똑같은 내용의 string일 것입니다.

따라서 기존 문자열과 temp의 내용을 비교해 줌으로써 기존 문자열이 palindrome인지 아닌지 stack을 이용해 확인할 수 있습니다.

```java
public boolean isPalindrome(string s){

        string k = s.replaceAll("\s",""); //빈칸 없앰

        k = k.replaceAll("\W",""); //문장부호 없앰

        k = k.toUpperCase();

        for(int i = 0; i< k.length(); i++){

                stack.push(k[i]);

        string temp = "";

        while(topIndex>=0){

                temp += stack.pop();

        if(k.equals(temp)){

                return True;

        }else{

                return False;
        }
}
```



## 2. 교과서 217쪽 6.11. 아래 줄에 To be safe, pop can set … 이게 뭔 뜻인가? stack[topIndex]= null로 하지 않으면 어떻게 되는가? 설명하라.

stack[topIndex] = null을 하지 않게 되면, 오로지 topIndex만 감소하는 추세로 pop()함수를 동작하게 되는데,
이 경우 기존에 top entry이었던 object들이 사라지지 않고 array에 계속 남아있게 됩니다.
그렇게 되면, 이미 pop()으로 인해 신경쓰지 않아도 되는 object들이 메모리를 차지하고 있을 뿐더러,아직 array에 남아있기 때문에 
원래의 pop()함수의 의도대로 흘러가지 않아 혼란을 초래할 수 있습니다. 
따라서 stack[topIndex] = null을 통해 기존의 top object를 array에서 없앰으로써 pop()함수를 구현해주어야 합니다. 