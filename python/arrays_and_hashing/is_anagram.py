import unittest

"""
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
"""

class IsAnagram:

    def is_anagram(self, s: str, t: str) -> bool: 
        if s is None or t is None:
            return False 
        # naive soln - add all elements of s to a dict of char: count and all elements of t to a similar dict and compute diff

        # more efficient soln (if characters are constrained by ascii) - array of fixed length initialized to 0
            # increment by 1 for each letter in s 
            # decrement by 1 for each letter in t 
                # edge case -> negative number, return False 
            # return whether the sum is 0

        counts = [0] * 26
        for c in s: 
            idx = ord(c) - ord('a') # lowercase a is smallest in ascii 
            counts[idx] += 1 
        for c in t:
            idx = ord(c) - ord('a')
            if counts[idx] == 0:
                return False 
            counts[idx] -= 1
        return sum(counts) == 0



class IsAnagramTest(unittest.TestCase):
    
    def test_same_string(self):
        self.assertTrue(IsAnagram().is_anagram("hello", "hello"))

    def test_same_string_shuffled(self):
        self.assertTrue(IsAnagram().is_anagram("olleh", "hello"))

    def test_slightly_different_strings(self):
        self.assertFalse(IsAnagram().is_anagram("racecars", "racecar"))

    def test_slightly_different_strings_by_character_count(self):
        self.assertFalse(IsAnagram().is_anagram("snakes", "snake"))

    def test_different_strings(self):
        self.assertFalse(IsAnagram().is_anagram("guava", "lemonade"))


if __name__ == "__main__":
    unittest.main()
