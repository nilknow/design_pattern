#include <stdio.h>

int main(){
    FILE *fp=NULL;
    char buff[1024];

    fp=fopen("./main.c","r");
    for(int i=0;i<20;i++){
        fscanf(fp,"%s",buff);
        printf("%d :%s\n",i+1,buff);
    }

    return 0;
}