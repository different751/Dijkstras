import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
	
	public Dijkstra(){
		
	}
	
	
	public Node getshortestpath(int graph[][],int srcx,int srcy,int destx,int desty){
	
		int cando[][] = graph.clone();
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				if(cando[i][z]==2 || cando[i][z]==3 || cando[i][z]==0 || cando[i][z]==7){
					cando[i][z]=0;
				}
				
				if(cando[i][z]==1 || cando[i][z]==6 || cando[i][z]==5 ){
					cando[i][z]=1;
				}
			}
		}
		
//		for(int i=0;i<5;i++){
//			for(int z=0;z<5;z++){
//				System.out.print(cando[i][z]+" , ");
//			}
//			System.out.println(" ");
//		}
		
		//PriorityQueue<Node> q = new PriorityQueue<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		ArrayList<Node> q = new ArrayList<Node>();
		//ArrayList<Node> open = new ArrayList<Node>();
		int min=1;
		int elementpop=0;
		Node root = new Node();
//		Node currentnode= new Node();
		
		
		
		
		root.x=srcx;
		root.y= srcy;
		root.cost=0;
		root.parent=null;
		
		q.add(root);
		cando[srcx][srcy]=-1;
		
		while(q.isEmpty()==false){
			Node currentnode= new Node();
			min =300;
			for(int i=0;i<q.size();i++){
				if(q.get(i).cost<min){
					min=q.get(i).cost;
					elementpop=i;
					//currentnode=q.remove(i);
				}
			}
			
			currentnode=q.remove(elementpop);
			
			
			if(currentnode.x==destx && currentnode.y==desty){
				//break;
				return(currentnode);
			}
			
			if(cando[currentnode.y][currentnode.x+1]==0){
				Node child1 = new Node();
				child1.x=currentnode.x+1;
				child1.y=currentnode.y;
				child1.parent=currentnode;
				child1.cost=currentnode.cost + 1;
				cando[child1.y][child1.x]=-1;
				q.add(child1);
				
			}
			else if(cando[currentnode.y][currentnode.x+1]==-1){
				Node child1 = new Node();
				child1.x=currentnode.x+1;
				child1.y=currentnode.y;
				child1.parent=currentnode;
				child1.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child1.x && q.get(i).y==child1.y){
						if(q.get(i).cost>child1.cost){
							q.remove(i);
							q.add(child1);
						}
						break;
					}
				}
				
			}
			
			if(cando[currentnode.y][currentnode.x-1]==0){
				Node child2 = new Node();
				child2.x=currentnode.x-1;
				child2.y=currentnode.y;
				child2.parent=currentnode;
				child2.cost=currentnode.cost + 1;
				cando[child2.y][child2.x]=-1;
				q.add(child2);
				
			}
			else if(cando[currentnode.y][currentnode.x-1]==-1){
				Node child2 = new Node();
				child2.x=currentnode.x-1;
				child2.y=currentnode.y;
				child2.parent=currentnode;
				child2.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child2.x && q.get(i).y==child2.y){
						if(q.get(i).cost>child2.cost){
							q.remove(i);
							q.add(child2);
						}
						break;
					}
				}
				
			}
			
			
			if(cando[currentnode.y+1][currentnode.x]==0){
				Node child3 =new Node();
				child3.x=currentnode.x;
				child3.y=currentnode.y+1;
				child3.parent=currentnode;
				child3.cost=currentnode.cost + 1;
				cando[child3.y][child3.x]=-1;
				
				q.add(child3);
			}
			else if(cando[currentnode.y+1][currentnode.x]==-1){
				Node child3 =new Node();
				child3.x=currentnode.x;
				child3.y=currentnode.y+1;
				child3.parent=currentnode;
				child3.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child3.x && q.get(i).y==child3.y){
						if(q.get(i).cost>child3.cost){
							q.remove(i);
							q.add(child3);
						}
						break;
					}
				}
				
			}
			
			if(cando[currentnode.y-1][currentnode.x]==0){
				Node child4 = new Node();
				child4.x=currentnode.x;
				child4.y=currentnode.y-1;
				child4.parent=currentnode;
				child4.cost=currentnode.cost + 1;
				cando[child4.y][child4.x]=-1;
				
				q.add(child4);
				
			}
			else if(cando[currentnode.y-1][currentnode.x]==-1){
				Node child4 = new Node();
				child4.x=currentnode.x;
				child4.y=currentnode.y-1;
				child4.parent=currentnode;
				child4.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child4.x && q.get(i).y==child4.y){
						if(q.get(i).cost>child4.cost){
							q.remove(i);
							q.add(child4);
						}
						break;
					}
				}
				
			}
			
			path.add(currentnode);
			
			
		}
		
		return(path.get(path.size()-1));
		
	}

}
