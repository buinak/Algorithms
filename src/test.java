enum Seasons {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

public class test {
    public static void main(String[] args) {
        int t = 0;
        System.out.println(solution(00, t));
    }

    public static int solution(int A, int B) {
        //this is the "naive" approach to the string search problem.
        //in practice, more efficient algorithms such as the Boyer-Moore or the Rabin Karp string search should be used,
        //as the naive approach has the worst time complexity of O(n^2) in the case where the size of the searched substring is the size of the string
        //in which the search is performed.
        String pattern = String.valueOf(A);
        String text = String.valueOf(B);
        for (int i = 0; i < text.length(); i++){
            if (pattern.charAt(0) == text.charAt(i)){
                for (int j = i; j < i + pattern.length(); j++){
                    //reached the end of the string, returning -1 as "not found"
                    if (j >= text.length()){
                        return -1;
                    }
                    //character mismatch, exiting the substring verification loop
                    if (text.charAt(j) != pattern.charAt(j - i)){
                        break;
                    }

                    //substring was found and verified, returning the index
                    if (j == i + pattern.length() - 1){
                        return i;
                    }
                }
            }
        }
        //not found
        return -1;
    }
}
