import java.util.*;
class Solution {
    static ArrayList<Integer> tree[];
    static class Info{
        int node;
        int sheep;
        int wolf;
        List<Integer> visited;
        public Info(int node, int sheep, int wolf, List<Integer> visited){
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    //트리 생성
    public void makeTree(int[] info, int[][] edges){
        tree = new ArrayList[info.length];
        
        for(int i =0; i<info.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            tree[edge[0]].add(edge[1]);
        }
    }
    public int solution(int[] info, int[][] edges) {
        makeTree(info, edges);
        //양의 최대 수
        int answer = 0;
        //BFS로 순회할 큐 생성
        ArrayDeque<Info> queue = new ArrayDeque<>();       
        
        queue.add(new Info(0, 1, 0, new ArrayList<>()));
        
        while(!queue.isEmpty()){
            Info curr = queue.poll();
            answer = Math.max(answer, curr.sheep);
            //현재 방문 가능한 노드 넣기
            curr.visited.addAll(tree[curr.node]);
            
            for(int next : curr.visited){
                //현재 방문 가능한 곳 복사
                List<Integer> list = new ArrayList<>(curr.visited);
                //next는 방문 한거니까 제거
                list.remove(Integer.valueOf(next));
                
                System.out.println(list.toString());
                
                //늑대일 때
                if(info[next] == 1){
                    //양의 수는 늑대+1보다 클 때만 방문
                    if(curr.sheep > curr.wolf+1){
                        queue.add(new Info(next, curr.sheep, curr.wolf+1, list));
                    }
                }else{
                    queue.add(new Info(next, curr.sheep+1, curr.wolf, list));   
                }
            }
            
        }      
        
        return answer;
    }
}