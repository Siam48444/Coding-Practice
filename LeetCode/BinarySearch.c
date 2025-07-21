#include <stdio.h>


int search(int* nums, int numsSize, int target) {
    int left = 0;
    int right = numsSize - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }

        return -1;
    }
}

int main() {
    int test1 = {-1,0,3,5,9,12};
    int test2 = {-1,0,3,5,9,12};

    printf("%d", search(test1, 6, 9));
    printf("%d", search(test2, 6, 2));
}