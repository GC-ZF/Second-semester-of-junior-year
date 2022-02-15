package ����ϵͳʵ��;

import java.util.Scanner;

public class ҳ���û��㷨 {
	private static int MaxPage_num = 100;
	private static int[] PageView = new int[MaxPage_num];// ����ҳ��˳��
	private static int[][] Blocks = new int[MaxPage_num][MaxPage_num];// �����
	private static int[] PageCount = new int[MaxPage_num];// ��¼Ȩ��

	private static int PageNum;// ����ҳ�����
	private static int BlockNum;// ��������

//	private static int temp = 0;
//	private static int flag = 0;
	private static int MissingPageNum;// ȱҳ����
	private static double MissingPageRate;// ȱҳ��

	private static boolean found;// �ж��Ƿ��ҵ�

	private static int j;
	private static int i;
	private static int k;

	private static int NULL = -1;// ȱҳ

	// ��̬��������顢ҳ�桢����ҳ��˳��
	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ҳ�����");
		PageNum = sc.nextInt();
		System.out.println("��������������");
		BlockNum = sc.nextInt();
		System.out.println("������ҳ�����˳��");
		for (int i = 0; i < PageNum; i++) {
			PageView[i] = sc.nextInt();
		}
	}

	// ������
	public static void output() {
		// �������ҳ��
		System.out.print("����ҳ��:");
		for (i = 0; i < PageNum; i++) {
			System.out.print(PageView[i] + " ");
		}
		System.out.println();
		// ��������
		System.out.println("�����");
		for (int j = 0; j < BlockNum; j++) {
			for (int i = 0; i < PageNum; i++) {
			if (Blocks[i][j] == NULL)
					System.out.print("  ");
				else
					System.out.print(Blocks[i][j] + " ");
			}
			System.out.println(" ");
		}
		MissingPageRate = (double) MissingPageNum / PageNum;
		System.out.println();
		System.out.println("��ҳ����" + PageNum + "ȱҳ����" + MissingPageNum + "ȱҳ��" + MissingPageRate + "%");
	}

	// ��ʼ�������
	public static void original() {
		for (i = 0; i < PageNum; i++) {
			for (j = 0; j < BlockNum; j++) {
				Blocks[i][j] = NULL;
			}
		}
		MissingPageNum = 1;
	}

	// �Ƚ��ȳ�
	public static void FIFO() {
		original();

		Blocks[0][0] = PageView[0];
		int temp = 0, flag = 0;// temp��Ǳ��У�flag�����һ��
		for (i = 0; i < PageNum; i++) {
			// ���ҳ�ѽ������������ѭ��
			for (j = 0; j < BlockNum; j++) {
				if (PageView[i] == Blocks[flag][j]) {
					break;           
				}
			}

			//���������
			if (j == BlockNum) {
				for (k = 0; k < BlockNum; k++) {
					if (Blocks[flag][k] == NULL) {
						break;
					} else {
						Blocks[i][k] = Blocks[flag][k];
					}
				}
				temp++;
				temp = temp % BlockNum;
				Blocks[i][temp] = PageView[i];
				MissingPageNum++;
				flag = i;
			} else {
				continue;
			}
		}

		output();
	}

	// ����û�
	public static void OPT() {
		original();

		Blocks[0][0] = PageView[0];
		int temp, flag = 0;

		for (i = 0; i < PageNum; i++) {
			// ��ȱҳ
			for (j = 0; j < BlockNum; j++) {
				if (PageView[i] == Blocks[flag][j]) {
					break;
				}
			}
			if (j != BlockNum) { // ����ҳ���Ѿ����ڴ���в�ȱҳ
				continue;
			}
			// ȱҳ
			for (k = 0; k < BlockNum; k++) {
				if (Blocks[flag][k] == NULL) {
					break;
				} else {
					Blocks[i][k] = Blocks[flag][k];
				}
			}
			// ҳ��ѡ�����Ͳ���
			// ȱҳʱ�����δ��
			for (j = 0; j < BlockNum; j++) {
				if (Blocks[i][j] == NULL) {
					Blocks[i][j] = PageView[i];
					MissingPageNum++;
					flag = i;
					break;
				}
			}
			if (j != BlockNum) {
				continue;
			}

			// ȱҳʱ�ڴ������
			temp = 0;
			for (j = 0; j < BlockNum; j++) {
				// ��������Ѱ����ò�����
				for (k = i + 1; k < PageNum; k++) {
					// Ѱ���ʱ���ڲ������ʵ�ҳ�� k���ڴ�ҳ�������±� ���PageCount������
					if (Blocks[i][j] == PageView[k]) {
						PageCount[j] = k;//�ҵ�,��¼Ȩ��
						break;
					}
				}
				// ʣ�µ�ҳ��û�к͵�ǰ�����һ���ģ�����Ȩ����Ϊ���ֵ
				if (k == PageNum) {
					PageCount[j] = PageNum;
				}
			}

//			�ҳ�Ȩ�����Ŀ�
			for(int a=1;a<BlockNum;a++) {
				if(PageCount[a]>PageCount[temp])
					temp=a;
			}

			Blocks[i][temp] = PageView[i];
			MissingPageNum++;
			flag = i;
		}
		output();
	}

	// ������δʹ��
	public static void LRU() {
		original();

		Blocks[0][0] = PageView[0];
		PageCount[0] = 0;
		int temp = 0, flag = 0;// temp��Ǳ��У�flag�����һ��
		for (i = 0; i < PageNum; i++) {
			// ��ȱҳ
			for (j = 0; j < BlockNum; j++) {
				if (PageView[i] == Blocks[flag][j]) {
					PageCount[j] = i;
					break;
				}
			}
			if (j != BlockNum)
				continue;

			//ȱҳ
			for (k = 0; k < BlockNum; k++) {
				if (Blocks[flag][k] == NULL) {
					break;
				} else {
					Blocks[i][k] = Blocks[flag][k];
				}
			}
			//ȱҳʱ������п���
			for (j = 0; j < BlockNum; j++) {
				if (Blocks[i][j] == NULL) {
					Blocks[i][j] = PageView[i];
					PageCount[j] = i;
					MissingPageNum++;
					flag = i;
					break;
				}
			}
			if (j != BlockNum) {
				continue;
			}
			//ȱҳʱ�����û����
			temp = 0;
			for (j = 0; j < BlockNum; j++) {
				if (PageCount[temp] > PageCount[j]) {
					temp = j;
				}
			}
			Blocks[i][temp] = PageView[i];
			PageCount[temp] = i;
			MissingPageNum++;
			flag = i;

			
		}
		output();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			input();
			System.out.println("1.�Ƚ��ȳ� 2.����û��㷨 3.������δʹ�� 4.�˳�");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				FIFO();
				break;
			case 2:
				OPT();
				break;
			case 3:
				LRU();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("������� ��������");
				break;
			}
		}
	}

}

//12 3 
//4 3 2 1 4 3 5 4 3 2 1 5
