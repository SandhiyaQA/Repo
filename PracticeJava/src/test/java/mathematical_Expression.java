import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class mathematical_Expression {
public static boolean matcher(String[] ar)
{
    boolean v =false;
    int count=0;
    String[] list = {"plus","minus","divide","multiply"};

    for(int i=1;i<=ar.length-2;i+=2)
    {

        for(int j=0;j<list.length-1;j++)
        {
        if(ar[i].equalsIgnoreCase(list[j]))
        {
            count++;

        }
    }}

    if(count==ar.length/2)
    {
        return true;
    }
    return v;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input  = sc.nextLine();
        int first, last, midd;
        String[] str =input.split(" ");

        if(matcher(str))
        {

//        System.out.println(Arrays.deepToString(str));
        try {
             first = Integer.parseInt(str[0]);
             last = Integer.parseInt(str[str.length - 1]);
             midd = Integer.parseInt(str[2]);

            if(first>=1&&last>=1)
            {
                System.out.println("TRUE");
            }
            else if(first>=1&&midd>=1&&last>=1)
            {
                System.out.println("TRUE");
            }
            else {
                System.out.println("FALSE");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("FALSE");
        }

    }
        else {
            System.out.println("FALSE");
        }
}}

