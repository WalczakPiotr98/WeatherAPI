public class TimeParser {
    public static int parseFromXML(String time) {
        if (Integer.parseInt(time) == 0) {

            System.out.print("0:00");
        }
        if (Integer.parseInt(time) > 0 && Integer.parseInt(time) < 1000) {
            System.out.print(time.charAt(0) + ":" + time.charAt(1) + time.charAt(2));
        } else if (Integer.parseInt(time) >= 1000) {
            System.out.print(time.charAt(0));
            System.out.print(time.charAt(1));
            System.out.print(":");
            System.out.print(time.charAt(2));
            System.out.print(time.charAt(3));
        }
        return 0;
    }
}
