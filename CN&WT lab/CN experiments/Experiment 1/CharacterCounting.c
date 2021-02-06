#include <stdio.h>
#include <string.h>
int main() {
    int n;
    char c[20][20];
    int h[15];
    printf("Enter no. of frames:");
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        printf("Frame %d:",i+1);
        printf("\n");
        scanf("%s",&c[i]);
    }
    printf("Data as frames:\n");
    for(int i=0;i<n;i++){
        printf("Frame %d:%d%s",i+1,(strlen(c[i])+1),c[i]);
        printf("\n");
    }
    printf("Data recived\n");
    for(int i=0;i<n;i++){
        printf("Frame %d:%s\n",i+1,c[i]);
    }
    return 0;
}
