MOV CX,5-1      ;ð��������ѭ��N-1�� 

LP1:
PUSH CX
MOV SI,OFFSET TAB   ;��ǰTABָ��ƫ�Ƶ�ַ��SI

LP2:
MOV AX,[SI]
CMP AX,[SI+2]       ;�Ƚ�TAB[i]��TAB[i+1]
JAE J1              ;TAB[i]>TAB[i+1]��ת
XCHG AX,[SI+2]      ;TAB[i]<TAB[i+1]����
MOV [SI],AX

J1:
ADD SI,2            ;SI+2ָ����һ������
LOOP LP2            ;������һ����ѭ��
POP CX
LOOP LP1            ;��ѭ����ɣ�������ѭ��
;JMP $

HLT

TAB DW 9,3,6,4,2   ;�νṹʹ�����ݱ������ں��棬���������