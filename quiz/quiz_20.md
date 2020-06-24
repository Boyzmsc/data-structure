## 1. Tree 구조가 list와 다른 것이 무엇이고 왜 필요한가? 설명하라.

list의 데이터들은 linear한 order로 위치해 있습니다. 정확히 말하면 entry의 position에 따라 순서대로 위치해 있습니다. 
따라서 list의 개체는 차례대로 나타납니다.
반면에 Tree 구조는 데이터들을 nonlinear하게 위치하며, list와 달리 계층적으로 데이터들을 분류합니다.
따라서 Tree는 데이터들을 그룹과 하위 그룹으로 계층적으로 분류하고 싶을 때 필요합니다.

## 2. 683쪽 expression tree는 201쪽에 stack을 2개 사용하는 방식과 어떻게 다른가? 비교해보라

201쪽의 stack 2개를 이용한 Infix Expression은 하나의 stack에는 연산자만을 다른 하나의 stack에는 피연산자만을 넣은채로 진행합니다.
연산자를 담고 있는 stack에서 연산자의 우선순위를 고려해 피연산자를 담고 있는 stack에서의 두개의 피연산자와 연산을 진행한 뒤 결과값을 다시 피연산자 스택에 추가합니다. 
이런 방식으로 연산자 스택이 empty가 될 때까지 연산을 진행해 최종적으로 나온 결과값을 피연산자 스택에 추가하고 해당 결과값을 리턴합니다.
683쪽의 expression tree는 binary tree를 이용했습니다. 전체 tree와 leaves를 가지고 있는 subtree들의 root들이 연산자를 가지고 있으며, 해당 root의 children이 연산자에 대한 피연산자들을 가지고 있는 형태로 구성되어 있습니다.
따라서 해당 expression tree를 inorder traversal로 돌게 되면, infix expression 형태의 식이 나오게 되며, tree를 도는 traversal 방식에 따라 prefix expression, postfix expression 형태로도 식이 나올 수 있습니다.
또한 expression tree는 201쪽에서 사용하는 방식과 달리 괄호 없이 연산 expression의 순서를 파악하고 구성할 수 있습니다.