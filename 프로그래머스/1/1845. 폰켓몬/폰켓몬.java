
/*
3 1 2 3
N = 4;
N/2
NCN/2
    
3 1
1 3
3 3 = 1

1 2 3
[]=8
[]

=8
3124 213412 412543 43 53523 62436 23523 44
N = 8;
4개
 4개
 
 N/2 <- 최대값이 된다
 1 1 1 1 1 1
 3 
 1
 
 이 문제에서 최대값은 N/2가 되지만
 이 경우는 모


3 3 3 3



if 해시에 이미 값이 있나요? -> 중복이다
else -> 처음이야 cnt++;

if cnt >= N/2 -> N/2
else -> cnt
1 2 3 4 5 6
1 1 1 1 2 2


*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0 ;i<nums.length;i++){
            set.add(nums[i]);
        }
        int size = set.size();
        int numsSize = nums.length;
        if(size < numsSize / 2){
            answer = size;
        }
        else {
            answer = numsSize / 2;
        }
        return answer;
    }
}