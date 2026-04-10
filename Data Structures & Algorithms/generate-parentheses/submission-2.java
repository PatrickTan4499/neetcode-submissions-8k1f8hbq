class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(answer, n, n, str);
        return answer;
    }

    private void dfs(List<String> answer, int open, int close, StringBuilder str) {
        if(open == 0 && close == 0) {
            answer.add(str.toString());
            return;
        }

        if(open > 0) {
            str.append('(');
            dfs(answer, open-1, close, str);
            str.deleteCharAt(str.length() -1);
        }


        if(close > open) {
            str.append(')');
            dfs(answer, open, close-1, str);
            str.deleteCharAt(str.length() -1);
        }
    }
}
