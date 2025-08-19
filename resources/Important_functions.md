## 📌 IMPORTANT FUNCTIONS

### 1. `Arrays.copyOfRange()`

Copies a specified range from the original array.

```java
int[] original = {1, 2, 3, 4, 5};
int[] copy = Arrays.copyOfRange(original, 1, 4); // [2, 3, 4]
```

### 2. `Arrays.toString()`

Returns the string representation of the 1D Array.

```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
```

### 3. `Map.replace(key, element)`

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Two");
map.replace(1, "One");
```

### 4. `Arrays.sort(arr, comparator)`

Sort the Array with custom order using lambda expression.

```java
int[][] arr = { {1, 100}, {2, 50}, {3, 65}, {4, 92} };
Arrays.sort(arr, (a, b) -> arr[1] - arr[2]);
```


