import pytest


def test_compare_lists_greater():
    list1 = [1, 2, 3]
    list2 = [1, 2, 2]
    comparer = ListComparer(list1, list2)
    assert comparer.compare_lists() == "Первый список имеет большее среднее значение"

def test_compare_lists_smaller():
    list1 = [1, 2, 2]
    list2 = [1, 2, 3]
    comparer = ListComparer(list1, list2)
    assert comparer.compare_lists() == "Второй список имеет большее среднее значение"

def test_compare_lists_equal():
    list1 = [1, 2, 3]
    list2 = [1, 2, 3]
    comparer = ListComparer(list1, list2)
    assert comparer.compare_lists() == "Средние значения равны"

def test_compare_lists_empty_lists():
    list1 = []
    list2 = []
    comparer = ListComparer(list1, list2)
    assert comparer.compare_lists() == "Средние значения равны"



class ListComparer:
    def __init__(self, list1, list2):
        self.list1 = list1
        self.list2 = list2

    def calculate_average(self, lst):
        if len(lst) == 0:
            return 0
        return sum(lst) / len(lst)

    def compare_lists(self):
        average1 = self.calculate_average(self.list1)
        average2 = self.calculate_average(self.list2)

        if average1 > average2:
            return "Первый список имеет большее среднее значение"
        elif average2 > average1:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"
