;AX+BX
CALL P  ;��תP
MOV AX,1
MOV BX,2
INT 40H     ;��ת�жϷ������
HLT ;JMP $

;�ӳ���P �޸��ж�����
P PROC NEAR
    MOV AX,0
    MOV ES,AX       ;�ε�ַ
    MOV DI,40H*4    ;ƫ�Ƶ�ַ
    MOV AX,OFFSET INT40H
    MOV ES:[DI],AX
    MOV AX,CS
    MOV ES:[DI+2],AX
    RET
P ENDP

;�жϷ����ӳ���
INT40H PROC FAR
    ADD AX,BX
    IRET
INT40H ENDP    