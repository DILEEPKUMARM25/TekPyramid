package Assiagment;

public class Day4Part {

        public static void main(String[] args) {
            String str = "Hello World Java";
            str = str.replace(" ", ""); // remove spaces
            int parts = 4;
            int len = str.length();
            int chars = len / parts;     // base characters per part
            int extra = len % parts;
            System.out.println(extra);// distribute extra characters
            int start = 0;

            for (int i = 0; i < parts; i++)
            {
                int end = start + chars;
                System.out.println(end);

                // if any extra characters are left, give one to this part
                if (extra > 0)
                {
                    end++;
                    extra--;
                }

                // handle case when end goes beyond length
                if (end > len)
                {
                    end = len;
                }

                String res = str.substring(start, end);
                System.out.println("Part " + (i + 1) + ": " + res);

                start = end;
            }
        }
    }















