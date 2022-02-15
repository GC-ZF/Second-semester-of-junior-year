package ����ϵͳʵ��;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
 * ���̵���FCFS��SSTF��SCAN
 * @author ��ʱ��
 * @data 2021��12��7��
 */
public class ���̵����㷨 {
	// ð������(��С����)
	public static void SortA(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}

	// ð������(�Ӵ�С)
	public static void SortB(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] < list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}

	// �����ȷ���FCSFS,�����ݴ��̷��ʵ��Ⱥ������е���,����list���鼴�ɣ����Բ���׸��
	private static void FCFS(int[] list) {
		System.out.println("�ŵ���ʼλ��Ϊ" + list[0]);

		int num = 0;// ����num��¼Ѱ������
		for (int j = 0; j < list.length - 1; j++) {
			num += Math.abs(list[j + 1] - list[j]);
		}
		System.out.println("����ɨ������Ϊ:" + Arrays.toString(list));
		System.out.println("Ѱ������:" + num);
		double w = ((float) num / (float) list.length);
		System.out.println("ƽ��Ѱ������:" + w);
	}

	// ���·���㷨SSTF,��������һ���ŵ�ǰ���ȼ���һ�ε�ǰ��ͷ�����ʸ����ŵ��ľ���
	private static void SSTF(int[] list) {
		int[] list1=new int[list.length];//��Ϊ�����޸���list���ٴ������㷨3ʱ��list�����Ѿ����޸ģ����������ֵ����list1
		System.arraycopy(list,0, list1, 0, list.length);
		int i = list1[0];// ����i��¼��ǰ��ͷλ��
		System.out.println("�ŵ���ʼλ��Ϊ" + list1[0]);
		int num = 0;// num��¼��Ѱ������
		int[] k = new int[list1.length];// k�����¼���ʵ�ÿһ���ŵ�����ͷ����
		int[] templist = new int[list1.length];// �����������templist[]��

		for (int a = 0; a < list1.length; a++) {
			// jѭ��������ÿһ�����ʵĴŵ�����ǰ��ͷ�ľ��뱣����k������
			for (int j = 0; j < list1.length; j++) {
				k[j] = Math.abs(list1[j] - i);
			}
			// ��k���鸳ֵ��temp���飬��temp����ð������
			int[] temp = new int[k.length];
			for (int j = 0; j < k.length; j++) {
				temp[j] = k[j];
			}
			SortA(temp);

			int j = temp[0];// �ҵ���ͷ����һ���ŵ�������С��Ϊtemp[0]

			// ѭ�������ҵ�temp[0]��list�ŵ����������е�λ��
			for (int t = 0; t < k.length; t++) {
				// if����ҵ�list[t]����ǰ��ͷ���
				if (k[t] == j) {
					i = list1[t];// ����i��¼��ͷλ��
					templist[a] = i;// ���������templist������
					list1[t] = 999999;// ����g���ŵ�����Ϊ999999���������ΪȨ����Ϊ99999������������һ�α�������k�������������
					break;
				}
			}
			num += j;
		}
		System.out.println("����ɨ������Ϊ:" + Arrays.toString(templist));
		System.out.println("Ѱ������:" + num);
		double w = ((float) num / (float) list.length);
		System.out.println("ƽ��Ѱ������:" + w);
	}

	/*
	 * ɨ���㷨SCAN ���̵�0�ŵ�������Ȧ ɨ���㷨�ֽе����㷨��������С�����Ӵ�С��˳��ȥ���η��ʴŵ���
	 * ������������������1.Ѱ����������(�Ӵ�С) 2.Ѱ����������(��С����)
	 * 
	 * 
	 * 1.����ǰ��ͷλ�ô������������������ 2.����ǰ��ͷλ��С��������������С�� 3.����ǰ�ŵ��Ŵ���������������С����С�������
	 * ������ͬһ������ȥ����������
	 */
	private static void SCAN(int[] list) {
		int[] list1=new int[list.length];//��Ϊ�����޸���list���ٴ������㷨3ʱ��list�����Ѿ����޸ģ����������ֵ����list1
		System.arraycopy(list,0, list1, 0, list.length);
		Scanner sc = new Scanner(System.in);
		int k = list1[0];// ����i��¼��ǰ��ͷλ��
		int tempk1 = 0;
		int tempk2 = 0;
		int flag=1;
		int num = 0;// num��¼��Ѱ������
		int[] templist = new int[list1.length];// ������˳�����templist��
		System.out.println("�ŵ���ʼλ��Ϊ:" + list1[0]);
		//while���ȼ�����ŵ����ʵ�˳��
		while (true) {
			System.out.println("1.��ͷ��������  2.��ͷ��������");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				flag=5;

				SortA(list1);// ��С��������
				// �ҳ��������k�������е�λ�ã�templist��¼����[0,list.length-tempk1]
				for (int i = 0; i < list1.length; i++) {
					if (k == list1[i])
						tempk1 = i;
				}
				System.arraycopy(list1, tempk1, templist, 0, list1.length - tempk1);

				SortB(list1);// �Ӵ�С
				// �ҳ��������k�������е�λ��,templist��¼����[tempk2+1,list.length]
				for (int i = 0; i < list1.length; i++) {
					if (k == list1[i])
						tempk2 = i;
				}
				System.arraycopy(list1, tempk2 + 1, templist, tempk2 + 1, list1.length - tempk2 - 1);
				break;
			}

			else if (choice == 2) {
				flag=5;

				SortB(list1);
				// �ҳ��������k�������е�λ�ã�templist��¼����[0,list.length-tempk1]
				for (int i = 0; i < list1.length; i++) {
					if (k == list1[i])
						tempk1 = i;
				}
				System.arraycopy(list1, tempk1, templist, 0, list1.length - tempk1);

				SortA(list1);// ��С����
				// �ҳ��������k�������е�λ��,templist��¼����[tempk2+1,list.length]
				for (int i = 0; i < list1.length; i++) {
					if (k == list1[i])
						tempk2 = i;
				}
				System.arraycopy(list1, tempk2 + 1, templist, tempk2 + 1, list1.length - tempk2 - 1);
				break;
			}

			else if (flag==5)
				break;
			
			else
				System.out.println("�����������������");
		}
		//����Ѱ������
		for (int j = 0; j < templist.length - 1; j++) {
			num += Math.abs(templist[j + 1] - templist[j]);
		}

		System.out.println("����ɨ������Ϊ:" + Arrays.toString(templist));
		System.out.println("Ѱ������" + num);
		double w = ((float) num / (float) list.length);
		System.out.println("ƽ��Ѱ������" + w);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Tracknum;// �ŵ���
		System.out.println("������ŵ�����Tracknum");
		Scanner sc = new Scanner(System.in);
		Tracknum = sc.nextInt();

		// ������ɴŵ�����
		Random r = new Random();
		int[] TrackSequence = new int[Tracknum];
		for (int i = 0; i < Tracknum; i++) {
			TrackSequence[i] = r.nextInt(100)+1;
		}
		System.out.println("�ŵ�����Ϊ" + Arrays.toString(TrackSequence));

		// �˵�
		while (true) {
			System.out.println("��ѡ���㷨 1.FCFS 2.SSTF 3.SCAN  0.�˳�");
			int k = sc.nextInt();
			switch (k) {
			case 1:
				FCFS(TrackSequence);
				break;
			case 2:
				SSTF(TrackSequence);
				break;
			case 3:
				SCAN(TrackSequence);
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("��Ĳ���");
			}
		}
	}
}
