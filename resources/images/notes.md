1. In array problems, **if you find a solution**, then try to find the **optimal solution**.


2. In array problems, optimal solutions mostly use:
    - **Frequency Array** (if constraints are limited)
    - **HashMap**
    - **Mathematical/Calculation-based Method**
    - **Prefix Sum / Suffix Sum Arrays**
    - **Sorting + Binary Search**
    - **Two Pointers / Sliding Window**

> ✅ So, try to apply the above three methods one by one to figure out the optimal solution.

3. In array rotation problems, if it is n x n array, you can definitely swap 2 numbers.
   But, if it is m x n array, number of rows and column will differ for current array and rotated array. So, you shouldn't swap. You have to traverse each element one by one.

# 4.  Bound and Upper Bound (Binary Search)

When working with sorted arrays, **lower bound** and **upper bound** are common concepts to find insertion points for a target value.

**NOTE** : *Upper/Lower* Bound doesn't mean *Ceil/Floor* of a number. You have to mind it

---

## ✅ Lower Bound (Inclusive of Target)

- Finds the **first index `i`** where `arr[i] >= target`.
- Think of it as:  
  **"Where can I place `target` without breaking the sorted order, on the leftmost side?"**

### Example:
```text
arr = [1, 3, 3, 5], target = 3
lower_bound(3) = index 1 (first 3)
```

---

## ✅ Upper Bound (Exclusive of Target)

- Finds the **first index `i`** where `arr[i] > target`.
- Think of it as:  
  **"Where can I place `target` if I want to go after all equal elements?"**

### Example:
```text
arr = [1, 3, 3, 5], target = 3
upper_bound(3) = index 3 (element 5)
```

---

### Example of all methods:
```java
import java.util.Arrays;

public class FloorCeilFinder {

    // ✅ Lower Bound (Inclusive) -> first index where arr[i] >= target
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // insertion index
    }

    // ✅ Upper Bound (Exclusive) -> first index where arr[i] > target
    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // insertion index
    }

    // ✅ Floor (Inclusive) -> greatest element <= target
    public static int floorInclusive(int[] arr, int target) {
       int idx = upperBound(arr, target);
       return (idx > 0) ? arr[idx - 1] : -1; // -1 if no floor exists
    }

    // ✅ Floor (Exclusive) -> greatest element < target
    public static int floorExclusive(int[] arr, int target) {
        int idx = lowerBound(arr, target);
        return (idx > 0) ? arr[idx - 1] : -1;
    }

    // ✅ Ceil (Inclusive) -> smallest element >= target
    public static int ceilInclusive(int[] arr, int target) {
        int idx = lowerBound(arr, target);
        return (idx < arr.length) ? arr[idx] : -1;
    }

    // ✅ Ceil (Exclusive) -> smallest element > target
    public static int ceilExclusive(int[] arr, int target) {
        int idx = upperBound(arr, target);
        return (idx < arr.length) ? arr[idx] : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 7, 9};
        int target = 3;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        System.out.println("Lower Bound (inclusive): index = " + lowerBound(arr, target));
        System.out.println("Upper Bound (exclusive): index = " + upperBound(arr, target));

        System.out.println("Floor (inclusive): " + floorInclusive(arr, target));
        System.out.println("Floor (exclusive): " + floorExclusive(arr, target));

        System.out.println("Ceil (inclusive): " + ceilInclusive(arr, target));
        System.out.println("Ceil (exclusive): " + ceilExclusive(arr, target));
    }
}

```
# Important Note :

```text
1. Lower Bound     -> Ceil Inclusive of Target
2. Upper Bound     -> Ceil Exclusive of Target
3. Floor Inclusive -> but opposite of lower bound in reverse
4. Floor Exclusive -> opposite of upper bound in reverse

✅ Rule of thumb

* If you’re searching for an index in a sorted array → use [low, high) and return low.
* If you’re searching for the maximum/minimum value that satisfies a condition → use [low, high] and track ans.
```

## 5. Ceiling Without Math.ceil (Efficient)

We can compute the ceiling of a division without using `Math.ceil` by using this formula:

ceil(a / b) = (a + b - 1) / b

---

## ✅ Example 1
- **a = 10, b = 3**

**Step 1:** Normal division  
`10 / 3 = 3.33`

**Step 2:** Apply ceiling  
`ceil(3.33) = 4`

**Step 3:** Using formula  
`(10 + 3 - 1) / 3 = 12 / 3 = 4`

✔ Both give the same result!

---

## ✅ Example 2
- **a = 12, b = 3**

**Step 1:** Normal division  
`12 / 3 = 4`

**Step 2:** Apply ceiling  
`ceil(4) = 4`

**Step 3:** Using formula  
`(12 + 3 - 1) / 3 = 14 / 3 = 4`
---

### Why does this work?
- Adding **(b - 1)** ensures that any remainder from the division "pushes" the result to the next integer, mimicking the ceiling effect.
- If `a` is already divisible by `b`, the subtraction of **1** prevents overshooting to the next integer.

