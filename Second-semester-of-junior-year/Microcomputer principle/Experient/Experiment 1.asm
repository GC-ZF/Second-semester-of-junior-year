MOV AH,1    ;AH=1����̨����,����ֵ��AL=�ַ���ASCII
INT 21H     ;����DOS
AND AL,15   ;������,����λ����,��������3D=33H,����λ����
MOV DH,AL   ;AL�浽DH,Note:AL=DL,05��AL��ֵ��Ϊ'+'����Ҫ����DH�ݴ�
MOV DL,'+'  ;DL=Ҫ�����ASCII
MOV AH,2    ;AH=2����̨���
INT 21H
MOV AH,1
INT 21H     ;Ϊʲô�ڶ���û����ADN����Ϊ�����������������Ҫ��15,�����ظ�����
ADD DH,AL   ;Ϊʲô��DH+AL������AL+DH,ԭ��͵�������ͬ,��һ��DL��ֵ��Ϊ'='
MOV DL,'='
MOV AH,2
INT 21H
MOV DL,DH
INT 21H     ;12��AH=2����14�в���Ҫ�ظ����� 
HLT         ;ͣ��ָ�� 
;Note:AL=DL!!!