#include <stdio.h>
#include <stdlib.h>

void adjacent(int k,int n,int a[100][100]) {
	int i,j;
	printf("Adjacent node of root node:\n");
	printf("%d\n",k);
	for(j=1;j<=n;j++) {
		if((a[k][j] == 1) || (a[j][k] == 1))
			printf("%d\t",j);
	}
	printf("\n");
	for(i=1;i<=n;i++) {
		if((a[k][j] == 0) && (a[i][k] == 0) && (i != k))
		       printf("%d",i);
	}
}
int main() {
	int i,j,root_node;
	int nodes[100][100],total_nodes;
	printf("Enter total number of nodes:");
	scanf("%d",&total_nodes);
	printf("Enter the adjacent matrix");
	for(i=1;i<=total_nodes;i++) {
		for(j=1;j<=total_nodes;j++) {
			printf("Enter the connecting node %d -> %d: ",i,j);
			scanf("%d",&nodes[i][j]);
		}
	}
	printf("Enter the root node: ");
	scanf("%d",&root_node);
	adjacent(root_node,total_nodes,nodes);
	return 0;
}
