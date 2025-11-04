package HackerRank;
import java.util.Arrays;

public class UseSplit {

    public static void main(String[] args) {
        String str="He is a very very good boy, isn't he?";

        String a="hdaihhFUYGgHGJHGIhlkhihUOhHOHJOGkllhjigI";
        String[] b=str.trim().split(" +");
        System.out.println(Arrays.toString(b));
        String[] arr=a.split("[^a-z]+");///apartfrom those a-zA-Z its will splits value
        System.out.println(Arrays.toString(arr));

    }

}

