package string;

/**
 * Created by seungbumpark on 9/17/16.
 */
public class StringMatching {
    public static void main(String[] args){
        String[] t = {"AABCCAADDEE","AAAAAAAAAAAAAAAAAA","AAAAAAAAAAAAAAAAAB"};
        String[] p = {"FAA","AAAAA", "AAAAB"};

        for(int i=0;i<t.length;i++){
            System.out.println(t[i] + ":" + p[i]);
            naiveMatcher(t[i],p[i]);
            rabin_karp_matcher(t[i],p[i]);
        }

    }

    public static void naiveMatcher(String t, String p){
        int nt = t.length();
        int np = p.length();
        for(int i=0; i<=nt-np; i++){
            for(int j=0; j<np; j++){
                if(t.charAt(i+j)!=p.charAt(j)){
                    break;
                }else if(j==np-1 && t.charAt(i+j)==p.charAt(j)){
                    System.out.print(i+" ");
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void rabin_karp_matcher(String t, String p){
        int N = t.length();
        int M = p.length();
        int dm = 1; // d^m-1 for shifting
        int hp =0, ht = 0;
        int d = 256, q = 1009;

        for(int i=0; i < M-1; i++)
            dm = (d * dm) % q;

        for(int i=0; i < M; i++){
            hp = (hp*d + p.charAt(i)) % q;
            ht = (ht*d + t.charAt(i)) % q;
        }

        for(int i=0; i <= N-M; i++){
            if(ht == hp){
                for(int j=0; j < M; j++){
                    if(t.charAt(i+j)!=p.charAt(j)){
                        break;
                    }else if(j==M-1 && t.charAt(i+j)==p.charAt(j)){
                        System.out.print(i+" ");
                        break;
                    }
                }
            }
            if(i < N-M){
                ht = (d*(ht - t.charAt(i)*dm%q) + t.charAt(i+M))%q;
            }
        }
        System.out.println();
    }

}
