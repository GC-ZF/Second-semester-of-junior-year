MOV CX,5-1      ;ѡ��������ѭ��N-1��
MOV BX,OFFSET TAB

LP1:
MOV AX,[BX]     ;ȡ��ǰTAB[i]��AX
PUSH CX         ;�������ݣ�CXѹջ
MOV SI,BX       ;�ݴ�BX��SI

LP2:
ADD SI,2        ;ƫ�Ƶ�ַ+2ת����һ����
CMP AX,[SI]     ;�����������Ƚ�
JAE J1          ;���AX>[SI]��ת
XCHG AX,[SI]    ;���AX<[SI]���������һ����ѭ���ҵ������AX

J1:
LOOP LP2        ;�����ص�LP2��ѭ��
MOV [BX],AX     ;�ҵ����������[BX]
POP CX
ADD BX,2
LOOP LP1        ;�ص����ѭ��

HLT

TAB DW 9,3,6,4,2   ;�νṹʹ�����ݱ������ں��棬���������