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

### 5. `Stream.boxed() and Stream.toArray(Integer[]::new)`

Arrays.sort(arr, comparator) only works for Objects, not for primitive types.
So, to convert primitive array into Object array, use below code

```java
int[] nums = { 1, 2, 3 };
Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
int[] unboxed = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
```
## String Replacement Methods in Java

### 6. `replace`
* Replaces all occurrences of the target char/char sequence (literal, not regex).

**Example:**
```java
String s = "abcabc";
System.out.println(s.replace("a", "x")); 
// Output: xbcxbc   (all "a"s replaced)
```

### 7. `replaceFirst`
* Replaces only the first occurrence, and the target is treated as a regex.

**Example:**
```java
String s = "abcabc";
System.out.println(s.replaceFirst("a", "x"));
// Output: xbcabc   (only the first "a" replaced)
```

### 6. `replaceAll`
* Replaces all occurrences, but the target is treated as a regex.

**Example:**
```java
String s = "abcabc";
System.out.println(s.replaceAll("a", "x"));
// Output: xbcxbc   (all "a"s replaced, regex-based)
```

## ✅ Summary

- `replace` → all, no regex
- `replaceFirst` → first only, regex
- `replaceAll` → all, regex  
