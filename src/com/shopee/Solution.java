package com.shopee;

import java.util.*;

public class Solution {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public String[] permutation(String s) {
        char[] c = s.toCharArray();

        boolean[] visited = new boolean[c.length];
        Arrays.fill(visited,false);

        dfs(c,visited);
        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] c,boolean[] visited){
        if (path.length()==c.length){
            res.add(new String(path));
            return;
        }
        for (int i = 0; i < c.length; i++) {
            if (i>0 && c[i]==c[i-1] && visited[i-1]==false){
                continue;
            }
            if (visited[i]==false){
                visited[i] = true;
                path.append(c[i]);
                dfs(c,visited);
                path.deleteCharAt(path.length()-1);
                visited[i] = false;
            }
        }
    }


}

