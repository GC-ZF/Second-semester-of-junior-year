#include <iostream>
using namespace std;
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<dos.h>
#pragma warning(disable:4996)

char A[20];/*����ջ*/
char B[20];/*ʣ�മ*/
char v1[20] = { 'i','+','-','*','/','(',')','#' };/*�ս��  */
char v2[20] = { 'E','G','T','S','F' };/*���ս��   */

int j = 0, b = 0, top = 0, l;/*LΪ���봮���� */

typedef struct type/*����ʽ���Ͷ���      */
{
	char origin;/*��д�ַ�  */
	char array[5];/*����ʽ�ұ��ַ� */
	int length;/*�ַ�����      */
}type;

type e, t, g, g1, g2, s, s2, s1, f, f1;/*�ṹ�����  */
type C[10][10];/*Ԥ�������      */

void print()/*�������ջ  */
{
	int a;/*ָ��*/
	for (a = 0; a <= top + 1; a++)
		printf("%c", A[a]);
	printf("\t\t");
}/*print*/

void print1()/*���ʣ�മ*/
{
	int j;
	for (j = 0; j < b; j++)/*��������*/
		printf(" ");
	for (j = b; j <= l; j++)
		printf("%c", B[j]);
	printf("\t\t\t");
}/*print1*/

void main()
{
	int m, n, k = 0, flag = 0, finish = 0;
	char ch, x;
	type cha;/*��������C[m][n]*/
	/*���ķ�����ʽ��ֵ�ṹ��*/
	e.origin = 'E';
	strcpy(e.array, "TG");
	e.length = 2;
	t.origin = 'T';
	strcpy(t.array, "FS");
	t.length = 2;

	g.origin = 'G';
	strcpy(g.array, "+TG");
	g.length = 3;
	g1.origin = 'G';
	strcpy(g1.array, "-TG");
	g1.length = 3;
	g2.origin = 'G';
	g2.array[0] = '^';
	g2.length = 1;
	/////////////////////////////////////////////
	s.origin = 'S';
	strcpy(s.array, "*FS");
	s.length = 3;
	s1.origin = 'S';
	strcpy(s1.array, "/FS");
	s1.length = 3;
	s2.origin = 'S';
	s2.array[0] = '^';
	s2.length = 1;
	////////////////////////////////
	f.origin = 'F';
	strcpy(f.array, "(E)");
	f.length = 3;
	f1.origin = 'F';
	f1.array[0] = 'i';
	f1.length = 1;

	for (m = 0; m <= 4; m++)/*��ʼ��������*/
		for (n = 0; n <= 5; n++)
			C[m][n].origin = 'N';/*ȫ����Ϊ��*/

   /*��������*/
//char v1[20]={'i','+','-','*','/','(',')','#'};/*�ս��  */
//char v2[20]={'E','G','T','S','F'};/*���ս��   */

	C[0][0] = e; C[0][5] = e;

	C[1][1] = g; C[1][2] = g1; C[1][3] = C[1][4] = C[1][7] = g2;

	C[2][0] = t; C[2][3] = t; C[2][5] = t;

	C[3][1] = C[3][2] = s2; C[3][3] = s; C[3][4] = s1; C[3][6] = C[3][7] = s2;

	C[4][0] = f1;     C[4][5] = f;
	printf("LL(1)�������򣬱����ˣ��ŷ���192062116��1920542��\n");
	printf("����һ��#�����ķ��Ŵ�(����+ - * / () i #)��");
	do/*���������*/
	{
		scanf("%c", &ch);
		if ((ch != 'i') && (ch != '+') && (ch != '-') && (ch != '*') && (ch != '/') && (ch != '(') && (ch != ')') && (ch != '#'))
		{
			printf("���봮���зǷ��ַ�\n");
			exit(1);
		}
		B[j] = ch;
		j++;
	} while (ch != '#');
	l = j;/*����������*/
	ch = B[0];/*��ǰ�����ַ�*/
	A[top] = '#'; A[++top] = 'E';/*'#','E'��ջ*/
	printf("����\t\t����ջ \t\tʣ���ַ� \t\t���ò���ʽ \n");
	do
	{
		x = A[top--];/*xΪ��ǰջ���ַ�*/
		printf("%d", k++);
		printf("\t\t");
		for (j = 0; j <= 7; j++)/*�ж��Ƿ�Ϊ�ս��*/
			if (x == v1[j])
			{
				flag = 1;
				break;
			}
		if (flag == 1)/*������ս��*/
		{
			if (x == '#')
			{
				finish = 1;/*�������*/
				printf("acc!\n");/*���� */
				getchar();
				getchar();
				cout << "�����ɹ�" << endl;
				exit(1);
			}/*if*/
			if (x == ch)
			{
				print();
				print1();
				printf("%cƥ��\n", ch);
				ch = B[++b];/*��һ�������ַ�*/
				flag = 0;/*�ָ����*/
			}/*if*/
			else/*������*/
			{
				print();
				print1();
				printf("%c����\n", ch);/*��������ս��*/
				cout << "����ʧ��" << endl;
				exit(1);
			}/*else*/
		}/*if*/
		else/*���ս������*/
		{
			for (j = 0; j <= 4; j++)
				if (x == v2[j])
				{
					m = j;/*�к�*/
					break;
				}
			for (j = 0; j <= 7; j++)
				if (ch == v1[j])
				{
					n = j;/*�к�*/
					break;
				}
			cha = C[m][n];
			if (cha.origin != 'N')/*�ж��Ƿ�Ϊ��*/
			{
				print();
				print1();
				printf("%c->", cha.origin);/*�������ʽ*/
				for (j = 0; j < cha.length; j++)
					printf("%c", cha.array[j]);
				printf("\n");
				for (j = (cha.length - 1); j >= 0; j--)/*����ʽ������ջ*/
					A[++top] = cha.array[j];
				if (A[top] == '^')/*Ϊ���򲻽�ջ*/
					top--;
			}/*if*/
			else/*������*/
			{
				print();
				print1();
				printf("%c����\n", x);/*���������ս��*/
				cout << "����ʧ��" << endl;
				exit(1);
			}/*else*/
		}/*else*/
	} while (finish == 0);
}/*main*/
