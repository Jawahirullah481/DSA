class Temp {

    public static void main(String[] args) {
        String str = "XXXXXLXXXX";
        String res = "LXXXXXXXXX";

        boolean ans = canTransform(str, res);
        System.out.println(ans);
    }

    public static boolean canTransform(String start, String result) {

        String str = start;

        while(true) {

            int swaps = 0;
            for(int i = 0; i < start.length(); ) {
                if(str.equals(result)) return true;

                if(str.charAt(i) == result.charAt(i)) {
                    i++;
                } else if (i < start.length() - 1) {
                    String sub1 = str.substring(i, i + 2);
                    if(sub1.equals("XL") || sub1.equals("RX")) {
                        String rev = sub1.equals("XL") ? "LX" : "XR";
                        str = str.substring(0, i) + rev + str.substring(i + 2);
                        i += 2;
                        swaps++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }

            if(swaps == 0) break;

        }

        return str.equals(result);
    }
}