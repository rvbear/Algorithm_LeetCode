class Solution {
    public int helper(int num) {
        int answer = 0;
        int last = num % 10;
        num /= 10;
        int curr = num % 10;
        num /= 10;

        while (num > 0) {
            int next = num % 10;
            num /= 10;

            if ((curr > last && curr > next) || (curr < last && curr < next)) {
                answer++;
            }

            last = curr;
            curr = next;
        }

        return answer;
    }

    public int totalWaviness(int num1, int num2) {
        int answer = 0;

        for (int i = num1; i <= num2; i++) {
            if (i < 100) {
                continue;
            }

            answer += helper(i);
        }

        return answer;
    }
}
