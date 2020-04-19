## 堆数据结构的特点
## 堆的创建
## 堆的节点删除
## 堆的节点新增

## PriorityQueue的实现是如何使用堆数据结构的
PriorityQueue内部使用的是一个小顶堆来实现的
### 创建/初始化PriorityQueue
### offer()
- 往数组的最后一个位置插入元素
- 元素不断与父节点比较，如果小于父节点，则交换位置，大于等于父节点或达到根节点则停止
```java
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
```
```java
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }
```
```java
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
```
### peek()
- 查看第一个元素不涉及移除，所以只需把最小的元素（数组位置0）取一下就好了
```java
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }
```
### poll()
- 将第一个元素取出，并移除掉
- 将最后一个元素放到第一个位置，不断与左右子节点比较
- 如果大于右子节点则与右子节点交换
- 小于右子节点，大于左子节点，则与左子节点交换
- 小于左子节点则结束
```java
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }
```
```java
    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }
```
```java
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
```

