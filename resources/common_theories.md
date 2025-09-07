# 📝 Notes: 

# 1. Encoding Two Numbers into One Integer

## 🔑 General Idea

Store two numbers `a` and `b` inside one integer `x` using a known bound `N`.

**Formula:**

- **Encode:**  
  `x = a + N * b`

- **Decode:**  
  `a = x % N`  
  `b = x / N`

---

## ✅ When It Works (Constraints)

- **Bounded values** → Both `a` and `b` must be `< N`.
- **No overflow** → `x = a + N * b` must fit in chosen data type (`int` or `long`).
- **Non-negative values** → Works directly if `a, b ≥ 0`.  
  For negatives, apply an offset before encoding.
- **Same N for encode & decode** → Must use identical `N` in both steps.
- **Integer division** → Decoding requires exact integer division (no floating-point).

---

## ⚙️ Example

If `N = 5`, and  
`a = 3, b = 4`

```java
x = 3 + 5 * 4 = 23
a = 23 % 5 = 3
b = 23 / 5 = 4
```
---

## 📌 Use Cases

- In-place array transformations (avoid extra space).
- LeetCode tricks (e.g., marking visited numbers without extra array).
- Pair encoding (store coordinates or two values compactly).

---

# 2. Negative Marking Trick for Visited Elements

## 🔑 General Idea

Given an array of numbers where each value maps to an index,  
use the **sign of the value** at that index to mark whether it’s been visited.

**Steps:**

1. For each number `num`, compute its index:
```text 
idx = abs(num) - 1
```

2. If `nums[idx]` is positive → mark it as visited by flipping sign:  
```text
nums[idx] = -nums[idx]
```

3. If `nums[idx]` is already negative → it means `num` has been seen before (duplicate).

---

## ✅ When It Works (Constraints)

- All numbers must be in the range **1 … n** (so they map to valid indices).
- The array can be modified (we’re allowed to change signs).
- Works with **non-zero positive integers only** (since 0/negatives would break sign logic).

---

## ⚙️ Example

**Input:**
`nums = [4, 3, 2, 7, 8, 2, 3, 1]`

**Process:**
```textmate
4 → idx = 3 → mark nums[3] = -7
3 → idx = 2 → mark nums[2] = -2
2 → idx = 1 → mark nums[1] = -3
7 → idx = 6 → mark nums[6] = -3
8 → idx = 7 → mark nums[7] = -1
2 → idx = 1 → nums[1] already negative → duplicate = 2
3 → idx = 2 → nums[2] already negative → duplicate = 3
1 → idx = 0 → mark nums[0] = -4
```

**Duplicates found:**  

---

## 📌 Use Cases

- Find duplicates (**LeetCode 442 – Find All Duplicates in an Array**).
- Find missing numbers (**LeetCode 448 – Find All Numbers Disappeared in an Array**).
- Any time you need to **track visited elements without extra space**.

