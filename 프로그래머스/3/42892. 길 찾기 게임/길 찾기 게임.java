import java.util.*;
class Solution {
    
    static class Node{
        int num; //번호
        int x; //x좌표
        int y; //y좌표
        Node left; //트리의 왼쪽 가지
        Node right; //트리의 오른쪽 가지
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    //노드 정보를 저장할 리스트 선언
    static ArrayList<Node> list;

    //전위 순회, 후위 순회 저장할 리스트 선언
    static ArrayList<Integer> preList = new ArrayList<>();
    static ArrayList<Integer> postList = new ArrayList<>();
    
    static Node makeTree(int[][] nodeinfo){
        list = new ArrayList<>();
        
        int n = 1;
        for(int[] node : nodeinfo){
            list.add(new Node(n++, node[0], node[1]));
        }
        
        //y가 다르면 y로 내림차순 정렬, y가 같으면 x로 오름차순 정렬
        Collections.sort(list, (node1, node2) -> {
           if(node2.y != node1.y){
               return node2.y - node1.y;
           }else{
               return node1.x - node2.x;
           } 
        });
        
        //트리 root 값 설정
        Node root = list.get(0);
        
        for(int i = 1; i<list.size(); i++){
            Node parent = root;
            
            while(true){
                //현재 노드의 x값이 부모 노드의 x값보다 작을 때(왼쪽)
                if(list.get(i).x < parent.x){
                    //부모 노드의 왼쪽 자식이 null일 때 넣어줌
                    if(parent.left == null){
                        parent.left = list.get(i);
                        break;
                    }else{ //있다면 왼쪽 자식이 다시 부모 노드가 된다.
                        parent = parent.left;
                    }
                }else{ //현재 노드의 x값이 부모 노드의 x값보다 클 때(오른쪽)
                    //부모 노드의 오른쪽 자식이 null일 때 넣어줌
                    if(parent.right == null){
                        parent.right = list.get(i);
                        break;
                    }else{ //있다면 오른쪽 자식이 다시 부모 노드가 된다.
                        parent = parent.right;
                    }
                }
            }
        }
        return list.get(0);
    }
    //전위순회
    static void preOrder(Node curr){
        if(curr == null){
            return;
        }else{
            preList.add(curr.num);
            preOrder(curr.left);
            preOrder(curr.right);
        }
    }
    
    //후위순회
    static void postOrder(Node curr){
        if(curr == null){
            return;
        }else{
            postOrder(curr.left);
            postOrder(curr.right);
            postList.add(curr.num);
        }
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = makeTree(nodeinfo); 
        int[][] answer = new int[2][nodeinfo.length];
        preOrder(root);
        postOrder(root);
        answer[0] = preList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}