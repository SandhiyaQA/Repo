public class TriangleStarPattern {
    public static void main(String[] args) {
        //*
        //**
        //***
        int n=10;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                if(i>=j)
                {
                    System.out.print(" *");
                }
            System.out.println();
        }
    }
}
