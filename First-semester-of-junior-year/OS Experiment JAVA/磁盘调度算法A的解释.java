package ����ϵͳʵ��;

import java.util.Arrays;
import java.util.Scanner;

public class ���̵����㷨A�Ľ��� {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] list = { 5, 2, 3, 8, 10, 12, 9 };// 7
		int[] templist = new int[list.length];
		int k = list[0];
		int tempk1 = 0;
		int tempk2 = 0;

		System.out.println("1.��ͷ��������  2.��ͷ��������(�Ӵ�С)");
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.println("����ǰ��list" + Arrays.toString(list));
			SortA(list);
			System.out.println("��С�����list" + Arrays.toString(list));
			//�ҳ��������k�������е�λ�ã�templist��¼����[0,list.length-tempk1]
			for (int i = 0; i < list.length; i++) {
				if (k == list[i])
					tempk1 = i;
			}

			System.arraycopy(list, tempk1, templist, 0, list.length - tempk1);
			System.out.println("��һ�ε�templist" + Arrays.toString(templist));

			SortB(list);
			System.out.println("�Ӵ�С��list" + Arrays.toString(list));
			//�ҳ��������k�������е�λ��,templist��¼����[tempk2+1,list.length]
			for (int i = 0; i < list.length; i++) {
				if (k == list[i])
					tempk2 = i;
			}
			System.arraycopy(list, tempk2 + 1, templist, tempk2 + 1, list.length - tempk2 - 1);
			System.out.println("�ڶ��ε�templist" + Arrays.toString(templist));
		}
		else if(choice==2){
			System.out.println("����ǰ��list" + Arrays.toString(list));
			SortB(list);
			System.out.println("�Ӵ�С��list" + Arrays.toString(list));
			//�ҳ��������k�������е�λ�ã�templist��¼����[0,list.length-tempk1]
			for (int i = 0; i < list.length; i++) {
				if (k == list[i])
					tempk1 = i;
			}

			System.arraycopy(list, tempk1, templist, 0, list.length - tempk1);
			System.out.println("��һ�ε�templist" + Arrays.toString(templist));

			SortA(list);//��С����
			System.out.println("��С�����list" + Arrays.toString(list));

			for (int i = 0; i < list.length; i++) {
				if (k == list[i])
					tempk2 = i;
			}
			System.arraycopy(list, tempk2 + 1, templist, tempk2 + 1, list.length - tempk2 - 1);
			System.out.println("�ڶ��ε�templist" + Arrays.toString(templist));
		}
	}
}
