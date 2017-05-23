# Data Structure
@kuroega
Java Data Structure
## The Stranger whom you are familiar with

- Arraylist
Resizable array implementation (1.5x resizing)

```java
import java.util.ArrayList;

ArrayList<Integer> a = new ArrayList<>(); // size = 0, length = 0
a.add(1); // size = 1, length = 10

for (int i = 2; i <= 10; i++) {
	a.add(i); // size ++, length = 10
}

a.add(11); // length = 15, copy elements from old arraylist with length 10 to this new one with length 15
```

**Why 1.5x Resizing?**

```
1 -> X (discard 1 b/c GC)
      -> X^2 (discard X b/c GC)
         -> ...
```
More and more mem with empty content causes low efficiency

Primitive: 1 + x + x^2 + ... + x^(n-2) = x^n
=> x = 1.618 ~= 1.5 (b/c handling a float number with fewer faction numbers)

What is the **Time Complexity** of ArrayList element appending?

```
Amortized O(1)
                         |
                         |
                         |
                 |       |
                 |       |
O(1) _____|______|_______|
```

- Resizable Array
- Access: O(1)
- AddFirst: O(n)
- AddLast: O(1) Amortized
- RemoveFirst: O(n) (no holes: continuous mem address location)
- RemoveLast: O(1)
- Set: O(1)