MOV CX,5-1      ;ð�ݷ�����������ѭ��N-1�� 

LP1:
PUSH CX
MOV SI,OFFSET TAB   ;��ǰTABָ��ƫ�Ƶ�ַ��SI
MOV BX,0            ;���ñ�־λ�����������+1���������ѭ��û��������(BX==0)˵��������ȷ����������ѭ����������

LP2:
MOV AX,[SI]
CMP AX,[SI+2]       ;�Ƚ�TAB[i]��TAB[i+1]
JAE J1              ;TAB[i]>TAB[i+1]��ת
XCHG AX,[SI+2]      ;TAB[i]<TAB[i+1]����
MOV [SI],AX
ADD BX,1

J1:
ADD SI,2            ;SI+2ָ����һ������
LOOP LP2            ;������һ����ѭ��
POP CX
CMP BX,0
JNA J2              ;BX������0��ת
LOOP LP1            ;��ѭ����ɣ�������ѭ��
;JMP $

J2:    
HLT

TAB DW 9,3,6,4,2   ;�νṹʹ�����ݱ������ں��棬���������