class Solution {
    private boolean isBipart = true;

    private void dfs(int[][] graph, int c, int node, int[] colors) {
        colors[node] = c;
        for(int i=0; i<graph[node].length; i++) {
            int neigh = graph[node][i];
            if(colors[neigh] != -1 && colors[neigh]==c)
                isBipart = false;
            if(colors[neigh] == -1)
                dfs(graph, 1-c, neigh, colors);
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for(int node=0; node < n; node++) {
            if(colors[node]==-1)
                dfs(graph, 0, node, colors);
        }
        return isBipart;
    }
}