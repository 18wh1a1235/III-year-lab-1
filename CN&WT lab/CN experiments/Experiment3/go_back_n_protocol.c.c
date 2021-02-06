#include <stdio.h>
#include <stdlib.h>

int main() {
	int window,sent = 0,ack,i;
	printf("Enter the window size:");
	scanf("%d",&window);
	while(1) {
		for(i=0;i<window;i++) {
			printf("Frame %d has been transmitted\n",sent);
			sent++;
			if(sent == window)
				break;
		}
		printf("\nPlease enter the last Acknowledgement received.\n");
		scanf("%d",&ack);
		if(ack == window) {
			break;
		}
		else {
			sent = ack;
		}
	}
	return 0;
}
