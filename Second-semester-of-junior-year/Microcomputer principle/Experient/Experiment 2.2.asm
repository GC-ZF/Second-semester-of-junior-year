BGN:
MOV AH,1
INT 21H     ;����DOS 1�����빦��
AND AL,15   ;������,����λ����,��������3D=33H,����λ����
MOV DH,AL   ;��һ�����ݴ浽DH
MOV AH,1
INT 21H     ;����DOS 1������ڶ�����
AND AL,15   ;��λ����
MOV AH,DH   ;��һ������Ϊ��λ��AH���ڶ�������AL����
AAD         ;AADָ�� AL=AH*0AH+AL AH=0.ʵ�����ǽ�AX�Ĵ����з�ѹ����BCD��ת����Ϊ�����Ķ����������������AL�Ĵ�����
CMP AL,N    ;������CF=0��С��CF=1������CF=1.ZF=1
JE JEND     ;���־λZF=1ת��
MOV DL,'>'
JA J1       ;���ڻ��߲�����ת��,CF=0
MOV DL,'<' 

J1:    
MOV AH,2 
INT 21H     ;����2�����>
MOV DL,0AH
INT 21H     ;����2�Ż���
MOV DL,0DH
INT 21H     ;����2�Żس�
JMP BGN     ;�µĽ����/С����������BGN

JEND:
MOV DL,'='
MOV AH,2
INT 21H 
MOV AH,4CH
INT 21H     ;����DOC 4CH�жϳ���

N DB 35      ;����ֵ���µ���Ϊʮ����35