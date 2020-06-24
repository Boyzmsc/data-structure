## 1. 교과서 15장에서는 List에 iterator를 달아 놓는 방법에 대해 이야기 하고 있다. 즉, Separate Class Iterator와 Inner Class Iterator가 있을 수 있다. 두가지 방식을 비교 분석 해보라. 어떤 것이 어떤 경우에 좋고 그 비용은 어떠한지 설명해 보라.

Separate Class Iterator는 말 그대로 ADT를 implement하는 클래스와 분리된 public한 클래스의 iterator을 만드는 방법이고 Inner Class Iterator는 ADT를 implement하는 클래스의 내부 클래스로 iterator을 만드는 방법입니다.
Separate Class Iterator는 ADT 데이터에 접근할 때 반드시 ADT의 operation(public method)을 통해 접근해야 합니다.
이러한 부분으로 인해, 만약 특정 ADT가 해당 ADT의 데이터에 접근하도록 하는 operation이 충분하지 않다면 문제가 될 수 있습니다.
그리고 ADT 데이터에 indirect하게 접근하기 때문에 다른 iterator 방법보다 시간소요가 더욱 많습니다.
하지만, Separate Class Iterator를 구현하는 것은 대체로 복잡하지 않고 간단하며, 동시에 여러개의 독립적인 Separate Class Iterator를 가질 수도 있습니다.
Inner Class Iterator는 Separate Class Iterator와 마찬가지로 여러개의 독립적인 iterations을 동시에 가질 수 있으며, Inner Class Iterator는 내부 클래스로 구현되었기 때문에 ADT 데이터 필드에 direct하게 접근할 수 있어 Separate Class Iterator보다 더욱 빠르게 iterator을 수행합니다.
하지만 대체로 Inner Class Iterator를 구현하는 것은 복잡합니다.
따라서 Iterator를 쉽게 구현하고 싶은 경우에는 Separate Class Iterator가 좋으며, Iterator 수행을 빠르게 진행하고 싶은 경우에는 Inner Class Iterator가 적합합니다

## 2. 그래서 달아 놓으면 좋아지는 것은 무엇일까? 치러야 하는 비용은 뭘까? 즉 무엇을 주고 무엇을 얻는 일인지 설명해 보라.

결국 선호되는 방법은 Inner Class Iterator이며, Inner Class Iterator로 구현함으로써 ADT 데이터 필드에 direct하게 접근할 수 있어 iterator를 보다 빠르게 수행할 수 있으며, 여러개의 독립적인 iterations을 동시에 가질 수 있습니다.

하지만 Inner Class Iterator를 구현하는 것은 대체로 복잡하므로, 
결론적으로 Inner Class Iterator를 사용하면, 구현의 복잡함을 주고 빠른 iterator 수행 속도를 얻게 됩니다.