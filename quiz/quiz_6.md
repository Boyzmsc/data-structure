## 1. 교과서 151쪽 부터 나오는 방법들(3.25 와 3.27)이 앞의 방법과 다른 점은 무엇이고 이렇게 하는 이유는 뭔가? 설명하라.

교과서 151쪽부터 나오는 3.25와 3.27예제는 각각 Node가 LinkedBag의 내부클래스로 선언되어 있는 경우와

package문을 통해 같은 package의 클래스들만 접근하도록 설정해 놓은 경우입니다.

이 두 예제에서는 앞의 방법들과 다르게 get과 set 메서드를 만들어 주었는데,

get메서드는 Node클래스의 private한 변수들을 그 변수의 이름으로 가져오는 것이 아닌 메서드를 통해 가져오게끔 만들고,

set메서드는 Node클래스의 private한 변수들을 그 변수의 이름으로 가져와 수정하는 것이 아닌 메서드를 통해 수정하게끔 만들어줍니다.

이렇게 변수 필드들을 private 접근 제한자로 막아두고 set과 get 메서드를 구현해줌으로써 객체들의 

데이터를 외부에서 직접적으로 접근하는 것을 막아주고 객체의 무결성을 보장할 수 있습니다.

## 2. 교과서 155쪽 exercise 3.

```java
public boolean replace(T anEntry){

        boolean replace = false;

        T entry = remove();

        replace = add(anEntry);

        return replace;

}
```

