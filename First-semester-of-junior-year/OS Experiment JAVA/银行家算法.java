package ����ϵͳʵ��;

import java.util.Arrays;
import java.util.Scanner;
/*
 * ���м��㷨
 * @author ��ʱ��
 * @data 2021��12��14��
 */
public class ���м��㷨 {
	// ���ȶ���ȫ�ֱ���
	static int resourceNum = 3; // ��ʼ��Դ������
	static int processNum = 5; // ��ʼ������
	static int[] available = new int[] { 3, 3, 2 }; // ���ã�ʣ�ࣩ��Դj������
	static int[][] maxRequest = new int[][] { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 }, { 4, 3, 3 } }; // ����i����Դj�����������
	static int[][] allocation = new int[][] { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 }, { 0, 0, 2 } }; // ����i�ѷ�����Դj������
	static int[][] need = new int[][] { { 7, 4, 3 }, { 1, 2, 2 }, { 6, 0, 0 }, { 0, 1, 1 }, { 4, 3, 1 } }; // ����i������Դj������
	static boolean[] finish = new boolean[] { false, false, false, false, false }; // �Ƿ�ȫ
	static int[] safeSeries = new int[] { 0, 0, 0, 0, 0 }; // ��ȫ���к�
	static int[] request = new int[] { 0, 0, 0 }; // ����������Դj������
	static int num; // ��Դ��������
	Scanner sc = new Scanner(System.in);

	// ��ӡ����ʼ��Դ��������Ϣ
	public static void showInfo() {
		System.out.println("**************************************************************");
		System.out.println("��ǰϵͳ������Դʣ��:");
		System.out.println(Arrays.toString(available));

		System.out.printf("\n��ǰϵͳ��Դ�����\n");
		System.out.printf(" PID\t\t maxRequest\tAllocation\t Need\n");

		for (int i = 0; i < processNum; i++) {
			System.out.printf(" P%d\t\t", i);
			for (int j = 0; j < resourceNum; j++) {
				System.out.printf("%2d", maxRequest[i][j]);
			}
			System.out.printf("\t\t");
			for (int j = 0; j < resourceNum; j++) {
				System.out.printf("%2d", allocation[i][j]);
			}
			System.out.printf("\t\t");
			for (int j = 0; j < resourceNum; j++) {
				System.out.printf("%2d", need[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * ��ӡ��ȫ�����Ϣ
	 * 
	 * @param work ������������ʾϵͳ���ṩ�����̼�����������ĸ�����Դ��Ŀ
	 * @param i    ��i������
	 */
	public static void safeInfo(int[] work, int i) {
		int j;
		System.out.printf(" P%d\t\t", i);
		for (j = 0; j < resourceNum; j++) {
			System.out.printf("%2d", work[j]);
		}
		System.out.printf("\t\t");
		for (j = 0; j < resourceNum; j++) {
			System.out.printf("%2d", allocation[i][j]);
		}
		System.out.printf("\t\t");
		for (j = 0; j < resourceNum; j++) {
			System.out.printf("%2d", need[i][j]);
		}
		System.out.printf("\t\t");
		for (j = 0; j < resourceNum; j++) {
			System.out.printf("%2d", allocation[i][j] + work[j]);
		}
		System.out.println();
	}

	/**
	 * �ж�һ�����̵���Դ���Ƿ�ȫΪ0��ȫΪ0����˵����ִ����ϣ����ͷ�����е���Դ
	 * 
	 * @param i ��i������
	 * @return
	 */
	static boolean isAllZero(int i) {
		num = 0;
		for (int j = 0; j < resourceNum; j++) {
			if (need[i][j] == 0) { // ����i�����
				num++;
			}
		}
		if (num == resourceNum) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��ȫ�Լ��
	 * 
	 * @return
	 */
	static boolean Safe() {
		int safeIndex = 0;
		int allFinishNum = 0;
		// ������������ʾϵͳ���ṩ�����̼�����������ĸ�����Դ��Ŀ
		int[] work = new int[resourceNum];
		int r = 0; // ��r������
		int temp = 0;
		int pNum = 0;

		for (int j = 0; j < resourceNum; j++) {
			work[j] = available[j];
		}

		// ��ʶ������ɣ�true����δ��ɣ�false��
		for (int i = 0; i < processNum; i++) {
			if (isAllZero(i)) {
				finish[i] = true;
				allFinishNum++;
			} else {
				finish[i] = false;
			}
		}

		// Ԥ���俪ʼ
		while (allFinishNum != processNum) { // ���̲�δȫ�����
			num = 0; // ����r��������Դ������
			for (int j = 0; j < resourceNum; j++) {
				// ��ĳ����δ��ɣ�������Դ������С�ڵ�ǰϵͳ�и���Դ��ʣ����ʱ
				if (need[r][j] <= work[j] && finish[r] == false) {
					num++;
				}
			}
			if (num == resourceNum) { // ��num����resourceNumʱ��˵�� ����r ��������Դ�������������if�������������Է���ɹ�
				allFinishNum++;
				safeInfo(work, r);
				safeSeries[safeIndex] = r;
				safeIndex++;
				finish[r] = true;
				for (int j = 0; j < resourceNum; j++) { // ����ִ����ϣ��ͷ� ����r �����е���Դ
					work[j] = work[j] + allocation[r][j];
				}
			}
			r++;
			if (r >= processNum) {
				r = r % processNum;
				if (temp == allFinishNum) {
					break;
				}
				temp = allFinishNum;
			}
			pNum = allFinishNum;
		}

		// �ж�ϵͳ�Ƿ�ȫ
		for (int i = 0; i < processNum; i++) {
			if (finish[i] == false) {
				System.out.printf("\n��ǰϵͳ����ȫ��\n\n");
				return false;
			}
		}

		// ��ӡ��ȫ����
		System.out.printf("\n��ǰϵͳ��ȫ~\n\n��ȫ����Ϊ��");
		for (int i = 0; i < processNum; i++) {
			if (isAllZero(i)) {
				pNum--;
			}
		}
		for (int i = 0; i < pNum; i++) {
			System.out.printf("%d ", safeSeries[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		int curProcess = 0;
		showInfo();
		System.out.printf("\n\nϵͳ��ȫ���������\n");
		System.out.printf(" PID\t\t Work\t\t Allocation\t Need\t\t Work+Allocation\n");
		boolean safe = Safe();
		Scanner scanner = new Scanner(System.in);
		while (safe) {
			// �û������Ԥ��ϵͳ��Դ�������ż������н��̷��乤��
			do {
				if (curProcess >= processNum || curProcess < 0) { // ע�����̱�ʶ���д�0��ʼ
					System.out.printf("\n�벻Ҫ���볬������������ֵ�������ַ���\n");
				}
				System.out.printf("\n**************************************************************\n");
				System.out.printf("\n����Ҫ����Ľ��̣�");
				curProcess = scanner.nextInt(); // �����û�����Ľ��̺�
				System.out.println();
			} while (curProcess >= processNum || curProcess < 0);

			// �û������Ԥ��ϵͳ��Դ�������ż������н��̷��乤��
			for (int j = 0; j < resourceNum; j++) {
				int requestJ = 0;
				do {
					if (requestJ < 0 || requestJ > available[j]) {
						System.out.printf("\n�벻Ҫ���볬������������Դ����������Ϊ�����������ַ���\n");
					}
					System.out.printf("������Ҫ��������� P%d �ĵ� %d ����Դ��", curProcess, j + 1);
					requestJ = scanner.nextInt();
					request[j] = requestJ;
				} while (requestJ < 0 || requestJ > available[j]);
			}

			// �ж��û�����ķ����Ƿ�������������Ԥ����
			num = 0;
			for (int j = 0; j < resourceNum; j++) {
				if (request[j] <= need[curProcess][j] && request[j] <= available[j]) {
					num++;
				} else {
					System.out.printf("\n�������󣡿���ԭ�����£�\n(1)������������Դ���ܴ��ڸý��̵�ĳЩ��Դ�������Ҫ��\n(2)ϵͳ��ʣ����Դ�Ѿ������ˣ�\n");
					break;
				}
			}
			if (num == resourceNum) {
				num = 0;
				for (int j = 0; j < resourceNum; j++) {
					// ������Դ��Ϣ
					available[j] = available[j] - request[j];
					allocation[curProcess][j] = allocation[curProcess][j] + request[j];
					need[curProcess][j] = need[curProcess][j] - request[j];
					if (need[curProcess][j] == 0) { // �˽��̵���Դj����������
						num++;
					}
				}

				// ��������Ժ󣬸ý��̶�����������Դ����Ϊ0����ô��Ϊ��ɣ��ͷŴ˽���
				if (num == resourceNum) {
					for (int j = 0; j < resourceNum; j++) {
						available[j] = available[j] + allocation[curProcess][j];
					}
					System.out.printf("\n\n���η������ P%d ���,�ý���ռ����Դȫ���ͷ���ϣ�\n", curProcess);
				} else {
					System.out.printf("\n\n���η������ P%d δ��ɣ�\n", curProcess);
				}

				showInfo();
				System.out.printf("\nϵͳ��ȫ�������\n");
				System.out.printf(" PID\t\t Work\t\tAllocation\t Need\t\tWork+Allocation\n");

				// Ԥ��������Ժ��жϸ�ϵͳ�Ƿ�ȫ������ȫ����ɼ������з��䣬������ȫ�����Ѿ��������Դ������
				if (!Safe()) {
					for (int j = 0; j < resourceNum; j++) {
						available[j] = available[j] + request[j];
						allocation[curProcess][j] = allocation[curProcess][j] - request[j];
						need[curProcess][j] = need[curProcess][j] + request[j];
					}
					System.out.printf("��Դ���㣬�ȴ���...\n\n����ʧ�ܣ�\n");
				}
			}
		}
	}
}
