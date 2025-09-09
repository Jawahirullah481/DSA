class Temp {

    public static void main(String[] args) {
        int count = 1;
        int num = 2;

        while(count <= 26) {
            if(isPrime(num)) {
                System.out.print(num + ", ");
                count++;
            }
            num++;
        }
    }

    public static boolean isPrime(int num) {
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        int x = num / 2;
        while(x >= 2) {
            if(num % x == 0) return false;
            x--;
        }

        return true;
    }
}