package ����ϵͳʵ��;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
 * ���̵���FCFS��SSTF��SCAN
 * @author CSDN ��ʱ��
 * @data 2021��12��7��
 */

public class ���̵����㷨�Զ����ͷ {
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
		int i = 0;
		System.out.println("�������ͷ��ʼλ��");
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		int num = 0;// ����num��¼Ѱ������
		num = Math.abs(i - list[0]);
		for (int j = 0; j < list.length - 1; j++) {
			num += Math.abs(list[j + 1] - list[j]);
		}
		System.out.println("����ɨ������Ϊ��" + Arrays.toString(list));
		System.out.println("Ѱ������" + num);
		double w = ((float) num / (float) list.length);
		System.out.println("ƽ��Ѱ������" + w);
	}

	// ���·���㷨SSTF,��������һ���ŵ�ǰ���ȼ���һ�ε�ǰ��ͷ�����ʸ����ŵ��ľ���
	private static void SSTF(int[] list) {
		int i = 0;// ����i��¼��ǰ��ͷλ��
		int num = 0;// num��¼��Ѱ������
		int[] templist = new int[list.length];// �����������templist[]��
		int[] k = new int[list.length];// k�����¼���ʵ�ÿһ���ŵ�����ͷ����
		System.out.println("�������ͷ��ʼλ��");
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();

		for (int a = 0; a < list.length; a++) {
			// jѭ��������ÿһ�����ʵĴŵ�����ǰ��ͷ�ľ��뱣����k������
			for (int j = 0; j < list.length; j++) {
				k[j] = Math.abs(list[j] - i);
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
					i = list[t];// ����i��¼��ͷλ��
					templist[a] = i;// ���������templist������
					list[t] = 999999;// ����g���ŵ�����Ϊ999999���������ΪȨ����Ϊ99999������������һ�α�����k�������������
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

	/*ɨ���㷨SCAN   ���̵�0�ŵ�������Ȧ
	ɨ���㷨�ֽе����㷨��������С�����Ӵ�С��˳��ȥ���η��ʴŵ���
	������������������1.Ѱ����������(�Ӵ�С) 2.Ѱ����������(��С����)
	
	ע��:ʵ��Ҫ��ֱ�۵Ŀ��������㷨���������Դŵ����е��״ŵ�Ϊ��ͷ���û��Զ����ͷ����
	������������,���̲ĵİ�������ͷ�����������
	1.����ǰ��ͷλ�ô�����������������ߣ���ֱ�������������θ����������
	2.����ǰ��ͷλ��С��������������С�ߣ���ֱ�������������θ�����������
	3.����ǰ�ŵ��Ŵ���������������С����С�������,����SCAN�㷨
	*/
	private static void SCAN(int[] list) {
		SortA(list);//�Ƚ���һ�δ�С��������
		int num = 0;// num��¼��Ѱ������
		System.out.println("�������ͷ��ʼλ��");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();//����i��¼��ͷλ��
		int k = 0;
		int[] templist=new int[list.length];//������˳�����templist��
		
		//1.����ǰ��ͷλ�ô�����������������ߣ���ֱ�������������θ����������
		if(i>list[list.length-1]) {
			SortB(list);//�Ӵ�С(��������)���η���
			System.arraycopy(list, 0, templist, 0, list.length);//������˳�����templist��
			//�������
			num +=Math.abs(i- list[list.length-1]);//��ͷ�ƶ�����һ���ŵ��ľ���
			for (int j = 0; j < list.length - 1; j++) {
				num += Math.abs(list[j + 1] - list[j]);
			}
		}
		
		//2.����ǰ��ͷλ��С��������������С�ߣ���ֱ�������������θ�����������
		else if(i<list[0]) {
			//�Ѿ����й���С���������������ﲻ���ٴε���SortA
			System.arraycopy(list, 0, templist, 0, list.length);
			//�������
			num +=Math.abs(i- list[list.length-1]);//��ͷ�ƶ�����һ���ŵ��ľ���
			for (int j = 0; j < list.length - 1; j++) {
				num += Math.abs(list[j + 1] - list[j]);
			}
		}
		//3.����ǰ��ͷ����������������С����С�������
		else {
			//Ѱ�����ͷ����ķ��ʴŵ�
			for (int j = 0; j < list.length; j++) {
				if (i <= list[j]) {
					k = j;
					break;
				}
			}
			//��¼�ŵ�����˳��templist��
			System.arraycopy(list, k, templist, 0, list.length-k);
			SortB(list);
			System.arraycopy(list,list.length-k, templist, list.length-k, k);
			
			num = Math.abs(i - templist[0]);//��ͷ�ƶ�����һ���ŵ��ľ���
			//ÿ�����ʴŵ�֮��ľ���
			for (int j = 0; j < templist.length - 1; j++) {
				num += Math.abs(templist[j + 1] - templist[j]);
			}
			/*����ע�ͱȽ��Ѷ�����������μ������*/
//			//�ҵ����������ڷ���(��С����)��Ȼ���������������(�Ӵ�С)
//			//����for�����ܾ���
//			num += list[k] - i;//��ͷ�ƶ�����һ���ŵ��ľ���
//			//�������ڣ�����[k,list.length-1)
//			for (int j = k; j < list.length - 1; j++) {
//				num += list[j + 1] - list[j];
//			}
//			//���������棬�������������ʣ��ŵ�,����[0,k-1)
//			for (int j = 0; j < k - 1; j++) {
//				num += Math.abs(list[j + 1] - list[j]);
//			}		
//			num += list[list.length - 1] - list[k - 1];
		}
		
		System.out.println("����ɨ������Ϊ:" + Arrays.toString(templist));
		System.out.println("Ѱ������" + num);
		double w = ((float) num / (float) list.length);
		System.out.println("ƽ��Ѱ������" + w);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Tracknum;// �ŵ���

		// �˵�
		while (true) {
			System.out.println("������ŵ�����Tracknum");
			Tracknum = sc.nextInt();
			// ����ŵ�����
			int[] TrackSequence = new int[Tracknum];
			System.out.println("�ŵ�����");
	        for (int i = 0; i < Tracknum; i++) {
	            TrackSequence[i] = sc.nextInt();
	        }
			System.out.println("�ŵ�����Ϊ" + Arrays.toString(TrackSequence));
			
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