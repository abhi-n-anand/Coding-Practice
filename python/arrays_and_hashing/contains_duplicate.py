import unittest

"""
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
"""

class ContainsDuplicate: 

    def contains_duplicate(self, arr) -> bool:
        if (arr is None) or len(arr) == 0:
            return False 

        seen = set()

        for n in arr: 
            if n in seen:
                return True 
            seen.add(n)
        return False 


class ContainsDuplicateTest(unittest.TestCase):

    def test_none(self):
        cd = ContainsDuplicate()
        self.assertFalse(cd.contains_duplicate(None))

    def test_unique(self):
        cd = ContainsDuplicate()
        self.assertFalse(cd.contains_duplicate([1, 2, 3, 4, 5, 6]))
    

    def test_non_unique(self):
        cd = ContainsDuplicate()
        self.assertTrue(cd.contains_duplicate([1, 2, 3, 4, 4, 6]))


if __name__ == "__main__":
    unittest.main()
