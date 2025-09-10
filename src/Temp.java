class Temp {

    public static void main(String[] args) {
        String str = reverse("jawahirullah");
        System.out.println(str);
    }

    private static String reverse(String str) {
        int st = 0, end = str.length() - 1;

        while(st < end) {
            String str1 = str.substring(0, st);
            String str2 = str.substring(st, st + 1);
            String str3 = str.substring(st + 1, end - 1);
            String str4 = str.substring(end, end + 1);
            String str5 = str.substring(end + 1);

            str = str1 + str4 + str3 + str2 + str5;
            st++;
            end--;
        }

        return str;
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