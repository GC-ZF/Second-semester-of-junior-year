;IN 125,OUT 127ָ\emu8086\DEVICES\Thermometer.exe����125��ȡ���ݣ���127��������

MOV AL,1
OUT 127,AL  ;�򿪼��ȣ�Ȼ����LP0ѭ��һֱ������75
   
LP0:
IN AL,125
CMP AL,75
JL LP0      ;<75��תLP0��������
   
MOV CX,120  ;һ��1s,������Ϊ120��
LP:
IN AL,125   ;125ָ\emu8086\DEVICES\Thermometer.exe����125��ȡ���ݣ���127��������
CMP AL,75
JL LOW      ;<75��תLOW
CMP AL,80
JLE OK      ;<80��תOK������˳��ִ��HIGH

HIGH:       
MOV AL��0
OUT 127,AL  ;�¸߹ؼ���
JMP OK

LOW:
MOV AL,1
OUT 127,AL  ;�µͿ�����
JMP OK

OK:             ;1����ʱ�ж�
PUSH CX         ;ѹջ������¼�����ӵ�CX����Ϊ��ʱ����Ҳ��CX
CALL DELAY5MS   ;75�浽80��
POP CX
LOOP LP

DELAY5MS PROC NEAR  ;��ʱ��15H�жϵ�86H�ӹ���
    ;wait 1 seconds (1 million microsecpnds)
    ;000F4240H = 1,000,000 = CX,DX ΢��
    MOV CX,15
    MOV DX,4240H
    MOV AH,86H
    INT 15H
    RET
DELAY5MS ENDP