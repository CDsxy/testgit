#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<time.h>
#pragma comment(lib, "Winmm.lib") //播放背景音乐需用此lib
#define width_window 500
#define high_window 398
#define sw 10
void InitGameBoard();
void InitSnake(int x0, int y0, int d0);
void SetFood();
int GetPlayerCommand();
void GameOver(bool iskilled);
void ClearTailNode();
void Eat(int x,int y);
void SnakeMove(int x,int y,int d);
void pause();
typedef struct snake{
	int x,y;
	struct snake* next;
}SNAKE;
	SNAKE *head = (snake*)malloc(sizeof(snake));
int n=0;
int sx=0,sy=0,sd=0;
int isagain=0;

void InitGameBoard(){
	initgraph(width_window,high_window);
	setorigin(0,0);
	setbkcolor(0xFFFFFF);
	cleardevice();
}

void InitSnake(int x0, int y0, int d0){
	int x,y,d;
	srand((unsigned)time(NULL));
	x = rand()%((width_window - 10*sw)/(2*sw))*2*sw + 5*sw;
	y = rand()%((high_window - 10*sw)/(2*sw))*2*sw + 5*sw;
	SNAKE *snak = (snake*)malloc(sizeof(snake));
	snak -> x=x;
	snak -> y=y;
	head -> next=snak;
	snak -> next=NULL;
	d=rand()%4;
	sx=x;
	sy=y;
	sd=d;
	setfillcolor(BLUE);
	fillcircle(x,y,sw);
}

void SetFood(){
	int x,y;
	srand((unsigned)time(NULL));
	do{
		x=rand()%(width_window/(2*sw))*2*sw + sw;
		y=rand()%(high_window/(2*sw))*2*sw + sw;
	}while(getpixel(x,y)==RED || getpixel(x,y)==BLUE);
	setcolor(getbkcolor());
	setfillcolor(GREEN);
	fillcircle(x,y,sw);
	n++;
}

int GetPlayerCommand(){
	int c= -1;
	char ch;
	if(kbhit()){
		ch=getch();
		switch(ch){
			case'd':case'D':c=0;break;
			case's':case'S':c=1;break;
			case'a':case'A':c=2;break;
			case'w':case'W':c=3;break;
			case' ':pause();break;
			case 27:exit(0);
		}
	}
	return c;
}




int main(){
	int i = 1;
	while(i){
		n=0;
		InitGameBoard();
		InitSnake(sx, sy, sd);
		SetFood();
		//SnakeMove(sx, sy, sd);

	i=0;}
	_getch();
	closegraph();
	return 0;
}
