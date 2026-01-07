package codingTest.src.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MathIsOfferedAsAnOnlineCourse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
                e = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());

        // 방법 1 수학
//        int x=(c*e-b*f)/(a*e-d*b), y=(c*d-a*f)/(b*d-a*e);

        // 방법 2 브루트포스
        int x=0, y=0, flag=0;
        for(int nx=-999; nx<=999; nx++){
            for(int ny=-999; ny<=999; ny++){
                if(a*nx+b*ny==c && d*nx+e*ny==f){
                    x=nx;
                    y=ny;
                    flag=1;
                    break;
                }
            }
            if(flag==1) break;
        }

        System.out.print(x+" "+y);
    }
}
