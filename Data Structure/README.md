# Data Structure
@kuroega
Java Data Structure
## The Stranger whom you are familiar with

- ## Arraylist
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

- Implementation: newCapicity = capacity + capacity >> 1

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

### Properties

- Resizable Array
- Access: O(1)
- AddFirst: O(n)
- AddLast: O(1) **Amortized**
- RemoveFirst: O(n) (**no holes**: continuous mem address location)
- RemoveLast: O(1)
- Set: O(1)

- ## ArrayDeque

```java
ArrayDeque<Integer> a = new ArrayDeque<>();

a.addLast(1);

for (int i = 2; i <= 16; i ++) {
	a.addLast(i);
}
a.removeFirst();
a.addLast(17);
```
Recursive Sequence Queue

head/tail
[       ][][][][][][][][][][][][][][][]
head tail
[ 1 ][  ][][][][][][][][][][][][][][]

element[tail] = 1
tail = tail + 1 (**tail** is always the one being added a new element)

Removed head                                              tail
[     ][  2 ][3][4][5][6][7][8][9][10][11][12][13][14][15][  ]

**Add more?**

tail = (tail + 1) % length
tail head
[  ][ 2 ][3][4][5][6][7][8][9][10][11][12][13][14][15][16]

**Add One More?**
   head/tail
[][    2   ][3][4][5][6][7][8][9][10][11][12][13][14][15][16]

**Then...Add One More!**
Resize: 2x

**Why 2x Resizing?**


     head/tail
[17][   2     ][3][4][5][6][7][8][9][10][11][12][13][14][15][16]
 head              👇 copy                              tail
[ 2  ][3][4][5][6][7][8][9][10][11][12][13][14][15][16][ 17 ][][][][][][][][][][][][][][][][]

**At Last...**
```a.addFirst(1)```

head = (head - 1 + length) % length = 31
                                                     tail                               head
[2][3][4][5][6][7][8][9][10][11][12][13][14][15][16][ 17 ][][][][][][][][][][][][][][][][ 1 ]

### Porperties

- Resizable circular queue
- Access: O(1) **Amortized** (resize(copy data to new space) ~ similar to ArrayList)
- Access: O(1) **Amortized** (resize)
- RemoveFirst: O(1)
- RemoveLast: O(1)
- Set: O(1)

**When** do we use ArrayList/ArrayDeque?
- AddFirst: AD √
- AddLast: AL/AD √
- RemoveFirst: AD √
- RemoveLast: AD/AL √







