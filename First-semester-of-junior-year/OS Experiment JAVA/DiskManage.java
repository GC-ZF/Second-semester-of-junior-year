package ����ϵͳʵ��;

import java.util.Scanner;
import java.util.Arrays;

/*
 * ���̵���FCFS��SSTF��SCAN
 * @author ��ʱ��
 * @data 2021��12��7��
 */

public class DiskManage {
	public static void main(String[] args) {
		DiskManage A = new DiskManage();
		int choice = -1;
		int[] cidao = { 55, 72, 100, 88, 93, 66 }; // ������ŵ���
		// int[] cidao = new int[6];
		int i = -1; // ȫ�ֱ���i
		int[] str = new int[6];
		System.out.println("�������һ���ŵ����У�����6���ŵ���\n");


		System.out.println("����õ��Ĵŵ�����Ϊ��");

		for (i = 0; i < 6; i++) {
			System.out.print(cidao[i] + "  ");
		}
		System.out.println();
		while (true) {
			System.out.println();
			System.out.println("----------------------------------------------");
			System.out.println("|                 ����ϵͳ�˵�                                 |");
			System.out.println("|                                            |");
			System.out.println("|               1. �����ȷ���                                   |");
			System.out.println("|               2. ���Ѱ��ʱ������                        |");
			System.out.println("|               3. ɨ�裨���ݣ�����                        |");
			System.out.println("|               4. ѭ��ɨ��                                      |");
			System.out.println("|               5. �˳������˵�                               |");
			System.out.println("----------------------------------------------");
			System.out.print("��ѡ���㷨��");
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			if (choice == 5) {
				System.err.println("�ѳɹ��˳���������");
				break;
			}
			switch (choice) {
			case 1: // ʹ��FCFS�㷨
				A.FCFS(cidao, 6);
				break;
			case 2: // ʹ��SSTF�㷨
				A.SSTF(cidao, 6);
				break;
			case 3: // ʹ��SCAN�㷨
				A.SCAN(cidao, 6);
				break;
			case 4: // ʹ��CSCAN�㷨
				A.CSCAN(cidao, 6);
				break;
			default:
				System.err.println("������1-5֮�������");
			}
		}
	}

	/**
	 * �����ȷ����㷨
	 * 
	 * @param cidao Ҫ���ʵĴŵ�����
	 * @param m
	 */
	void FCFS(int cidao[], int m) // �ŵ������飬����Ϊm
	{
		int now = -1; // ��ǰ�ŵ���
		int sum = 0; // ��Ѱ������
		int i;
		float ave = 0.0f; // ƽ��Ѱ������
		System.out.println("������������Ϊ��");
		for (i = 0; i < m; i++) // �������ȷ���Ĳ������������������
		{
			System.out.print(cidao[i] + "  ");
		}
		System.out.println();
		System.out.print("�����뵱ǰ�Ĵŵ��ţ�");
		Scanner input = new Scanner(System.in);
		now = input.nextInt();
		sum += Math.abs(cidao[0] - now);// ��ǰ����ŵ��͵�һҪ���ʴŵ��ľ���
		System.out.println("����ɨ������Ϊ��");
		System.out.print(now);
		for (i = 0; i < m; i++) // �������ɨ������
		{
			System.out.print(" --> " + cidao[i]);
		}
		for (i = 0; i < m - 1; i++) // ��ƽ��Ѱ������
		{
			sum += Math.abs(cidao[i + 1] - cidao[i]);
			ave = (float) sum / m;
		}
		System.out.println();
		System.out.println("ƽ��Ѱ�����ȣ�" + ave);
	}

	/**
	 * �����������ǰ�����Ȱ���������� 1������ǰ�ŵ��Ŵ�����������������ߣ���ֱ�������������θ�����������
	 * 2������ǰ�ŵ���С��������������С�ߣ���ֱ�������������θ��������������һ��ͬ�� 3������ǰ�ŵ��Ŵ���������������С����С�������
	 * ���Ѱ��ʱ�������㷨
	 * 
	 * @param cidao Ҫ���ʵĴŵ�����
	 * @param m
	 */
	void SSTF(int cidao[], int m) {
		int k = 1; // ���ڵ���������ҵ���ǰ�ŵ�������������е�λ��
		int now = -1, left = -1, right = -1;
		int i, j, sum = 0;

		float ave = 0.0f; // ������ƽ��Ѱ������
		Arrays.sort(cidao); // ���ÿ��������㷨������
		System.out.println("�����");
		for (int n = 0; n < cidao.length; n++) {
			System.out.print(cidao[n] + "  ");
		}
		System.out.println();
		System.out.print("�����뵱ǰ�Ĵŵ��ţ�");
		Scanner input = new Scanner(System.in);
		now = input.nextInt();
		// ע������ı���Ǵ��⵽�ڴ�0��ʼ��ŵ�
		if (cidao[m - 1] <= now) // ��һ�������������ǰ�ŵ��Ŵ�����������������ߣ���ֱ�������������θ�����������
		{ // ���磺����� 55 66 72 88 93 100 ����ǰ�ŵ�����100��ֱ�Ӵ�100��ʼ���Ը��������
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			for (i = m - 1; i >= 0; i--)
				System.out.print(" --> " + cidao[i]);
			sum = now - cidao[0];
		}

		if (cidao[0] >= now) // �ڶ������������ǰ�ŵ���С��������������С�ߣ���ֱ�������������θ��������������һ��ͬ��
		{
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			for (i = 0; i < m; i++)
				System.out.print(" --> " + cidao[i]);
			sum = cidao[m - 1] - now;
		}

		if (now > cidao[0] && now < cidao[m - 1]) // ���������������ǰ�ŵ��Ŵ���������������С����С�������
		{
			System.out.println("����ɨ������Ϊ��");

			while (cidao[k] < now) // ȷ����ǰ�ŵ������ŵ������е�λ��
			{
				k++; // k��1��ʼ��
				// ���磺55 66 72 88 93 100 ����ǰ�ŵ���Ϊ90 ֱ���ҵ�93�Ż�����ѭ������ʱk=4
			}
			left = k - 1; // ��ʾ��ʱλ�õ�����߼��±�
			right = k; // ��ʾ��ʱλ�õ��ұ��߼��±�

			System.out.print(now);
			while ((left >= 0) && (right < m)) // ��ǰ�ŵ����������з�Χ��

			{
				if ((now - cidao[left]) <= (cidao[right] - now)) // ѡ���뵱ǰ�ŵ����������������
				{ // ����90��88�Ƚ��ں�93�ȽϿ�˭����̾��ȸ��ĸ�����
					System.out.print(" --> " + cidao[left]); // ������߾���������
					sum += now - cidao[left];
					now = cidao[left];
					left = left - 1;
				} else { // System.out.print(now);
					System.out.print(" --> " + cidao[right]); // �����ұ߾���������
					sum += cidao[right] - now;
					now = cidao[right];
					right = right + 1;
				}
			}

			if (left == -1) // ��ͷ�ƶ������е���С�ţ������ڲ�ɨ����δɨ��Ĵŵ�
			{
				for (j = right; j < m; j++) {
					System.out.print("--> " + cidao[j]);
				}
				sum += cidao[m - 1] - cidao[0];
			} else // ��ͷ�ƶ������е����ţ��������ɨ����δɨ��Ĵŵ�
			{
				for (j = left; j >= 0; j--) {
					System.out.print("--> " + cidao[j]);// ����55 66 72 88 93 100���赱ǰ�ŵ�90
				} // ��ǰ����㷨����90-->88-->93-->100,��ʱ��100ʱright+1=6����ѭ��
				sum += cidao[m - 1] - cidao[0]; // ������else�����֧���Ѵ�ͷת��֮ǰleft��λ��ѭ�����
			} // �Ǹ�sumֱ�ӵ������һ����ȥ��һ������Ϊ�����ǻ�ɨ�赽�����Ĵŵ���
		} // �ͣ�100-72��+��72-66��+��66-55��= 100-55 = 45 ��һ����

		ave = sum / (float) (m);
		System.out.println();
		System.out.println("ƽ��Ѱ�����ȣ� " + ave);
	}

	/**
	 * ����㷨�����Ѱ�����һ���ģ�������Ҳ��������������Ƕ���һ��ѡ���ƶ��۵ķ��� 1������ǰ�ŵ��Ŵ�����������������ߣ���ֱ�������������θ�����������
	 * 2������ǰ�ŵ���С��������������С�ߣ���ֱ�������������θ����������� 3�����������������ǰ�ŵ��Ŵ���������������С����С������� ɨ���㷨(�����㷨)
	 * 
	 * @param cidao ������ŵ���
	 * @param m
	 */
	void SCAN(int cidao[], int m) // ��Ҫ������ǰ�ŵ��ź��ƶ��۵��ƶ�����
	{
		int k = 1;
		int now, left = -1, right = -1, choice = -1;
		int i, j, sum = 0;
		float ave = 0.0f;
		Arrays.sort(cidao);
		System.out.println("�����");

		for (int n = 0; n < cidao.length; n++) {
			System.out.print(cidao[n] + "  ");
		}
		System.out.println();
		System.out.print("�����뵱ǰ�Ĵŵ��ţ�");
		Scanner input = new Scanner(System.in);
		now = input.nextInt();
		if (cidao[m - 1] <= now) // ��һ�����������ǰ�ŵ��Ŵ�����������������ߣ���ֱ�������������θ�����������
		{
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			for (i = m - 1; i >= 0; i--)
				System.out.print(" --> " + cidao[i]);
			sum = now - cidao[0]; // ������Ҫɨ�赽����ֱ࣬�Ӽ���С���Ǹ��õľ����һ��һ����������ǵȼ۵�
		}
		if (cidao[0] >= now) // �ڶ������������ǰ�ŵ���С��������������С�ߣ���ֱ�������������θ�����������
		{
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			for (i = 0; i < m; i++)
				System.out.print(" --> " + cidao[i]);
			sum = cidao[m - 1] - now; // ͬ��
		}
		if (now > cidao[0] && now < cidao[m - 1]) // ���������������ǰ�ŵ��Ŵ���������������С����С�������
		{
			while (cidao[k] < now) // ��SSTF�㷨һ�����ҵ���ǰѰ���ŵ�λ��
			{
				k++;
			}
			left = k - 1;
			right = k;
			System.out.println("�����뵱ǰ�ƶ��۵��ƶ��ķ��� (1 ��ʾ���� ��0��ʾ����) : ");
			Scanner input2 = new Scanner(System.in);
			choice = input2.nextInt();
			if (choice == 0) // ѡ���ƶ��۷������⣬��������ɨ��
			{
				System.out.println("����ɨ������Ϊ��");
				System.out.print(now);
				for (j = left; j >= 0; j--) // ���ŵ���С�ķ���ɨ�裬������ɨ��
				{
					System.out.print(" --> " + cidao[j]);
				}
				for (j = right; j < m; j++) // ��ͷ�ƶ�����С�ţ���ı䷽������ɨ��δɨ��Ĵŵ�
				{
					System.out.print(" --> " + cidao[j]);
				}
				sum = now - 2 * cidao[0] + cidao[m - 1]; // ������55 66 72 88 93 100�����ӣ���ǰ�ŵ�����90����ô90�Ȼ�����ɨ�裬ɨ�赽��С��
			} // Ȼ����ת�ص���right=93��������һ�ξ�����now,Ȼ������ɨ�赽����
			// ���Կ�����ô��sum =(now-cidao[0])*2 + (cidao[m-1]-now)

			else // ѡ���ƶ��۷������⣬��������ɨ��
			{
				System.out.println("����ɨ������Ϊ��");
				System.out.print(now);
				for (j = right; j < m; j++) {
					System.out.print(" --> " + cidao[j]);
				}
				for (j = left; j >= 0; j--) // ��ͷ�ƶ������ţ���ı䷽������ɨ��δɨ��Ĵŵ�
				{
					System.out.print(" --> " + cidao[j]);
				}
				sum = -now - cidao[0] + 2 * cidao[m - 1]; // ͬ��sum =(cidao[m-1]-now)*2 + (now - cidao[0])
			}
		}
		ave = sum / (float) (m);
		System.out.println();
		System.out.print("ƽ��Ѱ�����ȣ� " + ave);
	}

	/**
	 * ���ҲҪ����������������ѭ��ɨ��Ҳ��������� 1������ǰ�ŵ��Ŵ�����������������ߣ���ֱ�ӽ��ƶ����ƶ�����С�Ŵŵ��������ڸ�����������
	 * 2������ǰ�ŵ���С��������������С�ߣ���ֱ�������������θ�����������,�ͺ�SSTFһ���� 3������ǰ�ŵ��Ŵ���������������С����С�������
	 * ѭ��ɨ���㷨(������ɨ�裬û�з���ʱ��ͷ�����������ʵ���С����ֱ��������������С�ŵ���ɨ�裬��֮һ����)
	 * 
	 * @param cidao //����Ǵŵ���
	 * @param m
	 */
	void CSCAN(int cidao[], int m) // ��Ĭ����ɨ�跽��������ŵ��ű�С�ķ�����У������ڵ���
	{
		int k = 1;
		int now = -1, left = -1, right = -1;
		int i, j, sum = 0;
		float ave;
		Arrays.sort(cidao);
		System.out.println("�����");
		for (int n = 0; n < cidao.length; n++) {
			System.out.print(cidao[n] + "  ");
		}
		System.out.println();
		System.out.print("�����뵱ǰ�Ĵŵ��ţ�");
		Scanner input = new Scanner(System.in);
		now = input.nextInt();
		if (cidao[m - 1] <= now) // ��һ�����������ǰ�ŵ��Ŵ�����������������ߣ���ֱ�ӽ��ƶ����ƶ�����С�Ŵŵ��������ڸ�����������
		{
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			for (i = m - 1; i >= 0; i--)
				System.out.print(" --> " + cidao[i]);
			sum = now - cidao[0]; // ��SCAN�㷨һ�� 55 66 72 88 93 100 ��ǰ�ŵ���Ϊ101
		}

		if (cidao[0] >= now) // �ڶ������������ǰ�ŵ���С��������������С�ߣ����ƶ��ŵ������λ�������������θ�����������,
		{
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			for (i = m - 1; i >= 0; i--)
				System.out.print(" --> " + cidao[i]);
			sum = 2 * cidao[m - 1] - now - cidao[0]; // 55 66 72 88 93 100 ��ǰ�ŵ���54
		} // sum = (cidao[m-1] - now) + (cidao[m-1]-cidao[0])

		if (now > cidao[0] && now < cidao[m - 1]) // ���������������ǰ�ŵ��Ŵ���������������С����С�������
		{
			System.out.println("����ɨ������Ϊ��");
			System.out.print(now);
			while (cidao[k] < now) // ͬ�ϣ����ҵ���ǰ�ŵ��ŵ�λ��
			{
				k++;
			}
			left = k - 1;
			right = k;
			for (j = left; j >= 0; j--) // ��Ϊ��Ĭ����ɨ����С�ŵ������Ƶ����ŵ���ɨ��
			{ // ����55 66 72 88 93 100 ��ǰ�ŵ���90
				System.out.print(" --> " + cidao[j]);
			}
			for (j = m - 1; j > left; j--) // ��ɨ������С�Ŵŵ�����ͷֱ���ƶ������Ŵŵ���������ɨ��δɨ��Ĵŵ�
			{
				System.out.print(" --> " + cidao[j]);
			}
			sum = 2 * cidao[m - 1] - cidao[right] + now - 2 * cidao[0];// sum=(now-cidao[0])+(cidao[m-1]-cidao[0])+(cidao[m-1]-cidao[right])
		}
		ave = sum / (float) (m);
		System.out.println();
		System.out.println("ƽ��Ѱ�����ȣ� " + ave);
	}

}
