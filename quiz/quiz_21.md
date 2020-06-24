## 1. 교과서 478쪽 15-3과 151쪽 3장의 Listing 3-4를 가지고 List라는 자료구조를 구현 한 적이 있다. 교과서 705쪽 Listing 24-1과 70쪽 Listing 24-2로 Binary Tree를 구하고 있다. 비교 해 보라. 뭐가 달라지고 뭐가 같은 지 설명 해 보라.

차이점은, Listing 3-4 를 이용한 Listing 15-3은 Node 클래스를 private하게 Inner Class로 구현하고 있으나, 
Listing 24-1 를 이용한 Listing 24-2 은 BinaryNode 클래스를 Binary Tree 클래스 밖에서 정의하고 있으며 접근 지정자를 뺀 상태로 package 구문을 사용함으로써 client로부터 클래스의 detail을 숨겼고 범위를 지정해주었습니다. 또한 Listing 3-4 에서는 다음 Node를 가리키는 next라는 Node 객체를 만들어 주었지만, Listing 24-1 에서는 BinaryTree를 구현하는 것이기 때문에 leftChild와 rightChild를 가리키는 각각의 BinaryNode 객체를 만들어 주었습니다.

같은점은, Listing 3-4와 Listing 24-1에서는 Node와 BinaryNode 클래스의 private한 data에 접근하기 위한 accessor와 mutator (set and get) methods를 구현하고 있습니다.



## 2. 교과서 708쪽 privateSetTree의 문제는 무엇이고 어떻게 풀겠다는 이야기 인지 설명해 보라.

708쪽의 privateSetTree으로 treeA.setTree(a, treeB, treeC)를 수행하게 되면, 만약 client가 treeB를 change하면 그에 따라 treeA도 change되는 상황이 발생하게 됩니다.
따라서 이에 따라 treeB와 treeC를 copy함으로써 treeB와 treeC를 treeA와 구별해줌으로써, treeB와 treeC가 변해도 treeA에 영향이 안가도록 문제를 해결해주었습니다.
하지만 Node들을 copy하는 것은 expensive하기 때문에, 교과서에서는 다른 해결책도 제시하였습니다.
또한 treeA.setTree(a, treeA, treeB)처럼 setTree를 호출하고 있는 자기자신이 매개변수로도 들어가게 되었을 때, 만약 privateSetTree가 subtree들을 empty하게 만든다면, 결국에는 treeA를 destroy하게 되는 상황이 발생하게 되고, treeA.setTree(a, treeB, treeB)처럼 두개의 BinaryTree를 가리키는 매개변수가 같은 것으로 들어갈 때에도 문제가 발생하게 됩니다.
따라서 이를 해결하기 위해, treeA.setTree(a, treeB, treeB)처럼 두개의 BinaryTree를 가리키는 매개변수가 같은 것으로 들어갈 때에는 leftChild에는 treeB를 그리고 rightChild에는 treeB를 copy한 Node를 할당해줌으로써 해결해주었고, treeA.setTree(a, treeA, treeB)처럼 자기자신이 매개변수로 들어가게 되었을 때, subtree를 empty하게 만들지 않도록 조건문을 이용해 해결해주었습니다.