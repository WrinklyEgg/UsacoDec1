import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
     static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[]args)
    {
        FastReader sc = new FastReader();

        int numTests = sc.nextInt();
        
        String output="";
        for(int i =0;i<numTests;i++)
        {
            int befRound= sc.nextInt();
           
            int numDifferent=0;

            for(int j=0;j<=befRound;j++)
            {
                int roundedOnce=roundOnce(j,findP(j));
                int chainRounded= chainRound(j, findP(j));
                if(roundedOnce!=chainRounded)
                {
                    numDifferent++;
                }
            }
            output+=numDifferent+"\n";
        }
        System.out.println(output.substring(0,output.length()-1));
        
    }
    public static int findP(int befRound)
    {
        String befRoundString=""+befRound;
       
        return befRoundString.length();
    }
    
    public static int roundOnce(int a, int b)
    {
        return (int)Math.round(a/Math.pow(10,b))*(int)Math.pow(10,b);
    }
 
    public static int chainRound(int a, int b)
    {
        for(int i=1; i<=b;i++)
        {
            a=roundOnce(a,i);   
        }
        return a;
    }
}

