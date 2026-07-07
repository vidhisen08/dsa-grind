class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        long place = 1;
        while(n>0){
            int last = n % 10;
            if(last!=0){
                sum = sum + last;
                num = last * place + num;
                place = place*10;
            }
            n = n/10;
        }
        return  num * sum;
    }
}